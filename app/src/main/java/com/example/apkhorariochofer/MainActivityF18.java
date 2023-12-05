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

public class MainActivityF18 extends AppCompatActivity {
    EditText nombreR, apellidoPaternoR, apellidoMaternoR, direcionbaseR, horaEntradaR, horaSalidaR, correoR, passwordR;
    Button btnEdit, btnElim;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    MainModel mainModelPesonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f18);

        // Cada Intent se tiene que llamar para modificar.

        String uirevint = getIntent().getStringExtra("nonullint");
        String correorevint = getIntent().getStringExtra("correorevint");
        String passwordrevint = getIntent().getStringExtra("passwordrevint");
        String nombrerevint = getIntent().getStringExtra("nombrerevint");
        String apellidoprevint = getIntent().getStringExtra("apellidoprevint");
        String apellidomrevint = getIntent().getStringExtra("apellidomrevint");
        String direccionbaserevint = getIntent().getStringExtra("direccionbaserevint");
        String horaentrarevint = getIntent().getStringExtra("horaentrarevint");
        String horasalidarevint = getIntent().getStringExtra("horasalidarevint");

        correoR = findViewById(R.id.txtCorreoRevisadorVer);
        passwordR = findViewById(R.id.txtPasswordRevisadorVer);
        nombreR = findViewById(R.id.txtNombreRevisadorVer);
        apellidoPaternoR = findViewById(R.id.txtApellPaterRevisadorVer);
        apellidoMaternoR = findViewById(R.id.txtApellMaterRevisadorVer);
        direcionbaseR = findViewById(R.id.txtDirecBaseRevisadorVer);
        horaEntradaR = findViewById(R.id.txtHoraEntradaRevisadorVer);
        horaSalidaR = findViewById(R.id.txtHoraSalidaRevisadorVer);

        iniciaFire();
        btnEdit = findViewById(R.id.txtbtnEditRevisa);
        btnElim = findViewById(R.id.txtbtnEliminRevisa);


       // datos en el editext
        correoR.setText(correorevint);
        passwordR.setText(passwordrevint);
        nombreR.setText(nombrerevint);
        apellidoPaternoR.setText(apellidoprevint);
        apellidoMaternoR.setText(apellidomrevint);
        direcionbaseR.setText(direccionbaserevint);
        horaEntradaR.setText(horaentrarevint);
        horaSalidaR.setText(horasalidarevint);

        ///Actualizar datos con botton
        mainModelPesonas = new MainModel();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainModelPesonas.setUid(uirevint.toString());
                mainModelPesonas.setCorreo(correoR.getText().toString().trim());
                mainModelPesonas.setPassword(passwordR.getText().toString().trim());
                mainModelPesonas.setNombreR(nombreR.getText().toString().trim());
                mainModelPesonas.setApellidoPaternoR(apellidoPaternoR.getText().toString().trim());
                mainModelPesonas.setApellidoMaternoR(apellidoMaternoR.getText().toString().trim());
                mainModelPesonas.setDirecionbaseR(direcionbaseR.getText().toString().trim());
                mainModelPesonas.setHoraEntradaR(horaEntradaR.getText().toString().trim());
                mainModelPesonas.setHoraSalidaR(horaSalidaR.getText().toString().trim());

                databaseReference.child("revisador").child(mainModelPesonas.getUid()).setValue(mainModelPesonas);
                Toast.makeText(MainActivityF18.this, "Actualizado", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), MainActivityF17.class);
                v.getContext().startActivity(intent);
            }
        });

        //Eliminar datos con boton
        btnElim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainModelPesonas.setUid(uirevint.toString());
                databaseReference.child("revisador").child(mainModelPesonas.getUid()).removeValue();
                Toast.makeText(MainActivityF18.this, "Elimindo", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), MainActivityF17.class);
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