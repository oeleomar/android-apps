package br.com.eleomardorneles.calculadoradegorjeta;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView totalGorjeta;
    private TextInputEditText valorConta;
    private TextView total;
    private SeekBar seekBar;
    private TextView percetageView;
    private int percentage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.totalGorjeta = findViewById(R.id.totalGorjeta);
        this.total = findViewById(R.id.total);
        this.seekBar = findViewById(R.id.seekBar);
        this.percetageView = findViewById(R.id.seekBarPercentage);
        this.valorConta = findViewById(R.id.valorConta);

        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                percentage = i;
                percetageView.setText(i + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void calcular() {
        String valorRecuperado = this.valorConta.getText().toString();

        if (valorRecuperado.isEmpty() || valorRecuperado == null) {
            Toast.makeText(getApplicationContext(), "Digite um valor primeiro", Toast.LENGTH_LONG).show();
        }else {
            Double valor = Double.parseDouble(valorRecuperado);
            Double gorjeta = valor * this.percentage / 100;
            Double totalAmount = valor + gorjeta;

            totalGorjeta.setText("R$ " + gorjeta);
            total.setText("R$ " + totalAmount);
        }


    }
}