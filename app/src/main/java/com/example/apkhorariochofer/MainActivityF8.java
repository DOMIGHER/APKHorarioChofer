package com.example.apkhorariochofer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class MainActivityF8 extends AppCompatActivity {
    private List<ChoferModel> listapersonasC = new ArrayList<ChoferModel>();
    ArrayAdapter<ChoferModel> arrayAdapterPersonasC;
    ListView listv_ChoferV;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ChoferModel choferModelselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f8);

        listv_ChoferV = findViewById(R.id.lv_datosHoraChofer);
        iniciaFire();
        listaDatos();

        listv_ChoferV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                choferModelselect = (ChoferModel) parent.getItemAtPosition(position);

                Intent intent = new Intent(view.getContext(), MainActivityF9.class);
                intent.putExtra("uid",choferModelselect.getUid());
                view.getContext().startActivity(intent);

            }
        });

    }

    private void listaDatos(){
        databaseReference.child("chofer").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listapersonasC.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    ChoferModel p = snapshot1.getValue(ChoferModel.class);
                    listapersonasC.add(p);

                    arrayAdapterPersonasC = new ArrayAdapter<ChoferModel>(MainActivityF8.this,android.R.layout.simple_list_item_1, listapersonasC);
                    listv_ChoferV.setAdapter(arrayAdapterPersonasC);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivityF8.this, "Datos no obtenidos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}