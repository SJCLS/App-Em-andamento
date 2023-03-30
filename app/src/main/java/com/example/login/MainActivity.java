package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView email;
    private TextView senha;
    private TextView result;
    private CheckBox termo;
    private CheckBox politica;
    private Button entrar;
    private Switch logado;
    private String email1;
    private String senha1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.txtEmail);
        senha = findViewById(R.id.txtSenha);
        result = findViewById(R.id.txtResult);
        termo = findViewById(R.id.checkTermos);
        politica = findViewById(R.id.checkPolitica);
        entrar = findViewById(R.id.btnEntrar);
        logado = findViewById(R.id.checkLogado);

        manterlogado();
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                email1 = charSequence.toString();
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        senha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                senha1 = charSequence.toString();
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
        email1 = email.getText().toString();
        senha1 = senha.getText().toString();
    }
    public void manterlogado(){
        logado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    //result.setText(logado.getTextOn());
                    result.setText("");
                    Toast.makeText(MainActivity.this, logado.getTextOn(), Toast.LENGTH_SHORT).show();

                }else {
                    //result.setText(logado.getTextOff());
                    Toast.makeText(getApplicationContext(), logado.getTextOff(), Toast.LENGTH_SHORT).show();
                   /* Toast toast = new Toast(getApplicationContext());
                    toast.setView((View) logado.getTextOff());
                    toast.setGravity(Gravity.TOP,0,0);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();*/
                }
            }
        });
    }
    public void entrar(View view) {

        if (!email1.isEmpty() && !senha1.isEmpty()) {
            if (termo.isChecked() && politica.isChecked()) {
               // result.setText("Sucesso!");
                Toast.makeText(this, "Sucesso!", Toast.LENGTH_SHORT).show();
                Intent irhome = new Intent(MainActivity.this, Home.class);
                startActivity(irhome);
            } else {
               // result.setText("Termos e Politicas devem ser aceito para prosseguir!");
                Toast.makeText(this, "Termos e Politicas devem ser aceito para prosseguir!", Toast.LENGTH_SHORT).show();
            }
        } else {
           // result.setText("Preencha os campos corretamente!");
             Toast.makeText(this, "Preencha os campos corretamente!", Toast.LENGTH_SHORT).show();
        }
    }
    public void fecharTeclado(View view){
        if (!email1.isEmpty() && !senha1.isEmpty()) {
            entrar.setBackgroundColor(Color.parseColor("#FF0B3F4F"));
            entrar.setTextColor(Color.parseColor("#FFFFFF"));
        }else {
            entrar.setBackgroundColor(Color.parseColor("#630B3F4F"));
            entrar.setTextColor(Color.parseColor("#FF000000"));
        }
        InputMethodManager fecharteclado = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        fecharteclado.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}