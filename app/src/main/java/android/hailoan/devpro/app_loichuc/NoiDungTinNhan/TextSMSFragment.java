package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;


import android.hailoan.devpro.app_loichuc.Adapter_Lisview;
import android.hailoan.devpro.app_loichuc.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextSMSFragment extends Fragment {
    ListView listText;
    Adapter_Lisview adapter_text;


    public TextSMSFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_text_sm, container, false);
        listText = (ListView) view.findViewById(R.id.listText);
        adapter_text = new Adapter_Lisview(getdatannoel(),inflater);
        listText.setAdapter(adapter_text);

        return view;
    }

    public ArrayList<item_RC_LV> getdatannoel() {
        ArrayList<item_RC_LV> lsdata = new ArrayList<item_RC_LV>();

        lsdata.add(new item_RC_LV(1, "gian sinh vui ve"));
        lsdata.add(new item_RC_LV(1, "moi dieu an lan"));
        lsdata.add(new item_RC_LV(1, "Merry chrismast"));
        return lsdata;
    }

}
