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

public class MainActivityF23 extends AppCompatActivity {
    EditText correoC, passwordC, nombreC, apellidoPaternoC, apellidoMaternoC, licenciaconducirC, curpC, domicilioC, antecedentesPenalesC, rutaC;
    Button btnEdit, btnElim;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ChoferModel choferModelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f23);

        String uichofint = getIntent().getStringExtra("idchoferint");

        String correochofint = getIntent().getStringExtra("correochoferint");
        String passwordchofint = getIntent().getStringExtra("paswordchoferint");
        String nombrechofint = getIntent().getStringExtra("nombrechoferint");
        String apellPchofint = getIntent().getStringExtra("apellidoPchoferint");
        String apellMchofint = getIntent().getStringExtra("apellidoMchoferint");
        String licenchofint = getIntent().getStringExtra("licenciaconducirchoferint");
        String curpchofint = getIntent().getStringExtra("curpchoferint");
        String domicilichofint = getIntent().getStringExtra("domiciliochoferint");
        String antecepenachofint = getIntent().getStringExtra("antecedentesPenaleschoferint");
        String rutachofint = getIntent().getStringExtra("rutachoferint");

        correoC = findViewById(R.id.txtCorreochoferVer);
        passwordC = findViewById(R.id.txtPasswordChoferVer);
        nombreC = findViewById(R.id.txtNombreChoferVer);
        apellidoPaternoC = findViewById(R.id.txtApellPaterChoferVer);
        apellidoMaternoC = findViewById(R.id.txtApellMaterChoferVer);
        licenciaconducirC = findViewById(R.id.txtLicenciaChoferVer);
        curpC = findViewById(R.id.txtCurpChoferVer);
        domicilioC = findViewById(R.id.txtDomicilioChoferVer);
        antecedentesPenalesC = findViewById(R.id.txtAntecePenalesChoferVer);
        rutaC = findViewById(R.id.txtRutaChoferVer);

        iniciaFire();

        btnEdit = findViewById(R.id.txtbtnEditChofer);
        btnElim = findViewById(R.id.txtbtnEliminChofer);

        correoC.setText(correochofint);
        passwordC.setText(passwordchofint);
        nombreC.setText(nombrechofint);
        apellidoPaternoC.setText(apellPchofint);
        apellidoMaternoC.setText(apellMchofint);
        licenciaconducirC.setText(licenchofint);
        curpC.setText(curpchofint);
        domicilioC.setText(domicilichofint);
        antecedentesPenalesC.setText(antecepenachofint);
        rutaC.setText(rutachofint);

        choferModelper = new ChoferModel();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choferModelper.setUid(uichofint.toString());
                choferModelper.setCorreo(correoC.getText().toString().trim());
                choferModelper.setPassword(passwordC.getText().toString().trim());
                choferModelper.setNombreC(nombreC.getText().toString().trim());
                choferModelper.setApellidoPaternoC(apellidoPaternoC.getText().toString().trim());
                choferModelper.setApellidoMaternoC(apellidoMaternoC.getText().toString().trim());
                choferModelper.setLicenciaconducirC(licenciaconducirC.getText().toString().trim());
                choferModelper.setCurpC(curpC.getText().toString().trim());
                choferModelper.setDomicilioC(domicilioC.getText().toString().trim());
                choferModelper.setAntecedentesPenalesC(antecedentesPenalesC.getText().toString().trim());
                choferModelper.setRutaC(rutaC.getText().toString().trim());

                databaseReference.child("chofer").child(choferModelper.getUid()).setValue(choferModelper);
                Toast.makeText(MainActivityF23.this, "Actualizado", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), MainActivityF21.class);
                v.getContext().startActivity(intent);

            }
        });

        btnElim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choferModelper.setUid(uichofint.toString());
                databaseReference.child("chofer").child(choferModelper.getUid()).removeValue();
                Toast.makeText(MainActivityF23.this, "Elimindo", Toast.LENGTH_SHORT).show();

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
}