package android.hailoan.devpro.app_loichuc.SMS;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hailoan.devpro.app_loichuc.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Loan on 10/25/2016.
 */

public class SendSMS extends AppCompatActivity implements View.OnClickListener {
    private TextView nd;
    String nd_;
    int vt;
    int check;
    LinearLayout nen_send;
    ImageView send, next_, preview_;
    private ArrayList<ItemSMS> lsdata;
    boolean checksms;
    Toolbar toolbar;
    LinearLayout ln;

    public void init() {
        nd = (TextView) findViewById(R.id.txt_nd);
        nen_send = (LinearLayout) findViewById(R.id.activity_main__sendsms_arclayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ln= (LinearLayout) findViewById(R.id.lnsms);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        init();
        setSupportActionBar(toolbar);
        toolbar.setTitle("SMS");
        toolbar.setNavigationIcon(R.drawable.undo);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(on_click);
        check = getIntent().getIntExtra("check", 1);
        checksms = getIntent().getBooleanExtra("checksms", true);
        setbackground(check);
        vt = getIntent().getIntExtra("VT", 0);
        lsdata = (ArrayList<ItemSMS>) getIntent().getSerializableExtra("listND");

        nd_ = lsdata.get(vt).getNoidung();
        nd.setText(lsdata.get(vt).getNoidung());

        send = (ImageView) findViewById(R.id.send_);
        next_ = (ImageView) findViewById(R.id.next);
        preview_ = (ImageView) findViewById(R.id.preview);

        next_.setOnClickListener(this);
        preview_.setOnClickListener(this);
        send.setOnClickListener(this);

        if (checksms == true) {
            Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Youngblood.ttf");
            ((TextView) (findViewById(R.id.txt_nd))).setTypeface(typeface);
        }
    }


    private View.OnClickListener on_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    public void setbackground(int k) {

        switch (k) {
            case 1: {
                ln.setBackgroundResource(R.drawable.framevalentine);
                nd.setTextColor(Color.parseColor("#ffffff"));
                break;
            }
            case 2: {
                ln.setBackgroundResource(R.drawable.framenoel);
                nd.setTextColor(Color.parseColor("#52adbe"));
                break;
            }
            case 3: {
                ln.setBackgroundResource(R.drawable.frametet);
                nd.setTextColor(Color.parseColor("#fc2626"));
                break;
            }
            case 4: {
                ln.setBackgroundResource(R.drawable.framesinhnhat);
                nd.setTextColor(Color.parseColor("#ffffff"));
                break;
            }
            case 5: {
                ln.setBackgroundResource(R.drawable.framewomenday);
                nd.setTextColor(Color.parseColor("#ffffff"));
                break;
            }
        }

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
