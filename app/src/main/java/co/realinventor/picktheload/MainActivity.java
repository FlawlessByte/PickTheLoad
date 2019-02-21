package co.realinventor.picktheload;

import androidx.appcompat.app.AppCompatActivity;
import co.realinventor.picktheload.Admin.AdminLoginActivity;
import co.realinventor.picktheload.Authentication.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void modeSelectButtonPressed(View view){
        startActivity(new Intent(this, LoginActivity.class).putExtra("mode", view.getTag().toString()));
    }

    public void adminModeSelected(View view){
        startActivity(new Intent(this, AdminLoginActivity.class));
    }
}
