package com.cosmoplat.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zilong.wang on 2019-11-19.
 */
public class BrowserUtils {
    private enum BrowserType {
        IE11, IE10, IE9, IE8, IE7, IE6, Firefox, Safari, Chrome, Opera, Camino, Gecko
    }

    // 判断是否是IE
    public static boolean isIE(String userAgent) {
        return userAgent.toLowerCase().indexOf("msie") > 0 ||
                userAgent.toLowerCase().indexOf("rv:11.0") > 0;
    }

    /**
     * 获取IE版本
     *
     * @param userAgent
     * @return
     */
    public static Double getIEversion(String userAgent) {
        Double version = 0.0;
        if (getBrowserType(userAgent, IE11)) {
            version = 11.0;
        } else if (getBrowserType(userAgent, IE10)) {
            version = 10.0;
        } else if (getBrowserType(userAgent, IE9)) {
            version = 9.0;
        } else if (getBrowserType(userAgent, IE8)) {
            version = 8.0;
        } else if (getBrowserType(userAgent, IE7)) {
            version = 7.0;
        } else if (getBrowserType(userAgent, IE6)) {
            version = 6.0;
        }
        return version;
    }

    /**
     * 获取浏览器类型
     *
     * @param userAgent
     * @return
     */
    public static BrowserType getBrowserType(String userAgent) {
        BrowserType browserType = null;
        if (getBrowserType(userAgent, IE11)) {
            browserType = BrowserType.IE11;
        }
        if (getBrowserType(userAgent, IE10)) {
            browserType = BrowserType.IE10;
        }
        if (getBrowserType(userAgent, IE9)) {
            browserType = BrowserType.IE9;
        }
        if (getBrowserType(userAgent, IE8)) {
            browserType = BrowserType.IE8;
        }
        if (getBrowserType(userAgent, IE7)) {
            browserType = BrowserType.IE7;
        }
        if (getBrowserType(userAgent, IE6)) {
            browserType = BrowserType.IE6;
        }
        if (getBrowserType(userAgent, FIREFOX)) {
            browserType = BrowserType.Firefox;
        }
        if (getBrowserType(userAgent, SAFARI)) {
            browserType = BrowserType.Safari;
        }
        if (getBrowserType(userAgent, CHROME)) {
            browserType = BrowserType.Chrome;
        }
        if (getBrowserType(userAgent, OPERA)) {
            browserType = BrowserType.Opera;
        }
        if (getBrowserType(userAgent, "Camino")) {
            browserType = BrowserType.Camino;
        }
        return browserType;
    }

    private static boolean getBrowserType(String userAgent, String brosertype) {
        return userAgent.toLowerCase().indexOf(brosertype) > 0;
    }

    private final static String IE11 = "rv:11.0";
    private final static String IE10 = "MSIE 10.0";
    private final static String IE9 = "MSIE 9.0";
    private final static String IE8 = "MSIE 8.0";
    private final static String IE7 = "MSIE 7.0";
    private final static String IE6 = "MSIE 6.0";
    private final static String MAXTHON = "Maxthon";
    private final static String QQ = "QQBrowser";
    private final static String GREEN = "GreenBrowser";
    private final static String SE360 = "360SE";
    private final static String FIREFOX = "Firefox";
    private final static String OPERA = "Opera";
    private final static String CHROME = "Chrome";
    private final static String SAFARI = "Safari";
    private final static String OTHER = "其它";

    public static String checkBrowse(String userAgent) {
        if (regex(OPERA, userAgent)) {
            return OPERA;
        }
        if (regex(CHROME, userAgent)) {
            return CHROME;
        }
        if (regex(FIREFOX, userAgent)) {
            return FIREFOX;
        }
        if (regex(SAFARI, userAgent)) {
            return SAFARI;
        }
        if (regex(SE360, userAgent)) {
            return SE360;
        }
        if (regex(GREEN, userAgent)) {
            return GREEN;
        }
        if (regex(QQ, userAgent)) {
            return QQ;
        }
        if (regex(MAXTHON, userAgent)) {
            return MAXTHON;
        }
        if (regex(IE11, userAgent)) {
            return IE11;
        }
        if (regex(IE10, userAgent)) {
            return IE10;
        }
        if (regex(IE9, userAgent)) {
            return IE9;
        }
        if (regex(IE8, userAgent)) {
            return IE8;
        }
        if (regex(IE7, userAgent)) {
            return IE7;
        }
        if (regex(IE6, userAgent)) {
            return IE6;
        }
        return OTHER;
    }

    private static boolean regex(String regex, String str) {
        Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher m = p.matcher(str);
        return m.find();
    }
}
