package com.geekster.Nationalize;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NationalizeApplication {

	public static void main(String[] args) throws Exception{

        URL getUrl = new URL(" https://api.nationalize.io/?name=nathaniel");
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.setRequestMethod("GET");


        int responseCode = connection.getResponseCode();

        if (responseCode == 200) {


            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonResponseData = new StringBuilder();
            String readLine = null;


            while ((readLine = in.readLine()) != null) {
                jsonResponseData.append(readLine);
            }

            in.close();
            System.out.println(jsonResponseData.toString());
        } else {
            System.out.println("This is not valid URL- " + responseCode);
        }
    }

}
