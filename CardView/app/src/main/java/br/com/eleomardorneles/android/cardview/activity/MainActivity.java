package br.com.eleomardorneles.android.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.eleomardorneles.android.cardview.R;
import br.com.eleomardorneles.android.cardview.adapter.PostsAdapter;
import br.com.eleomardorneles.android.cardview.model.Post;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerPosts;
    private List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPosts = findViewById(R.id.recyclerPosts);
        this.createListOfPosts();

        //Definir Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPosts.setLayoutManager(layoutManager);

        //Definir o Adapter
        PostsAdapter postsAdapter = new PostsAdapter(posts);
        recyclerPosts.setAdapter(postsAdapter);
        recyclerPosts.setHasFixedSize(true);
    }

    private void createListOfPosts() {
        Post post = new Post("Eleomar Dorneles", "#TBT Saudades viagem", R.drawable.imagem1);
        this.posts.add(post);

        post = new Post("João Fulano", "#TBT Saudades viagem,Saudades viagem", R.drawable.imagem2);
        this.posts.add(post);

        post = new Post("Eleomar Dorneles", "#TBT", R.drawable.imagem3);
        this.posts.add(post);

        post = new Post("Vitor", "Blabla bla;", R.drawable.imagem4);
        this.posts.add(post);
    }
}