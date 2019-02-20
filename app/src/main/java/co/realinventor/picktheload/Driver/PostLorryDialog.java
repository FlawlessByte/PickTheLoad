package co.realinventor.picktheload.Driver;

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
import co.realinventor.picktheload.Common.LorryPost;
import co.realinventor.picktheload.R;

public class PostLorryDialog  extends DialogFragment {
    public static String TAG = "PostLorryDialog";
    private TextInputEditText textInputPostLorryCapacity, textInputPostLorryDate, textInputPostLorryLocationFrom, textInputPostLorryLocationTo,
            textInputPostLorryTrackNo, textInputPostLorryName, textInputPostLorryPhone;
    private Button postButton;
    private ImageButton calendarImageButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.layout_post_lorry_dialog, container, false);


        Toolbar toolbar = view.findViewById(R.id.toolbarDialog);
        toolbar.setNavigationIcon(R.drawable.close_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDialog();
            }
        });
        toolbar.setTitle("Post Lorry Information");


        textInputPostLorryCapacity = view.findViewById(R.id.textInputPostLorryCapacity);
        textInputPostLorryDate= view.findViewById(R.id.textInputPostLorryDate);
        textInputPostLorryLocationFrom = view.findViewById(R.id.textInputPostLorryLocationFrom);
        textInputPostLorryLocationTo = view.findViewById(R.id.textInputPostLorryLocationTo);
        textInputPostLorryTrackNo = view.findViewById(R.id.textInputPostLorryTrackNo);
        textInputPostLorryName = view.findViewById(R.id.textInputPostLorryName);
        textInputPostLorryPhone = view.findViewById(R.id.textInputPostLorryPhone);
        postButton = view.findViewById(R.id.postButton);
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

                                textInputPostLorryDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postLorry();
            }
        });


        return view;
    }


    private void postLorry(){
        String capacity = textInputPostLorryCapacity.getText().toString();
        String date = textInputPostLorryDate.getText().toString();
        String locationFrom = textInputPostLorryLocationFrom.getText().toString();
        String locationTo = textInputPostLorryLocationTo.getText().toString();
        String trackNo = textInputPostLorryTrackNo.getText().toString();
        String phone = textInputPostLorryPhone.getText().toString();
        String name = textInputPostLorryName.getText().toString();


        if(TextUtils.isEmpty(capacity) || TextUtils.isEmpty(date) || TextUtils.isEmpty(locationFrom) || TextUtils.isEmpty(locationTo) ||
                TextUtils.isEmpty(trackNo) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(name)){
            //Some of the inputs are empty
            Toast.makeText(getContext(), "Fill all the inputs and try again!", Toast.LENGTH_SHORT).show();
        }
        else{
            //inputs ok
            new LorryPost().makeLorryPost(capacity,date,locationFrom,locationTo,trackNo,name,phone);

            Toast.makeText(getContext(), "The Lorry information has been posted!", Toast.LENGTH_SHORT).show();
            dismiss();

        }


    }



    private void closeDialog(){
        this.dismiss();
    }
}
