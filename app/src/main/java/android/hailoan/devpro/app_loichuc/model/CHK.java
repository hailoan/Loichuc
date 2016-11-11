package android.hailoan.devpro.app_loichuc.model;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Loan on 11/5/2016.
 */

public class CHK extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
