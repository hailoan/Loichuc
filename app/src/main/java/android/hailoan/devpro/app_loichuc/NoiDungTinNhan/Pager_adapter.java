package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ThanhHang on 10/13/2016.
 */

public class Pager_adapter extends FragmentStatePagerAdapter{
    public Pager_adapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new TextSMSFragment();
                break;
            case 1:
                frag=new MultimediaFragment();
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
        switch (position){
            case 0:
                title="Text ";
                break;
            case 1:
                title="Multimedia";
                break;
        }

        return title;
    }


}
