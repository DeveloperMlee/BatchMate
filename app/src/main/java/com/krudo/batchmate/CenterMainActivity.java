package com.krudo.batchmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.krudo.batchmate.Fragments.CraftRoomFragment;
import com.krudo.batchmate.Fragments.DiscoverFragment;
import com.krudo.batchmate.Fragments.HomeFragment;
import com.krudo.batchmate.Fragments.ProfileFragment;

public class CenterMainActivity extends AppCompatActivity {


    NavigationView nav;
    ActionBarDrawerToggle toggle;
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        bottomNavigationView=findViewById(R.id.bottom_nav);
//        bottomNavigationView.setSelectedItemId(R.id.homeFrag);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment temp=null;
               switch (item.getItemId())
               {
                   case R.id.homeFrag:temp=new HomeFragment();
                   break;
                   case R.id.disFrag: temp=new DiscoverFragment();
                       break;
                   case R.id.craftFrag: temp=new CraftRoomFragment();
                       break;
                   case R.id.profileFrag:
                       temp=new ProfileFragment();
                       break;
               }
               getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
               return true;
           }
       });


        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.notification:
                        Toast.makeText(CenterMainActivity.this, " Notification clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.aboutUs:
                        Toast.makeText(CenterMainActivity.this, " About us clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.rateUs:
                        Toast.makeText(CenterMainActivity.this, " Rate us clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.legal:
                        Toast.makeText(CenterMainActivity.this, " Legal clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.inviteFri:
                        Toast.makeText(CenterMainActivity.this, " Invite clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
    }
}