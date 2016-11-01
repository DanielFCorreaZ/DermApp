package com.danielcorrea.dermapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {


    ViewPager vp;
    TextView tName,tmail;
    String mais,nomb;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    private String[] opciones;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;
    String name,price,description;
    int ids;
    int num,cliente,i=0;
    int[] pros=new int[]{7,7,7,7,7};
    Productos datos[]=
            new Productos[]{
                    new Productos(),
                    new Productos(),
                    new Productos(),
                    new Productos(),
                    new Productos()
            };
    ListView list;
    ContentValues dataBD;
    SQLiteDatabase dbContactos,dbMisFavoritos,dbProductos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        prefs=getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();
        opciones = new String[] {getText(R.string.main).toString(),getText(R.string.main1).toString(),getText(R.string.main2).toString(),getText(R.string.main3).toString(),
                getText(R.string.main4).toString()};
       // ContactosSQLiteHelper misfavoritos = new ContactosSQLiteHelper(this,"MisFavoritosBD", null, 1);
       // ContactosSQLiteHelper productos = new ContactosSQLiteHelper(this,"ProductosBD", null, 1);
        BasesSQLiteHelper contactos = new BasesSQLiteHelper(this,"ContactosBD", null, 1);
        dbContactos = contactos.getWritableDatabase();
        // dbProductos = productos.getWritableDatabase();
        // dbMisFavoritos = misfavoritos.getWritableDatabase();

        ActionBar actionBar1 = getSupportActionBar();
        if (actionBar1 != null){
            actionBar1.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar1.setDisplayHomeAsUpEnabled(true);
        }
        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal3);
        listView = (ListView) findViewById(R.id.menuIzq3);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Fragment fragment = null;
                switch (i){
                    case(0): Intent intent=new Intent(Perfil.this,Main.class);
                        startActivity(intent);


                        break;
                    case(1):

                        break;
                    case(2):
                        Intent intent1=new Intent(Perfil.this,Valopre.class);
                        startActivity(intent1);

                        break;
                    case(3):
                        Intent intent2= new Intent(Perfil.this, Clasificacion.class);
                        startActivity(intent2);
                        break;
                    case(4):
                        Intent intent3= new Intent(Perfil.this, Loggin.class);
                        editor.putInt("var",-1);
                        editor.commit();

                        startActivity(intent3);
                        finish();
                        break;
                }
                if (i != 3) {
                    // FragmentManager fragmentManager = getSupportFragmentManager();
                    // fragmentManager.beginTransaction().replace(R.id.contenedorFrame, fragment).commit();

                }
                listView.setItemChecked(i,true);
                drawerLayout.closeDrawer(listView);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.abierto, R.string.cerrado);

        drawerLayout.setDrawerListener(drawerToggle);




       // cliente=prefs.getInt("num",-1);

        num=prefs.getInt("num",-1);
        Cursor c = dbContactos.rawQuery("select * from Contactos where id='"+num+"'",null);
        if(c.moveToFirst()) {

            nomb = c.getString(1);
            mais = c.getString(3);
        }
        /*Cursor c1 = dbMisFavoritos.rawQuery("select * from MisFavoritos where user='"+cliente+"'",null);
        if(c1.moveToFirst()) {
            i=0;
            pros=new int[]{7,7,7,7,7};
            do {

                pros[i]=c1.getInt(2);
                i++;
            } while(c1.moveToNext());
        }
        for(int j=0;j<=4;j++) {

            Cursor c2 = dbProductos.rawQuery("select * from Productos where id='" + (pros[j]) + "'", null);
            if (c2.moveToFirst()) {
                ids = c2.getInt(1);
                name = c2.getString(2);
                description = c2.getString(3);
                price = c2.getString(4);

            }
            if(pros[j]==7){
                datos[j]=new Productos();
            }else{
                datos[j]= new Productos(ids,price,name,description);
            }
        }*/
      /*  tName=(TextView) findViewById(R.id.nombre);
        tmail=(TextView) findViewById(R.id.email);
        tName.setText(nomb);
        tmail.setText(mais);*/


        PagerAdapter page1 =new PagerAdapter(getSupportFragmentManager());
        vp = (ViewPager) findViewById(R.id.Pager1);
        vp.setAdapter(page1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);




        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
            }
        };

        ActionBar.Tab tab = actionBar.newTab().setText(R.string.perfil).setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText(R.string.perfil1).setTabListener(tabListener);
        actionBar.addTab(tab);



        vp.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }
        });


    }

    public class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 : return new PerfilFragment(nomb,mais);
                case 1 : return new PerfilFragment(nomb,mais);

                default: return null;
            }

        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
