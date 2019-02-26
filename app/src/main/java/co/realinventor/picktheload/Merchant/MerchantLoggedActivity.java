package co.realinventor.picktheload.Merchant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import co.realinventor.picktheload.Admin.PostLorryReviewActivity;
import co.realinventor.picktheload.Common.Constants;
import co.realinventor.picktheload.MainActivity;
import co.realinventor.picktheload.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MerchantLoggedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_logged);

//        // Attaching the layout to the toolbar object
//        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
//        // Setting toolbar as the ActionBar with setSupportActionBar() call
//        toolbar.setTitle("Merchant");
//        setSupportActionBar(toolbar);

        Constants.CURRENT_USER = Constants.MERCHANT;
    }

    public  void logOutButtonClicked(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }


    public void merchantSearchLorryButtonCicked(View view){
        startActivity(new Intent(this, PostLorryReviewActivity.class));
    }

    public void merchantPostLoadButtonClicked(View view){
        PostLoadDialog dialog = new PostLoadDialog();
        dialog.show(getSupportFragmentManager().beginTransaction(), PostLoadDialog.TAG);
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu, this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_logout) {
//
//            Log.d("MenuSignOutButton", "Pressed");
//            FirebaseAuth.getInstance().signOut();
//            startActivity(new Intent(this, MainActivity.class));
//            this.finish();
//
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        super.onBackPressed();
    }
}
