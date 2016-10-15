package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;

import android.content.Context;
import android.content.Intent;
import android.hailoan.devpro.app_loichuc.R;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Loan on 9/30/2016.
 */
public class Adapter_RecyclerView extends RecyclerView.Adapter<Adapter_RecyclerView.RecyclewViewHolder> {
    private ArrayList<String> lsdata;
    private LayoutInflater inflater;
    private int idimg;
//cmgsyta
    public int getIdimg() {
        return idimg;
    }

    public void setIdimg(int idimg) {
        this.idimg = idimg;
    }

    public Adapter_RecyclerView(ArrayList<String> lsdata, LayoutInflater inflater) {
        this.lsdata = lsdata;
        this.inflater = inflater;
    }

    public ArrayList<String> getLsdata() {
        return lsdata;
    }

    public void setLsdata(ArrayList<String> lsdata) {
        this.lsdata = lsdata;
    }

    @Override
    public RecyclewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myview = inflater.inflate(R.layout.item_rc_view, null);
        return new RecyclewViewHolder(myview);
    }

    @Override
    public void onBindViewHolder(RecyclewViewHolder holder, int position) {
        holder.txt_nd_rc.setText(lsdata.get(position));
      holder.txt_nd_rc.setTag(lsdata.get(position));
        holder.txt_nd_rc.setOnClickListener(on_click);

    }

    private View.OnClickListener on_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String nd= (String) view.getTag();
            Uri uri=Uri.parse("smsto:"+"0293847");
            Intent it=new Intent(Intent.ACTION_SENDTO,uri);
            it.putExtra("sms_body",nd);
            view.getContext().startActivity(it);

        }
    };

    @Override
    public int getItemCount() {
        return lsdata.size();
    }

    class RecyclewViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_nd_rc;
        public RecyclewViewHolder(View itemView) {
            super(itemView);
            txt_nd_rc = (TextView) itemView.findViewById(R.id.txt_rc);

        }
    }
}
