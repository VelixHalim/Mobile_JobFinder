package id.ac.umn.mobile_jobfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private EditText etRegEmail, etRegPassword, etRetypePassword, etRegNama;
    private Button btnRegister;
    private TextView tvSignIn, tvIncorrectRetype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegNama = findViewById(R.id.etRegNama);
        etRegEmail = findViewById(R.id.etRegEmail);
        etRegPassword = findViewById(R.id.etRegPassword);
        etRetypePassword = findViewById(R.id.etRetypePassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvSignIn = findViewById(R.id.tvSignIn);
        tvIncorrectRetype = findViewById(R.id.tvIncorrectRetype);
        tvIncorrectRetype.setVisibility(View.INVISIBLE);

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keHalamanLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivityForResult(keHalamanLogin, 2);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etRegPassword.getText().toString().equalsIgnoreCase(etRetypePassword.getText().toString())) {
                    Intent berhasilRegister = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivityForResult(berhasilRegister, 3);
                    finish();
                } else {
                    tvIncorrectRetype.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}