package com.jxkj.sms.util;

/**
 * 功能描述：生成六位随机数的工具类
 *
 * @author 吴呈兴
 * @version 1.0.0.RELEASE
 */
public final class RandomCodeUtil {

    public static String getSixCode() {
        /**
         * 生成自己的随机六位数code
         */
        StringBuffer stringBuffer = new StringBuffer();
        for (int x = 0; x <= 5; x++) {
            int random = (int) (Math.random() * (10 - 1));
            stringBuffer.append(random);
        }
        String code = stringBuffer.toString();
        return code;
    }

    public static String getFourCode() {
        /**
         * 生成自己的随机四位数code
         */
        StringBuffer stringBuffer = new StringBuffer();
        for (int x = 0; x <= 3; x++) {
            int random = (int) (Math.random() * (10 - 1));
            stringBuffer.append(random);
        }
        String code = stringBuffer.toString();
        return code;
    }


}
