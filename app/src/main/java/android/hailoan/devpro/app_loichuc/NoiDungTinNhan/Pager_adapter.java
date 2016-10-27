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
    ArrayList<Fragment> lsfrgment=new ArrayList<>();

    public ArrayList<Fragment> getLsfrgment() {
        return lsfrgment;
    }

    public Pager_adapter(FragmentManager fm, int k) {
        super(fm);
        this.k = k;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment a;
        Bundle bundle=new Bundle();
        bundle.putInt("K",k);
        switch (position) {
            case 0:

                a=new TextSMSFragment();
                a.setArguments(bundle);
                lsfrgment.add(a);
                return a;


            case 1:
                a=new MultimediaFragment();
                a.setArguments(bundle);
                lsfrgment.add(a);
                return a;

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

