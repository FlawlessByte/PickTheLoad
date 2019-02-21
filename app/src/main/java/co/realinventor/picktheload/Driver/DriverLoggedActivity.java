package co.realinventor.picktheload.Driver;

import androidx.appcompat.app.AppCompatActivity;
import co.realinventor.picktheload.Admin.PostLoadReviewActivity;
import co.realinventor.picktheload.Common.Constants;
import co.realinventor.picktheload.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DriverLoggedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_logged);

        Constants.CURRENT_USER = Constants.DRIVER;
    }


    public void driverSearchLoadButtonCicked(View view){
        startActivity(new Intent(this, PostLoadReviewActivity.class));
    }

    public void driverPostLorryButtonClicked(View view){
        PostLorryDialog dialog = new PostLorryDialog();
        dialog.show(getSupportFragmentManager().beginTransaction(), PostLorryDialog.TAG);
    }



}
