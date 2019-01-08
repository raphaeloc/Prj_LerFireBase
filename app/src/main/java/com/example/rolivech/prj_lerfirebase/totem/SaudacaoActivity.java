package com.example.rolivech.prj_lerfirebase.totem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rolivech.prj_lerfirebase.R;

public class SaudacaoActivity extends AppCompatActivity {

    private TextView tv_nome;
    private ImageView iv_foto;
    private Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {

    }

    private void inicializarAcao() {
    }
}
