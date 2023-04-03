package br.com.eleomardorneles.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

                Usuario usuario = new Usuario("Eleomar Dorneles", "eleomar@gmail.com");
                //Adicionar parametros para passar de uma activity para outra
                intent.putExtra("nome", "Eleomar Dorneles");
                intent.putExtra("idade", 22);
                //Para transmitir objetos é necessário usar a interface Serializable
                intent.putExtra("objeto", usuario);

                startActivity(intent);
            }
        });
    }
}