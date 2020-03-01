package com.therich.apps.globals.services.encrypt;

import java.security.NoSuchAlgorithmException;

/**
 * Created by kh.jin on 2020. 2. 25.
 */
public interface EncryptService {
    String encypt(String source) throws NoSuchAlgorithmException;
    String encypt(String source, String salt) throws NoSuchAlgorithmException;
}
