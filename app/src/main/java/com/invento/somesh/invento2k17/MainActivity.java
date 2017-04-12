package com.invento.somesh.invento2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    private FirebaseAuth firebaseAuth;
    public final static String MESSAGE_KEY ="androidbelieve.message_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        Intent intent = getIntent();
        String d = intent.getStringExtra(MESSAGE_KEY);



        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff) ;

          switch (d) {
              case "TabFr":
              mFragmentManager = getSupportFragmentManager();
              mFragmentTransaction = mFragmentManager.beginTransaction();
              mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                  break;

              case "ScheduleFragment":
                  mFragmentManager = getSupportFragmentManager();
                  mFragmentTransaction = mFragmentManager.beginTransaction();
                  mFragmentTransaction.replace(R.id.containerView, new ScheduleFragment()).commit();
                  break;
          }

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();


                if (menuItem.getItemId() == R.id.nav_item_Events) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_sch) {
                    mFragmentManager = getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.containerView,new ScheduleFragment()).commit();
                }


                if (menuItem.getItemId() == R.id.nav_spo) {
                    startActivity(new Intent(getApplication(), Sponsor.class));

                }


                if (menuItem.getItemId() == R.id.nav_logout){
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(MainActivity.this, Loginactivity.class));
                }

                return false;
            }

        });



        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }

}