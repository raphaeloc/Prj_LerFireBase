package com.example.rolivech.prj_lerfirebase.totem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rolivech.prj_lerfirebase.R;
import com.example.rolivech.prj_lerfirebase.Visitantes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuscarActivity extends AppCompatActivity {

    private ListView lv_visitantes;

    private ArrayAdapter<HMAux> arrayAdapter;

    private VisitantesAdapter visitantesAdapter;

    private Visitantes visitantes;

    private ArrayList<HMAux> listVisitante = new ArrayList<>();

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child("visitantes");
        //
        lv_visitantes = findViewById(R.id.lv_visitantes);
        //
        visitantes = new Visitantes();
        //
        procurarVisitante();
        //
    }

    private void inicializarAcao() {
       lv_visitantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long telefone) {
               HMAux aux = (HMAux) parent.getItemAtPosition(position);
               //
               //
               String id = aux.get("id");

               Intent mIntent = new Intent(BuscarActivity.this, SaudacaoActivity.class);
               //
               mIntent.putExtra("id", id);
               //
               startActivity(mIntent);
               //
           }
       });
    }

    private void procurarVisitante(){
            mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                limparLista();
                //
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    HMAux aux = new HMAux();
                    String id = snapshot.getKey();
                    String nome = snapshot.child("nome").getValue().toString();
                    String telefone = snapshot.child("telefone").getValue().toString();
                    String status = snapshot.child("status").getValue().toString();

                    if(status.equals("false")){
                        aux.put("id", id);
                        aux.put("visitante", nome);
                        aux.put("telefone", telefone);

                        listVisitante.add(aux);
                    }
                    else{
                    }
                }
                visitantesAdapter = new VisitantesAdapter(
                        BuscarActivity.this,
                        listVisitante,
                        android.R.layout.simple_list_item_1
                );

                lv_visitantes.setAdapter(visitantesAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void limparLista() {
        listVisitante.clear();
        visitantesAdapter = new VisitantesAdapter(BuscarActivity.this, listVisitante, android.R.layout.simple_list_item_1);
        lv_visitantes.setAdapter(visitantesAdapter);
    }

}
