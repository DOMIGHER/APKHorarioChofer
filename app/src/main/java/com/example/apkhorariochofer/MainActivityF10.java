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

import org.checkerframework.common.subtyping.qual.Bottom;

import java.util.UUID;

public class MainActivityF10 extends AppCompatActivity {
    EditText horaEntrada, horaSalida;
    Button btnaddHoraChofer;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f10);

        String uidchoferint = getIntent().getStringExtra("uid");

        horaEntrada = findViewById(R.id.txtHoraEntradaCho);
        horaSalida = findViewById(R.id.txtHoraSalidaCho);
        iniciaFire();

        btnaddHoraChofer = findViewById(R.id.btnAddHoraChofer);
        btnaddHoraChofer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String horaentrada = horaEntrada.getText().toString();
                String horasalida = horaSalida.getText().toString();

                ChoferModel pModel = new ChoferModel();
                pModel.setUid(uidchoferint);

                ChoferHoraModel p = new ChoferHoraModel();
                p.setUid(UUID.randomUUID().toString());
                p.setHoraEntrada(horaentrada);
                p.setHoraSalida(horasalida);

                databaseReference.child("chofer").child(pModel.getUid()).child("horario").child(p.getUid()).setValue(p);
                Toast.makeText(MainActivityF10.this, "Añadido", Toast.LENGTH_SHORT).show();

                /*
                Intent intent = new Intent(v.getContext(), MainActivityF9.class);
                v.getContext().startActivity(intent); */
            }
        });

    }

    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}