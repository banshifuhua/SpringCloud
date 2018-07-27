package com.eamon.eamonhouseconsumer.controller;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import org.assertj.core.util.Lists;
import org.junit.Test;
import rx.Observable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RibbonConsumerBaseTest {
    @Test
    public void testRibbon() {
        List<Server> servers = Lists.newArrayList(
                new Server("localhost", 8081),
                new Server("localhost", 8083));

        BaseLoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(servers);

        for (int i = 0; i < 5; i++) {
            String result = (String) LoadBalancerCommand.builder()
                    .withLoadBalancer(loadBalancer)
                    .build()
                    .submit((ServerOperation<Object>) server -> {
                        HttpURLConnection connection = null;
                        try {
                            String addr = "http://" + server.getHost() + ":" + server.getPort() + "/house/hello";
                            System.out.println("调用地址：" + addr);
                            URL url = new URL(addr);
                            connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("GET");
                            connection.connect();
                            InputStream is = connection.getInputStream();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                            String line = null;
                            String msg = "";
                            while ((line = bufferedReader.readLine()) != null) {
                                msg += line + "\n";
                            }
                            return Observable.just(msg);
                        } catch (Exception e) {
                            return Observable.error(e);
                        }
                    }).toBlocking().first();
            System.out.println("调用结果：" + result);
        }
    }

}