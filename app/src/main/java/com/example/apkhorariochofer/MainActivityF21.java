package com.example.apkhorariochofer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

public class MainActivityF21 extends AppCompatActivity {

    private List<ChoferModel> listapersonasC = new ArrayList<ChoferModel>();
    ArrayAdapter<ChoferModel> arrayAdapterPersonasC;
    ListView listv_C;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ChoferModel choferModelSelec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f21);

        listv_C = findViewById(R.id.lv_datosPersonaChofer);
        iniciaFire();
        listaDatos();

        listv_C.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                choferModelSelec = (ChoferModel) parent.getItemAtPosition(position);

                Intent intent = new Intent(view.getContext(), MainActivityF23.class);

                intent.putExtra("idchoferint", choferModelSelec.getUid());
                intent.putExtra("correochoferint", choferModelSelec.getCorreo());
                intent.putExtra("paswordchoferint", choferModelSelec.getPassword());
                intent.putExtra("nombrechoferint", choferModelSelec.getNombreC());
                intent.putExtra("apellidoPchoferint", choferModelSelec.getApellidoPaternoC());
                intent.putExtra("apellidoMchoferint", choferModelSelec.getApellidoMaternoC());
                intent.putExtra("licenciaconducirchoferint", choferModelSelec.getLicenciaconducirC());
                intent.putExtra("curpchoferint", choferModelSelec.getCurpC());
                intent.putExtra("domiciliochoferint", choferModelSelec.getDomicilioC());
                intent.putExtra("antecedentesPenaleschoferint", choferModelSelec.getAntecedentesPenalesC());
                intent.putExtra("rutachoferint", choferModelSelec.getRutaC());

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

                arrayAdapterPersonasC = new ArrayAdapter<ChoferModel>(MainActivityF21.this,android.R.layout.simple_list_item_1, listapersonasC);
                listv_C.setAdapter(arrayAdapterPersonasC);

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            Toast.makeText(MainActivityF21.this, "Datos no obtenidos", Toast.LENGTH_SHORT).show();
        }
    });
    }

    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    public void añadirChofer(View view) {
        Intent intent = new Intent(view.getContext(), MainActivityF22.class);
        view.getContext().startActivity(intent);
    }


    //Llamar el icono de Menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuadmin, menu);
        return true;
    }

    //Rutas de Actvity menu
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.idrevisadormenu){
            startActivity(new Intent(this,MainActivityF17.class));

        } if (id == R.id.idchofermenu) {
            startActivity(new Intent(this, MainActivityF21.class));
        }
        return super.onOptionsItemSelected(item);
    }
}