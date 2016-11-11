package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;

import android.content.Intent;
import android.hailoan.devpro.app_loichuc.Other.Main_send;
import android.hailoan.devpro.app_loichuc.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Loan on 10/18/2016.
 */

public class Adapter_fragment extends BaseAdapter {
    private ArrayList<ItemListViewFragment> lsdata;
    private LayoutInflater inflater;
    private int check;

    public ArrayList<ItemListViewFragment> getLsdata() {
        return lsdata;
    }

    public void setLsdata(ArrayList<ItemListViewFragment> lsdata) {
        this.lsdata = lsdata;
    }

    public Adapter_fragment(ArrayList<ItemListViewFragment> lsdata, LayoutInflater inflater, int check) {
        this.lsdata = lsdata;
        this.inflater = inflater;
        this.check = check;
    }

    @Override
    public int getCount() {
        return lsdata.size();
    }

    @Override
    public ItemListViewFragment getItem(int i) {
        return lsdata.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private TextView txt_nd;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.item_sms, null);
        }

        ItemListViewFragment nd = getItem(i);
        txt_nd = (TextView) view.findViewById(R.id.txt_rc);
        txt_nd.setText(nd.getNoidung());
        switch (check) {
            case 1: {
                txt_nd.setBackgroundResource(R.drawable.button_border1);
                break;
            }
            case 2: {
                txt_nd.setBackgroundResource(R.drawable.button_border1);
                break;
            }
            case 3: {
                txt_nd.setBackgroundResource(R.drawable.button_border1);
                break;
            }
            case 4: {
                txt_nd.setBackgroundResource(R.drawable.button_border1);
                break;
            }
            case 5: {
                txt_nd.setBackgroundResource(R.drawable.button_border1);
                break;
            }
        }
        txt_nd.setOnClickListener(on_click);
        txt_nd.setTag(i);
        return view;
    }

    private View.OnClickListener on_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent(view.getContext(), Main_send.class);
            int vt= (int) view.getTag();
            it.putExtra("VT",vt);
            it.putExtra("check",check);
            it.putExtra("listND",lsdata);
            view.getContext().startActivity(it);

        }
    };

}
