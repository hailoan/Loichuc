package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;


import android.content.Intent;
import android.hailoan.devpro.app_loichuc.Adapter_Lisview;
import android.hailoan.devpro.app_loichuc.R;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextSMSFragment extends Fragment {
    RecyclerView rcview;
    Adapter_RecyclerView adapter_text;


    public TextSMSFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_sm, container, false);
        rcview = (RecyclerView) view.findViewById(R.id.rcviewtText);
        adapter_text = new Adapter_RecyclerView(getdatannoel(),inflater);
        LinearLayoutManager manager = new LinearLayoutManager(inflater.getContext());
        rcview.setLayoutManager(manager);
        rcview.setHasFixedSize(true);
        rcview.setAdapter(adapter_text);
        return view;
    }



    public ArrayList<String> getdatannoel() {
        ArrayList<String> lsdata = new ArrayList<String>();

        lsdata.add("gian sinh vui ve");
        lsdata.add("moi dieu an lan");
        lsdata.add("Merry chrismast");
        return lsdata;
    }

}
