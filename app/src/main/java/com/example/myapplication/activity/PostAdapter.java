package com.example.myapplication.activity;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.Post;

import java.util.List;

import ru.toylep.example.R;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Post> posts;

    PostAdapter(Context context, List<Post> posts) {
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
        Post post = posts.get(position);

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
    private TextView userView, teacherView, descriptionView, subjectView, linksView;
    public ViewHolder(View view){
        super(view);

        userView = (TextView) view.findViewById(ru.toylep.example.R.id.user);
        teacherView = (TextView) view.findViewById(R.id.teacher);
        descriptionView =(TextView) view.findViewById(R.id.description);
        subjectView =(TextView) view.findViewById(R.id.subject);
        linksView =(TextView) view.findViewById(R.id.links);

    }
}}