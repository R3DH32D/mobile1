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
        holder.idView.setText(post.getId().toString());
        holder.userView.setText(post.getStudent());
        holder.teacherView.setText(post.getTeacherFIO());
        holder.descriptionView.setText(post.getText());
        holder.subjectView.setText(post.getSubjectName());
        holder.linksView.setText(post.getSpecLinks());
        holder.comButton.setOnClickListener(new View.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {
                                                    Context context = v.getContext();
                                                    Intent intent = new Intent(v.getContext(), CommentActivity.class);
                                                    intent.putExtra("id", holder.idView.getText() );

                                                    context.startActivity(intent);
                                                }
                                            }

        );
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

public static class ViewHolder extends RecyclerView.ViewHolder  {
    private Button comButton;
    private TextView userView,idView, teacherView, descriptionView, subjectView, linksView;
    ViewHolder(View view){
        super(view);
        idView = (TextView) view.findViewById(R.id.idView);
        comButton = (Button) view.findViewById(R.id.commentaryButton);
        userView = (TextView) view.findViewById(R.id.user);
        teacherView = (TextView) view.findViewById(R.id.teacher);
        descriptionView =(TextView) view.findViewById(R.id.description);
        subjectView =(TextView) view.findViewById(R.id.subject);
        linksView =(TextView) view.findViewById(R.id.links);

    }

//    @Override
//    public void onClick(View v) {
//
//    }
}}