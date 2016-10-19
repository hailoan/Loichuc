package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ThanhHang on 10/13/2016.
 */

public class Pager_adapter extends FragmentStatePagerAdapter {
    private int k;

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public Pager_adapter(FragmentManager fm, int k) {
        super(fm);
        this.k = k;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        Bundle bundle=new Bundle();
        switch (position) {
            case 0:
                bundle.putInt("K",getK());
                frag = new TextSMSFragment();
                frag.setArguments(bundle);
                break;
            case 1:
                frag = new MultimediaFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Text ";
                break;
            case 1:
                title = "Multimedia";
                break;
        }
        return title;
    }
}
