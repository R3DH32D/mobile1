package com.example.myapplication.activity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.web.ApiClient;

import ru.toylep.example.R;


public class AddPostActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_post);
        Button addButton = (Button) findViewById(R.id.addPostButton);

        TextView teacherFIO_name = (TextView) findViewById(R.id.teacherFio_name);

        TextView student = (TextView) findViewById(R.id.student_name);

        TextView subject =   (TextView) findViewById(R.id.subjectName_text);

        TextView links =  (TextView) findViewById(R.id.spec_links);
        TextView post =  (TextView) findViewById(R.id.Text_post);
        TextView id =  (TextView) findViewById(R.id.ID_view);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiClient client = new ApiClient();
//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            client.postAddPost(null,
//                                    subject.getText().toString(),
//                                    teacherFIO_name.getText().toString(),
//                                    post.getText().toString(),
//                                    links.getText().toString(),
//                                    student.getText().toString());
//
//                        } catch (JsonProcessingException e) {
//
//                        }
//
//                        //
//                    }
//                });
//                thread.start();


                //group.setText("success");
                Intent intent = new Intent(v.getContext(), TapeActivity.class);
                startActivity(intent);


            }
        });

    }








}