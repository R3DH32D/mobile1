package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.widget.Button;

import com.example.myapplication.model.Post;
import com.example.myapplication.web.ApiClient;

import ru.toylep.example.R;


public class TapeActivity extends AppCompatActivity {

    private ApiClient client = new ApiClient();
    private List<Post> posts= new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tape);
        new Thread(new FillPost()).start();
        new Thread(new AdapterInit()).start();
        recyclerView = findViewById(R.id.list);

        Button postButton = (Button) findViewById(R.id.addPost);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddPostActivity.class);
                startActivity(intent);

            }
        });
    }










    class AdapterInit implements Runnable{
        @Override
        public void run() {
            PostAdapter adapter = new PostAdapter(TapeActivity.this, posts);
            recyclerView.setAdapter(adapter);
        }
    }

    class FillPost implements Runnable{
        @Override
        public void run() {
            try {
                List<Post> d= client.getDescriptions();
                for (Post p : d) {
                    posts.add(new Post(p.getSubjectName(),p.getTeacherFIO(),p.getText(), p.getSpecLinks(), p.getStudent()));
                }
            } catch
            (NullPointerException e) {}
        }
    }











}