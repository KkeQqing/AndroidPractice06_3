package com.example.androidpractice06_3.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidpractice06_3.NextActivity;
import com.example.androidpractice06_3.R;

public class LifecycleFragment extends Fragment {

    private View view;
    private Button btnNext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("demoinfo", "Fragment onAttach() 方法执行！");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("demoinfo", "Fragment onCreate() 方法执行！");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("demoinfo", "Fragment onCreateView() 方法执行！");

        if (savedInstanceState != null) {
            Log.d("demoinfo", "保存了的数据：" + savedInstanceState.getString("myinfo"));
        } else {
            Log.d("demoinfo", "没有保存的数据！");
        }

        view = inflater.inflate(R.layout.fragment_lifecycle, container, false);
        btnNext = view.findViewById(R.id.next_activity);
        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NextActivity.class);
            startActivity(intent);
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("demoinfo", "Fragment onActivityCreated() 方法执行！");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("demoinfo", "Fragment onStart() 方法执行！");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("demoinfo", "Fragment onResume() 方法执行！");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("demoinfo", "Fragment onPause() 方法执行！");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("demoinfo", "Fragment onStop() 方法执行！");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("demoinfo", "Fragment onSaveInstanceState() 方法执行！");
        outState.putString("myinfo", "haha");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("demoinfo", "Fragment onDestroyView() 方法执行！");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("demoinfo", "Fragment onDestroy() 方法执行！");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("demoinfo", "Fragment onDetach() 方法执行！");
    }
}