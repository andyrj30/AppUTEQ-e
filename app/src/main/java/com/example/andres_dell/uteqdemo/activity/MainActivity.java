package com.example.andres_dell.uteqdemo.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.example.andres_dell.uteqdemo.fragments.VerNoticiaFragment;
import com.example.andres_dell.uteqdemo.fragments.ArchivoFragment;
import com.example.andres_dell.uteqdemo.fragments.InvestigacionFragment;
import com.example.andres_dell.uteqdemo.fragments.MainFragment;
import com.example.andres_dell.uteqdemo.fragments.NoticiaFragment;
import com.example.andres_dell.uteqdemo.fragments.OfertaFragment;
import com.example.andres_dell.uteqdemo.fragments.RendicionFragment;
import com.example.andres_dell.uteqdemo.fragments.TransparenciaFragment;
import com.example.andres_dell.uteqdemo.fragments.UniversidadFragment;
import com.example.andres_dell.uteqdemo.fragments.VinculacionFragment;
import com.example.andres_dell.uteqdemo.fragments.WebViewFragment;
import com.example.andres_dell.uteqdemo.R;
import com.example.andres_dell.uteqdemo.utils.Constants;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    private DrawerLayout drawerLayout;
    Fragment fragment;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Constants.fragmentManager = getSupportFragmentManager();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initNavigationDrawer();
        fragmentManager = getSupportFragmentManager();
        String menu = getIntent().getExtras() != null ? getIntent().getExtras().getString("menu") : "";
        //getSupportActionBar().setTitle(menu);
        Bundle b = new Bundle();
        b.putString("tipo", "1");
        fragment = new MainFragment();
        fragment.setArguments(b);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
        Intent intent = getIntent();
        b = intent.getExtras();

        if (b!=null && b.getString("id") != null) {

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            VerNoticiaFragment fragment = new VerNoticiaFragment();
            Bundle b1 = new Bundle();
            b1.putString("titulo", "Noticias");
            b1.putString("id",b.getString("id"));
            fragment.setArguments(b1);
            fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void initNavigationDrawer() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                //getSupportActionBar().setTitle(menuItem.getTitle());

                Bundle b = new Bundle();
                switch (id) {
                    case R.id.nav_home:
                        menuItem.setChecked(true);
                        fragment = new MainFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_noticias:
                        menuItem.setChecked(true);
                        b = new Bundle();
                        b.putString("tipo", "1");
                        b.putString("titulo", "Noticias");
                        fragment = new NoticiaFragment();
                        fragment.setArguments(b);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_universidad:
                        menuItem.setChecked(true);
                        fragment = new UniversidadFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_investigacion:
                        menuItem.setChecked(true);
                        fragment = new InvestigacionFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_vinculacion:
                        menuItem.setChecked(true);
                        fragment = new VinculacionFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_ofertaacademica:
                        menuItem.setChecked(true);
                        fragment = new OfertaFragment();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_transparencia:
                        menuItem.setChecked(true);
                        b = new Bundle();
                        b.putString("tipoFragment", "tr");
                        fragment = new TransparenciaFragment();
                        fragment.setArguments(b);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_rendicioncuentas:
                        menuItem.setChecked(true);
                        b = new Bundle();
                        b.putString("tipoFragment", "rc");
                        fragment = new RendicionFragment();
                        fragment.setArguments(b);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_archivos:
                        menuItem.setChecked(true);
                        b = new Bundle();
                        b.putString("tipoFragment", "ar");
                        fragment = new ArchivoFragment();
                        fragment.setArguments(b);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_consultanotas:
                        menuItem.setChecked(true);
                        b = new Bundle();
                        b.putString("titulo", "Consulta de notas");
                        b.putString("url", "http://sicau.uteq.edu.ec/portal/estudiantes/notas/home.faces");
                        fragment = new WebViewFragment();
                        fragment.setArguments(b);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack(null);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_videosuteq:
                        b = new Bundle();
                        b.putString("titulo", "Videos UTEQ");
                        b.putString("url", "https://www.youtube.com/user/UTEQCHANNEL/videos");
                        fragment = new WebViewFragment();
                        fragment.setArguments(b);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment, "webview").addToBackStack(null);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_exit:
                        finish();

                }
                return true;
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}