package android.hailoan.devpro.app_loichuc.SMS;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hailoan.devpro.app_loichuc.R;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import java.util.ArrayList;


/**
 * Created by Loan on 10/25/2016.
 */

public class SendSMS extends AppCompatActivity implements View.OnClickListener {
    private TextView nd;
    String nd_;
    int vt, idnen, paddingtop, paddingleft, widthtxt, check;
    LinearLayout nen_send, send, sharefb, ln;
    ImageView next_, preview_;
    private ArrayList<ItemSMS> lsdata;
    boolean checksms;
    Toolbar toolbar;
    private CallbackManager callbackManager;
    Typeface typeface;
    ShareDialog shareDialog;

    public void init() {
        nd = (TextView) findViewById(R.id.txt_nd);
        nen_send = (LinearLayout) findViewById(R.id.activity_main__sendsms_arclayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ln = (LinearLayout) findViewById(R.id.lnsms);
        sharefb = (LinearLayout) findViewById(R.id.sharefb_);
        send = (LinearLayout) findViewById(R.id.send_);
        next_ = (ImageView) findViewById(R.id.next);
        preview_ = (ImageView) findViewById(R.id.preview);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        init();
        fomattoobar();
        check = getIntent().getIntExtra("check", 1);
        checksms = getIntent().getBooleanExtra("checksms", true);
        setbackground(check);
        vt = getIntent().getIntExtra("VT", 0);
        lsdata = (ArrayList<ItemSMS>) getIntent().getSerializableExtra("listND");
        nd_ = lsdata.get(vt).getNoidung();
        nd.setText(lsdata.get(vt).getNoidung());
        next_.setOnClickListener(this);
        preview_.setOnClickListener(this);
        send.setOnClickListener(this);
        sharefb.setOnClickListener(this);
        if (checksms == true) {
            typeface = Typeface.createFromAsset(getAssets(), "fonts/imromanslant_10_regular.otf");
            ((TextView) (findViewById(R.id.txt_nd))).setTypeface(typeface);
        }
    }

    public void fomattoobar() {
        setSupportActionBar(toolbar);
        toolbar.setTitle("SMS");
        toolbar.setNavigationIcon(R.drawable.left);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(on_click);
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
                ln.setBackgroundResource(R.drawable.nensmsvalentine);
                idnen = R.drawable.nensmsvalentine;
                nd.setTextColor(Color.parseColor("#ffffff"));
                paddingleft = 50;
                paddingtop = 200;
                widthtxt = 450;
                break;
            }
            case 2: {
                ln.setBackgroundResource(R.drawable.nensmsnoel);
                idnen = R.drawable.nensmsnoel;
                nd.setTextColor(Color.parseColor("#FF006D9B"));
                paddingleft = 50;
                paddingtop = 400;
                widthtxt = 650;
                break;
            }
            case 3: {
                ln.setBackgroundResource(R.drawable.frametet);
                idnen = R.drawable.frametet;
                nd.setTextColor(Color.parseColor("#fc2626"));
                paddingleft = 50;
                paddingtop = 350;
                widthtxt = 650;
                break;
            }
            case 4: {
                ln.setBackgroundResource(R.drawable.nensmssinhnhat);
                idnen = R.drawable.nensmssinhnhat;
                nd.setTextColor(Color.parseColor("#ffffff"));
                paddingleft = 50;
                paddingtop = 50;
                widthtxt = 550;
                break;
            }
            case 5: {
                widthtxt = 600;
                paddingleft = 200;
                paddingtop = 50;
                ln.setBackgroundResource(R.drawable.nensmsphunu);
                idnen = R.drawable.nensmsphunu;
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
            case R.id.sharefb_: {
                try {
                    //kiểm tra phiên bản SDK của máy với phiên bản android studio
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED
                                && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE}, 100);
                        }
                    }
                } catch (SecurityException e) {
                    Toast.makeText(this, "Show My Location Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
                FacebookSdk.sdkInitialize(getApplicationContext());
                callbackManager = CallbackManager.Factory.create();
                sharePhotoToFacebook(drawTextToBitmap(SendSMS.this, idnen, lsdata.get(vt).getNoidung()));
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
                break;
            }
        }


    }

    private void sharePhotoToFacebook(Bitmap image) {
        shareDialog = new ShareDialog(this);
        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(image)
                .setCaption("")
                .build();
        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();
        shareDialog.show(SendSMS.this, content);
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        super.onActivityResult(requestCode, responseCode, data);
        callbackManager.onActivityResult(requestCode, responseCode, data);
    }

    public Bitmap drawTextToBitmap(Context mContext, int resourceId, String mText) {
        try {
            Resources resources = mContext.getResources();
            Bitmap bitmap = BitmapFactory.decodeResource(resources, resourceId);
            android.graphics.Bitmap.Config bitmapConfig = bitmap.getConfig();
            bitmap = bitmap.copy(bitmapConfig, true);
            Canvas canvas = new Canvas(bitmap);
            Bitmap bitmaptext = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            TextPaint textPaint = new TextPaint();
            textPaint.setTypeface(typeface);
            textPaint.setTextSize(35);
            switch (check) {
                case 1: {
                    textPaint.setColor(Color.parseColor("#FFFFFF"));
                    break;
                }
                case 2: {
                    textPaint.setColor(Color.parseColor("#FF006D9B"));
                    break;
                }
                case 3: {
                    textPaint.setColor(Color.parseColor("#fc2626"));
                    break;
                }
                case 4: {
                    textPaint.setColor(Color.parseColor("#FFFFFF"));
                    break;
                }
                case 5: {
                    textPaint.setColor(Color.parseColor("#FFFFFF"));
                    break;
                }
            }

            textPaint.setAntiAlias(true);
            Canvas canvastxt = new Canvas(bitmaptext);
            StaticLayout staticLayout = new StaticLayout(mText, textPaint, widthtxt, Layout.Alignment.ALIGN_NORMAL, 1f, 10f, false);
            staticLayout.draw(canvastxt);
            canvas.drawBitmap(bitmaptext, paddingleft, paddingtop, textPaint);


            return bitmap;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }

}
