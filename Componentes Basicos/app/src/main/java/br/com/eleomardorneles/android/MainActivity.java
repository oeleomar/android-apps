package br.com.eleomardorneles.android;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private TextInputEditText email;
    private TextView result;
    private CheckBox checkVerde, checkAzul, checkVermelho;
    private RadioGroup radioGroup;
    private RadioButton radioOption, sexoFeminino, sexoMasculino;
    private Switch switchSenha;
    private ToggleButton toggleDesligado;
    private ProgressBar progressBar;
    private ProgressBar horizontalProgressBar;
    private int progress = 0;
    private SeekBar seekBar;

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

        this.switchSenha = findViewById(R.id.switchSenha);
        this.toggleDesligado = findViewById(R.id.toggleLigado);

        this.progressBar = findViewById(R.id.progressBar);
        this.progressBar.setVisibility(View.GONE);
        this.horizontalProgressBar = findViewById(R.id.horizontalProgressBar);
        horizontalProgressBar.setVisibility(View.GONE);

        this.seekBar = findViewById(R.id.seekBar);
        this.seekBar.setMax(10);

        this.adicionarListener();
        this.adicionarListenerSeekBar();
    }

    public void adicionarListenerSeekBar() {
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               result.setText("Progresso: " + i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    public void recoverySeekBar(View view) {
        result.setText("Valor recuperado: " + this.seekBar.getProgress());
    }

    public void loading(View view) {
        progressBar.setVisibility(View.VISIBLE);
        horizontalProgressBar.setVisibility(View.VISIBLE);

        this.progress++;
        horizontalProgressBar.setMax(10);
        horizontalProgressBar.setProgress(this.progress);
        if (horizontalProgressBar.getProgress() == horizontalProgressBar.getMax())
            horizontalProgressBar.setVisibility(View.GONE);

        progressBar.setMax(10);
        progressBar.setProgress(this.progress);
        if (this.progress == progressBar.getMax()) progressBar.setVisibility(View.GONE);
    }

    public void createAlertDialog(View view) {
        //Instanciar AlertDialog
        //Configurar Título e Mensagem
        //Configurar Ações para o sim e não
        //Criar e exibir Dialog

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Titulo da Dialog");
        dialog.setMessage("Mensagem do Dialog");

        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Ação clicada: SIM", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Ação clicada: NÃO", Toast.LENGTH_SHORT).show();
            }
        });

        //Configurar cancelamento (caso o usuário clique fora da tela, true para permitir, false para bloquear)
        dialog.setCancelable(true);

        //Configurar Icone
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        dialog.create();
        dialog.show();
    }

    public void sendToast(View view) {
        //Criar o próprio toast
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(android.R.drawable.star_big_off);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(imageView);
        toast.show();


        //Para utilizar um toast pronto
        //Toast.makeText(getApplicationContext(), "Esse é um toast", Toast.LENGTH_SHORT).show();
    }


    public void send(View view) {

//        if (switchSenha.isChecked()) {
//            result.setText("Salvar senha ativado.");
//        }
//
//        if (toggleDesligado.isChecked()) {
//            result.setText(result.getText().toString() + " - " + "Toggle ligado");
//        }

//        radioButton();

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

    public void adicionarListener() {
        this.switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    result.setText("Está ativado");
                } else {
                    result.setText("Está desativado");
                }
            }
        });
    }

    public void clean(View view) {
        this.name.setText("");
        this.email.setText("");
    }


    public void checkBox() {
        String text = "";
        if (checkVerde.isChecked()) text += "Verde selecionado - ";
        if (checkVermelho.isChecked()) text += "Vermelho selecionado - ";
        if (checkAzul.isChecked()) text += "Azul selecionado";

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

}