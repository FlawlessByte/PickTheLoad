package co.realinventor.picktheload.Merchant;

import androidx.appcompat.app.AppCompatActivity;
import co.realinventor.picktheload.Authentication.LoginActivity;
import co.realinventor.picktheload.Common.MerchantDetails;
import co.realinventor.picktheload.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MerchantDetailsActivity extends AppCompatActivity {
    private TextInputEditText textInputMerchantName, textInputMerchantSurname, textInputMerchantShopName,
            textInputMerchantRegNo, textInputMerchantPlace, textInputMerchantPhone;
    private TextInputLayout textInputLayoutPhone;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_details);

        textInputMerchantName = findViewById(R.id.textInputMerchantName);
        textInputMerchantSurname = findViewById(R.id.textInputMerchantSurname);
        textInputMerchantShopName = findViewById(R.id.textInputMerchantShopName);
        textInputMerchantRegNo = findViewById(R.id.textInputMerchantRegNo);
        textInputMerchantPlace = findViewById(R.id.textInputMerchantPlace);
        textInputMerchantPhone = findViewById(R.id.textInputMerchantPhone);
        textInputLayoutPhone = findViewById(R.id.textInputLayoutPhone);


        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    public void merchantSignUpButtonClicked(View view) {
        String merchantName = textInputMerchantName.getText().toString();
        String surName = textInputMerchantSurname.getText().toString();
        String shopName= textInputMerchantShopName.getText().toString();
        String regNo = textInputMerchantRegNo.getText().toString();
        String place = textInputMerchantPlace.getText().toString();
        String phone = textInputMerchantPhone.getText().toString();
        boolean numError = false;
        if(!(phone.length()==10 || phone.length()==12)){
            numError = true;
            textInputLayoutPhone.setError("Please enter a valid number!");
        }

        if(TextUtils.isEmpty(merchantName) || TextUtils.isEmpty(surName) || TextUtils.isEmpty(shopName) || TextUtils.isEmpty(regNo) ||
                TextUtils.isEmpty(place) || TextUtils.isEmpty(phone) || numError ){
            //Some of the inputs are empty
            Toast.makeText(this, "Check all the inputs and try again!", Toast.LENGTH_SHORT).show();
        }
        else{
            MerchantDetails merchantDetails = new MerchantDetails(uid, merchantName, surName, shopName, regNo, place, phone);

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            ref.child("Merchants").child(uid).setValue(merchantDetails);

            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

    }
}
