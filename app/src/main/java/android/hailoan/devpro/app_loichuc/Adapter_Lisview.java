package android.hailoan.devpro.app_loichuc;

import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.item_listleft;
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
public class Adapter_Lisview extends BaseAdapter {
    private ArrayList<item_listleft> lsdata;
    private LayoutInflater inflater;

    public Adapter_Lisview(ArrayList<item_listleft> lsdata, LayoutInflater inflater) {
        this.lsdata = lsdata;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return lsdata.size();
    }

    @Override
    public item_listleft getItem(int i) {
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
        item_listleft s = getItem(i);
        txt_nd.setText(s.getNdung());
        txt_nd.setTag(i);
        img_ls.setImageResource(s.getImg());
        return view;
    }


}
