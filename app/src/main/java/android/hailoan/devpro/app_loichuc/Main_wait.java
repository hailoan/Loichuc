package android.hailoan.devpro.app_loichuc;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main_wait extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wait);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main_=new Intent(Main_wait.this,MainActivity.class);
                Main_wait.this.startActivity(main_);
                Main_wait.this.finish();
            }
        },1000);

    }
}
