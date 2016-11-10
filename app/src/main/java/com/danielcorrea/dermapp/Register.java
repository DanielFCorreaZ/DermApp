package com.danielcorrea.dermapp;

import android.content.ContentValues;
import android.content.Intent;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    Button acept, cancel;
    EditText user, pass, repass, mail,username, passhos, repasshos;
    int t=0,l=0,m=0,p=0,o=0,id=0,i=0,k=0,f=0,idp=0,n=0;
    boolean emailcheck=false;
    String nombre, correo,contra, name;

    private String FIREBASE_URL="https://dermapp-d2599.firebaseio.com/";
    private Firebase firebasedatos1;
    ArrayList<Valoration> valo;
    ArrayList<Profetional> profe,achu;
    ArrayList<ArrayList<Profetional>> dale;
    ArrayList<Hospital> hospi,hospix;
    String[] con= new String[100];
    String[] cor= new String[100];
    Integer[] cos= new Integer[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        valo = new ArrayList<Valoration>();
        profe = new ArrayList<Profetional>();
        dale= new ArrayList<ArrayList<Profetional>>();
        hospi = new ArrayList<Hospital>();

        Firebase.setAndroidContext(this);
        firebasedatos1 = new Firebase(FIREBASE_URL);

        acept = (Button) findViewById(R.id.acept);
        cancel = (Button) findViewById(R.id.cancel);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        repass = (EditText) findViewById(R.id.repass);
        mail = (EditText) findViewById(R.id.mail);
        username = (EditText) findViewById(R.id.usernam);
        passhos = (EditText) findViewById(R.id.passhos);
        repasshos = (EditText) findViewById(R.id.repasshos);


      /*  Firebase firebd;
        Profetional profes = new Profetional("Javier Alberto","javi","123",String.valueOf(1),valo);
        firebasedatos.child("Hospital "+1).child("Profesional "+1).setValue(profes);*/

        Valoration valos2 = new Valoration("","","","","",String.valueOf(1));
        valo.add(valos2);

        final Profetional profes = new Profetional("Javier Alberto", "javi", "123", String.valueOf(1), valo);
        profe.add(profes);

        Hospital hospis2 = new Hospital(profe,"","","","lat","long","");

        firebasedatos1.child("Hospital "+-1).setValue(hospis2);

        final String code = "Hospitalito";

        firebasedatos1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.child(code).exists()) {
                    hospi.add(dataSnapshot.child("Hospitalito").getValue(Hospital.class));

                   //Toast.makeText(getApplicationContext(), "id recuperado", Toast.LENGTH_SHORT).show();
                    id = Integer.parseInt(hospi.get(0).getIdh());

                    for(i=0; i<id;i++){
                        hospix = new ArrayList<Hospital>();
                        hospix.add(dataSnapshot.child("Hospital "+i).getValue(Hospital.class));

                        //dale.add( new ArrayList<Profetional>());
                        con[i] = hospix.get(0).getCodh();
                        cos[i] = Integer.parseInt(hospix.get(0).getProfesionales().get(0).getIdp());

                        achu=hospix.get(0).getProfesionales();
                        dale.add(achu);

                        hospix = new ArrayList<Hospital>();
                      //  Toast.makeText(getApplicationContext(), con[i], Toast.LENGTH_SHORT).show();
                    }

                }

            }@Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });






        acept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(username.getText().toString())) {
                    p=0;
                    Toast.makeText(getApplicationContext(), R.string.loggin12 ,Toast.LENGTH_SHORT).show();
                } else{nombre=username.getText().toString();
                        p=1;


                }



                if(TextUtils.isEmpty(user.getText().toString())) {
                    t=0;
                    Toast.makeText(getApplicationContext(), R.string.loggin1 ,Toast.LENGTH_SHORT).show();
                } else{name=user.getText().toString();
                    t=1;

                   /* if(TextUtils.isEmpty(con)) {
                        t=1;
                    }else{
                        Toast.makeText(getApplicationContext(),R.string.loggin5  ,Toast.LENGTH_SHORT).show();
                    }*/

                }
                if(TextUtils.isEmpty(pass.getText().toString())) {
                    l=0;
                    Toast.makeText(getApplicationContext(), R.string.loggin3 ,Toast.LENGTH_SHORT).show();
                } else{
                    if(TextUtils.isEmpty(repass.getText().toString())){
                        l=0;
                        Toast.makeText(getApplicationContext(), R.string.loggin3 ,Toast.LENGTH_SHORT).show();
                    }else{
                        if((pass.getText().toString()).equals(repass.getText().toString())){
                            l=1;
                        }else{
                            l=0;
                            Toast.makeText(getApplicationContext(), R.string.loggin6 ,Toast.LENGTH_SHORT).show();
                        }

                    }
                }



                if(TextUtils.isEmpty(passhos.getText().toString())) {
                    o=0;
                    Toast.makeText(getApplicationContext(), R.string.loggin31 ,Toast.LENGTH_SHORT).show();
                } else{
                    if(TextUtils.isEmpty(repasshos.getText().toString())){
                        o=0;
                        Toast.makeText(getApplicationContext(), R.string.loggin31 ,Toast.LENGTH_SHORT).show();
                    }else{
                        if((passhos.getText().toString()).equals(repasshos.getText().toString())){
                            o=1;
                        }else{
                           o=0;
                            Toast.makeText(getApplicationContext(), R.string.loggin61 ,Toast.LENGTH_SHORT).show();
                        }

                    }
                }





                if(TextUtils.isEmpty(mail.getText().toString())) {
                    m=0;
                    Toast.makeText(getApplicationContext(), R.string.loggin7 ,Toast.LENGTH_SHORT).show();
                } else{checkemail(mail.getText().toString());
                    if(emailcheck==true)
                    {
                        m=1;
                    }else{
                        m=0;
                        Toast.makeText(getApplicationContext(),R.string.loggin8  ,Toast.LENGTH_SHORT).show();
                    }
                }


                if(t==1 && l==1 && m==1 && p==1 && o==1) {




                    k=0;
                    n=0;
                    f=0;
                    for(i=0; i<id;i++){

                        if(con[i].equals(passhos.getText().toString())){ k=1;f=i;idp=cos[i];




                        }


                    }
                    for(int j=1;j<idp;j++){
                       // cor[j]=dale[f].get(j).getNombrep();
                        if(dale.get(f).get(j).getUsuariop().equals(user.getText().toString())){ n=1;}
                    }


                    if(k==0){Toast.makeText(getApplicationContext(), R.string.logginp1  ,Toast.LENGTH_SHORT).show();}
                    if(n==1){Toast.makeText(getApplicationContext(), R.string.logginp11  ,Toast.LENGTH_SHORT).show();}
                    if(k==1 && n==0){

                        Profetional profes = new Profetional(username.getText().toString(),user.getText().toString(),pass.getText().toString(),mail.getText().toString(),valo);
                        firebasedatos1.child("Hospital "+f).child("profesionales").child(""+idp).setValue(profes);
                        idp++;
                        Profetional profes1 = new Profetional("","","",String.valueOf(idp),valo);
                        firebasedatos1.child("Hospital "+f).child("profesionales").child(""+0).setValue(profes1);

                    Toast.makeText(getApplicationContext(), R.string.loggin9 ,Toast.LENGTH_SHORT).show();

                    Intent inten = new Intent(Register.this,Loggin.class);
                    startActivity(inten);
                }}
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(Register.this,Loggin.class);
                startActivity(inten);
            }
        });


    }

    public void checkemail(String email)
    {
        Pattern pattern = Pattern.compile(".+@.+.[a-z]+");
        Matcher matcher = pattern.matcher(email);
        emailcheck = matcher.matches();
    }

}
