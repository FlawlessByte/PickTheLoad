package co.realinventor.picktheload.Merchant;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import co.realinventor.picktheload.Common.LoadPost;
import co.realinventor.picktheload.R;

public class PostLoadDialog extends DialogFragment{
    public static String TAG = "PostLoadDialog";
    private TextInputEditText textInputPostLoadCapacity, textInputPostLoadDate, textInputPostLoadLocationFrom, textInputPostLoadLocationTo,
            textInputPostLoadTruckType, textInputPostLoadName, textInputPostLoadPhone, textInputPostLoadGoodsType, textInputPostLorryExpPrice;
    private Button postButtonLoad;
    private ImageButton calendarImageButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.layout_post_load_dialog, container, false);


        Toolbar toolbar = view.findViewById(R.id.toolbarDialog);
        toolbar.setNavigationIcon(R.drawable.close_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDialog();
            }
        });
        toolbar.setTitle("PosttLoad Information");


        textInputPostLoadTruckType = view.findViewById(R.id.textInputPostLoadTruckType);
        textInputPostLoadCapacity = view.findViewById(R.id.textInputPostLoadCapacity);
        textInputPostLoadGoodsType = view.findViewById(R.id.textInputPostLoadGoodsType);
        textInputPostLoadDate= view.findViewById(R.id.textInputPostLoadDate);
        textInputPostLoadLocationFrom = view.findViewById(R.id.textInputPostLoadLocationFrom);
        textInputPostLoadLocationTo = view.findViewById(R.id.textInputPostLoadLocationTo);
        textInputPostLorryExpPrice = view.findViewById(R.id.textInputPostLorryExpPrice);
        textInputPostLoadName = view.findViewById(R.id.textInputPostLoadName);
        textInputPostLoadPhone = view.findViewById(R.id.textInputPostLoadPhone);
        postButtonLoad = view.findViewById(R.id.postButtonLoad);
        calendarImageButton = view.findViewById(R.id.calendarImageButton);


        calendarImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                textInputPostLoadDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        postButtonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postLoad();
            }
        });


        return view;
    }


    private void postLoad(){
        String truckType = textInputPostLoadTruckType.getText().toString();
        String goodsType = textInputPostLoadGoodsType.getText().toString();
        String capacity = textInputPostLoadCapacity.getText().toString();
        String date = textInputPostLoadDate.getText().toString();
        String locationFrom = textInputPostLoadLocationFrom.getText().toString();
        String locationTo = textInputPostLoadLocationTo.getText().toString();
        String phone = textInputPostLoadPhone.getText().toString();
        String name = textInputPostLoadName.getText().toString();
        String expPrice = textInputPostLorryExpPrice.getText().toString();


        if(TextUtils.isEmpty(capacity) || TextUtils.isEmpty(date) || TextUtils.isEmpty(locationFrom) || TextUtils.isEmpty(locationTo) ||
                TextUtils.isEmpty(truckType) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(name) || TextUtils.isEmpty(goodsType)
                || TextUtils.isEmpty(expPrice)){
            //Some of the inputs are empty
            Toast.makeText(getContext(), "Fill all the inputs and try again!", Toast.LENGTH_SHORT).show();
        }
        else{
            //inputs ok
            new LoadPost().makeLoadPost(truckType,capacity,goodsType,date,locationFrom,locationTo,expPrice,name,phone);

            Toast.makeText(getContext(), "The Load information has been posted!", Toast.LENGTH_SHORT).show();
            dismiss();

        }


    }



    private void closeDialog(){
        this.dismiss();
    }
}
