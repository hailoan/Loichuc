package android.hailoan.devpro.app_loichuc;

import android.content.Intent;

import android.hailoan.devpro.app_loichuc.NoiDungTinNhan.ItemListNDsms;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Loan on 10/25/2016.
 */

public class Main_send extends AppCompatActivity implements View.OnClickListener {
    private TextView nd;
    String nd_;
    int vt;
    Button send, next_, preview_;
    private ArrayList<ItemListNDsms> lsdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        nd = (TextView) findViewById(R.id.txt_nd);
//        nd_ = getIntent().getStringExtra("ND");
        vt = getIntent().getIntExtra("VT", 1);
        lsdata = (ArrayList<ItemListNDsms>) getIntent().getSerializableExtra("listND");
        nd_ = lsdata.get(vt).getNoidung();
        nd.setText(lsdata.get(vt).getNoidung());
        send = (Button) findViewById(R.id.send_);
        next_ = (Button) findViewById(R.id.next);
        preview_ = (Button) findViewById(R.id.preview);
        next_.setOnClickListener(this);
        preview_.setOnClickListener(this);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_: {
                Uri uri = Uri.parse("smsto:" + "");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra("sms_body", nd_);
                startActivity(it);
                break;
            }
            case R.id.next: {
                if (vt == lsdata.size() - 1) {
                    vt = vt;
                } else {
                    vt = vt + 1;

                }
                nd_ = lsdata.get(vt).getNoidung();
                nd.setText(lsdata.get(vt).getNoidung());
                break;
            }
            case R.id.preview: {
                if (vt == 0) {
                    vt = vt;
                } else {
                    vt = vt - 1;
                }
                nd_ = lsdata.get(vt).getNoidung();
                nd.setText(lsdata.get(vt).getNoidung());
                break;
            }
        }


    }
}
