package br.com.eleomardorneles.android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private TextInputEditText email;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = findViewById(R.id.name);
        this.email = findViewById(R.id.email);
        this.result = findViewById(R.id.textView);

        this.clean();
    }

    public void send(View view) {
        String nome = this.name.getText().toString();
        String editedEmail = this.email.getText().toString();

        if (nome.isEmpty() || editedEmail.isEmpty()) {
            this.result.setText("Campo nome e email são obrigatórios.");
            return;
        }

        this.result.setText("Nome: " + nome + " - " + "email: " + editedEmail);
    }

    private void clean() {
        this.name.setText("");
        this.email.setText("");
    }
}