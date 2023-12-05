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

import java.util.UUID;

public class MainActivityF20 extends AppCompatActivity {
    EditText nombreR, apellidoPaternoR, apellidoMaternoR, direcionbaseR, horaEntradaR, horaSalidaR, correo, password;
    Button btnAdd;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f20);

        //vista xml a variable
        correo = findViewById(R.id.txtCorreoRevisador);
        password = findViewById(R.id.txtPasswordRevisador);
        nombreR = findViewById(R.id.txtNombreRevisador);
        apellidoPaternoR = findViewById(R.id.txtApellPaterRevisador);
        apellidoMaternoR = findViewById(R.id.txtApellMaterRevisador);
        direcionbaseR = findViewById(R.id.txtDirecBaseRevisador);
        horaEntradaR = findViewById(R.id.txtHoraEntradaRevisador);
        horaSalidaR = findViewById(R.id.txtHoraSalidaRevisador);

        iniciaFire();

        btnAdd = findViewById(R.id.btnAdd);


        //Añadir revisadores

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo = MainActivityF20.this.correo.getText().toString();
                String password = MainActivityF20.this.password.getText().toString();
                String nombre = nombreR.getText().toString();
                String apellidoPaterno = apellidoPaternoR.getText().toString();
                String apellidoMaterno = apellidoMaternoR.getText().toString();
                String direcionbase = direcionbaseR.getText().toString();
                String horaEntrada = horaEntradaR.getText().toString();
                String horaSalida = horaSalidaR.getText().toString();

                String accessType = "revisador";


                MainModel p = new MainModel();
                p.setUid(UUID.randomUUID().toString());
                p.setPassword(password);
                p.setCorreo(correo);
                p.setNombreR(nombre);
                p.setApellidoPaternoR(apellidoPaterno);
                p.setApellidoMaternoR(apellidoMaterno);
                p.setDirecionbaseR(direcionbase);
                p.setHoraEntradaR(horaEntrada);
                p.setHoraSalidaR(horaSalida);
                p.setAccessType(accessType);


                databaseReference.child("revisador").child(p.getUid()).setValue(p);
                Toast.makeText(MainActivityF20.this, "Añadido", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), MainActivityF17.class);
                v.getContext().startActivity(intent);

                //limpiarRevisador();
            }
        });

    }

    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public  void limpiarRevisador(){
        correo.setText("");
        password.setText("");
        nombreR.setText("");
    }


    public void regresarF17(View view) {
        Intent intent = new Intent(view.getContext(), MainActivityF17.class);
        view.getContext().startActivity(intent);
    }

}