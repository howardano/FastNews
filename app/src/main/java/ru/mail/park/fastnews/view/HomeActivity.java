package ru.mail.park.fastnews.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.mail.park.fastnews.R;
import ru.mail.park.fastnews.view.fragment.FavoritesFragment;
import ru.mail.park.fastnews.view.fragment.HomeFragment;
import ru.mail.park.fastnews.view.fragment.SettingsFragment;

public class HomeActivity extends AppCompatActivity {
    TextView name, mail;
    Button logout;
    BottomNavigationView btmNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        logout = findViewById(R.id.signout);
//        name = findViewById(R.id.name);
 //       mail = findViewById(R.id.email);
        btmNavView = findViewById(R.id.bottom_menu);
        btmNavView.setOnNavigationItemSelectedListener(navListener);


 /*       logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });*/
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch(item.getItemId()) {
                        case R.id.home_fr:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.favorites_fr:
                            selectedFragment = new FavoritesFragment();
                            break;
                        case R.id.settings_fr:
                            selectedFragment = new SettingsFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}