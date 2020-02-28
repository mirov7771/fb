package ru.foodbooking.foodws.gates;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBConstant;
import ru.foodbooking.foodws.config.FBConfig;

import java.io.IOException;

@Component
@Slf4j
public class SmsGate {

    @Autowired
    private FBConfig fbConfig;

    private final OkHttpClient httpClient = new OkHttpClient();

    public int sendSms(String phoneNumber, String code){
        log.debug("Send sms for phone "+phoneNumber);
        int retVal = 1;
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
                ResponseBody responseBody = response.body();
                log.debug("SMS answer" + responseBody.toString());
                String smsResponse = responseBody.toString();
                boolean smsSend = smsResponse == null || !smsResponse.contains("error");
                if (Boolean.TRUE.equals(smsSend))
                    retVal = 0;
            }
        } catch (IOException e){
            e.printStackTrace();
            return 1;
        }
        return retVal;
    }

}
