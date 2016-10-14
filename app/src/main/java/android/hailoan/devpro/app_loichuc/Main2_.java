package android.hailoan.devpro.app_loichuc;

import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.Pager_adapter;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.item_RC_LV;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2_ extends AppCompatActivity {
    private int values;
    private ListView ls_view;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    ViewPager pager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_);
        values = (int) getIntent().getExtras().getSerializable("K");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.list_view);
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
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            drawerLayout.closeDrawer(ls_view);
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) return true;
        return super.onOptionsItemSelected(item);
    }

    public void createViewPager() {
        pager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        FragmentManager manager = getSupportFragmentManager();
        Pager_adapter adapter = new Pager_adapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
    }




    public ArrayList<item_RC_LV> getdata() {
        ArrayList<item_RC_LV> lsdata = new ArrayList<item_RC_LV>();

        lsdata.add(new item_RC_LV(1, "Giáng sinh"));
        lsdata.add(new item_RC_LV(1, "lễ Tình yêu"));
        lsdata.add(new item_RC_LV(1, "mừng năm mới"));
        return lsdata;
    }

}
