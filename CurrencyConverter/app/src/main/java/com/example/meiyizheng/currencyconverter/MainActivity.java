package com.example.meiyizheng.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View View){
        Log.i("Info","Button pressed!");

        EditText editText = findViewById(R.id.editText);

        String amountInPounds = editText.getText().toString();

        double amountInPoundsDouble = Double.parseDouble(amountInPounds);

        double amountInDollars = amountInPoundsDouble * 1.3;

        String amountInDollarsString = String.format("%.2f", amountInDollars);

        Toast.makeText(this, "pound" + amountInPounds +" is $" + amountInDollars, Toast.LENGTH_SHORT).show();

        //Log.i("Amount in dollars", amountInDollarsString);

        //Log.i("Info", editText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
