package com.javarush.task.task40.task4002;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/*
Опять POST, а не GET

https://mvnrepository.com/artifact/commons-logging/commons-logging/1.1.1
https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore/4.4.7
https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient/4.5.3

https://stackoverflow.com/questions/3324717/sending-http-post-request-in-java
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.sendPost("https://requestb.in/1hxnm2y1", "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(String url, String urlParameters) throws Exception {
        HttpClient client = getHttpClient();
        HttpPost post = new HttpPost(url);
        post.addHeader("User-Agent", "Mozilla/5.0");

        // Request parameters and other properties.
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        String[] paramList = urlParameters.split("&");
        for (String param : paramList) {
            String[] items = param.split("=");
            String param1 = items[0];
            String param2 = items.length == 1 ? "" : items[1];
            params.add(new BasicNameValuePair(param1, param2));
        }
        post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        //Execute and get the response.
        HttpResponse response = client.execute(post);
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String responseLine;
        while ((responseLine = bufferedReader.readLine()) != null) {
            result.append(responseLine);
        }

        System.out.println("Response: " + result.toString());
    }

    protected HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }
}
