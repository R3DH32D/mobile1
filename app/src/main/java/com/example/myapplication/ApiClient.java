package com.example.myapplication;

import android.os.AsyncTask;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.xml.transform.Result;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiClient {

    private static final String BASE_URL = "https://cb66-176-59-134-214.ngrok-free.app/";
    private static OkHttpClient client = new OkHttpClient();

    public User[] getUsers() {
        //String result = "";
        okhttp3.Request request = new okhttp3.Request.Builder().url(BASE_URL + "/api/users/find").build();
        try {
            Response response = client.newCall(request).execute();
            User[] users = new ObjectMapper().readValue(response.body().string(), User[].class);
            return users;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void postUser(String groups,
                         String name,
                         String lastName,
                         String login,
                         String password) throws JsonProcessingException {
        User user = new User(groups, name, lastName, login, password);
        String json = new ObjectMapper().writeValueAsString(user);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url("https://cb66-176-59-134-214.ngrok-free.app/api/users/reg").post(requestBody).build();
        try {
            Response response = client.newCall(request).execute();

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
//    public void postAddPost(Long id,
//                            String subjectName,
//                         String teacherFIO,
//                         String text,
//                         String specLinks,
//                         String student) throws JsonProcessingException {
//        Posts post=  new Posts(id,subjectName, teacherFIO, text, specLinks, student);
//        String json = new ObjectMapper().writeValueAsString(post);
//        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//        RequestBody requestBody = RequestBody.create(JSON, json);
//        Request request = new Request.Builder().url(BASE_URL + "/api/desc/add").post(requestBody).build();
//        try {
//            Response response = client.newCall(request).execute();
//
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//
//    }

    public List<Posts> getDescriptions()  {



        String result = "";
        okhttp3.Request request = new Request.Builder().url("https://cb66-176-59-134-214.ngrok-free.app/api/desc/all").build();

        try {
            Response response = client.newCall(request).execute();
            Posts[] descriptions = new ObjectMapper().readValue(response.body().string(), Posts[].class);

            List<Posts> description= Arrays.stream(descriptions).collect(Collectors.toList());
            for (int i = 0; i < description.size(); i++) {
                System.err.println(description.get(i));
            }
            return description;
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }









}
