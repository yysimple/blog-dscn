package com.jxkj.usercenter.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 功能描述：时间转换类
 *
 * @author 吴呈兴
 * @version 1.0.0.RELEASE
 */
public final class DateFormatConvertUtil {

    /**
     * 将LocalDateTime转为自定义的时间格式的字符串
     *
     * @param localDateTime
     * @param format
     * @return
     */
    public static String getDateTimeAsString(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    /**
     * 将long类型的timestamp转为LocalDateTime
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 将LocalDateTime转为long类型的timestamp
     *
     * @param localDateTime
     * @return
     */
    public static long getTimestampOfDateTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 将某时间字符串转为自定义时间格式的LocalDateTime
     *
     * @param time
     * @param format
     * @return
     */
    public static LocalDateTime parseStringToDateTime(String time, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(time, df);
    }

    /**
     * 功能描述: 开始时间
     *
     * @param time
     * @return java.time.LocalDateTime
     * @Author 吴呈兴
     **/
    public static LocalDateTime startTime(String time) {
        if (time != null) {
            LocalDateTime startTime = com.jxkj.usercenter.util.DateFormatConvertUtil.parseStringToDateTime(time + " 00:00:00", "yyyy/MM/dd HH:mm:ss");
            return startTime;
        } else {
            return null;
        }
    }

    /**
     * 功能描述: 结束时间
     *
     * @param time
     * @return java.time.LocalDateTime
     * @Author 吴呈兴
     **/
    public static LocalDateTime endTime(String time) {
        if (time != null) {
            LocalDateTime endTime = com.jxkj.usercenter.util.DateFormatConvertUtil.parseStringToDateTime(time + " 23:59:59", "yyyy/MM/dd HH:mm:ss");
            return endTime;
        } else {
            return null;
        }
    }
}



