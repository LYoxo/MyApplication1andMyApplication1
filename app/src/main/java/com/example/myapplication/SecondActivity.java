package com.example.myapplication;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Switch;


public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // 设置布局

        // 引用 XML 中的视图
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView4 = findViewById(R.id.imageView4);
        ImageView imageView5 = findViewById(R.id.imageView5);
        ImageView imageView6 = findViewById(R.id.imageView6);
        ImageView imageView = findViewById(R.id.imageView);

        TextView textView = findViewById(R.id.textView);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);

        Switch switch1 = findViewById(R.id.switch1);

        // 设置文本或样式（如果需要）
        textView.setText("DCA");
        textView3.setText("MARS");
        textView4.setText("DEPART");
        textView5.setText("1 Traveller");


        // 设置其他视图属性（如开关的初始状态）
        switch1.setChecked(false); // 设置开关状态
    }
}
