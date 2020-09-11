package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    EditText num1, num2;
    Button button1;
    TextView text;
    Spinner spinner;
    String[] operation = {"Choose operation", "+", "-", "*", "/"};
    String selected;
    int a, b, c;
    private View.OnClickListener myClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            a = Integer.parseInt(num1.getText().toString());
            b = Integer.parseInt(num2.getText().toString());
            if (selected == "+") {
                c = a + b;
                text.setText(Integer.toString(c));
            } else if (selected == "-") {
                c = a - b;
                text.setText(Integer.toString(c));
            } else if (selected == "*") {
                c = a * b;
                text.setText(Integer.toString(c));
            } else if (selected == "/") {
                c = a / b;
                text.setText(Integer.toString(c));
            } else {
                text.setText("Please select the operation");
            }

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.textView3);

        button1 = (Button)findViewById(R.id.button);
        button1.setText("Display result");
        button1.setOnClickListener(myClickListener);

        num1 = (EditText)findViewById(R.id.editTextNumber);
        num1.setText("");
        num2 = (EditText)findViewById(R.id.editTextNumber2);
        num2.setText("");

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, operation);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }
    public void onItemSelected (AdapterView<?> p,View v,int position,long id) {
        selected=operation[position];
        text.setText("Your selection is - > " + selected);
    }
    public void onNothingSelected(AdapterView<?> p) {
        text.setText("Please select something");
    }
}