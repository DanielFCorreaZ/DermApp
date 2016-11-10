package com.danielcorrea.dermapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class RegisterHos extends AppCompatActivity {
    Button acept, cancel,busca;
    EditText nomhos, codhos, recodhos, abrehos,lat,lon;
    int t=0,l=0,m=0,i=0,id=0,p=0,h=0,g=0;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    private String FIREBASE_URL="https://dermapp-d2599.firebaseio.com/";
    private Firebase firebasedatos;
    String[] con= new String[100];
    String[] cos= new String[100];
    String[] cor= new String[100];
    ArrayList<Integer> f;
    ArrayList<Valoration> valo,valox;
    ArrayList<Profetional> profe,profex;
    ArrayList<Hospital> hospi,hospis;
    Firebase firebd;
    String  a="", name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_hos);



        acept = (Button) findViewById(R.id.acepthos);
        cancel = (Button) findViewById(R.id.cancelhos);
        busca = (Button) findViewById(R.id.busca);
        nomhos = (EditText) findViewById(R.id.nombrehos);
        codhos = (EditText) findViewById(R.id.codhospi);
        recodhos = (EditText) findViewById(R.id.recodhospi);
        abrehos = (EditText) findViewById(R.id.abrehos);
     //   lat = (EditText) findViewById(R.id.lati);
       // lon = (EditText) findViewById(R.id.longi);

        profe = new ArrayList<Profetional>();
        profex = new ArrayList<Profetional>();
        hospi = new ArrayList<Hospital>();
       valo = new ArrayList<Valoration>();

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL);

        prefs=getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();
       // lon.setText(String.valueOf(prefs.getFloat("longi",-1)));
        //lat.setText(String.valueOf(prefs.getFloat("lati",-1)));




        /*final String codes = "Numero de Usus";
        firebasedatos.addChildEventListener(new ChildEventListener() {

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot.child(codes).exists()) {

                    f.add(dataSnapshot.child("Numero de Usus").getValue(Integer.class));

                    Toast.makeText(getApplicationContext(),"id recuperado" ,Toast.LENGTH_SHORT).show();
                    id = f.get(0);}
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }
        });*/


        Valoration valos2 = new Valoration("","","","","",String.valueOf(1));
        valo.add(valos2);
        Profetional profes = new Profetional("Javier Alberto","javi","123",String.valueOf(1),valo);
        profe.add(profes);
        Hospital hospis2 = new Hospital(profe,"","","","lat","long","");



        firebasedatos.child("Hospital "+-1).setValue(hospis2);




        final String code = "Hospitalito";

        firebasedatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                hospis = new ArrayList<Hospital>();
                if (dataSnapshot.child(code).exists()) {
                    hospi.add(dataSnapshot.child("Hospitalito").getValue(Hospital.class));



                    //Toast.makeText(getApplicationContext(), "id recuperado", Toast.LENGTH_SHORT).show();
                    id = Integer.parseInt(hospi.get(0).getIdh());

                    for(i=0; i<id;i++){
                        hospis.add(dataSnapshot.child("Hospital "+i).getValue(Hospital.class));

                        con[i] = hospis.get(0).getCodh();
                        cos[i] = hospis.get(0).getNombreh();
                        cor[i] = hospis.get(0).getAbreh();
                        //correo = hospis.get(0).getCodh();
                        hospis = new ArrayList<Hospital>();
                        //Toast.makeText(getApplicationContext(), con[i], Toast.LENGTH_SHORT).show();
                    }

                }

            }@Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });




        acept.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {



                //id= prefs.getInt("idss",0);


                if(TextUtils.isEmpty(nomhos.getText().toString())) {

                    Toast.makeText(getApplicationContext(), R.string.loggin11 ,Toast.LENGTH_SHORT).show();
                    t=0;
                } else{name=nomhos.getText().toString();
                    t=1;

                    /* final String code = "Hospital ";
                    firebasedatos.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.child(code).exists()) {
                                hospi.add(dataSnapshot.child("Hospital ").getValue(Hospital.class));
                                for(i=0; i<id;i++){

                                con = hospi.get(i).getNombreh();
                                if((con).equals(name)) {
                                    Toast.makeText(getApplicationContext(),R.string.loggin5  ,Toast.LENGTH_SHORT).show();
                                    p=1;
                                    t=0;
                                    }if(p==1){t=0;}else{t=1;}}

                            }
                        }@Override
                        public void onCancelled(FirebaseError firebaseError) {
                        }
                    });*/



                }


                if(TextUtils.isEmpty(codhos.getText().toString())) {
                    l=0;
                    Toast.makeText(getApplicationContext(), R.string.loggin31 ,Toast.LENGTH_SHORT).show();
                } else{
                    if(TextUtils.isEmpty(recodhos.getText().toString())){
                        l=0;
                        Toast.makeText(getApplicationContext(), R.string.loggin31 ,Toast.LENGTH_SHORT).show();
                    }else{
                        if((codhos.getText().toString()).equals(recodhos.getText().toString())){
                            l=1;
                        }else{
                            l=0;
                            Toast.makeText(getApplicationContext(), R.string.loggin61 ,Toast.LENGTH_SHORT).show();
                        }

                    }
                }
                if(TextUtils.isEmpty(abrehos.getText().toString())) {
                    m=0;
                    Toast.makeText(getApplicationContext(), R.string.loggin71 ,Toast.LENGTH_SHORT).show();
                } else{ m=1;
                }


              /*  if(t==1 && l==1 && m==1){
                    final String code = "Hospitalito";

                    Hospital hospis2 = new Hospital("","","","lat","long","",profe);

                    // hospi.add(hospis);

                    firebd = firebasedatos.child("Hospital "+-1);
                    firebd.setValue(hospis2);
                    firebasedatos.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.child(code).exists()) {
                                for(i=0; i<id;i++){
                                hospi.add(dataSnapshot.child("Hospital "+i).getValue(Hospital.class));

                                    con = hospi.get(0).getCodh();
                                    if((con).equals(codhos.getText().toString())) {
                                        Toast.makeText(getApplicationContext(),R.string.loggin5  ,Toast.LENGTH_SHORT).show();
                                        h=1;

                                    }
                                    p=1;
                                }

                            }else{p=1;}
                        }@Override
                        public void onCancelled(FirebaseError firebaseError) {
                        }
                    });
                }*/



                if(t==1 && l==1 && m==1 ) {

                    p=0;h=0;g=0;

                    for(i=0; i<id;i++){

                        if(con[i].equals(recodhos.getText().toString())){
                            Toast.makeText(getApplicationContext(), R.string.logginh1  ,Toast.LENGTH_SHORT).show();
                            p=1;
                        }
                        if(cos[i].equals(nomhos.getText().toString())){
                            Toast.makeText(getApplicationContext(), R.string.logginh2  ,Toast.LENGTH_SHORT).show();
                            h=1;
                        }
                        if(cor[i].equals(abrehos.getText().toString())){
                            Toast.makeText(getApplicationContext(), R.string.logginh3  ,Toast.LENGTH_SHORT).show();
                            g=1;
                        }
                    }

                    if(p==0 && h==0 && g==0 ){

                    Hospital hospis = new Hospital(profe,nomhos.getText().toString(),abrehos.getText().toString(),codhos.getText().toString(),String.valueOf(prefs.getFloat("lati",-1)),String.valueOf(prefs.getFloat("longi",-1)),String.valueOf(id));

                   // hospi.add(hospis);

                    firebd = firebasedatos.child("Hospital "+id);
                    firebd.setValue(hospis);


                    Toast.makeText(getApplicationContext(), R.string.loggin91 ,Toast.LENGTH_SHORT).show();
                    id++;
                   /* editor.putInt("idss",id);
                    editor.commit();*/

                    firebd = firebasedatos.child("Hospitalito");
                    Hospital hospis1 = new Hospital(profe,"","","","lat","long",String.valueOf(id));
                    firebd.setValue(hospis1);


                    Intent inten = new Intent(RegisterHos.this,Loggin.class);
                    startActivity(inten);
                }}
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(RegisterHos.this,Loggin.class);
                startActivity(inten);
            }
        });
        busca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(RegisterHos.this,MapsActivity.class);
                startActivity(inten);
            }
        });

    }
}
