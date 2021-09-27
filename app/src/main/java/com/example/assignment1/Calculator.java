package com.example.assignment1;

import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> values = new ArrayList<String>();
    private String displayOutput;
    private Boolean advancedMode;

    private void removeOperands(){
        values.remove(1);
        values.remove(1);
    }

    public Calculator(){
        displayOutput = "";
        advancedMode = false;
    }

    public void push(String value){
        values.add(value);
    }

    public int calculator(){
        int result;

        while (values.size() > 1) {
            String operator = values.get(1);

            switch (operator) {
                case "*":
                    values.set(0, Integer.toString(Integer.parseInt(values.get(0)) * Integer.parseInt(values.get(2))));
                    removeOperands();
                    break;
                case "+":
                    values.set(0, Integer.toString(Integer.parseInt(values.get(0)) + Integer.parseInt(values.get(2))));
                    removeOperands();
                    break;
                case "-":
                    values.set(0, Integer.toString(Integer.parseInt(values.get(0)) - Integer.parseInt(values.get(2))));
                    removeOperands();
                    break;
                case "/":
                    values.set(0, Integer.toString(Integer.parseInt(values.get(0)) / Integer.parseInt(values.get(2))));
                    removeOperands();
                    break;
                default:
                    break;
            }
        }
        result = Integer.parseInt(values.get(0));

        this.clearList();

        return result;
    }

    public void setMode(boolean result){
        advancedMode = result;
    }

    public void clearDisplayOutputVal(){
        displayOutput = "";
    }

    public String getDisplayOutput(){
        return this.displayOutput;
    }

    public void clearList(){
        values.clear();
    }



    public void checkInput(Button btn, TextView hisText){
        String operand = btn.getText().toString();

        switch (operand){
            case "C":
                this.clearDisplayOutputVal();
                clearList();
                break;
            case "=":
                if(displayOutput.length() >= 3) {
                    int result = this.calculator();
                    displayOutput += " = " + Integer.toString(result);
                    if(advancedMode){
                        hisText.append(displayOutput + "\n");
                    }
                } else {
                    displayOutput = "Not enough operands!";
                    this.clearList();
                }
                break;
            default:
                displayOutput += " " + btn.getText().toString();
                this.push(btn.getText().toString());
        }

    }
}


