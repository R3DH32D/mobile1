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

public class CommentActivity extends AppCompatActivity {
    ApiClient client = new ApiClient();
    List<Comment> comments= new ArrayList<>();

  //  Bundle arguments = getIntent().getExtras();
    Intent intent = getIntent();
   // Long idPost = (Long) Long.parseLong(String.valueOf(arguments.getLong("id")));
   //Long idPost= (Long) Long.parseLong(String.valueOf(intent.getStringExtra("id")));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

      //  System.out.println(idPost);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        RecyclerView recyclerView = findViewById(R.id.Commlist);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                CommentAdapter adapter = new CommentAdapter(CommentActivity.this, comments);
                recyclerView.setAdapter(adapter);
            }});
        thread1.start();
        Button postButton = (Button) findViewById(R.id.AddComm);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(v.getContext(), AddPostActivity.class);
//                startActivity(intent);

            }
        });


    }
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {

            try {

                List<Comment> d= client.getComments(Long.valueOf(1));

               for (Comment p : d) {

                    comments.add(new Comment(p.getText(),p.getDescription(), p.getStudent()));
                   System.out.println(p.getText());
                   System.out.println(p.getDescription());
                   System.out.println(p.getStudent());
                }
            } catch
            (NullPointerException e) {

            }
        }


    });
}