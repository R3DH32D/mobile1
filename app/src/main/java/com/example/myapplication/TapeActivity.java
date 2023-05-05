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
    List<Posts> posts=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        thread.start();
        setContentView(R.layout.activity_tape);

       // setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);


        PostAdapter adapter = new PostAdapter(this, posts);
        //Toast toast = Toast.makeText(this, "постов нет",Toast.LENGTH_LONG);
        recyclerView.setAdapter(adapter);
        Button postButton = (Button) findViewById(R.id.addPost);
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), AddPostActivity.class);
                startActivity(intent);

            }
        });
    }
    private void setInitialData(){

  //      posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead" ));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead" ));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead" ));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead" ));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
//        posts.add(new Posts ("www.youtube.com/watch?v=UYRdtfo5Ix0", "ООП","поставьте за курсач 4 плез", "Аршинский В.Л.", "redhead"));
    }

//    String subjectName,
//    String teacherFIO,
//    String text,
//    String  specLinks,
//    String student
       Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {

            try {

               posts= Arrays.stream(client.getDescriptions()).collect(Collectors.toList());
            } catch
            (NullPointerException e) {

                //toast.show();
            }
        }


    });





}