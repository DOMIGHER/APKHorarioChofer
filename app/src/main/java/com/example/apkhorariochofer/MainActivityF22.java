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

public class MainActivityF22 extends AppCompatActivity {
    EditText correo, password, nombreC, apellidoPaternoC, apellidoMaternoC, licenciaconducirC, curpC, domicilioC, antecedentesPenalesC, rutaC;
    Button btnAddCho;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f22);

        correo = findViewById(R.id.txtCorreochofer);
        password = findViewById(R.id.txtPasswordChofer);
        nombreC = findViewById(R.id.txtNombreChofer);
        apellidoPaternoC = findViewById(R.id.txtApellPaterChofer);
        apellidoMaternoC = findViewById(R.id.txtApellMaterChofer);
        licenciaconducirC = findViewById(R.id.txtLicenciaChofer);
        curpC = findViewById(R.id.txtCurpChofer);
        domicilioC = findViewById(R.id.txtDomicilioChofer);
        antecedentesPenalesC = findViewById(R.id.txtAntecePenalesChofer);
        rutaC = findViewById(R.id.txtRutaChofer);

        iniciaFire();

        btnAddCho = findViewById(R.id.btnAddCho);
        btnAddCho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = MainActivityF22.this.correo.getText().toString();
                String password = MainActivityF22.this.password.getText().toString();
                String nombre =   nombreC.getText().toString();
                String apellidoPaterno = apellidoPaternoC.getText().toString();
                String apellidoMaterno = apellidoMaternoC.getText().toString();
                String licenciaconducir = licenciaconducirC.getText().toString();
                String curp = curpC.getText().toString();
                String domicilio = domicilioC.getText().toString();
                String antecedentesPenales =  antecedentesPenalesC.getText().toString();
                String ruta = rutaC.getText().toString();

                String accessType = "chofer";

                ChoferModel p = new ChoferModel();
                p.setUid(UUID.randomUUID().toString());
                p.setCorreo(correo);
                p.setPassword(password);
                p.setNombreC(nombre);
                p.setApellidoPaternoC(apellidoPaterno);
                p.setApellidoMaternoC(apellidoMaterno);
                p.setLicenciaconducirC(licenciaconducir);
                p.setCurpC(curp);
                p.setDomicilioC(domicilio);
                p.setAntecedentesPenalesC(antecedentesPenales);
                p.setRutaC(ruta);
                p.setAccessType(accessType);

                databaseReference.child("chofer").child(p.getUid()).setValue(p);
                Toast.makeText(MainActivityF22.this, "Añadido", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), MainActivityF21.class);
                v.getContext().startActivity(intent);
            }
        });

    }

    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    public void regresarChof(View view) {
        Intent intent = new Intent(view.getContext(), MainActivityF21.class);
        view.getContext().startActivity(intent);
    }
}