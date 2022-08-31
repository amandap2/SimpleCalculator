package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText number1EditText;
    EditText number2EditText;

    Button sumButton;
    Button subtractionButton;
    Button multiplicationButton;
    Button divisionButton;

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        listeners();
    }

    private void initComponents(){
        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);

        sumButton = findViewById(R.id.sumButton);
        subtractionButton = findViewById(R.id.subtractionButton);
        multiplicationButton = findViewById(R.id.multiplicationButton);
        divisionButton = findViewById(R.id.divisionButton);

        resultTextView = findViewById(R.id.resultTextView);
    }

    private void listeners() {
        sumButton.setOnClickListener(evt -> sum());
        subtractionButton.setOnClickListener(evt -> subtraction());
        multiplicationButton.setOnClickListener(evt -> multiplication());
        divisionButton.setOnClickListener(evt -> division());
    }

    private void sum(){
        if(checkNull()){
            double number1 = Double.parseDouble(number1EditText.getText().toString());
            double number2 = Double.parseDouble(number2EditText.getText().toString());

            double result = number1 + number2;

            resultTextView.setText(String.valueOf(result));
        }
    }

    private void subtraction() {
        if(checkNull()){
            double number1 = Double.parseDouble(number1EditText.getText().toString());
            double number2 = Double.parseDouble(number2EditText.getText().toString());

            double result = number1 - number2;

            resultTextView.setText(String.valueOf(result));
        }
    }

    private void multiplication() {
        if(checkNull()){
            double number1 = Double.parseDouble(number1EditText.getText().toString());
            double number2 = Double.parseDouble(number2EditText.getText().toString());

            double result = number1 * number2;

            resultTextView.setText(String.valueOf(result));
        }
    }

    private void division() {
        if(checkNull()){
            double number1 = Double.parseDouble(number1EditText.getText().toString());
            double number2 = Double.parseDouble(number2EditText.getText().toString());

            if(number2 == 0){
                Toast.makeText(this, "Não é possível dividir por zero!", Toast.LENGTH_LONG).show();
                return;
            }

            double result = number1 / number2;

            resultTextView.setText(String.valueOf(result));
        }
    }

    private boolean checkNull(){
        if(number1EditText.getText().toString().isEmpty() || number2EditText.getText().toString().isEmpty()){
            Toast.makeText(this, "Digite dois números!", Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            return true;
        }
    }
}