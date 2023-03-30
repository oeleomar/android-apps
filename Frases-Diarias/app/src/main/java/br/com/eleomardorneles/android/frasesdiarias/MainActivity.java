package br.com.eleomardorneles.android.frasesdiarias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Refresh(View view) {
        String[] phrases = {
                "É em meio a dificuldade que se encontra a oportunidade",
                "O êxito é ir de frustração a frustração sem perder a animação",
                "Mesmo que algo pareça difícil, nunca desista antes de tentar",
                "Você é o único que entende as suas dificuldades, por isso motive se a prosseguir",
                "Não é uma vida ruim, é apenas um dia ruim, lembre-se disso",
                "A maior prova de que você pode fazer o impossível, é superar circunstâncias difíceis",
                "Que os dias bons se tornem rotina, e os ruins se tornem raros",
                "É genial celebrar a vitória, contudo é mais significativo aprender com as lições da derrota",
                "Qualquer dificuldade pode ser ultrapassada, já que para todo problema há uma solução",
                "Já pensou que você já superou muitas dificuldades até aqui?",
        };

        int index = new Random().nextInt(phrases.length);

        TextView text = findViewById(R.id.phrase);
        text.setText(phrases[index]);
    }
}