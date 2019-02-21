package co.realinventor.picktheload.Merchant;

import androidx.appcompat.app.AppCompatActivity;
import co.realinventor.picktheload.Admin.PostLorryReviewActivity;
import co.realinventor.picktheload.Common.Constants;
import co.realinventor.picktheload.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MerchantLoggedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_logged);

        Constants.CURRENT_USER = Constants.MERCHANT;
    }


    public void merchantSearchLorryButtonCicked(View view){
        startActivity(new Intent(this, PostLorryReviewActivity.class));
    }

    public void merchantPostLoadButtonClicked(View view){
        PostLoadDialog dialog = new PostLoadDialog();
        dialog.show(getSupportFragmentManager().beginTransaction(), PostLoadDialog.TAG);
    }
}
