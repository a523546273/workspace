package com.whw.layui.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created with IDEA
 * author:wanghongwei
 * Date:2019/3/31
 * Time:12:59
 */
public class ParseUrlUtils {

    public static String downLoad(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).timeout(12138).get();
            Elements elem = doc.getElementsByTag("script");
            String replaceAll = null;
            for (int i = 0; i < elem.size(); i++) {
                Element e = elem.get(i);
                String url1 = e.toString();
                // System.out.println(url1);
                int start = url1.indexOf("playUrl\":\"https:");
                if (start == -1) {
                    continue;
                }
                url1 = url1.substring(start);
                int end = url1.indexOf("\",");
                replaceAll = url1.substring(10, end);

            }
            return replaceAll;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
