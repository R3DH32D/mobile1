package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import android.widget.Button;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonProcessingException;


public class TapeActivity extends AppCompatActivity {
   // ArrayList<Posts> posts;
    ApiClient client = new ApiClient();
    List<Posts> posts= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tape);

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RecyclerView recyclerView = findViewById(R.id.list);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
           PostAdapter adapter = new PostAdapter(TapeActivity.this, posts);
                recyclerView.setAdapter(adapter);
            }});
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Button postButton = (Button) findViewById(R.id.addPost);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), AddPostActivity.class);
                startActivity(intent);

            }
        });


    }



       Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {

            try {

                List<Posts> d= client.getDescriptions();

                for (Posts p : d) {

                    posts.add(new Posts(p.getId(),p.getSubjectName(),p.getTeacherFIO(),p.getText(), p.getSpecLinks(), p.getStudent()));
                }
            } catch
            (NullPointerException e) {

            }
        }


    });





}