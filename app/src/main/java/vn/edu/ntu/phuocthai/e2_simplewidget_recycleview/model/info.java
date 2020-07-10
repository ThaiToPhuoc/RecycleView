package vn.edu.ntu.phuocthai.e2_simplewidget_recycleview.model;

public class info {
    String ngay;
    String menhgia;
    String phuongthuc;
    String muavao;
    String banra;

    public info() {
    }

    public info(String ngay, String menhgia, String phuongthuc, String muavao, String banra) {
        this.ngay = ngay;
        this.menhgia = menhgia;
        this.phuongthuc = phuongthuc;
        this.muavao = muavao;
        this.banra = banra;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getMenhgia() {
        return menhgia;
    }

    public void setMenhgia(String menhgia) {
        this.menhgia = menhgia;
    }

    public String getPhuongthuc() {
        return phuongthuc;
    }

    public void setPhuongthuc(String phuongthuc) {
        this.phuongthuc = phuongthuc;
    }

    public String getMuavao() {
        return muavao;
    }

    public void setMuavao(String muavao) {
        this.muavao = muavao;
    }

    public String getBanra() {
        return banra;
    }

    public void setBanra(String banra) {
        this.banra = banra;
    }
}
