package com.yobo.studying_view;

import com.blankj.utilcode.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by YoBo on 2018/5/4.
 */

public class Test {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机IP地址
//        System.out.println(InetAddress.getLocalHost().getHostAddress());
//        //获取www.baidu.com的地址
//        System.out.println(InetAddress.getByName("www.baidu.com"));
//        //获取www.baidu.com的真实IP地址
//        System.out.println(InetAddress.getByName("www.baidu.com").getHostAddress());
//        //获取配置在HOST中的域名IP地址
//        System.out.println(InetAddress.getByName("date.robochina.com").getHostAddress());


        String machId = "ZGC002ABD0130";
        //getHost();

        String b = getTime() + machId + getHost() + "8080";

        System.out.println(b);
        System.out.println(b.length());

    }


    private static String getHost() throws UnknownHostException {
        String host1 = InetAddress.getByName("date.robochina.com.cn").getHostAddress();
        String[] fa = host1.split("\\.");

//        StringBuffer all = new StringBuffer();
//        if (fa.length > 0) {
//            for (String a : fa) {
//
//                String b = leftZeroShift(a, 3);
//                all.append(b);
//
//                System.out.println(all.toString());
//            }
//        }
        return fa[fa.length - 1];
    }

    /**
     * 左侧补零
     * length  返回字符串长度
     * s的长度超过length,返回s;小于length，左侧不足补零
     */
    public static String leftZeroShift(String s, int length) {
        if (s == null || s.length() > length)
            return s;
        String str = getZero(length) + s;
        str = str.substring(str.length() - length);
        return str;
    }

    //获取0的字符串
    static String getZero(int length) {
        String str = "";
        for (int i = 0; i < length; i++) {
            str += "0";
        }
        return str;
    }

    private static String getTime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("ssSSSyyMMddHHmm");
        String a = format.format(date);
        return a;
    }
}
//ZGC002ABD013005-04 14:45:510391070521158080
//0504145555756ZGC002ABD01301158080