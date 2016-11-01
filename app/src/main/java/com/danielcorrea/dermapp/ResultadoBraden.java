package com.danielcorrea.dermapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoBraden extends AppCompatActivity {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Button atras1;
    TextView nomb, eda, fech, resul,riesgo;

    int edad,result;
    String fecha,nombre;
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



        if(result<13){
            riesgo.setText(R.string.calcu4);
        }else{
            if (result==13||result==14){
                riesgo.setText(R.string.calcu5);
            }else{
                if(result>=15 && result<=16 && edad<=75){
                    riesgo.setText(R.string.calcu6);
                }else{
                    if(result>=15 && result<=18 && edad>75){
                        riesgo.setText(R.string.calcu6);
                    }else{riesgo.setText(R.string.calcu9);}
                }
            }
        }
        atras1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent inten = new Intent(ResultadoBraden.this,Main.class);
                startActivity(inten);
            }
        });

    }
}
