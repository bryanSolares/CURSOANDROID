package com.example.droidcafe;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year= c.get(Calendar.YEAR);
        int month= c.get(Calendar.MONTH);
        int day= c.get(Calendar.DAY_OF_MONTH);


        return new DatePickerDialog(getActivity(),this,year,month,day);


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        PickerDate main = (PickerDate) getActivity();
        main.proccessDatePickerResult(year,month,dayOfMonth);

    }
}
