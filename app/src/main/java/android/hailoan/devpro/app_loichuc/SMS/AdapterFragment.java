package android.hailoan.devpro.app_loichuc.SMS;

import android.content.Intent;
import android.graphics.Typeface;
import android.hailoan.devpro.app_loichuc.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Loan on 10/18/2016.
 */

public class AdapterFragment extends BaseAdapter {
    private ArrayList<ItemSMS> lsdata;
    private LayoutInflater inflater;
    private int check;
    private boolean checksms;

    public ArrayList<ItemSMS> getLsdata() {
        return lsdata;
    }

    public void setLsdata(ArrayList<ItemSMS> lsdata) {
        this.lsdata = lsdata;
    }

    public AdapterFragment(ArrayList<ItemSMS> lsdata, LayoutInflater inflater, int check, boolean checksms) {
        this.lsdata = lsdata;
        this.inflater = inflater;
        this.check = check;
        this.checksms = checksms;
    }

    @Override
    public int getCount() {
        return lsdata.size();
    }

    @Override
    public ItemSMS getItem(int i) {
        return lsdata.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private TextView txt_nd;
    private LinearLayout lnview;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.item_sms, null);
        }
        ItemSMS nd = getItem(i);
        lnview = (LinearLayout) view.findViewById(R.id.ln_txt);
        txt_nd = (TextView) view.findViewById(R.id.txt_rc);
        if (checksms == true) {
            Typeface typeface = Typeface.createFromAsset(inflater.getContext().getAssets(), "fonts/imromanslant_10_regular.otf");
            txt_nd.setTypeface(typeface);
        }
        txt_nd.setText(nd.getNoidung());
        lnview.setOnClickListener(on_click);
        lnview.setTag(i);
        return view;
    }

    private View.OnClickListener on_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent(view.getContext(), SendSMS.class);
            int vt = (int) view.getTag();
            it.putExtra("VT", vt);
            it.putExtra("check", check);
            it.putExtra("listND", lsdata);
            it.putExtra("checksms", checksms);
            view.getContext().startActivity(it);

        }
    };

}
