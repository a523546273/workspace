package com.whw.layui.controller;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DownLoadController {


    @RequestMapping(value = "/download")
    @ResponseBody
    public Map<String, Object> dowload(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String url = request.getParameter("url");
        String type = request.getParameter("type");
        String url1 = null;
        if ("kuaishou".equals(type)) {
            url1 = this.downLoad1(url);
        }

        /*
         * String fileName=FileUtil.getFileName(url1); String
         * path=localFile+"\\"+fileName; File file = new File(path);
         *
         * String returnURl=PathUtil.getLocalFile(request)+"/upload/"+fileName;
         *
         * if (file.exists()) { file.delete(); }
         *
         * URL url2 = new URL(url1); FileUtils.copyURLToFile(url2, file);
         */

        if (StringUtils.isBlank(url1)) {
            map.put("success", false);
        } else {
            map.put("success", true);
            map.put("downUrl", url1);
        }

        return map;
    }

    private String downLoad1(String url) {
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
