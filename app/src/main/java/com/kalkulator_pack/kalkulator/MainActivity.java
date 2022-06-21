package com.kalkulator_pack.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalc;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalc = findViewById(R.id.previousCalcView);
        display = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false);
    }
    public void updateText(String str){
        String oldStr = display.getText().toString();

        int cursorPosition = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPosition);
        String rightStr = oldStr.substring(cursorPosition);

        display.setText(String.format("%s%s%s",leftStr, str, rightStr));
        display.setSelection(cursorPosition+str.length());
    }

    public void zeroBTNPush(View view){
        updateText(getResources().getString(R.string.zero));
    }
    public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.one));
    }
    public void twoBTNPush(View view){
        updateText(getResources().getString(R.string.two));
    }
    public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.three));
    }
    public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.four));
    }
    public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.five));
    }
    public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.six));
    }
    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.seven));
    }
    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eight));
    }
    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nine));
    }
    public void clearBTNPush(View view){
        display.setText("");
        previousCalc.setText("");
    }
    public void addBTNPush(View view){
        updateText(getResources().getString(R.string.add));
    }
    public void subeBTNPush(View view){
        updateText(getResources().getString(R.string.subtract));
    }
    public void multiBTNPush(View view){
        updateText(getResources().getString(R.string.multiply));
    }
    public void divideBTNPush(View view){
        updateText(getResources().getString(R.string.divide));
    }
    public void parStartBTNPush(View view){
        updateText(getResources().getString(R.string.parentheseStart));
    }
    public void parEndBTNPush(View view){
        updateText(getResources().getString(R.string.parentheseEnd));
    }
    public void pointEndBTNPush(View view){
        updateText(getResources().getString(R.string.point));
    }
    public void backspaceEndBTNPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void equalsEndBTNPush(View view){
        String userExp = display.getText().toString();

        previousCalc.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divide), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiply), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void trigSinBTNPush(View view){
        updateText("sin(");
    }

    public void trigCosBTNPush(View view){
        updateText("cos(");
    }
    public void trigTanBTNPush(View view){
        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){
        updateText("arcsin(");
    }

    public void trigArcCosBTNPush(View view){
        updateText("arccos(");
    }

    public void trigArcTanBTNPush(View view){
        updateText("arctan(");
    }

    public void naturalLogBTNPush(View view){
        updateText("ln(");
    }

    public void LogBTNPush(View view){
        updateText("log(");
    }

    public void squareRootBTNPush(View view){
        updateText("sqrt(");
    }

    public void absoluteValueBTNPush(View view){
        updateText("abs(");
    }

    public void piBTNPush(View view){
        updateText("pi");
    }

    public void eBTNPush(View view){
        updateText("e");
    }

    public void xSquaredBTNPush(View view){
        updateText("^(2)");
    }

    public void xPowerYBTNPush(View view){
        updateText("^(");
    }

    public void isPrimeFunBTNPush(View view){
        updateText("ispr(");
    }


}