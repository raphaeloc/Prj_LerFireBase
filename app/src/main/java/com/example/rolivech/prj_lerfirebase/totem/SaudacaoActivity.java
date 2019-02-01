package com.example.rolivech.prj_lerfirebase.totem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rolivech.prj_lerfirebase.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class SaudacaoActivity extends AppCompatActivity {

    private TextView tv_nome;
    private ImageView iv_foto;
    private ConstraintLayout saudacao_tela;
    private Button btn_ok, btn_cancela;
    private DatabaseReference mDatabase;
    private StorageReference mStorage;
    private String id;
    private int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saudacao);

        inicializarVariaveis();
        inicializarAcao();
    }

    private void inicializarVariaveis() {
        tv_nome = findViewById(R.id.saudacao_tv_nome);
        btn_ok = findViewById(R.id.saudacao_btn_ok);
        iv_foto = findViewById(R.id.imageView);
        saudacao_tela = findViewById(R.id.saudacao_tela);
        //
        //
        Intent mIntent = getIntent();
        id = mIntent.getStringExtra("id");
        color = mIntent.getIntExtra("color", -1);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("visitantes");
        mStorage = FirebaseStorage.getInstance().getReference();

        //
        Query query = mDatabase.child(id);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HMAux aux = new HMAux();

                String nome = dataSnapshot.child("nome").getValue().toString();
                String photopath = dataSnapshot.child("photopath").getValue().toString();


                StorageReference pathReference = mStorage.child(photopath);
                pathReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(iv_foto);
                    }
                });
                getWindow().setStatusBarColor(color);
                saudacao_tela.setBackgroundColor(color);
                tv_nome.setText(nome);
                int i = 10;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarAcao() {

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mDatabase.child(id).child("status").setValue(true);
                    Toast.makeText(SaudacaoActivity.this, "Sucesso!", Toast.LENGTH_SHORT).show();
                    Intent mIntent = new Intent(SaudacaoActivity.this, BuscarActivity.class);
                    //
                    startActivity(mIntent);
                    //
                    finish();
                }
                catch(Exception e){
                    Toast.makeText(SaudacaoActivity.this, "Erro: " + e +". Tente novamente.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
