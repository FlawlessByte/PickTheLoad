package co.realinventor.picktheload.Admin;

import androidx.appcompat.app.AppCompatActivity;
import co.realinventor.picktheload.Common.Constants;
import co.realinventor.picktheload.MainActivity;
import co.realinventor.picktheload.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        Constants.CURRENT_USER = Constants.ADMIN;
    }

    public void adminReviewLorryButtonPressed(View view){
        startActivity(new Intent(this, PostLorryReviewActivity.class));
    }

    public void adminReviewLoadButtonPressed(View view){
        startActivity(new Intent(this, PostLoadReviewActivity.class));
    }

    public  void logOutButtonClicked(View view){
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }
}
