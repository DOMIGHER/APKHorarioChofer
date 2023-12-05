package com.example.apkhorariochofer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityF11 extends AppCompatActivity {
    EditText horaEntrada, horaSalida;
    Button btnEdit, btnElim;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ChoferHoraModel choferHoraModelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f11);

        String uidchoint = getIntent().getStringExtra("uidC");
        String uidchohoraint = getIntent().getStringExtra("uid");
        String horaentradachofint = getIntent().getStringExtra("horaentrada");
        String horasalidachofint = getIntent().getStringExtra("horasalida");


        horaEntrada = findViewById(R.id.txtHoraEntradaChover);
        horaSalida = findViewById(R.id.txtHoraSalidaChover);

        iniciaFire();

        btnEdit = findViewById(R.id.btneditHoraChofer);
        btnElim = findViewById(R.id.btneliminartHoraChofer);

        horaEntrada.setText(horaentradachofint);
        horaSalida.setText(horasalidachofint);

        choferHoraModelper = new ChoferHoraModel();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoferModel p = new ChoferModel();
                p.setUid(uidchoint);

                choferHoraModelper.setUid(uidchohoraint);
                choferHoraModelper.setHoraEntrada(horaEntrada.getText().toString().trim());
                choferHoraModelper.setHoraSalida(horaSalida.getText().toString().trim());

                databaseReference.child("chofer").child(p.getUid()).child("horario").child(choferHoraModelper.getUid()).setValue(choferHoraModelper);
                Toast.makeText(MainActivityF11.this, "Actualizado", Toast.LENGTH_SHORT).show();

                /*
                Intent intent = new Intent(v.getContext(), MainActivityF9.class);
                startActivity(intent);
                */

            }
        });


        btnElim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoferModel p = new ChoferModel();
                p.setUid(uidchoint);
                choferHoraModelper.setUid(uidchohoraint);

                databaseReference.child("chofer").child(p.getUid()).child("horario").child(choferHoraModelper.getUid()).removeValue();
                Toast.makeText(MainActivityF11.this, "Elimindo", Toast.LENGTH_SHORT).show();

                /*
                Intent intent = new Intent(MainActivityF11.this, MainActivityF9.class);
                startActivity(intent);*/
            }
        });



    }
    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}