package com.danielcorrea.dermapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoBraden extends AppCompatActivity {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Button atras1;
    TextView nomb, eda, fech, resul,riesgo;

    private String FIREBASE_URL="https://dermapp-d2599.firebaseio.com/";
    private Firebase firebasedatos;
    ArrayList<Valoration> valo,valo1,valo2;
    ArrayList<Profetional> profe;
    ArrayList<Hospital> hospi;

    int edad,result,id=0,idh,idv,idp;
    String fecha,nombre,punt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_braden);
        atras1 = (Button) findViewById(R.id.atras30);

nomb=(TextView)findViewById(R.id.finalnom) ;
        eda=(TextView)findViewById(R.id.finaledad) ;
        fech=(TextView)findViewById(R.id.finalfecha) ;
        resul=(TextView)findViewById(R.id.finalpuntua) ;
        riesgo=(TextView)findViewById(R.id.finalriesgo) ;

        valo = new ArrayList<Valoration>();
        valo1 = new ArrayList<Valoration>();
        valo2 = new ArrayList<Valoration>();
        profe = new ArrayList<Profetional>();
        hospi = new ArrayList<Hospital>();

        Firebase.setAndroidContext(this);
        firebasedatos = new Firebase(FIREBASE_URL);
        Valoration valos2 = new Valoration("","","","","",String.valueOf(1));
        valo.add(valos2);

        final Profetional profes = new Profetional("Javier Alberto", "javi", "123", String.valueOf(1), valo);
        profe.add(profes);
        prefs=getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();

        edad=prefs.getInt("edad",-1);
        result=prefs.getInt("result",-1);
        fecha=prefs.getString("fecha","");
        nombre=prefs.getString("nombresito","");

        nomb.setText(nombre);
        fech.setText(fecha);
        eda.setText(String.valueOf(edad));
        resul.setText(String.valueOf(result));

        idh=prefs.getInt("idhospital",-1);
        idp=  prefs.getInt("idprofesio",-1);

        if(result<13){
            punt=getString(R.string.calcu4);
            riesgo.setText(R.string.calcu4);
        }else{
            if (result==13||result==14){
                punt=getString(R.string.calcu5);
                riesgo.setText(R.string.calcu5);
            }else{
                if(result>=15 && result<=16 && edad<=75){
                    punt=getString(R.string.calcu6);
                    riesgo.setText(R.string.calcu6);
                }else{
                    if(result>=15 && result<=18 && edad>75){
                        punt=getString(R.string.calcu6);
                        riesgo.setText(R.string.calcu6);
                    }else{riesgo.setText(R.string.calcu9);
                        punt=getString(R.string.calcu9);}
                }
            }
        }


        Hospital hospis2 = new Hospital(profe,"","","","lat","long","");

        firebasedatos.child("Hospital "+-1).setValue(hospis2);

        final String code = "Hospitalito";

        firebasedatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.child(code).exists()) {
                    //Toast.makeText(getApplicationContext(), "id recuperado", Toast.LENGTH_SHORT).show();

                    hospi = new ArrayList<Hospital>();
                    hospi.add(dataSnapshot.child("Hospital "+idh).getValue(Hospital.class));


                    idv= Integer.parseInt(hospi.get(0).getProfesionales().get(idp).getValoraciones().get(0).getIdv());


                    //Toast.makeText(getApplicationContext(), String.valueOf(idv), Toast.LENGTH_SHORT).show();
                    id=1;


                }

            }@Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });



        atras1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





        Firebase firebd;


    if(id==1){
        Valoration valos4 = new Valoration(nombre,String.valueOf(edad),String.valueOf(result),punt,fecha,"Braden UPP");

        firebasedatos.child("Hospital "+idh).child("profesionales").child(""+idp).child("valoraciones").child(""+idv).setValue(valos4);
        idv++;
        Valoration valos5 = new Valoration("","","","","",String.valueOf(idv));

        firebasedatos.child("Hospital "+idh).child("profesionales").child(""+idp).child("valoraciones").child(""+0).setValue(valos5);

        Intent inten = new Intent(ResultadoBraden.this,Main.class);
        startActivity(inten);

    }




            }
        });
    }
}
