package co.realinventor.picktheload.Admin;

import androidx.appcompat.app.AppCompatActivity;
import co.realinventor.picktheload.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText emailAdmin, passwordAdmin;
    private Button btn_login_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        FirebaseAuth.getInstance().signOut();

        emailAdmin = findViewById(R.id.emailAdmin);
        passwordAdmin = findViewById(R.id.passwordAdmin);
        btn_login_admin = findViewById(R.id.btn_login_admin);


        btn_login_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAdmin.getText().toString();
                String password = passwordAdmin.getText().toString();
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    //Some of the inputs are empty
                    Toast.makeText(AdminLoginActivity.this, "Check username or password!", Toast.LENGTH_SHORT).show();
                }
                else if(email.equals("admin@picktheload.com") && password.equals("admin")){
                    //Log in success
                    Toast.makeText(AdminLoginActivity.this, "Login success!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AdminLoginActivity.this, AdminHomeActivity.class));
                    finish();

                }
                else{
                    Toast.makeText(AdminLoginActivity.this, "Wrong credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
