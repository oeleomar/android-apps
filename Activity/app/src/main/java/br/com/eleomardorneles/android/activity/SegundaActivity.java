package br.com.eleomardorneles.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    private TextView nome, idade, obejctName, objectEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        nome = findViewById(R.id.textNome);
        idade = findViewById(R.id.textParameter);
        obejctName = findViewById(R.id.textObjectName);
        objectEmail = findViewById(R.id.textObjectEmail);

        //Recuperar dados
        Bundle dados = getIntent().getExtras();
        Usuario usuario = (Usuario) dados.getSerializable("objeto");

        nome.setText(dados.getString("nome"));
        idade.setText(String.valueOf(dados.getInt("idade")));

        obejctName.setText(usuario.getNome());
        objectEmail.setText(usuario.getEmail());

    }
}