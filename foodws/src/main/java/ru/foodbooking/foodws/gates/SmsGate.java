package ru.foodbooking.foodws.gates;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBConstant;
import ru.foodbooking.foodws.config.FBConfig;
import ru.foodbooking.foodws.support.response.SmsResponse;

import java.io.IOException;

@Component
public class SmsGate {

    @Autowired
    private FBConfig fbConfig;

    private final OkHttpClient httpClient = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Integer sendSms(String phoneNumber, String code){
        String message = FBConstant.SMS_MESSAGE+code;
        String smsUrl = fbConfig.getSmsUrl()+
                "?login="+fbConfig.getSmsLogin()+
                "&psw="+fbConfig.getSmsPassword()+
                "&phones="+phoneNumber+
                "&mes="+message+
                "&fmt=3";
        Request request = new Request.Builder()
                .url(smsUrl)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            if (response != null) {
                if (!response.isSuccessful())
                    return 1;
                ResponseBody responseBody = response.body();
                SmsResponse smsResponse = objectMapper.readValue(responseBody.toString(), SmsResponse.class);
                if (smsResponse.getErroCode() != null && smsResponse.getErroCode() > 0)
                    return 1;
                return 0;
            }
        } catch (IOException e){
            e.printStackTrace();
            return 1;
        }
        return 1;
    }

}
