package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;

public class GS25Goods {

    //bad code
    public static void main(String[] args) throws Exception {

        String path = "http://gs25.gsretail.com/gscvs/ko/products/event-goods";


        Document doc =  Jsoup.connect(path).get();

        //CSRFTOKEN
        //System.out.println(doc);



        String token = doc.select("#CSRFForm").get(0).select("input[name='CSRFToken']").get(0).attr("value");

        System.out.println(token);

        //POST방식으로 행사상품 조회

        HashMap<String, String> params = new HashMap<>();
        params.put("pageNum", "1");
        params.put("pageSize", "8");
        params.put("parameterList", "ONE_TO_ONE");

        String target = "http://gs25.gsretail.com/gscvs/ko/products/event-goods-search?CSRFToken="+token;

        System.out.println(target);

        Connection.Response response = Jsoup.connect(target)
                .method(Connection.Method.GET)
                .data(params)
                .header("Origin","http://gs25.gsretail.com")
                .header("Referer","http://gs25.gsretail.com/gscvs/ko/products/event-goods")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36") // 헤더 설정
                .execute();

        Document document = response.parse();

        System.out.println(document);

    }//end main
}//end class
