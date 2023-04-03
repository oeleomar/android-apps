package br.com.eleomardorneles.android.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Botão pressionado", Snackbar.LENGTH_SHORT)
                        .setAction("Confirmar", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                button.setText("Botão abrir alterado");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.purple_200))
                        .show();
            }
        });
    }
}