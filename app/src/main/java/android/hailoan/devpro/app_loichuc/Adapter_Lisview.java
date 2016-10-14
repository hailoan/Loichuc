package android.hailoan.devpro.app_loichuc;

import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.item_RC_LV;
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
    private ArrayList<item_RC_LV> lsdata;
    private LayoutInflater inflater;

    public Adapter_Lisview(ArrayList<item_RC_LV> lsdata, LayoutInflater inflater) {
        this.lsdata = lsdata;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return lsdata.size();
    }

    @Override
    public item_RC_LV getItem(int i) {
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
        item_RC_LV s = getItem(i);
        txt_nd.setText(s.getNdung());
        txt_nd.setTag(i);
        return view;
    }


}
