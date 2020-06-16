package com.jxkj.usercenter.util;

import java.util.UUID;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public class RandomCreateSixNumber {

    public static String getRandomSixNumber() {
        UUID uuid = UUID.randomUUID();
        String text = uuid.toString();
        return text.substring(0, 6);
    }
}
