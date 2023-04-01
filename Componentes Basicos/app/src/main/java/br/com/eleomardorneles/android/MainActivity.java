package br.com.eleomardorneles.android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private TextInputEditText email;
    private TextView result;
    private CheckBox checkVerde, checkAzul, checkVermelho;
    private RadioGroup radioGroup;
    private RadioButton radioOption, sexoFeminino, sexoMasculino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = findViewById(R.id.name);
        this.email = findViewById(R.id.email);
        this.result = findViewById(R.id.textView);

        this.checkVerde = findViewById(R.id.checkVerde);
        this.checkAzul = findViewById(R.id.checkAzul);
        this.checkVermelho = findViewById(R.id.checkVermelho);

        this.radioGroup = findViewById(R.id.opcaoSexo);
        this.sexoMasculino = findViewById(R.id.radioButtonM);
        this.sexoFeminino = findViewById(R.id.radioButtonF);

    }

    public void checkBox() {
        String text = "";
        if (checkVerde.isChecked())
            text += "Verde selecionado - ";
        if (checkVermelho.isChecked())
            text += "Vermelho selecionado - ";
        if (checkAzul.isChecked())
            text += "Azul selecionado";

        result.setText(text);
    }

    public void radioButton() {
        //Adicionar um listner que escuta quando o usuario muda de opção
        this.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioOption = findViewById(checkedId);
                result.setText(radioOption.getText().toString());
            }
        });

//        this.radioOption = findViewById(radioGroup.getCheckedRadioButtonId());
//
//        if(radioGroup.getCheckedRadioButtonId() == -1) {
//            result.setText("Nenhuma opção selecionada");
//            return;
//        }
//
//        result.setText("Opção selecionada: " + this.radioOption.getText().toString());
    }

    public void send(View view) {
        radioButton();

//        checkBox();

//        String nome = this.name.getText().toString();
//        String editedEmail = this.email.getText().toString();
//
//        if (nome.isEmpty() || editedEmail.isEmpty()) {
//            this.result.setText("Campo nome e email são obrigatórios.");
//            return;
//        }
//
//        this.result.setText("Nome: " + nome + " - " + "email: " + editedEmail);
    }

    public void clean(View view) {
        this.name.setText("");
        this.email.setText("");
    }
}