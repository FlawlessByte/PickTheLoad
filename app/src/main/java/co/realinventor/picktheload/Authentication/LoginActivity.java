package co.realinventor.picktheload.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import co.realinventor.picktheload.Driver.DriverLoggedActivity;
import co.realinventor.picktheload.MainActivity;
import co.realinventor.picktheload.Merchant.MerchantLoggedActivity;
import co.realinventor.picktheload.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;
    String intentMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("Activity", "LoginActivity");

        FirebaseApp.initializeApp(this);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            switch (auth.getCurrentUser().getDisplayName()) {
                case "driver": {
                    Log.d("Logged", "driver");
                    startActivity(new Intent(LoginActivity.this, DriverLoggedActivity.class));
                    break;
                }
                case "merchant": {
                    Log.d("Logged", "Merchant");
                    startActivity(new Intent(LoginActivity.this, MerchantLoggedActivity.class));
                    break;
                }
                default:
                    break;

            }
            finish();

        }

        try {
            intentMode = getIntent().getStringExtra("mode");

        }
        catch(Exception e){
            Log.d("Intent", "null");
        }


        // set the view now
        setContentView(R.layout.activity_login);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        inputEmail =  findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset_password);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button", "SignUp button clicked");
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                intent.putExtra("mode", intentMode);
                startActivity(intent);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button", "reset button clicked");
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button", "Login button clicked");
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    Log.d("Sign In", "Some error");
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Log.d("Sign in", "Successful");

                                    Intent intent = null;
                                    if(auth.getCurrentUser().getDisplayName().equals("driver")){
                                        intent = new Intent(LoginActivity.this, DriverLoggedActivity.class);
                                    }
                                    else if(auth.getCurrentUser().getDisplayName().equals("merchant")){
                                        intent = new Intent(LoginActivity.this, MerchantLoggedActivity.class);
                                    }
                                    else{
                                        intent = new Intent(LoginActivity.this, MainActivity.class);
                                    }

                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
