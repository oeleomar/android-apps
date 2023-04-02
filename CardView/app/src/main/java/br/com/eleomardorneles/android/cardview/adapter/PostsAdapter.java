package br.com.eleomardorneles.android.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.eleomardorneles.android.cardview.R;
import br.com.eleomardorneles.android.cardview.model.Post;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyHolderAdapter> {
    List<Post> postsList;

    public PostsAdapter(List<Post> posts) {
        this.postsList = posts;
    }

    @NonNull
    @Override
    public MyHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View postLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);
        return new MyHolderAdapter(postLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderAdapter holder, int position) {
        Post post = postsList.get(position);
        holder.username.setText(post.getName());
        holder.post.setText(post.getPostText());
        holder.image.setImageResource(post.getImage());
    }

    @Override
    public int getItemCount() {
        return this.postsList.size();
    }

    public class MyHolderAdapter extends RecyclerView.ViewHolder{
        private TextView username;
        private TextView post;
        private ImageView image;

        public MyHolderAdapter(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.textName);
            post = itemView.findViewById(R.id.textPost);
            image = itemView.findViewById(R.id.imageView);

        }
    }
}
