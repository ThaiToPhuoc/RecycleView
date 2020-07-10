package vn.edu.ntu.phuocthai.e2_simplewidget_recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import vn.edu.ntu.phuocthai.e2_simplewidget_recycleview.controller.Icontroller;
import vn.edu.ntu.phuocthai.e2_simplewidget_recycleview.controller.controller;

public class MainActivity extends AppCompatActivity {

    Icontroller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new controller();
        controller = (Icontroller) getApplication();
    }
}