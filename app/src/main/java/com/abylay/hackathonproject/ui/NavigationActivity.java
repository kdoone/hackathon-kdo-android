package com.abylay.hackathonproject.ui;

import android.os.Bundle;
import android.view.WindowManager;

import com.abylay.hackathonproject.R;
import com.abylay.hackathonproject.fragments.main_fragments.ChatFragment;
import com.abylay.hackathonproject.fragments.main_fragments.MainFragment;
import com.abylay.hackathonproject.fragments.main_fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationActivity extends AppCompatActivity {

    @BindView(R.id.nav_view) BottomNavigationView navView;
    Fragment selectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nagivation);
        ButterKnife.bind(this);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        navView.setItemIconTintList(null);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        navView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new MainFragment();
                    break;

                case R.id.nav_chat:
                    selectedFragment = new ChatFragment();
                    break;

                case R.id.nav_prof:
                    selectedFragment = new ProfileFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).addToBackStack("my_fragment").commit();
            return true;
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
    }

}
