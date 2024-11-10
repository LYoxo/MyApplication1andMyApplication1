package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input; // 输入框
    private TextView output; // 输出框
    private StringBuilder currentInput = new StringBuilder();
    private double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取输入框和输出框的引用
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        // 设置数字按钮的点击监听
        setNumberButtonListeners();

        // 设置操作符按钮的点击监听
        setOperatorButtonListeners();
    }

    // 数字按钮点击处理
    private void setNumberButtonListeners() {
        int[] numberButtons = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9};

        for (int id : numberButtons) {
            Button button = findViewById(id);
            button.setOnClickListener(v -> {
                currentInput.append(((Button) v).getText().toString());
                input.setText(currentInput.toString());
            });
        }
    }

    // 操作符按钮点击处理
    private void setOperatorButtonListeners() {
        int[] operatorButtons = {R.id.btn_add, R.id.btn_subtract, R.id.btn_multiply, R.id.btn_divide, R.id.btn_equal};

        for (int id : operatorButtons) {
            Button button = findViewById(id);
            button.setOnClickListener(v -> {
                if (button.getText().equals("=")) {
                    // 处理结果计算逻辑
                    calculateResult();
                } else {
                    // 处理其他操作符的逻辑
                    currentInput.append(" " + button.getText().toString() + " ");
                    input.setText(currentInput.toString());
                }
            });
        }
    }

    // 计算结果的方法
    private void calculateResult() {
        try {
            // 拆分输入的表达式，假设格式为 "数字 操作符 数字"
            String expression = currentInput.toString();
            String[] tokens = expression.split(" ");

            if (tokens.length == 3) {
                double num1 = Double.parseDouble(tokens[0]); // 第一个数字
                String operator = tokens[1]; // 操作符
                double num2 = Double.parseDouble(tokens[2]); // 第二个数字

                // 根据操作符进行相应的计算
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            output.setText("错误: 除零");
                            return;
                        }
                        break;
                    default:
                        output.setText("无效的操作符");
                        return;
                }

                // 显示计算结果
                output.setText(String.valueOf(result));
            } else {
                output.setText("无效的表达式");
            }
        } catch (Exception e) {
            output.setText("计算错误");
        }
    }
}
