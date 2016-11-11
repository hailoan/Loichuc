package android.hailoan.devpro.app_loichuc.Other;

import android.graphics.Color;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.ItemListView;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.ItemListViewFragment;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.MultimediaFragment;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.Pager_adapter;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.TextSMSFragment;
import android.hailoan.devpro.app_loichuc.R;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2_ extends AppCompatActivity {
    private int values;
    private ListView ls_view;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    ViewPager pager;
    TabLayout tabLayout;
    LinearLayout main_left;
    Toolbar toolbar;
    FrameLayout fr_layout;
    ArrayList<ArrayList<ItemListViewFragment>> lsdatatext = new ArrayList<>();
    ArrayList<ArrayList<ItemListViewFragment>> lsdatahinh = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_);
        main_left = (LinearLayout) findViewById(R.id.main_left);
        fr_layout = (FrameLayout) findViewById(R.id.fr_layout);
        values = (int) getIntent().getExtras().getSerializable("K");
        lsdatatext.add((ArrayList<ItemListViewFragment>) getIntent().getExtras().getSerializable("NMtext"));
        lsdatatext.add((ArrayList<ItemListViewFragment>) getIntent().getExtras().getSerializable("GStext"));
        lsdatatext.add((ArrayList<ItemListViewFragment>) getIntent().getExtras().getSerializable("TYtext"));
        lsdatatext.add((ArrayList<ItemListViewFragment>) getIntent().getExtras().getSerializable("SNtext"));
        lsdatatext.add((ArrayList<ItemListViewFragment>) getIntent().getExtras().getSerializable("PNtext"));
        lsdatahinh.add((ArrayList<ItemListViewFragment>) getIntent().getExtras().getSerializable("NMhinh"));
        lsdatahinh.add((ArrayList<ItemListViewFragment>) getIntent().getExtras().getSerializable("GShinh"));
        lsdatahinh.add((ArrayList<ItemListViewFragment>) getIntent().getExtras().getSerializable("TYhinh"));
        lsdatahinh.add((ArrayList<ItemListViewFragment>) getIntent().getExtras().getSerializable("SNhinh"));
        lsdatahinh.add((ArrayList<ItemListViewFragment>) getIntent().getExtras().getSerializable("PNhinh"));
        Log.w("size 1", lsdatatext.size() + "");
        Log.w("size 2", lsdatahinh.size() + "");
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
        Pager_adapter adapter = new Pager_adapter(manager, values, lsdatatext, lsdatahinh);
        ls = adapter.getLsfrgment();
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setTabsFromPagerAdapter(adapter);
        updatetoolbar(values - 1);
    }


    public ArrayList<ItemListView> getdata() {
        ArrayList<ItemListView> lsdata = new ArrayList<ItemListView>();
        lsdata.add(new ItemListView(R.drawable.iconvalentine, "Lễ Tình yêu"));
        lsdata.add(new ItemListView(R.drawable.iconnoel, "Giáng sinh"));
        lsdata.add(new ItemListView(R.drawable.icontet, "Chúc mừng năm mới"));
        lsdata.add(new ItemListView(R.drawable.iconsinhnhat, "Sinh nhật"));
        lsdata.add(new ItemListView(R.drawable.iconphunu, "Phụ nữ"));
        return lsdata;
    }

    public void updatetoolbar(int k) {
        switch (k) {
            case 0: {
                toolbar.setTitle("Valentine's Day");
                fr_layout.setBackgroundResource(R.drawable.valentine);
                break;
            }
            case 1: {
                toolbar.setTitle("Giáng Sinh");
                fr_layout.setBackgroundResource(R.drawable.nennoel);
                break;
            }
            case 2: {
                toolbar.setTitle("Năm mới");
                fr_layout.setBackgroundResource(R.drawable.tet);
                break;
            }
            case 3: {
                toolbar.setTitle("Sinh Nhật");
                fr_layout.setBackgroundResource(R.drawable.sinhnhat);
                break;
            }
            case 4: {
                toolbar.setTitle("Phụ Nữ");
                fr_layout.setBackgroundResource(R.drawable.phunu);
                break;
            }
        }
    }

}
