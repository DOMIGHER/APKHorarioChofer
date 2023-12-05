package com.example.apkhorariochofer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivityF1 extends AppCompatActivity {
    private EditText emailEditText, passEditText;
    //private FirebaseAuth mAuth;
    Button btnInicio;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_f1);

        iniciaFirebaseA();

        btnInicio = findViewById(R.id.btnInicio);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = ((EditText) findViewById(R.id.editemall)).getText().toString().trim();
                String password = ((EditText) findViewById(R.id.editpass)).getText().toString().trim();

                Query queryadm = databaseReference.child("admin").orderByChild("correo").equalTo(email);
                Query queryrev = databaseReference.child("revisador").orderByChild("correo").equalTo(email);
                Query querycho = databaseReference.child("chofer").orderByChild("correo").equalTo(email);

                queryadm.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                User user = dataSnapshot.getValue(User.class);
                                String accessType = user.getAccessType();

                                if (password.equals(user.getPassword()) && accessType.equals("admin")){
                                    Intent intent = new Intent(MainActivityF1.this, MainActivityF17.class);
                                    startActivity(intent);
                                }
                                else {
                                 System.out.println("No encontrado");
                                }
                            }

                        }else {
                            Toast.makeText(MainActivityF1.this, "Buscando", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivityF1.this, "Error en base de datos", Toast.LENGTH_SHORT).show();
                    }
                });

                queryrev.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                User user = dataSnapshot.getValue(User.class);
                                String accessType = user.getAccessType();


                                if (password.equals(user.getPassword()) && accessType.equals("revisador")) {
                                    Intent intent = new Intent(MainActivityF1.this, MainActivityF7.class);

                                    MainModel mainModel = dataSnapshot.getValue(MainModel.class);
                                    intent.putExtra("uid",mainModel.getUid());
                                    intent.putExtra("nombrerevint",mainModel.getNombreR());
                                    intent.putExtra("direccionbaserevint",mainModel.getDirecionbaseR());
                                    intent.putExtra("horaentrarevint",mainModel.getHoraEntradaR());
                                    intent.putExtra("horasalidarevint",mainModel.getHoraSalidaR());

                                    startActivity(intent);

                                }
                                else {
                                    System.out.println("NO");
                                }
                            }

                        }else {
                            Toast.makeText(MainActivityF1.this, "Buscando", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivityF1.this, "Error en base de datos", Toast.LENGTH_SHORT).show();
                    }
                });

                querycho.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                User user = dataSnapshot.getValue(User.class);
                                String accessType = user.getAccessType();

                                if (password.equals(user.getPassword()) && accessType.equals("chofer")) {

                                    Intent intent = new Intent(MainActivityF1.this, MainActivityF3.class);

                                   ChoferModel choferModel = dataSnapshot.getValue(ChoferModel.class);
                                   intent.putExtra("uid",choferModel.getUid());
                                   intent.putExtra("nombrechoint",choferModel.getNombreC());
                                   intent.putExtra("rutachoferint", choferModel.getRutaC());

                                    startActivity(intent);
                                }
                                else {
                                    System.out.println("NO");
                                }
                            }
                        }else {
                            Toast.makeText(MainActivityF1.this, "Buscando", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(MainActivityF1.this, "Error en base de datos", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
        public  void  iniciaFirebaseA(){
            FirebaseApp.initializeApp(this);
            firebaseDatabase = firebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference();
        }
}
