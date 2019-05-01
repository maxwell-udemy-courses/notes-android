package com.maxwell.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.maxwell.notes.notes.NotesActivity;
import com.maxwell.notes.utils.Constants;

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUserName = findViewById(R.id.etUserName);
        final EditText etPassword = findViewById(R.id.etPassword);
        Button btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString();
                String password = etPassword.getText().toString();

                if(username.equals("max") && password.equals("123")){

                    prefs.setPref(Constants.PREFS_USER, true);

                    Intent intent = new Intent(LoginActivity.this, NotesActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Ingreso incorrecto!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
