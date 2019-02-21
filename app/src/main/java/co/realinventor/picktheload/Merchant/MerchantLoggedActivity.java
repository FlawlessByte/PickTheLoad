package co.realinventor.picktheload.Merchant;

import androidx.appcompat.app.AppCompatActivity;
import co.realinventor.picktheload.R;

import android.os.Bundle;
import android.view.View;

public class MerchantLoggedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_logged);
    }


    public void merchantSearchLorryButtonCicked(View view){

    }

    public void merchantPostLoadButtonClicked(View view){
        PostLoadDialog dialog = new PostLoadDialog();
        dialog.show(getSupportFragmentManager().beginTransaction(), PostLoadDialog.TAG);
    }
}
