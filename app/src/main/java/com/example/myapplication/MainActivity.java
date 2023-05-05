package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.core.JsonProcessingException;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button regButton = (Button) findViewById(R.id.button_SignUp);
        //Button logButton = (Button) findViewById(R.id.log_in_button);
         TextView groups = (TextView) findViewById(R.id.groups);//new TextView(this);// findViewById(R.id.EditTextViewGroup);

         TextView login = (TextView) findViewById(R.id.login); //new TextView(this);//findViewById(R.id.editTextViewLogin);

         TextView password =   (TextView) findViewById(R.id.password);//new TextView(this);// findViewById(R.id.editTextViewPassword);

         TextView name =  (TextView) findViewById(R.id.name);//new TextView(this); //findViewById(R.id.editTextViewName);

         TextView lastname = (TextView) findViewById(R.id.lastname);//new TextView(this);//findViewById(R.id.editTextViewLastName);

       // apiInterface = ApiClient.getClient().create(ServerCon.class);
        regButton.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View v) {
        ApiClient client = new ApiClient();

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
        }
        //
            }
        });
             thread.start();
             try {
                 thread.sleep(2000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }


             //thread.start();
        //group.setText("success");
             Intent intent = new Intent(v.getContext(), TapeActivity.class);
             startActivity(intent);


    }
});

    }
}
