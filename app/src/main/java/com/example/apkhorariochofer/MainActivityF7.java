package com.example.apkhorariochofer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityF7 extends AppCompatActivity {
    EditText nombreR, direcionbaseR, horaEntradaR, horaSalidaR;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    MainModel mainModelseleverrevisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f7);

        String uidrevint = getIntent().getStringExtra("uid");
        String nombrerevint = getIntent().getStringExtra("nombrerevint");
        String direccionbaserevint = getIntent().getStringExtra("direccionbaserevint");
        String horaentrarevint = getIntent().getStringExtra("horaentrarevint");
        String horasalidarevint = getIntent().getStringExtra("horasalidarevint");

        nombreR = findViewById(R.id.txtNombreRevisadorVer);
        direcionbaseR = findViewById(R.id.txtPocisRevisadorVer);
        horaEntradaR = findViewById(R.id.txtHoraEntradaRevisadorVer);
        horaSalidaR = findViewById(R.id.txtHoraSalidaRevisadorVer);

        iniciaFire();

        nombreR.setText(nombrerevint);
        direcionbaseR.setText(direccionbaserevint);
        horaEntradaR.setText(horaentrarevint);
        horaSalidaR.setText(horasalidarevint);
    }


    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void registrarhorariochofer(View view) {
        Intent intent = new Intent(view.getContext(), MainActivityF8.class);
        view.getContext().startActivity(intent);
    }

}