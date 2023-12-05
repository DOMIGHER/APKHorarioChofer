package com.example.apkhorariochofer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class MainActivityF17 extends AppCompatActivity {

    private List<MainModel> listPerson = new ArrayList<MainModel>();
    ArrayAdapter<MainModel> arrayAdapterPersonas;
    ListView listv_R;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    MainModel mainModelselect;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f17);

        listv_R = findViewById(R.id.lv_datosPersonaRevisador);
        iniciaFire();
        listaDatos();

        listv_R.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mainModelselect = (MainModel) parent.getItemAtPosition(position);

                //editar
                Intent intent = new Intent(view.getContext(), MainActivityF18.class);

                intent.putExtra("nonullint",mainModelselect.getUid());

                intent.putExtra("correorevint", mainModelselect.getCorreo());
                intent.putExtra("passwordrevint", mainModelselect.getPassword());
                intent.putExtra("nombrerevint",mainModelselect.getNombreR());
                intent.putExtra("apellidoprevint",mainModelselect.getApellidoMaternoR());
                intent.putExtra("apellidomrevint",mainModelselect.getApellidoPaternoR());
                intent.putExtra("direccionbaserevint",mainModelselect.getDirecionbaseR());
                intent.putExtra("horaentrarevint",mainModelselect.getHoraEntradaR());
                intent.putExtra("horasalidarevint",mainModelselect.getHoraSalidaR());
                view.getContext().startActivity(intent);
                
            }
        });

    }

    //ver datos
    private void listaDatos() {
        databaseReference.child("revisador").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listPerson.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    MainModel p = snapshot1.getValue(MainModel.class);
                    listPerson.add(p);

                    arrayAdapterPersonas = new ArrayAdapter<MainModel>(MainActivityF17.this, android.R.layout.simple_list_item_1, listPerson);
                    listv_R.setAdapter(arrayAdapterPersonas);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivityF17.this, "Datos no obtenidos", Toast.LENGTH_SHORT).show();

            }
        });
    }


    public  void  iniciaFire(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    //añadir
    public void añadirRevisador(View view) {
        Intent intent = new Intent(view.getContext(), MainActivityF20.class);
        view.getContext().startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuadmin, menu);
        return true;
    }

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