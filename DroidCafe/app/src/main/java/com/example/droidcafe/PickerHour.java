package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PickerHour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_hour);
    }

    public void showHourPicker(View view) {
        DialogFragment dialogFragment = new HourPickerFragment();
        dialogFragment.show(getSupportFragmentManager(),getString(R.string.hourpicker));
    }

    public void proccessHourPickerResult(int hours, int minutes){
        String hour = Integer.toString(hours);
        String minut= Integer.toString(minutes);
        String dateMessage = (hour +
                "/" + minut);
        Toast.makeText(this,"Hour: " + dateMessage,Toast.LENGTH_LONG).show();
    }
}
