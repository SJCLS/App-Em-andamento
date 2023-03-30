package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    private ProgressBar progressBarHorizontal;
    private ProgressBar progressBarCircular;
    private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBarCircular = findViewById(R.id.progressBarCircular);
        progressBarCircular.setVisibility(View.GONE);
    }
    public void cameraDialog(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Permissão Camera!");
        dialog.setMessage("Para usar esse funcionalidade precisamos da permissão da camera.");
        dialog.setIcon(android.R.drawable.ic_menu_camera);
        dialog.setCancelable(false);

        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Permissão concedida", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Permissão negada", Toast.LENGTH_SHORT).show();

            }
        });
        dialog.create();
        dialog.show();
    }
    public void carregarProgressBar(View view){
        final int progressoMaximo = 10;
        final int intervaloDeAtualizacao = 500; // em milissegundos
        final Handler handler = new Handler();
        final Runnable atualizarProgressBar = new Runnable() {
            @Override
            public void run() {
                progressBarHorizontal.setProgress(progresso);
                if (progresso < progressoMaximo) {
                    progresso++;
                    handler.postDelayed(this, intervaloDeAtualizacao);
                } else {
                    progressBarCircular.setVisibility(View.GONE);
                }
            }
        };
        progressBarCircular.setVisibility(View.VISIBLE);
        progresso = 0;
        handler.post(atualizarProgressBar);
    }

}