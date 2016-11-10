package com.danielcorrea.dermapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Set;

public class Loggin extends AppCompatActivity {
    Button ok,reg,sin;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    private String FIREBASE_URL="https://dermapp-d2599.firebaseio.com/";
    private Firebase firebasedatos;
    ArrayList<Valoration> valo;
    ArrayList<String> v;
    ArrayList<Profetional> profe;
    ArrayList<Hospital> hospi,hospis;
    String[] con= new String[100];
    String[] cos= new String[100];
    String[] cor= new String[100];
    EditText usser,paass,codhos;
    int id,idp=0,u=0;
    String contra="",correo,useer,pas,hos,ko,mail,name;
    int l=0,t=0,i=0,y=0;

    ContentValues dataBD;
    SQLiteDatabase dbContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);


        v = new ArrayList<String>();
        valo = new ArrayList<Valoration>();
        profe = new ArrayList<Profetional>();
        hospi = new ArrayList<Hospital>();

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL);

        prefs=getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();

        reg = (Button) findViewById(R.id.reg);
        sin = (Button) findViewById(R.id.sin);
        ok = (Button) findViewById(R.id.ok);
        paass = (EditText)findViewById(R.id.paass);
        usser = (EditText) findViewById(R.id.usser);
        codhos = (EditText) findViewById(R.id.codhoss);

        if((prefs.getInt("var",-1)==1)){
            Intent intent= new Intent(Loggin.this,Main.class);
            startActivity(intent);
            finish();
        }

        Valoration valos2 = new Valoration("","","","","",String.valueOf(1));
        valo.add(valos2);

        final Profetional profes = new Profetional("Javier Alberto", "javi", "123", String.valueOf(1), valo);
        profe.add(profes);
      /*  Hospital hospis2 = new Hospital("","","","lat","long","",profe);



        firebasedatos.child("Hospital "+-1).setValue(hospis2);




        final String code = "Hospitalito";

        firebasedatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                hospis = new ArrayList<Hospital>();
                if (dataSnapshot.child(code).exists()) {
                    hospi.add(dataSnapshot.child("Hospitalito").getValue(Hospital.class));



                    // Toast.makeText(getApplicationContext(), "id recuperado", Toast.LENGTH_SHORT).show();
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
                    editor.putInt("IDhos",id);

                    editor.putString("con",con[]);
                    editor.putString("cos",cos[]);
                    editor.putString("cor",cor[]);
                    editor.commit();
                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });*/





        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                useer=usser.getText().toString();
                pas=paass.getText().toString();
                hos=codhos.getText().toString();
                if(TextUtils.isEmpty(hos)) {
                    y=0;
                    Toast.makeText(getApplicationContext(), R.string.loggin111 ,Toast.LENGTH_SHORT).show();
                }else{y=1;}
                if(TextUtils.isEmpty(useer)) {
                    t=0;
                    Toast.makeText(getApplicationContext(), R.string.loggin1 ,Toast.LENGTH_SHORT).show();
                } else{


                    

                    Hospital hospis2 = new Hospital(profe,"","","","lat","long","");

                    firebasedatos.child("Hospital "+-1).setValue(hospis2);

                    final String code = "Hospitalito";

                    firebasedatos.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            if (dataSnapshot.child(code).exists()) {

                                hospi = new ArrayList<Hospital>();
                                hospi.add(dataSnapshot.child("Hospitalito").getValue(Hospital.class));

                                //Toast.makeText(getApplicationContext(), "id recuperado", Toast.LENGTH_SHORT).show();
                                id = Integer.parseInt(hospi.get(0).getIdh());

                                for (i = 0; i < id; i++) {
                                    hospi = new ArrayList<Hospital>();
                                    hospi.add(dataSnapshot.child("Hospital " + i).getValue(Hospital.class));

                                    //dale.add( new ArrayList<Profetional>());
                                    con[i] = hospi.get(0).getCodh();

                                    if (con[i].equals(hos)) {
                                        correo= String.valueOf(i);
                                        idp=Integer.parseInt(hospi.get(0).getProfesionales().get(0).getIdp());

                                        for(int j=1;j<idp;j++){
                                            // cor[j]=dale[f].get(j).getNombrep();
                                            if(hospi.get(0).getProfesionales().get(j).getUsuariop().equals(useer)){ t=1;
                                                ko=String.valueOf(j);
                                               contra= hospi.get(0).getProfesionales().get(j).getContrap();
                                                mail=hospi.get(0).getProfesionales().get(j).getIdp();
                                                name=hospi.get(0).getProfesionales().get(j).getNombrep();
                                                if(TextUtils.isEmpty(pas)) {
                                                    l=0;
                                                    Toast.makeText(getApplicationContext(), R.string.loggin3 ,Toast.LENGTH_SHORT).show();
                                                } else{
                                                    if(pas.equals(contra)){
                                                        l=1;
                                                    }else{
                                                        Toast.makeText(getApplicationContext(),R.string.loggin4  ,Toast.LENGTH_SHORT).show();

                                                    }
                                                }


                                            }
                                        }if(t==0){ Toast.makeText(getApplicationContext(), R.string.loggin2 ,Toast.LENGTH_SHORT).show();}

                                    }if((l==1 && t==1 && y==1)){
                                        Intent intent= new Intent(Loggin.this,Main.class);







                                        editor.putInt("idhospital",Integer.parseInt(correo));
                                        editor.putInt("idprofesio",Integer.parseInt(ko));
                                        editor.putString("nombrep",name);
                                        editor.putString("correop",mail);
                                        editor.putInt("var",1);
                                        editor.commit();

                                        startActivity(intent);
                                        finish();
                                    }
                                }

                                        hospi = new ArrayList<Hospital>();
                                        //  Toast.makeText(getApplicationContext(), con[i], Toast.LENGTH_SHORT).show();




                            }

                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }

                    });








                }





            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(Loggin.this,Register.class);
                startActivity(inten);
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(Loggin.this,RegisterHos.class);
                startActivity(inten);
            }
        });

    }





}
