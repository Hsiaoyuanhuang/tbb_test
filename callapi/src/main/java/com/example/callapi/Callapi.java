package com.example.callapi;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Callapi {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://od.moi.gov.tw/api/v1/rest/datastore/301000000A-002073-001")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonData = response.body().string();
                System.out.println(jsonData);
            } else {
                System.out.println("Failed to retrieve data: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}