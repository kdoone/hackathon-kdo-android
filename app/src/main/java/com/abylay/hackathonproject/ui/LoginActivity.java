package com.abylay.hackathonproject.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.abylay.hackathonproject.R;
import com.github.pinball83.maskededittext.MaskedEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.loginBtn) Button loginBtn;
    @BindView(R.id.phNumber) MaskedEditText phoneEdit;
    @BindView(R.id.passTxt) EditText passEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginBtn.setOnClickListener(v -> startActivity(new Intent(this, NavigationActivity.class)));
    }
}
