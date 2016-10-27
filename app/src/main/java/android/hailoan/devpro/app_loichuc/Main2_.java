package android.hailoan.devpro.app_loichuc;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.MultimediaFragment;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.Pager_adapter;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.TextSMSFragment;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.item_listleft;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2_ extends AppCompatActivity {
    private int values;
    private ListView ls_view;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    ViewPager pager;
    TabLayout tabLayout;
    FragmentManager manager;
    Pager_adapter adapter;
    LinearLayout main_left;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_);
        main_left = (LinearLayout) findViewById(R.id.main_left);
        values = (int) getIntent().getExtras().getSerializable("K");
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        toolbar.setTitle("SMS");
        toolbar.setTitleTextColor(Color.WHITE);
        createDrawer();
        createViewPager();
    }

    public void createDrawer() {
        ls_view = (ListView) findViewById(R.id.ls_view);
        ls_view.setOnItemClickListener(on_item_click);
        drawerLayout = (DrawerLayout) findViewById(R.id.dr_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.mipmap.ic_launcher, R.string.dong, R.string.mo) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        Adapter_Lisview adapter_lisview = new Adapter_Lisview(getdata(), getLayoutInflater());
        ls_view.setAdapter(adapter_lisview);

    }

    private AdapterView.OnItemClickListener on_item_click = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            updatetoolbar(position);
            values = position + 1;
            ((TextSMSFragment) ls.get(0)).update(values);
            ((MultimediaFragment) ls.get(1)).update(values);
            drawerLayout.closeDrawer(main_left);
        }
    };

    ArrayList<Fragment> ls = new ArrayList<>();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) return true;
        return super.onOptionsItemSelected(item);
    }

    public void createViewPager() {
        pager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        FragmentManager manager = getSupportFragmentManager();
        Pager_adapter adapter = new Pager_adapter(manager, values);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabsFromPagerAdapter(adapter);
        ls = adapter.getLsfrgment();
        updatetoolbar(values - 1);
    }


    public ArrayList<item_listleft> getdata() {
        ArrayList<item_listleft> lsdata = new ArrayList<item_listleft>();
        lsdata.add(new item_listleft(R.drawable.icon_valentine, "Lễ Tình yêu"));
        lsdata.add(new item_listleft(R.drawable.icon_noel, "Giáng sinh"));

        lsdata.add(new item_listleft(R.drawable.icon_tet, "Chúc mừng năm mới"));
        lsdata.add(new item_listleft(R.drawable.icon_sn, "Sinh nhật"));
        lsdata.add(new item_listleft(R.drawable.icon_women, "Phụ nữ"));
        return lsdata;
    }

    public void updatetoolbar(int k) {
        switch (k) {
            case 0: {
                tabLayout.setBackgroundResource(R.drawable.slide_pink);
                toolbar.setTitle("Valentine's Day");
                toolbar.setBackgroundResource(R.drawable.slide_pink);
                break;
            }
            case 1: {
                toolbar.setTitle("Giáng Sinh");
                tabLayout.setBackgroundResource(R.drawable.slide_green);
                toolbar.setBackgroundResource(R.drawable.slide_green);
                break;
            }
            case 2: {
                toolbar.setTitle("Năm mới");
                tabLayout.setBackgroundResource(R.drawable.slide_red);
                toolbar.setBackgroundResource(R.drawable.slide_red);
                break;
            }
            case 3: {
                toolbar.setTitle("Sinh Nhật");
                tabLayout.setBackgroundResource(R.drawable.slide_cam);
                toolbar.setBackgroundResource(R.drawable.slide_cam);
                break;
            }
            case 4: {
                toolbar.setTitle("Phụ Nữ");
                tabLayout.setBackgroundResource(R.drawable.slide_tim);
                toolbar.setBackgroundResource(R.drawable.slide_tim);
                break;
            }
        }
    }
}
