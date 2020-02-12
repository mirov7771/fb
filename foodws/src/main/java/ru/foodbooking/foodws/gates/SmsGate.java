package ru.foodbooking.foodws.gates;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBConstant;
import ru.foodbooking.foodws.config.FBConfig;
import ru.foodbooking.foodws.support.response.SmsResponse;

import java.io.IOException;

@Component
public class SmsGate {

    private static Logger LOG = Logger.getLogger(SmsGate.class);

    @Autowired
    private FBConfig fbConfig;

    private final OkHttpClient httpClient = new OkHttpClient();

    public int sendSms(String phoneNumber, String code){
        LOG.debug("Send sms for phone "+phoneNumber);
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
                LOG.debug("SMS answer" + responseBody.toString());
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
