package org.example.mailsend.utils;

import org.springframework.beans.factory.annotation.Value;

public class CommonUtil {
    @Value("${upload.path}")
    private static String path;

    public static String getPath(){
        return System.getProperty("user.dir") + path;
    }
}
