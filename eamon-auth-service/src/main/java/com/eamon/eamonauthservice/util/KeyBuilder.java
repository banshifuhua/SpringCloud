package com.eamon.eamonauthservice.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.*;

/**
 * 生成密钥对 工具
 */
public class KeyBuilder {

    /**
     * 默认密钥长度
     */
    private int keySize = 2048;

    /**
     * 默认签名算法
     */
    private String algorithm = "RSA";

    /**
     * 设置随机数生成器(RNG) 算法
     */
    private SecurityRandomConfiguration securityRandomConfiguration;


    /**
     * 设置密钥长度
     *
     * @param keySize
     * @return
     */
    public KeyBuilder setKeySize(int keySize) {
        this.keySize = keySize;
        return this;
    }

    /**
     * 设置密钥算法
     *
     * @param algorithm
     * @return
     */
    public KeyBuilder setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }


    public KeyPair build() throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm, new BouncyCastleProvider());
        if (securityRandomConfiguration == null) {
            securityRandomConfiguration = new SecurityRandomConfiguration();
        }
        SecureRandom secureRandom = SecureRandom.getInstance(
                securityRandomConfiguration.getAlgorithm(),
                securityRandomConfiguration.getProvider()
        );

        keyPairGenerator.initialize(keySize,secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }


    public static class SecurityRandomConfiguration{
        private String algorithm = "SHA1PRNG";
        private String provider = "SUN";

        public String getAlgorithm() {
            return algorithm;
        }

        public void setAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
        }
    }


}
