package com.example.apkhorariochofer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivityFAddAdmin extends AppCompatActivity {

    EditText nombreA, correo, password;

    Button btnAddAdm;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fadd_admin);
        iniciaFire();

        nombreA = findViewById(R.id.txtNombreAnadirAdm);
        correo = findViewById(R.id.txtCorreoAnadirAdm);
        password = findViewById(R.id.txtPasswordAnadirAdm);

        btnAddAdm = findViewById(R.id.idAddAdmin);

        btnAddAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = nombreA.getText().toString();
                String correo = MainActivityFAddAdmin.this.correo.getText().toString();
                String password = MainActivityFAddAdmin.this.password.getText().toString();
                String accessType = "admin";

                MainAdmin p = new MainAdmin();
                p.setUid(UUID.randomUUID().toString());
                p.setNombreA(nombre);
                p.setCorreo(correo);
                p.setPassword(password);
                p.setAccessType(accessType);

                databaseReference.child("admin").child(p.getUid()).setValue(p);
                Toast.makeText(MainActivityFAddAdmin.this, "Admin Añadido", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}