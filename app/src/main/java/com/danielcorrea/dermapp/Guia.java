package com.danielcorrea.dermapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class Guia extends AppCompatActivity {

    ViewPager vp;

    String mais,nomb;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    private String[] opciones;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;
    int a=1,b=2,c=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia);
        prefs=getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();
        opciones = new String[] {getText(R.string.main).toString(),getText(R.string.main1).toString(),getText(R.string.main2).toString(),getText(R.string.main3).toString(),
                getText(R.string.main4).toString()};




        ActionBar actionBar1 = getSupportActionBar();
        if (actionBar1 != null){
            actionBar1.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar1.setDisplayHomeAsUpEnabled(true);
        }
        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipales1);
        listView = (ListView) findViewById(R.id.menuIzqes1);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Fragment fragment = null;
                switch (i){
                    case(0): Intent intent=new Intent(Guia.this,Main.class);
                        startActivity(intent);


                        break;
                    case(1):Intent intent1=new Intent(Guia.this,Perfil.class);
                        startActivity(intent1);

                        break;
                    case(2):Intent intent21= new Intent(Guia.this, Valopre.class);
                        startActivity(intent21);


                        break;
                    case(3):
                        Intent intent2= new Intent(Guia.this, Clasificacion.class);
                        startActivity(intent2);
                        break;
                    case(4):
                        Intent intent3= new Intent(Guia.this, Loggin.class);
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








        PagerAdapter page1 =new PagerAdapter(getSupportFragmentManager());
        vp = (ViewPager) findViewById(R.id.Pager21);
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

        ActionBar.Tab tab = actionBar.newTab().setText(R.string.valoras1).setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText(R.string.valoras2).setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText(R.string.valoras3).setTabListener(tabListener);
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
                case 0 : return new GuiaBradenFragment();
                case 1 : return new GuiaBradenFragment();
                case 2 : return new GuiaBradenFragment();
                default: return null;
            }

        }

        @Override
        public int getCount() {
            return 3;
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



