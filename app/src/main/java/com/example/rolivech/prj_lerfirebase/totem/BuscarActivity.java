package com.example.rolivech.prj_lerfirebase.totem;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rolivech.prj_lerfirebase.R;
import com.example.rolivech.prj_lerfirebase.Visitantes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuscarActivity extends AppCompatActivity {

    private EditText et_telefone;
    private Button btn_buscar;
    private List<Visitantes> listVisitante = new ArrayList<Visitantes>();

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {
        btn_buscar = findViewById(R.id.buscar_btn_buscar);
        et_telefone = findViewById(R.id.buscar_et_telefone);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("visitantes");
    }

    private void inicializarAcao() {
        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procurarVisitante(String.valueOf(et_telefone.getText()));
            }
        });
        //
    }

    private void procurarVisitante(String telefone){

        /*Query query = mDatabase.equalTo(telefone);
        Visitantes visitante = new Visitantes();

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> listaVisitantes = new ArrayList<String>();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    listaVisitantes.add(postSnapshot.getValue().toString());
                }
                int i = 10;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    for(DataSnapshot vSnapshot : snapshot.)
                }

                listVisitante.clear();
                Visitantes v;
                v = dataSnapshot.getValue(Visitantes.class);
                listVisitante.add(v);


                int i = 10;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
