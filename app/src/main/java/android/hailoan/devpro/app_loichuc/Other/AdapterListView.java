package android.hailoan.devpro.app_loichuc.Other;

import android.hailoan.devpro.app_loichuc.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Loan on 9/30/2016.
 */
public class AdapterListView extends BaseAdapter {
    private ArrayList<ItemListView> lsdata;
    private LayoutInflater inflater;

    public AdapterListView(ArrayList<ItemListView> lsdata, LayoutInflater inflater) {
        this.lsdata = lsdata;
        this.inflater = inflater;
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.item_ls_view, null);
        }
        txt_nd = (TextView) view.findViewById(R.id.txt_ls);
        img_ls= (ImageView) view.findViewById(R.id.img_ls);
        ItemListView s = getItem(i);
        txt_nd.setText(s.getNdung());
        txt_nd.setTag(i);
        img_ls.setImageResource(s.getImg());
        return view;
    }


}
