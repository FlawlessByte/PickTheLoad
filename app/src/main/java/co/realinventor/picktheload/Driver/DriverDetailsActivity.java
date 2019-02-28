package co.realinventor.picktheload.Driver;

import androidx.appcompat.app.AppCompatActivity;
import co.realinventor.picktheload.Authentication.LoginActivity;
import co.realinventor.picktheload.Common.DriverDetails;
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

public class DriverDetailsActivity extends AppCompatActivity {
    private TextInputEditText textInputDriverName, textInputDriverSurname, textInputDriverLicenceNo, textInputDriverVehicleNo,
            textInputDriverPlace, textInputDriverPhone;
    private TextInputLayout textInputLayoutPhone;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_details);

        textInputDriverName = findViewById(R.id.textInputDriverName);
        textInputDriverSurname = findViewById(R.id.textInputDriverSurname);
        textInputDriverLicenceNo = findViewById(R.id.textInputDriverLicenceNo);
        textInputDriverVehicleNo = findViewById(R.id.textInputDriverVehicleNo);
        textInputDriverPlace = findViewById(R.id.textInputDriverPlace);
        textInputDriverPhone = findViewById(R.id.textInputDriverPhone);
        textInputLayoutPhone = findViewById(R.id.textInputLayoutPhone);

        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

    }

    public void driverSignUpButtonClicked(View view){
        String driverName = textInputDriverName.getText().toString();
        String surName = textInputDriverSurname.getText().toString();
        String licence = textInputDriverLicenceNo.getText().toString();
        String vehicleNo = textInputDriverVehicleNo.getText().toString();
        String place = textInputDriverPlace.getText().toString();
        String phone = textInputDriverPhone.getText().toString();
        boolean numError = false;
        if(!(phone.length()==10 || phone.length()==12)){
            numError = true;
            textInputLayoutPhone.setError("Please enter a valid number!");
        }

        if(TextUtils.isEmpty(driverName) || TextUtils.isEmpty(surName) || TextUtils.isEmpty(licence) || TextUtils.isEmpty(vehicleNo) ||
                TextUtils.isEmpty(place) || TextUtils.isEmpty(phone) || numError ){
            //Some of the inputs are empty
            Toast.makeText(this, "Check all the inputs and try again!", Toast.LENGTH_SHORT).show();
        }
        else{
            DriverDetails driverDetails = new DriverDetails(uid, driverName, surName, licence, vehicleNo, place, phone);

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            ref.child("Drivers").child(uid).setValue(driverDetails);

            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, LoginActivity.class));
            finish();

        }
    }
}
