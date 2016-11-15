package android.hailoan.devpro.app_loichuc.Other;

import android.content.Intent;
import android.hailoan.devpro.app_loichuc.SMS.ItemSMS;
import android.hailoan.devpro.app_loichuc.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView noelhinhh;
    private TextView valentinehinhh;
    private TextView sinhnhathinhh;
    private TextView nammoihinhh;
    private TextView phunuhinhvnh;
    FirebaseDatabase database;
    ArrayList<ItemSMS> noelhinh, valentinehinh, sinhnhathinh, nammoihinh, phunuhinh;
    ArrayList<ItemSMS> noeltext, valentinetext, sinhnhattext, nammoitext, phunutext;

    public void kt() {
        noelhinh = new ArrayList<>();
        nammoihinh = new ArrayList<>();
        sinhnhathinh = new ArrayList<>();
        valentinehinh = new ArrayList<>();
        phunuhinh = new ArrayList<>();
        noeltext = new ArrayList<>();
        nammoitext = new ArrayList<>();
        sinhnhattext = new ArrayList<>();
        valentinetext = new ArrayList<>();
        phunutext = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        database = FirebaseDatabase.getInstance();
        kt();
        loaddata();
        init();

    }

    public void init() {
        noelhinhh = (TextView) findViewById(R.id.img_noel);
        valentinehinhh = (TextView) findViewById(R.id.img_valentine);
        sinhnhathinhh = (TextView) findViewById(R.id.img_sinhnhat);
        nammoihinhh = (TextView) findViewById(R.id.img_nammoi);
        phunuhinhvnh = (TextView) findViewById(R.id.img_phunuvn);
        noelhinhh.setOnClickListener(MainActivity.this);
        valentinehinhh.setOnClickListener(MainActivity.this);
        sinhnhathinhh.setOnClickListener(MainActivity.this);
        nammoihinhh.setOnClickListener(MainActivity.this);
        phunuhinhvnh.setOnClickListener(MainActivity.this);

    }

    public void loaddata() {
        loaddatanammoihinh();
        loaddatanammoitext();
        loaddatanoelhinh();
        loaddatanoeltext();
        loaddatavalentinehinh();
        loaddatavalentinetext();
        loaddatasinhnhathinh();
        loaddatasinhnhattext();
        loaddataphunutext();
        loaddataphunuhinh();

    }

    @Override
    public void onClick(View view) {
        final Intent m2 = new Intent(MainActivity.this, Main2_.class);
        m2.putExtra("NMtext", nammoitext);
        m2.putExtra("NMhinh", nammoihinh);
        m2.putExtra("GStext",noeltext);
        m2.putExtra("GShinh",noelhinh);
        m2.putExtra("TYtext",valentinetext);
        m2.putExtra("TYhinh",valentinehinh);
        m2.putExtra("SNtext",sinhnhattext);
        m2.putExtra("SNhinh",sinhnhathinh);
        m2.putExtra("PNtext",phunutext);
        m2.putExtra("PNhinh",phunuhinh);
        switch (view.getId()) {
            case R.id.img_valentine: {
                m2.putExtra("K", 1);
                break;
            }
            case R.id.img_noel: {
                m2.putExtra("K", 2);
                break;
            }
            case R.id.img_nammoi: {
                m2.putExtra("K", 3);
                break;
            }
            case R.id.img_sinhnhat: {
                m2.putExtra("K", 4);
                break;
            }
            case R.id.img_phunuvn: {
                m2.putExtra("K", 5);
                break;
            }
        }
        startActivityForResult(m2, 100);
    }

    public void loaddatanammoitext() {
        DatabaseReference ref = database.getReference("chucmungnammoi");
        ref.child("SMStext").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                nammoitext.add(new ItemSMS(Integer.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue().toString()));

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.w("size nammoi changed", nammoitext.size() + " " + dataSnapshot.getValue());
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void loaddatanammoihinh() {
        DatabaseReference ref = database.getReference("chucmungnammoi");
        ref.child("SMShinh").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                nammoihinh.add(new ItemSMS(Integer.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue().toString()));
                Log.w("size nam moi hinh", nammoihinh.size() + "");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }

    public void loaddatanoeltext() {
        DatabaseReference ref = database.getReference("chucmungnoel");
        ref.child("SMStext").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                noeltext.add(new ItemSMS(Integer.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue().toString()));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void loaddatanoelhinh() {
        DatabaseReference ref = database.getReference("chucmungnoel");
        ref.child("SMShinh").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                noelhinh.add(new ItemSMS(Integer.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue().toString()));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }

    public void loaddatavalentinetext() {
        DatabaseReference ref = database.getReference("chucmungvalentine");
        ref.child("SMStext").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                valentinetext.add(new ItemSMS(Integer.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue().toString()));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void loaddatavalentinehinh() {
        DatabaseReference ref = database.getReference("chucmungvalentine");
        ref.child("SMShinh").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                valentinehinh.add(new ItemSMS(Integer.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue().toString()));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }

    public void loaddatasinhnhattext() {
        DatabaseReference ref = database.getReference("chucmungsinhnhat");
        ref.child("SMStext").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                sinhnhattext.add(new ItemSMS(Integer.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue().toString()));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void loaddatasinhnhathinh() {
        DatabaseReference ref = database.getReference("chucmungsinhnhat");
        ref.child("SMShinh").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                sinhnhathinh.add(new ItemSMS(Integer.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue().toString()));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }

    public void loaddataphunutext() {
        DatabaseReference ref = database.getReference("chucmungphunu");
        ref.child("SMStext").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                phunutext.add(new ItemSMS(Integer.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue().toString()));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void loaddataphunuhinh() {
        DatabaseReference ref = database.getReference("chucmungphunu");
        ref.child("SMShinh").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                phunuhinh.add(new ItemSMS(Integer.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue().toString()));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }
}
