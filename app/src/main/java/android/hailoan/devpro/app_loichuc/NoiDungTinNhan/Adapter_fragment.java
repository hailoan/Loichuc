package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;

import android.content.Intent;
import android.hailoan.devpro.app_loichuc.R;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Loan on 10/18/2016.
 */

public class Adapter_fragment extends BaseAdapter {
    private ArrayList<String> lsdata;
    private LayoutInflater inflater;

    public ArrayList<String> getLsdata() {
        return lsdata;
    }

    public void setLsdata(ArrayList<String> lsdata) {
        this.lsdata = lsdata;
    }

    public Adapter_fragment(ArrayList<String> lsdata, LayoutInflater inflater) {
        this.lsdata = lsdata;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return lsdata.size();
    }

    @Override
    public String getItem(int i) {
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
            view = inflater.inflate(R.layout.item_rc_view, null);
        }
        String nd=getItem(i);
        txt_nd = (TextView) view.findViewById(R.id.txt_rc);
        txt_nd.setText(nd);
        txt_nd.setOnClickListener(on_click);
        txt_nd.setTag(nd);
        return view;
    }
    private View.OnClickListener on_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String nd= (String) view.getTag();
            Uri uri=Uri.parse("smsto:"+"");
            Intent it=new Intent(Intent.ACTION_SENDTO,uri);
            it.putExtra("sms_body",nd);
            view.getContext().startActivity(it);

        }
    };

}
