package com.abylay.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.abylay.hackathonproject.ui.LoginActivity;
import com.abylay.hackathonproject.ui.NavigationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_get_btn) Button getBtn;
    @BindView(R.id.main_login_btn) TextView loginTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getBtn.setOnClickListener(v -> startActivity(new Intent(this, NavigationActivity.class)));
        loginTxt.setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
    }
}