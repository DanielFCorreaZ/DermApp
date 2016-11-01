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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    Button acept, cancel;
    EditText user, pass, repass, mail;
    int t=0,l=0,m=0;
    boolean emailcheck=false;
    String nombre, correo,contra, con,name;

    ContentValues dataBD;
    SQLiteDatabase dbContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        BasesSQLiteHelper contactos = new BasesSQLiteHelper(this,"ContactosBD", null, 1);
        dbContactos = contactos.getWritableDatabase();

        acept = (Button) findViewById(R.id.acept);
        cancel = (Button) findViewById(R.id.cancel);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        repass = (EditText) findViewById(R.id.repass);
        mail = (EditText) findViewById(R.id.mail);

        acept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(user.getText().toString())) {
                    t=0;
                    Toast.makeText(getApplicationContext(), R.string.loggin1 ,Toast.LENGTH_SHORT).show();
                } else{name=user.getText().toString();
                    Cursor c = dbContactos.rawQuery("select * from Contactos where nombre='"+name+"'",null);
                    if(c.moveToFirst()) {
                        con= c.getString(2);
                    }
                    if(TextUtils.isEmpty(con)) {
                        t=1;
                    }else{
                        Toast.makeText(getApplicationContext(),R.string.loggin5  ,Toast.LENGTH_SHORT).show();
                    }

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


                if(t==1 && l==1 && m==1) {


                    nombre = user.getText().toString();
                    correo = mail.getText().toString();
                    contra = pass.getText().toString();
                    dataBD = new ContentValues();
                    dataBD.put("nombre",nombre);
                    dataBD.put("contra",contra);
                    dataBD.put("correo",correo);

                    dbContactos.insert("Contactos",null,dataBD);
                    Toast.makeText(getApplicationContext(), R.string.loggin9 ,Toast.LENGTH_SHORT).show();
                    Intent inten = new Intent(Register.this,Loggin.class);
                    startActivity(inten);
                }
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
