package android.hailoan.devpro.app_loichuc.Other;

import android.hailoan.devpro.app_loichuc.SMS.ItemSMS;
import android.hailoan.devpro.app_loichuc.SMS.MultimediaSMSFragment;
import android.hailoan.devpro.app_loichuc.SMS.TextSMSFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by ThanhHang on 10/13/2016.
 */

public class PaperViewAdapter extends FragmentStatePagerAdapter {
    private int k;
    ArrayList<ArrayList<ItemSMS>> lstext,lshinh;
    ArrayList<Fragment> lsfrgment=new ArrayList<>();

    public ArrayList<Fragment> getLsfrgment() {
        return lsfrgment;
    }

    public PaperViewAdapter(FragmentManager fm, int k, ArrayList<ArrayList<ItemSMS>> lstext,
                            ArrayList<ArrayList<ItemSMS>> lshinh) {
        super(fm);
        this.k = k;
        this.lstext=lstext;
        this.lshinh=lshinh;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment a;
        Bundle bundle=new Bundle();
        bundle.putInt("K",k);
        switch (position) {
            case 0:
                a=new TextSMSFragment(lstext);
                a.setArguments(bundle);
                lsfrgment.add(a);
                return a;


            case 1:
                a=new MultimediaSMSFragment(lshinh);
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

