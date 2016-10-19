package android.hailoan.devpro.app_loichuc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView noel;
    private ImageView valentine;
    private ImageView sinhnhat;
    private ImageView nammoi;
    private ImageView phunuvn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    public void init() {
        noel = (ImageView) findViewById(R.id.img_noel);
        noel.setOnClickListener(this);
        valentine = (ImageView) findViewById(R.id.img_valentine);
        valentine.setOnClickListener(this);
        sinhnhat = (ImageView) findViewById(R.id.img_sinhnhat);
        sinhnhat.setOnClickListener(this);
        nammoi = (ImageView) findViewById(R.id.img_nammoi);
        nammoi.setOnClickListener(this);
        phunuvn = (ImageView) findViewById(R.id.img_phunuvn);
        phunuvn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent m2=new Intent(MainActivity.this,Main2_.class);;
        switch (view.getId()) {
            case R.id.img_noel: {
                m2.putExtra("K",2);
                startActivityForResult(m2,100);
                break;
            }
            case R.id.img_valentine: {
                m2.putExtra("K",1);
                startActivityForResult(m2,100);
                break;
            }
            case R.id.img_nammoi: {
                m2.putExtra("K",3);
                startActivityForResult(m2,100);
                break;
            }
            case R.id.img_sinhnhat: {
                m2.putExtra("K",4);
                startActivityForResult(m2,100);
                break;
            }
            case R.id.img_phunuvn: {
                m2.putExtra("K",5);
                startActivityForResult(m2,100);
                break;
            }
        }
    }
}
