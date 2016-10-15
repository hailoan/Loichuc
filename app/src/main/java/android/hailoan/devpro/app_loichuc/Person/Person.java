package android.hailoan.devpro.app_loichuc.Person;

import java.util.Date;

/**
 * Created by HOAROM on 15/10/2016.
 */

public class Person {
    private String hoten;
    private String ngaysinh;
    private  String sodienthoai;
    private  boolean isCheck;

    public Person() {
    }

    public Person(String hoten, String ngaysinh, String sodienthoai) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.sodienthoai = sodienthoai;
        isCheck = false;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
