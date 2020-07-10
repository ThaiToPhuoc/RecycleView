package vn.edu.ntu.phuocthai.e2_simplewidget_recycleview.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.phuocthai.e2_simplewidget_recycleview.model.info;

public class controller extends Application implements Icontroller {
    //Chú ý nhớ thêm Application
    // và thêm name:".controller.controller" bên manifest

    List<info> infoList;

    public controller() {
        infoList = new ArrayList<>(); //Nhớ khởi tạo Array list
    }

    @Override
    public List<info> GetAllInfo() {
        return infoList; //Nhớ trả về List mình vừa tạo
    }

    @Override
    public void add(info info) {
        infoList.add(info);
    }
}
