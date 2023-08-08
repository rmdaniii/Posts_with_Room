package com.example.postswithroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private ArrayList<Post> postList = new ArrayList<>();

    @NonNull
    @Override
    public PostsAdapter.PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.PostsViewHolder holder, int position) {

        holder.title.setText(postList.get(position).getTitle());
        holder.body.setText(postList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setPostList(ArrayList<Post> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {
        private TextView title , body;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.list_item_title);
            body = itemView.findViewById(R.id.list_item_body);
        }
    }
}
