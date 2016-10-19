package android.hailoan.devpro.app_loichuc;

import android.content.Intent;
import android.graphics.Color;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.Pager_adapter;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.TextSMSFragment;
import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.item_listleft;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import android.support.v7.widget.Toolbar;
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
    private ViewPager pager;
    private TabLayout tabLayout;
    private FragmentManager manager;
    private int vt = 1;
    private Pager_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_);
        values = (int) getIntent().getExtras().getSerializable("K");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        toolbar.setTitle("");
        toolbar.setTitleTextColor(Color.RED);
        createViewPager();
        createDrawer();

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
            values=i+1;
            adapter=new Pager_adapter(manager,values);
            adapter.notifyDataSetChanged();
            pager.invalidate();
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
        manager = getSupportFragmentManager();
        adapter = new Pager_adapter(manager, values);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    public ArrayList<item_listleft> getdata() {
        ArrayList<item_listleft> lsdata = new ArrayList<item_listleft>();
        lsdata.add(new item_listleft(R.mipmap.ic_launcher, "Lễ Tình yêu"));
        lsdata.add(new item_listleft(R.mipmap.ic_launcher, "Giáng sinh"));
        lsdata.add(new item_listleft(R.mipmap.ic_launcher, "Chúc mừng năm mới"));
        lsdata.add(new item_listleft(R.mipmap.ic_launcher, "Sinh nhật"));
        lsdata.add(new item_listleft(R.mipmap.ic_launcher, "Phụ nữ"));
        return lsdata;
    }

}
