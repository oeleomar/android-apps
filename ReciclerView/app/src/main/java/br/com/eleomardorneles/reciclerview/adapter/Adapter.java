package br.com.eleomardorneles.reciclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.eleomardorneles.reciclerview.R;
import br.com.eleomardorneles.reciclerview.model.Film;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Film> films;

    public Adapter(List<Film> films) {
        this.films = films;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Film film = this.films.get(position);
        holder.titulo.setText(film.getTitulo());
        holder.ano.setText(film.getAno());
        holder.genero.setText(film.getGenero());
    }

    @Override
    public int getItemCount() {
        return this.films.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo  = itemView.findViewById(R.id.textTitulo);
            ano  = itemView.findViewById(R.id.textAno);
            genero  = itemView.findViewById(R.id.textGenero);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), titulo.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
