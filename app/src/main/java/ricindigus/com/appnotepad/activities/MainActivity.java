package ricindigus.com.appnotepad.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import ricindigus.com.appnotepad.R;
import ricindigus.com.appnotepad.fragments.PendientesFragment;
import ricindigus.com.appnotepad.fragments.PrincipalFragment;
import ricindigus.com.appnotepad.fragments.SuperMercadoFragment;
import ricindigus.com.appnotepad.fragments.VacacionesFragment;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                drawerLayout.closeDrawers();

                switch(item.getItemId()){
                    case R.id.opcion_principal:
                        setFragment(0);
                        break;
                    case R.id.opcion_supermercado:
                        setFragment(1);
                        break;
                    case R.id.opcion_pendientes:
                        setFragment(2);
                        break;
                    case R.id.opcion_vacaciones:
                        setFragment(3);
                        break;
                }
                return false;
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();



        setFragment(0);
    }
    public void setFragment(int pos){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (pos){
            case 0:
                PrincipalFragment principalFragment = new PrincipalFragment();
                fragmentTransaction.replace(R.id.fragments, principalFragment);
                break;
            case 1:
                SuperMercadoFragment superMercadoFragment = new SuperMercadoFragment();
                fragmentTransaction.replace(R.id.fragments, superMercadoFragment);
                break;
            case 2:
                PendientesFragment pendientesFragment= new PendientesFragment();
                fragmentTransaction.replace(R.id.fragments, pendientesFragment);
                break;
            case 3:
                VacacionesFragment vacacionesFragment = new VacacionesFragment();
                fragmentTransaction.replace(R.id.fragments, vacacionesFragment);
                break;
        }
        fragmentTransaction.commit();
    }
}
