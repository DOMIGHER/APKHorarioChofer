package com.example.apkhorariochofer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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

public class MainActivityF4 extends AppCompatActivity {
    private List<ChoferHoraModel> listapersonasC = new ArrayList<ChoferHoraModel>();
    ArrayAdapter<ChoferHoraModel> arrayAdapterhoraC;
    ListView listv_Choferhoraver;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f4);
        String uidchofint = getIntent().getStringExtra("uid");
        listv_Choferhoraver = findViewById(R.id.lv_datosHoraChoferver);
        iniciaFire();
        horachoferver();
    }
    private  void horachoferver(){
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

                    arrayAdapterhoraC = new ArrayAdapter<ChoferHoraModel>(MainActivityF4.this, android.R.layout.simple_list_item_1, listapersonasC);
                    listv_Choferhoraver.setAdapter(arrayAdapterhoraC);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivityF4.this, "Datos no obtenidos", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}