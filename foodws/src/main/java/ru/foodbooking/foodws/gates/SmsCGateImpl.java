package ru.foodbooking.foodws.gates;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("smsc")
public class SmsCGateImpl implements SmsGate {

    @Override
    public int sendSms(String url, OkHttpClient httpClient) throws IOException {
        int retInt = 1;
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = httpClient.newCall(request).execute();
        if (response != null){
            ResponseBody responseBody = response.body();
            String answer = responseBody.string();
            if (!answer.contains("error_code")){
                retInt = 0;
            }
        }
        return retInt;
    }
}
