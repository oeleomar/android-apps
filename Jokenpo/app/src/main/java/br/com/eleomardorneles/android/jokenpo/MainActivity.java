package br.com.eleomardorneles.android.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void stoneChoice(View view) {
        this.getChoice("stone");
    }

    public void paperChoice(View view) {
        this.getChoice("paper");
    }

    public void scissorChoice(View view) {
        this.getChoice("scissor");
    }

    public void getChoice(String choice) {
        int numberChoice = new Random().nextInt(3);
        String[] options = {"stone", "paper", "scissor"};
        String machineOption = options[numberChoice];
        System.out.println(machineOption);

        ImageView imageView = findViewById(R.id.imageResult);
        TextView result = findViewById(R.id.result);

        switch (machineOption) {
            case "stone":
                imageView.setImageResource(R.drawable.pedra);
                break;
            case "paper":
                imageView.setImageResource(R.drawable.papel);
                break;
            case "scissor":
                imageView.setImageResource(R.drawable.tesoura);
                break;
        }

        if (machineOption == "stone" && choice == "scissor" || machineOption == "paper" && choice == "stone" || machineOption == "scissor" && choice == "paper") {
            result.setText("Você perdeu!");
        } else if (choice == "stone" && machineOption == "scissor" || choice == "paper" && machineOption == "stone" || choice == "scissor" && machineOption == "paper") {
            result.setText("Você ganhou!");
        } else {
            result.setText("Empate!");
        }

    }
}