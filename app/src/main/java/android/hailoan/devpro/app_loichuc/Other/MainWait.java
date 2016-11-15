package android.hailoan.devpro.app_loichuc.Other;

import android.content.Intent;
import android.hailoan.devpro.app_loichuc.R;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainWait extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wait);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main_ = new Intent(MainWait.this, MainActivity.class);
                MainWait.this.startActivity(main_);
                MainWait.this.finish();
            }
        }, 1000);

    }


}
