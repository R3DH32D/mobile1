package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fasterxml.jackson.core.JsonProcessingException;

public class AddCommActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comm);
        Button addButton = (Button) findViewById(R.id.AddCommButton);

        EditText commText = (EditText) findViewById(R.id.EditTextAddComm);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiClient client = new ApiClient();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            client.postAddComm(1L, commText.getText().toString(),null);

                        } catch (JsonProcessingException e) {

                        }

                        //
                    }
                });
                thread.start();


                //group.setText("success");
                Intent intent = new Intent(v.getContext(), CommentActivity.class);
                startActivity(intent);


            }
        });
    }
}