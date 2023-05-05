package com.example.myapplication;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Posts> posts;

    PostAdapter(Context context, List<Posts> posts) {
        this.posts = posts;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_layout, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(PostAdapter.ViewHolder holder, int position) {
        Posts post = posts.get(position);

        holder.userView.setText(post.getStudent());
        holder.teacherView.setText(post.getTeacherFIO());
        holder.descriptionView.setText(post.getText());
        holder.subjectView.setText(post.getSubjectName());
        holder.linksView.setText(post.getSpecLinks());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

public static class ViewHolder extends RecyclerView.ViewHolder {

    final TextView userView, teacherView, descriptionView, subjectView, linksView;
    ViewHolder(View view){
        super(view);

        userView = view.findViewById(R.id.user);
        teacherView = view.findViewById(R.id.teacher);
        descriptionView = view.findViewById(R.id.description);
        subjectView = view.findViewById(R.id.subject);
        linksView = view.findViewById(R.id.links);

    }
}}