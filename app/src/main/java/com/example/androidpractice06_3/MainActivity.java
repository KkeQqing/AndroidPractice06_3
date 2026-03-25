package com.example.androidpractice06_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;

import android.os.Bundle;
import android.view.View;

import com.example.androidpractice06_3.Fragment.LifecycleFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 启用 Edge-to-Edge（可选，美观用）
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);

        // 设置系统栏内边距（避免被状态栏遮挡）
        View mainView = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
            // 👇 修正这里：类型改为 Insets
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            // 现在 systemBars.left, .top 等就可以正常使用了
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 动态加载 Fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_layout, new LifecycleFragment())
                .commit();
    }
}