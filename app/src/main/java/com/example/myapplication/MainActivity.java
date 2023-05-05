package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.activity.TapeActivity;
import com.example.myapplication.web.ApiClient;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

import ru.toylep.example.R;


public class MainActivity extends AppCompatActivity {
    private ApiClient client = new ApiClient();
    private Button regButton;
    private TextView groups;
    private TextView login;
    private TextView password;
    private TextView name;
    private TextView lastname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         regButton = (Button) findViewById(R.id.button_SignUp);
         groups = (TextView) findViewById(R.id.groups);
         login = (TextView) findViewById(R.id.login);
         password =   (TextView) findViewById(R.id.password);
         name =  (TextView) findViewById(R.id.name);
         lastname = (TextView) findViewById(ru.toylep.example.R.id.lastname);


        regButton.setOnClickListener(new View.OnClickListener() {

            @Override
        public void onClick(View v) {
             thread.start();
             try {
                 thread.sleep(2000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             Intent intent = new Intent(v.getContext(), TapeActivity.class);
             startActivity(intent);
            }
        });

    }
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                client.postUser(groups.getText().toString(),
                        name.getText().toString(),
                        lastname.getText().toString(),
                        login.getText().toString(),
                        password.getText().toString());

            } catch (JsonProcessingException e) {
                groups.setText("not work");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //
        }
    });
}
