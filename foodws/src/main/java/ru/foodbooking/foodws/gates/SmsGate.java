package ru.foodbooking.foodws.gates;

import okhttp3.OkHttpClient;
import java.io.IOException;

public interface SmsGate {
    int sendSms(String url, OkHttpClient httpClient) throws IOException;
}
