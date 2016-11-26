package android.hailoan.devpro.app_loichuc.Other;

import android.graphics.Color;
import android.hailoan.devpro.app_loichuc.R;
import android.hailoan.devpro.app_loichuc.SMS.ItemSMS;
import android.hailoan.devpro.app_loichuc.SMS.MultimediaSMSFragment;
import android.hailoan.devpro.app_loichuc.SMS.TextSMSFragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

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
    RelativeLayout nenitem;
    AdapterListView adapter_lisview;
    ArrayList<ArrayList<ItemSMS>> lsdatatext = new ArrayList<>();
    ArrayList<ArrayList<ItemSMS>> lsdatahinh = new ArrayList<>();
    private LinearLayout adview;
    private AdView adView;

    public void init() {
        main_left = (LinearLayout) findViewById(R.id.main_left);
        fr_layout = (FrameLayout) findViewById(R.id.fr_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        values = (int) getIntent().getExtras().getSerializable("K");
        nenitem = (RelativeLayout) findViewById(R.id.nenitem);
        adview = (LinearLayout) findViewById(R.id.adview);
        lsdatatext.add((ArrayList<ItemSMS>) getIntent().getExtras().getSerializable("NMtext"));
        lsdatatext.add((ArrayList<ItemSMS>) getIntent().getExtras().getSerializable("GStext"));
        lsdatatext.add((ArrayList<ItemSMS>) getIntent().getExtras().getSerializable("TYtext"));
        lsdatatext.add((ArrayList<ItemSMS>) getIntent().getExtras().getSerializable("SNtext"));
        lsdatatext.add((ArrayList<ItemSMS>) getIntent().getExtras().getSerializable("PNtext"));
        lsdatahinh.add((ArrayList<ItemSMS>) getIntent().getExtras().getSerializable("NMhinh"));
        lsdatahinh.add((ArrayList<ItemSMS>) getIntent().getExtras().getSerializable("GShinh"));
        lsdatahinh.add((ArrayList<ItemSMS>) getIntent().getExtras().getSerializable("TYhinh"));
        lsdatahinh.add((ArrayList<ItemSMS>) getIntent().getExtras().getSerializable("SNhinh"));
        lsdatahinh.add((ArrayList<ItemSMS>) getIntent().getExtras().getSerializable("PNhinh"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_);
        init();
        loadAD();
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        toolbar.setTitle("SMS");
        toolbar.setTitleTextColor(Color.WHITE);
        createDrawer();
        createViewPager();

    }

    public void loadAD() {
        adView = new AdView(this, "1711725415813231_1713085545677218", AdSize.BANNER_HEIGHT_50);
        adview.addView(adView);
        adView.loadAd();
    }

    @Override
    protected void onDestroy() {
        adView.destroy();
        super.onDestroy();
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
        adapter_lisview = new AdapterListView(getdata(), getLayoutInflater(), values - 1);
        ls_view.setAdapter(adapter_lisview);

    }

    private AdapterView.OnItemClickListener on_item_click = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            updatetoolbar(position);
            values = position + 1;
            ((TextSMSFragment) ls.get(0)).update(values);
            ((MultimediaSMSFragment) ls.get(1)).update(values);
            drawerLayout.closeDrawer(main_left);
            adapter_lisview.setVtitem(position);
            adapter_lisview.notifyDataSetChanged();

        }
    };

    ArrayList<Fragment> ls = new ArrayList<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ykien: {
                Toast.makeText(this, "y kien", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.danhgia: {
                Toast.makeText(this, "danh gia", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        if (drawerToggle.onOptionsItemSelected(item)) return true;
        return super.onOptionsItemSelected(item);
    }

    public void createViewPager() {
        pager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        FragmentManager manager = getSupportFragmentManager();
        PaperViewAdapter adapter = new PaperViewAdapter(manager, values, lsdatatext, lsdatahinh);
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
                fr_layout.setBackgroundResource(R.drawable.backgroundvalentine);
                break;
            }
            case 1: {
                toolbar.setTitle("Giáng Sinh");
                fr_layout.setBackgroundResource(R.drawable.backgroundnoel);
                break;
            }
            case 2: {
                toolbar.setTitle("Năm mới");
                fr_layout.setBackgroundResource(R.drawable.backgroundtet);
                break;
            }
            case 3: {
                toolbar.setTitle("Sinh Nhật");
                fr_layout.setBackgroundResource(R.drawable.backgroundsinhnhat);
                break;
            }
            case 4: {
                toolbar.setTitle("Phụ Nữ");
                fr_layout.setBackgroundResource(R.drawable.backgroundphunu);
                break;
            }
        }
    }

}
