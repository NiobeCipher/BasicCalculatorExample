package com.example.jettcalder.basiccalculatorexample;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //    constants
    private static final int PLUS = 0;
    private static final int MINUS = 1;
    private static final int MUL = 2;
    private static final int DIV = 3;
//    activity main components
    private TextInputLayout mNum1;
    private TextInputLayout mNum2;
    private Button mPlusBtn;
    private Button mMinusBtn;
    private Button mDivBtn;
    private Button mMulBtn;
    private Button mResetBtn;
    private TextView mResult;
//    variables
    private Float number1;
    private Float number2;
    private Float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        UI Binding
        mNum1 = (TextInputLayout) findViewById(R.id.primary_num1);
        mNum2 = (TextInputLayout) findViewById(R.id.primary_num2);
        mPlusBtn = (Button) findViewById(R.id.primary_plus_btn);
        mMinusBtn = (Button) findViewById(R.id.primary_minus_btn);
        mMulBtn = (Button) findViewById(R.id.primary_mul_btn);
        mDivBtn = (Button) findViewById(R.id.primary_div_btn);
        mResetBtn = (Button) findViewById(R.id.primary_reset_btn);
        mResult = (TextView) findViewById(R.id.primary_result_tv);

//        Actions
        mPlusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResult.setText(String.format("Result: %s", calculate(PLUS)));
            }
        });
        mMinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResult.setText(String.format("Result: %s", calculate(MINUS)));
            }
        });
        mMulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResult.setText(String.format("Result: %s", calculate(MUL)));
            }
        });
        mDivBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResult.setText(String.format("Result: %s", calculate(DIV)));
            }
        });
        mResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNum1.getEditText().setText("");
                mNum2.getEditText().setText("");
                mResult.setText("Result: ");
            }
        });

    }

    private Float calculate(int op_type) {
        number1 = Float.parseFloat(mNum1.getEditText().getText().toString());
        number2 = Float.parseFloat(mNum2.getEditText().getText().toString());
        switch (op_type){
            case 0: return number1 + number2;
            case 1: return number1 - number2;
            case 2: return number1 * number2;
            case 3: return number1 / number2;
            default: return Float.valueOf(0);
        }
    }
}
