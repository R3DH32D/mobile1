package com.example.myapplication;

import static com.example.myapplication.R.id.teacherFio_name;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class AddPostActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_post);
        Button addButton = (Button) findViewById(R.id.addPostButton);

        EditText teacherFIO_name = (EditText) findViewById(R.id.teacherFio_name);



        EditText subject =   (EditText) findViewById(R.id.subjectName_text);

        EditText links =  (EditText) findViewById(R.id.spec_links);
        EditText post =  (EditText) findViewById(R.id.Text_post);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiClient client = new ApiClient();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            client.postAddPost(null,
                                    subject.getText().toString(),
                                    teacherFIO_name.getText().toString(),
                                    post.getText().toString(),
                                    links.getText().toString(),
                                    null);

                        } catch (JsonProcessingException e) {

                        }

                        //
                    }
                });
                thread.start();


                //group.setText("success");
                Intent intent = new Intent(v.getContext(), TapeActivity.class);
                startActivity(intent);


            }
        });

    }








}