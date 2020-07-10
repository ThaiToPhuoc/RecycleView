package vn.edu.ntu.phuocthai.e2_simplewidget_recycleview.controller;

import java.util.List;

import vn.edu.ntu.phuocthai.e2_simplewidget_recycleview.model.info;

public interface Icontroller {
    public List<info> GetAllInfo();
    public void add(info info);
}
