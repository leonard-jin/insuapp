package com.therich.apps.globals.services.encrypt;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kh.jin on 2020. 2. 25.
 */
public class SHA256EncoderHelper implements EncoderHelper {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private SHA256EncoderHelper() {
        // do nothing
    }

    public static SHA256EncoderHelper getInstance() {
        return SHA256Holder.INSTANCE;
    }

    @Override
    public String encypt(String source) throws NoSuchAlgorithmException {
        return encypt(source, SaltGenerator.generate());
    }

    @Override
    public String encypt(String source, String salt) throws NoSuchAlgorithmException {

        byte[] bSource = source.getBytes();
        byte[] bSalt = salt.getBytes();
        byte[] bEcrypt = new byte[bSource.length + bSalt.length];

        System.arraycopy(bSource, 0, bEcrypt, 0, bSource.length);
        System.arraycopy(bSalt, 0, bEcrypt, bSource.length, bSalt.length);

        log.debug("copied byte : {}", bEcrypt);

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(bEcrypt);

        StringBuilder sb = new StringBuilder();
        for (byte b : bEcrypt) {
            sb.append(String.format("%02x", b));
        }

        log.debug("convert to hex value : {}", sb.toString());
        return DigestUtils.sha256Hex(sb.toString());
    }

    /**
     * Holder class
     * Singleton 패턴 구현을 위한 클래스이다.
     * 참고 사이트 : https://jeong-pro.tistory.com/86 (JVM 에게 싱글톤 생성에 대한 책임을 넘긴다.)
     */
    private static class SHA256Holder {
        private static final SHA256EncoderHelper INSTANCE = new SHA256EncoderHelper();
    }
}
