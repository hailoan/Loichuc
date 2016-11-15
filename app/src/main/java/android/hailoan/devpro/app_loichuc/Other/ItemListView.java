package android.hailoan.devpro.app_loichuc.Other;

/**
 * Created by ThanhHang on 10/13/2016.
 */

public class ItemListView {
    private int img;
    private String ndung;

    public ItemListView(int img, String ndung) {
        this.img = img;
        this.ndung = ndung;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNdung() {
        return ndung;
    }

    public void setNdung(String ndung) {
        this.ndung = ndung;
    }
}
