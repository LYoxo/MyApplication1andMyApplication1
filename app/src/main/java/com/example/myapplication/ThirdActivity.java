package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_third); // 确保这里的布局文件名与 XML 文件名相匹配

            // 获取 TextView 并设置文本
            TextView textView = findViewById(R.id.textView7);
            textView.setText("Hello, World!"); // 可根据需要修改文本
        }

}
