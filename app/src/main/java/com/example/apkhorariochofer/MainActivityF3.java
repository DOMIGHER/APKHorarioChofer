package com.example.apkhorariochofer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivityF3 extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button verHoraChofer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f3);

        String uidrchoint = getIntent().getStringExtra("uid");
        String nombrechoint = getIntent().getStringExtra("nombrechoint");
        String rutachoferint = getIntent().getStringExtra("rutachoferint");

        EditText nombreChofer = findViewById(R.id.txtNombreChoferVer);
        EditText rutaChoferint = findViewById(R.id.txtRutaChoferVer);
        iniciaFire();

        nombreChofer.setText(nombrechoint);
        rutaChoferint.setText(rutachoferint);

        verHoraChofer = findViewById(R.id.idVerHorarioschofer);
        verHoraChofer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivityF4.class);
                intent.putExtra("uid",uidrchoint);
                v.getContext().startActivity(intent);
            }
        });
    }

    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}