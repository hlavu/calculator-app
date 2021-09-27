package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button plusBtn;
    Button multiBtn;
    Button divBtn;
    Button minusBtn;
    Button equalBtn;
    Button clearBtn;

    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnZero;

    TextView displayCalculation;
    TextView displayHistory;

    private Calculator myCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayCalculation = (TextView) findViewById(R.id.resultText);
        displayHistory = (TextView) findViewById(R.id.historyText);

        plusBtn = (Button) findViewById(R.id.plusop);
        minusBtn = (Button) findViewById(R.id.minusop);
        multiBtn = (Button) findViewById(R.id.multiop);
        divBtn = (Button) findViewById(R.id.divop);
        equalBtn = (Button) findViewById(R.id.equalsign);
        clearBtn = (Button) findViewById(R.id.delbtn);

        btnZero = (Button) findViewById(R.id.btn0);
        btnOne = (Button) findViewById(R.id.btn1);
        btnTwo = (Button) findViewById(R.id.btn2);
        btnThree = (Button) findViewById(R.id.btn3);
        btnFour = (Button) findViewById(R.id.btn4);
        btnFive = (Button) findViewById(R.id.btn5);
        btnSix = (Button) findViewById(R.id.btn6);
        btnSeven = (Button) findViewById(R.id.btn7);
        btnEight = (Button) findViewById(R.id.btn8);
        btnNine = (Button) findViewById(R.id.btn9);

        multiBtn.setOnClickListener(this);
        minusBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);
        plusBtn.setOnClickListener(this);
        equalBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);

        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);

        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Button btn = (Button) view;
        myCalculator.checkInput(btn, displayHistory);
        displayCalculation.setText(myCalculator.getDisplayOutput());
    }

    public void optBtnClicked(View view){
        Button optBtn = (Button) view;
        if(optBtn.getText().equals("ADVANCE - WITH HISTORY")){
            optBtn.setText("STANDARD - NO HISTORY");
            displayCalculation.setText("");
            myCalculator.clearDisplayOutputVal();
            myCalculator.setMode(true);
        } else {
            optBtn.setText("ADVANCE - WITH HISTORY");
            displayHistory.setText("");
            displayCalculation.setText("");
            myCalculator.clearDisplayOutputVal();
            myCalculator.setMode(false);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        myCalculator = new Calculator();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}