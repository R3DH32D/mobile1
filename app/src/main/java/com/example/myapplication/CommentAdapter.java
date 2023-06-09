package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<Comment> comms;


    public CommentAdapter(Context context, List<Comment> comms) {
        this.inflater = LayoutInflater.from(context);
        this.comms = comms;
    }



    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.commrecycler_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, int position) {
        Comment comment = comms.get(position);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                holder.studView.setText(comment.getStudent().toString());
                System.out.println(comment.getText());
                holder.commTextView.setText(comment.getText().toString());
            }});
        thread1.start();


    }

    @Override
    public int getItemCount() {
        return comms.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder  {

        private TextView studView, commTextView;
        ViewHolder(View view){
            super(view);

            studView = (TextView) view.findViewById(R.id.StudCommText);
            commTextView = (TextView) view.findViewById(R.id.comm_Text);
        }


    }
}
