package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.style.UpdateLayout;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ThanhHang on 10/13/2016.
 */

public class Pager_adapter extends FragmentStatePagerAdapter {
    private int k;
    private TextSMSFragment frag1;
    private MultimediaFragment frag2;

    public TextSMSFragment getFrag1() {
        return frag1;
    }

    public void setFrag1(TextSMSFragment frag1) {
        this.frag1 = frag1;
    }

    public MultimediaFragment getFrag2() {
        return frag2;
    }

    public void setFrag2(MultimediaFragment frag2) {
        this.frag2 = frag2;
    }

    public Pager_adapter(FragmentManager fm, int k) {
        super(fm);
        this.k = k;

    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle=new Bundle();
        switch (position) {
            case 0:
                frag1 = new TextSMSFragment();

                bundle.putInt("K",k);

                frag1.setArguments(bundle);
                return frag1;


            case 1:
                frag2 = new MultimediaFragment();
                bundle.putInt("K",k);
                frag2.setArguments(bundle);
                return frag2;

        }
        return null;
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

