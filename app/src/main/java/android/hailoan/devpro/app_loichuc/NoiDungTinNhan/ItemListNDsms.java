package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;

import java.io.Serializable;

/**
 * Created by Loan on 10/27/2016.
 */

public class ItemListNDsms implements Serializable{
    private int id;
    private String noidung;

    public ItemListNDsms() {
    }

    public ItemListNDsms(int id,String noidung) {
        this.noidung = noidung;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
