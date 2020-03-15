package ru.foodbooking.foodws.gates;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBConstant;
import ru.foodbooking.foodws.config.FBConfig;

import java.io.IOException;
import java.util.Map;

@Component
@Slf4j
public class SmsByOperator {

    @Autowired
    private FBConfig fbConfig;

    @Autowired
    private Map<String, SmsGate> smsGates;

    private final OkHttpClient httpClient = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public int sendSmsByOperator(String phoneNumber, String code){
        int retInt = 1;
        String smsUrl = fbConfig.getSmsCheckUrl()+
                "?get_operator=1"+
                "&login="+fbConfig.getSmsLogin()+
                "&psw="+fbConfig.getSmsPassword()+
                "&phone="+phoneNumber+
                "&fmt=3";
        Request request = new Request.Builder()
                .url(smsUrl)
                .build();
        try(Response response = httpClient.newCall(request).execute()){
            if (response != null){
                String respBody = response.body().string();
                Operator operator = mapper.readValue(respBody, Operator.class);
                String tran = "smsc";
                String text = FBConstant.SMS_MESSAGE+code;
                String url = fbConfig.getSmsSendUrl()+
                        "?login="+fbConfig.getSmsLogin()+
                        "&psw="+fbConfig.getSmsPassword()+
                        "&phones="+phoneNumber+
                        "&mes="+text+
                        "&fmt=3";
                if (operator.getOperator() != null && operator.getOperator().equalsIgnoreCase("мегафон")) {
                    tran = "prostor";
                    url = fbConfig.getSmsProstorUrl()+
                            "?login="+fbConfig.getSmsProstorLogin()+
                            "&password="+fbConfig.getSmsProstorPassword()+
                            "&phone="+phoneNumber+
                            "&text="+text;
                }
                SmsGate smsGate = smsGates.get(tran);
                retInt = smsGate.sendSms(url, httpClient);
            }
        } catch (IOException e){
            log.error("Error: "+e);
            e.printStackTrace();
        }
        return retInt;
    }

    @Getter @Setter
    private static class Operator{
        String country;
        String operator;
        String region;
        String mcc;
        String mnc;
        String tz;
    }

}
