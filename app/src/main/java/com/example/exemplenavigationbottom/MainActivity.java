package com.example.exemplenavigationbottom;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.navigation_compte)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);

        // on remplace l'actionbar par notre toolbar
        setSupportActionBar(toolbar);

        // on supprime le titre de l'application
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // j'ajoute un logo(drawable) dans la toolbar
        //toolbar.setLogo(R.drawable.ic_action_asso);

        // je definis le titre de la toolbar
        toolbar.setTitle("AFPA Asso");

        toolbar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //on associe un menu a notre activity
        getMenuInflater().inflate(R.menu.mnu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case R.id.action_compte:
                navController.navigate(R.id.navigation_compte);
                break;
            case R.id.action_quitter:
                //on quitte l'application
                finish();
                break;

        }

        return true;
    }
}
