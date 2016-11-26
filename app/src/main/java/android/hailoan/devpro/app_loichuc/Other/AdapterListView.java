package android.hailoan.devpro.app_loichuc.Other;

import android.graphics.Color;
import android.hailoan.devpro.app_loichuc.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Loan on 9/30/2016.
 */
public class AdapterListView extends BaseAdapter {
    private ArrayList<ItemListView> lsdata;
    private LayoutInflater inflater;
    private int vtitem;

    public AdapterListView(ArrayList<ItemListView> lsdata, LayoutInflater inflater, int vtitem) {
        this.lsdata = lsdata;
        this.inflater = inflater;
        this.vtitem = vtitem;
    }

    public void setVtitem(int vtitem) {
        this.vtitem = vtitem;
    }

    @Override
    public int getCount() {
        return lsdata.size();
    }

    @Override
    public ItemListView getItem(int i) {
        return lsdata.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private TextView txt_nd;
    private ImageView img_ls;
    private RelativeLayout renen;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.item_ls_view, null);
        }

        txt_nd = (TextView) view.findViewById(R.id.txt_ls);
        img_ls = (ImageView) view.findViewById(R.id.img_ls);
        renen = (RelativeLayout) view.findViewById(R.id.nenitem);
        if (i == vtitem) {
            renen.setBackgroundColor(Color.parseColor("#c83ae2ed"));
        }
        else {
            renen.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        ItemListView s = getItem(i);
        txt_nd.setText(s.getNdung());
        txt_nd.setTag(i);
        img_ls.setImageResource(s.getImg());
        return view;
    }


}
