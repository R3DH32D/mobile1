package com.example.myapplication;

import static com.example.myapplication.App.clientApplication;
import static com.example.myapplication.App.getClient;

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
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiClient {
    private static final String BASE_URL1 = "https://cb66-176-59-134-214.ngrok-free.app";
    private static final String BASE_URL = "http://192.168.248.243:8080";

    public static Intercept intercept;
    private static OkHttpClient secondclient = getClient();
    private static OkHttpClient client = new OkHttpClient();
    private String credential;
    public Boolean postAuth(
            String login,
            String password) throws JsonProcessingException {
        User user = new User( login, password);

        String json = new ObjectMapper().writeValueAsString(user);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, json);

        Request request = new Request.Builder().url(BASE_URL+"/api/users/sign_up").post(requestBody).build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            truth = new ObjectMapper().readValue(response.body().string(), Boolean.class);

            if(truth){
                intercept= new Intercept(login,password);
                secondclient.newBuilder().addInterceptor(intercept).build();
            }
            System.out.println(truth);

        }
        catch (IOException e){
            e.printStackTrace();
        }
        return truth;
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
        Request request = new Request.Builder().url(BASE_URL+"/api/users/reg").post(requestBody).build();
        try {
            Response response = client.newCall(request).execute();

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public Boolean truth;


    public void postAddPost(Long id,
                            String subjectName,
                         String teacherFIO,
                         String text,
                         String specLinks,
                         String author) throws JsonProcessingException {
        Posts posts=  new Posts(id,subjectName, teacherFIO, text, specLinks, author);
        String json = new ObjectMapper().writeValueAsString(posts);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(BASE_URL + "/api/desc/add").post(requestBody).build();
        try {
            Response response =secondclient.newBuilder().addInterceptor(intercept).build().newCall(request).execute();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    public void postAddComm(Long id,
                            String text,

                            String author) throws JsonProcessingException {
        Comment comment=  new Comment(id, text,  author);
        String json = new ObjectMapper().writeValueAsString(comment);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(BASE_URL + "/api/comm/add/" + id ).post(requestBody).build();
        try {
            Response response =secondclient.newBuilder().addInterceptor(intercept).build().newCall(request).execute();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    public List<Posts> getDescriptions()  {


       // Long correctId =Long.parseLong(id);
        String result = "";
        okhttp3.Request request = new Request.Builder()
                .url(BASE_URL +"/api/desc/all")
                .build();

        try {
            Response response = secondclient.newBuilder().addInterceptor(intercept).build().newCall(request).execute();
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
    public List<Comment> getComments(Long id)  {



        String result = "";
        okhttp3.Request request = new Request.Builder()
                .url(BASE_URL +"/api/comm/all/" + id)
                .build();

        try {
            Response response = secondclient.newBuilder().addInterceptor(intercept).build().newCall(request).execute();
            Comment[] descriptions = new ObjectMapper().readValue(response.body().string(), Comment[].class);

            List<Comment> description= Arrays.stream(descriptions).collect(Collectors.toList());
            for (int i = 0; i < description.size(); i++) {
                System.err.println(description.get(i));
            }
            return description;
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }
}
