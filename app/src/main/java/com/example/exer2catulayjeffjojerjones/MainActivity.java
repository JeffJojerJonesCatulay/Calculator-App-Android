package com.example.exer2catulayjeffjojerjones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.output);
        display.setShowSoftInputOnFocus(false);
        display.requestFocus();
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + 1);
    }

    public void zeroBtn(View view){
        updateText("0");
    }
    public void oneBtn(View view){
        updateText("1");
    }
    public void twoBtn(View view){
        updateText("2");
    }
    public void threeBtn(View view){
        updateText("3");
    }
    public void fourBtn(View view){
        updateText("4");
    }
    public void fiveBtn(View view){
        updateText("5");
    }
    public void sixBtn(View view){
        updateText("6");
    }
    public void sevenBtn(View view){
        updateText("7");
    }
    public void eightBtn(View view){
        updateText("8");
    }
    public void nineBtn(View view){
        updateText("9");
    }
    public void divBtn(View view){
        updateText("/");
    }
    public void mulBtn(View view){
        updateText("*");
    }
    public void subBtn(View view){
        updateText("-");
    }
    public void addBtn(View view){
        updateText("+");
    }
    public void dotBtn(View view){
        updateText(".");
    }
    public void modBtn(View view){
        updateText("%");
    }
    public void rightBtn(View view){
        updateText(")");
    }
    public void leftBtn(View view){
        updateText("(");
    }
    public void signBtn(View view){
        updateText("-");
    }
    public void clearBtn(View view){
        display.setText("");
    }
    public void cubeBtn(View view){
        updateText("^3");
        int cursorPos = display.getSelectionStart();
        display.setSelection(cursorPos + 1);
    }
    public void squareBtn(View view){
        updateText("^2");
        int cursorPos = display.getSelectionStart();
        display.setSelection(cursorPos + 1);
    }
    public void backspaceBtn(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if (cursorPos !=0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);

        }
    }

    public void equalsBtn(View view){
        String userExp = display.getText().toString();
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
}
