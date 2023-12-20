package com.thedorcode.bmicalculatorappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();

    }
    public void myButtonListenerMethod() {
        Button button = (Button) findViewById(R.id.btnCalculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText heightText = (EditText) findViewById(R.id.height);
                String heightStr = heightText.getText().toString();
                double heightDle = Double.parseDouble(heightStr);
                final EditText weightText = (EditText) findViewById(R.id.weight);
                String weightStr = weightText.getText().toString();
                double weightDle = Double.parseDouble(weightStr);
                double bmi = (weightDle) / (heightDle * heightDle);
                DecimalFormat df = new DecimalFormat("#.#");
                double bmi_trimmed = Double.parseDouble(df.format(bmi));
                final TextView bmiResult = (TextView) findViewById(R.id.response);
                bmiResult.setText(Double.toString(bmi_trimmed));

                String bmi_cat;
                if(bmi < 15)
                    bmi_cat = "Very severely underweight";
                else if(bmi < 16)
                    bmi_cat = "Severely underweight";
                else if(bmi < 18.5)
                    bmi_cat = "Underweight";
                else if (bmi <25)
                    bmi_cat = "Normal";
                else if(bmi < 30)
                    bmi_cat = "Overweight";
                else if(bmi < 35)
                    bmi_cat = "Obese class 1 - Moderately obese";
                else if(bmi < 40)
                    bmi_cat = "Obese class 2 - Severely obese";
                else
                    bmi_cat = "Obese class 3 - very severely obese";
                final TextView bmiCategory = (TextView) findViewById(R.id.appearance);
                bmiCategory.setText(bmi_cat);
            }
        });
    }
}