package br.com.eleomardorneles.android.gasolinaoualcool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editPrecoAlcool = findViewById(R.id.editAlcool);
        this.editPrecoGasolina = findViewById(R.id.editGasolina);
        this.textResult = findViewById(R.id.textResult);
    }

    public void calculate(View view) {
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        if(this.validadeFields(precoAlcool, precoGasolina)){
            Double valueAlcool = Double.parseDouble(precoAlcool);
            Double valueGasolina = Double.parseDouble(precoGasolina);

            if(valueGasolina != 0 && (valueAlcool / valueGasolina >=0.7)) {
                textResult.setText("Melhor utilizar gasolina.");
            }else {
                textResult.setText("Melhor utilizar alcool.");
            }
        }else {
            textResult.setText("Digite todos os valores.");
        }

    }

    private boolean validadeFields(String precoAlcool, String precoGasolina) {
        if(
            precoAlcool.isEmpty()
            || precoAlcool == null
            || precoGasolina.isEmpty()
            || precoGasolina == null
        ) {
            return false;
        }

        return true;
    }
}