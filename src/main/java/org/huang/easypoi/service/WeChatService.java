package org.huang.easypoi.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class WeChatService {

    public String getUserInfo(String code) throws Exception {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        url += "?appid=wx248517ef9197fb46";
        url += "&secret=cd4f41b06076eb683838251a09424468";
        url += "&js_code=" + code;
        url += "&grant_type=authorization_code";
        String res = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000)
                .setRedirectsEnabled(false).build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        if (httpEntity != null) {
            res = EntityUtils.toString(httpEntity);
        }
        httpClient.close();
        httpResponse.close();

        JSONObject jo = JSON.parseObject(res);
        assert jo != null;
        return jo.getString("openid");
    }
}
