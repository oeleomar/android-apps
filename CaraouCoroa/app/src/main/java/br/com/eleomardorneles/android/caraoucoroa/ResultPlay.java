package br.com.eleomardorneles.android.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class ResultPlay extends AppCompatActivity {
    private int choice;
    private ImageView image;
    private ImageButton buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_play);

        image = findViewById(R.id.coin);
        buttonReturn = findViewById(R.id.buttonReturn);

        choice = new Random().nextInt(2);

        if(choice == 0) {
            image.setImageResource(R.drawable.moeda_cara);
        }else {
            image.setImageResource(R.drawable.moeda_coroa);
        }

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Encarra a Activity e retorna para a pilha anterior.
                finish();
            }
        });
    }
}