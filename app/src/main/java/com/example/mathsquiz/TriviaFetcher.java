package com.example.mathsquiz;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TriviaFetcher {
    private static final String TAG="TriviaFetcher";
    private static final String LINK="https://opentdb.com/api.php";
    public byte[] getUrlBytes(String uriSpec) throws IOException{
        URL url=new URL(uriSpec);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        try{
            ByteArrayOutputStream output=new ByteArrayOutputStream();
            InputStream input=connection.getInputStream();
            int byteRead=0;
            byte[] buffer=new byte[1024];
            while((byteRead= input.read(buffer))>0){
                output.write(buffer,0,byteRead);
            }
            Log.i(TAG,"made a connection");
            output.close();
            return output.toByteArray();
        }finally {
            connection.disconnect();
        }
    }
    public String getUrlString(String urlSpec) throws IOException{
        return new String(getUrlBytes(urlSpec));
    }
    public List<Questions> fetchItems(String code){

        List<Questions> items=new ArrayList<>();
        try{
            String url= Uri.parse(LINK).buildUpon()
                    .appendQueryParameter("amount","6")
                    .appendQueryParameter("category",code)
                    .appendQueryParameter("difficulty","easy")
                    .appendQueryParameter("type","boolean")
                    .build().toString();
            String jsonString=getUrlString(url);
            Log.i(TAG,"got json data");
            JSONObject jsonBody=new JSONObject(jsonString);
            parseItems(items,jsonBody);
        }catch(JSONException je){
            Log.e(TAG,"failed to parse items");
        }catch(IOException ioE){
            Log.e(TAG,"failed to fetch");
        }
        return items;
    }
    private void parseItems(List<Questions> items,JSONObject jsonBody) throws
            IOException,JSONException{
//        JSONObject questsJsonObject=jsonBody.getJSONObject("results");
        JSONArray questJsonArray=jsonBody.getJSONArray("results");
        for(int i=0;i<questJsonArray.length();i++){
            JSONObject questJsonObject=questJsonArray.getJSONObject(i);
            Questions question=new Questions();
            question.setQues_id(questJsonObject.getString("question"));
            Log.i(TAG,"1. "+question.getQues_id());

            question.setResult(questJsonObject.getBoolean("correct_answer"));
            Log.i(TAG,"1. "+question.getResult());
            items.add(question);
            if(!questJsonObject.has("url_s")){
                continue;
            }
//            question.setUrl(questJsonObject.getString("url_s"));

        }
        Log.i(TAG,"got "+items.size()+"questions from url");
    }














}
