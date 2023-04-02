package br.com.eleomardorneles.reciclerview.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.eleomardorneles.reciclerview.R;
import br.com.eleomardorneles.reciclerview.adapter.Adapter;
import br.com.eleomardorneles.reciclerview.model.Film;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Film> films = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Criar filmes
        this.createListFilms();


        //COnfigurar o Adapter
        Adapter adapter = new Adapter(this.films);

        //Configurar o LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    private void createListFilms () {
        Film film = new Film("Homem Aranha de volta ao Lar", "2017", "Aventura");
        this.films.add(film);
        film = new Film("Mulher Maravilha", "2017", "Fantasia");
        this.films.add(film);

        film = new Film("Liga da Justiça", "2017", "Ficção");
        this.films.add(film);

        film = new Film("Capitão América - Guerra Civil", "2016", "Ação");
        this.films.add(film);

        film = new Film("It: A coisa", "2017", "Drama/Terror");
        this.films.add(film);

        film = new Film("Pica Pau o Filme", "2016", "Comédia/Animação");
        this.films.add(film);

        film = new Film("A múmia", "2020", "Terror");
        this.films.add(film);

        film = new Film("A Bela e a Fera", "2021", "Romance");
        this.films.add(film);

        film = new Film("Meu Malvado Favorito 3", "2017", "Animação/Comédia");
        this.films.add(film);

        film = new Film("Carros 3", "2017", "Animação");
        this.films.add(film);
    }


}