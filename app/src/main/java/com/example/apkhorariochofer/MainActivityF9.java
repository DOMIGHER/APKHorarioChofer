package com.example.apkhorariochofer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivityF9 extends AppCompatActivity {
    private List<ChoferHoraModel> listapersonasC = new ArrayList<ChoferHoraModel>();
    ArrayAdapter<ChoferHoraModel> arrayAdapterhoraC;
    ListView listv_Choferhora;
    Button btnHoraChoferHora;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ChoferHoraModel choferHoraModelmod;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f9);

        listv_Choferhora = findViewById(R.id.lv_datosHoraChofer);
        String uidchofint = getIntent().getStringExtra("uid");
        iniciaFire();
        listahorarios();

        btnHoraChoferHora = findViewById(R.id.idañadirHoraChofer);
        btnHoraChoferHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityF9.this, MainActivityF10.class);
                intent.putExtra("uid",uidchofint);
                startActivity(intent);
            }
        });

        listv_Choferhora.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                choferHoraModelmod = (ChoferHoraModel) parent.getItemAtPosition(position);

                Intent intent = new Intent(view.getContext(), MainActivityF11.class);

                intent.putExtra("uidC",uidchofint);

                intent.putExtra("uid",choferHoraModelmod.getUid());
                intent.putExtra("horasalida",choferHoraModelmod.getHoraEntrada());
                intent.putExtra("horaentrada", choferHoraModelmod.getHoraSalida());
                view.getContext().startActivity(intent);
            }
        });
    }


    private void listahorarios(){
        String uidchofint = getIntent().getStringExtra("uid");
        ChoferModel pModel = new ChoferModel();
        pModel.setUid(uidchofint);

        databaseReference.child("chofer").child(pModel.getUid()).child("horario").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listapersonasC.clear();

                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    ChoferHoraModel p = snapshot1.getValue(ChoferHoraModel.class);
                    listapersonasC.add(p);

                    arrayAdapterhoraC = new ArrayAdapter<ChoferHoraModel>(MainActivityF9.this, android.R.layout.simple_list_item_1, listapersonasC);
                    listv_Choferhora.setAdapter(arrayAdapterhoraC);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivityF9.this, "Datos no obtenidos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}