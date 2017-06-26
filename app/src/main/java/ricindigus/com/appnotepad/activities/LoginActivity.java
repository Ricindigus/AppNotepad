package ricindigus.com.appnotepad.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ricindigus.com.appnotepad.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor  = sharedPreferences.edit();
        editor.putString("usuario", "ed");
        editor.putString("password", "ed");
        editor.commit();


        edtUsername = (EditText)findViewById(R.id.edt_username);
        edtPassword = (EditText)findViewById(R.id.edt_password);

        btnLogin = (Button)findViewById(R.id.btn_ingreso);
        btnRegister = (Button)findViewById(R.id.btn_registro);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUsername.getText().toString().toLowerCase();
                String pass = edtPassword.getText().toString().toLowerCase();
                SharedPreferences sharedPreferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
                if(user.equals(sharedPreferences.getString("usuario","x")) && pass.equals(sharedPreferences.getString("password","x"))){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "usuario o password incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Registrar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
