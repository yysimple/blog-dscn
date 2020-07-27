package com.jxkj.common.util;

import cn.hutool.core.util.StrUtil;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
            LocalDateTime startTime = DateFormatConvertUtil.parseStringToDateTime(time + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
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
            LocalDateTime endTime = DateFormatConvertUtil.parseStringToDateTime(time + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
            return endTime;
        } else {
            return null;
        }
    }

    /**
     * 功能描述: 将LocalDate转换成 Date
     *
     * @Author wcx
     * @param localDate
     * @return java.util.Date
     **/
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 功能描述: localDateTime装换成Date
     *
     * @Author wcx
     * @param localDateTime
     * @return java.util.Date
     **/
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 功能描述: 将 Date 转换成LocalDate
     *
     * @Author wcx
     * @param date
     * @return java.time.LocalDate
     **/
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 功能描述: 将Date 装换成LocalDateTime
     *
     * @Author wcx
     * @param date
     * @return java.time.LocalDateTime
     **/
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 将LocalDate 转换成 字符串
     * @param localDate
     */
    public static String localDateToString(LocalDate localDate){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(dateTimeFormatter);
    }

}



