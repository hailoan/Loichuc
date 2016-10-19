package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;


import android.content.Intent;
import android.hailoan.devpro.app_loichuc.Adapter_Lisview;
import android.hailoan.devpro.app_loichuc.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.style.UpdateLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextSMSFragment extends Fragment {
    ListView lsview;
    Adapter_fragment adapter_fragment;
    private ArrayList<String> lsdata;
    private int k;

    public TextSMSFragment(int k) {
        // Required empty public constructor
        this.k = k;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_sm, container, false);
        lsview = (ListView) view.findViewById(R.id.lsviewtxt);
        switch (k) {
            case 1: {
                lsdata = getdatannoel();
                break;
            }
            case 2: {
                lsdata = getdatavalentine();
                break;
            }
            case 3: {
                lsdata = getdatanewyear();
                break;
            }
            case 4: {
                lsdata = getdatabirthday();
                break;
            }
            case 5: {
                lsdata = getdatawomen();
                break;
            }
        }
        adapter_fragment = new Adapter_fragment(lsdata, inflater);
        adapter_fragment.notifyDataSetChanged();
        lsview.setAdapter(adapter_fragment);
        return view;
    }

    public ArrayList<String> getdatannoel() {
        ArrayList<String> lsdata = new ArrayList<String>();
        lsdata.add("chúc mừng năm mới");
        lsdata.add("Giáng sinh an lành");
        lsdata.add("Merry chrismast");
        return lsdata;
    }

    public ArrayList<String> getdatavalentine() {
        ArrayList<String> lsdata = new ArrayList<String>();
        lsdata.add("chúc mừng năm mới ty");
        lsdata.add("Giáng sinh an lành ty");
        lsdata.add("Merry chrismast ty");
        return lsdata;
    }

    public ArrayList<String> getdatanewyear() {
        ArrayList<String> lsdata = new ArrayList<String>();
        lsdata.add("chúc mừng năm mới new year");
        lsdata.add("Giáng sinh an lành new year");
        lsdata.add("Merry chrismast new yewar");
        return lsdata;
    }

    public ArrayList<String> getdatabirthday() {
        ArrayList<String> lsdata = new ArrayList<String>();
        lsdata.add("chúc mừng năm mới sinh nhat");
        lsdata.add("Giáng sinh an lành sinh nhat");
        lsdata.add("Merry chrismast sinh nhat");
        return lsdata;
    }

    public ArrayList<String> getdatawomen() {
        ArrayList<String> lsdata = new ArrayList<String>();
        lsdata.add("chúc mừng năm mới phụ nữ");
        lsdata.add("Giáng sinh an lành phụ nữ");
        lsdata.add("Merry chrismast phụ nữ");
        return lsdata;
    }
}
