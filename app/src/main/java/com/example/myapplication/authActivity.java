package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonProcessingException;

public class authActivity extends AppCompatActivity {
   // ApiClient client;
    Thread thread;
    private Boolean truth;
  //  Toast toast = Toast.makeText(this, "неверный логин или пароль",Toast.LENGTH_LONG);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Button loginButton = (Button) findViewById(R.id.logButton);
        EditText password = (EditText) findViewById(R.id.text_password);//new TextView(this);// findViewById(R.id.EditTextViewGroup);
        EditText login = (EditText) findViewById(R.id.login_text); //new TextView(this);//findViewById(R.id.editTextViewLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiClient client = new ApiClient();

                 thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            truth = client.postAuth(login.getText().toString(),password.getText().toString());
                            System.out.println(truth);
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                thread.start();
                try {
                    thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (truth) {
                    Intent intent = new Intent(v.getContext(), TapeActivity.class);
                    startActivity(intent);
                }
                else {
                  // toast.show();
                }

            }
        });




    }
}