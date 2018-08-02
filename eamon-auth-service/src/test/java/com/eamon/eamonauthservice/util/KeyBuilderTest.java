package com.eamon.eamonauthservice.util;

import com.google.gson.JsonObject;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;

import javax.swing.table.TableRowSorter;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;


public class KeyBuilderTest {
    @Test
    public void test() throws NoSuchProviderException, NoSuchAlgorithmException {
        KeyPair build = new KeyBuilder().build();
        System.out.println(build.getPublic());
        System.out.println(build.getPrivate());

        RSAPrivateKey privateKey = (RSAPrivateKey) build.getPrivate();
        byte[] encoded = privateKey.getEncoded();
        byte[] bytes = Base64.encode(encoded);
        String s = new String(bytes);

        byte[] decode = Base64.decode(bytes);
        String s1 = new String(decode);
        System.out.println(s1);

    }

    @Test
    public void test1() throws NoSuchProviderException, NoSuchAlgorithmException {
        JwtUtils instance = JwtUtils.getInstance();
        String token = instance.getToken("1002", 60);
        System.out.println(token);
        JwtUtils.JWTResult jwtResult = instance.checkToken(token);
        System.out.println(jwtResult.getCode());
        System.out.println(jwtResult.getMsg());
        System.out.println(jwtResult.getUid());
    }

    @Test
    public void test2() throws NoSuchProviderException, NoSuchAlgorithmException {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxMDAxIiwiZXhwIjoxNTMzMjA3MjQ3fQ.cBJBmNXlRFVMgjXJPp5pWeqf2ip6KX_v8SYum1hIG5h-_z2dv5mGwhQrL4--GB1E-i3BJ7yUpdtL9Wp5v89eo8uWtdh57UG1_iMkYd9TiKf-nQhFDtNJhUF_KPB4zZxWV_L7hAhdgQEqVmc6QsWwxgWpzjkT-mCHym-QM-DpROc4e5_naycJvHmpy4dAF2WSTa_QA5OSAV2nW_DaahcsyltJZFyXQzU0splqyWMZDSMAx_ZTlnkHTsI6SFhip-IYAQ__vYibcMLZ_5LvWU9NHGDbU58Evj0XkRISo4eAaWoWcwEbZkUYW6pcKSJJXAgTF8463brtBLZO0Y2fbcKXPg\n";
        JwtUtils.JWTResult jwtResult = JwtUtils.getInstance().checkToken(token);
        System.out.println(jwtResult.getCode());
        System.out.println(jwtResult.getMsg());
        System.out.println(jwtResult.getUid());
    }

    @Test
    public void test3(){
        RSAPublicKey publicKey = RSAUtils.getPublicKey("9e4c683f5d87c2237fea065978bafa50125c0fc57b6f5bbd3b4f760ea0def6ffbbefc3ffd82a522e50f69b0e681f8f8b7e8754c4698eb597eb41b424bc37851b7821a4a3373bb1a91a8f9f177b841c434b86bf68da112e77ae1eaada6f845df2ed3c3b490c2a90dd50e0d71ff28d90ec1bbde7863e3c8ce9c2559d50397720cb021d0ed5f82322b8223a626a20bef7e249b7aef86a0451f7f387dce0c60063ace2c9756c4902e8b2286535dd5db6e2ec7ab46dbf5c83b5bf7129e400cc74ec99dff9e81c0a8b6f9ab8e8de065dedf24319d599d7772e3472867632f6e36b850b758b7468d54a72424b2736ad8e5da4def1dddf360ef07dd52b8033e09b6347d5", "10001");
        System.out.println(publicKey);
    }

}