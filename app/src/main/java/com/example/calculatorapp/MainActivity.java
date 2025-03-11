package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText inputFirstNumber, inputSecondNumber;
    Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        textResult = findViewById(R.id.textResult);

        buttonPlus.setOnClickListener(this::calculate);
        buttonMinus.setOnClickListener(this::calculate);
        buttonMultiply.setOnClickListener(this::calculate);
        buttonDivide.setOnClickListener(this::calculate);
    }

    public void calculate(View view) {
        String num1 = inputFirstNumber.getText().toString();
        String num2 = inputSecondNumber.getText().toString();

        if (num1.isEmpty() || num2.isEmpty()) {
            textResult.setText("Enter numbers");
            return;
        }

        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        double result = 0;

        if (view.getId() == R.id.buttonPlus) {
            result = number1 + number2;
        } else if (view.getId() == R.id.buttonMinus) {
            result = number1 - number2;
        } else if (view.getId() == R.id.buttonMultiply) {
            result = number1 * number2;
        } else if (view.getId() == R.id.buttonDivide) {
            if (number2 != 0) {
                result = number1 / number2;
            } else {
                textResult.setText("Cannot divide by zero");
                return;
            }
        }

        textResult.setText(String.valueOf(result));
    }

}
