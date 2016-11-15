package android.hailoan.devpro.app_loichuc.SMS;


import android.hailoan.devpro.app_loichuc.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */

public class TextSMSFragment extends Fragment implements UpdateFragment {
    ListView lsview;
    FrameLayout fm_layout;
    AdapterFragment adapter_fragment;
    private int k;
    ArrayList<ArrayList<ItemSMS>> lsdata;
    ArrayList<ItemSMS> noeltext, valentinetext, sinhnhattext, nammoitext, phunutext;
    public TextSMSFragment(ArrayList<ArrayList<ItemSMS>> lsdata) {
        this.lsdata=lsdata;
    }
    private View view;
    private LayoutInflater in;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_text_sm, container, false);
        lsview = (ListView) view.findViewById(R.id.lsviewtxt);
        fm_layout = (FrameLayout) view.findViewById(R.id.nen_fragment);
        nammoitext=lsdata.get(0);
        noeltext=lsdata.get(1);
        valentinetext=lsdata.get(2);
        sinhnhattext=lsdata.get(3);
        phunutext=lsdata.get(4);
        k = getArguments().getInt("K");
        in = inflater;
        adapter_fragment = new AdapterFragment(getdata(k), inflater,k,true);
        lsview.setAdapter(adapter_fragment);
        return view;
    }

    public ArrayList<ItemSMS> getdata(int k) {
        ArrayList<ItemSMS> lsdata = new ArrayList<ItemSMS>();
        switch (k) {
            case 1: {
                lsdata = valentinetext;
                break;
            }
            case 2: {
                lsdata = noeltext;
                break;
            }
            case 3: {
                lsdata = nammoitext;
                break;
            }
            case 4: {
                lsdata = sinhnhattext;
                break;
            }
            case 5: {
                lsdata = phunutext;
                break;
            }
        }
        return lsdata;
    }

    @Override
    public void update(int k) {
        if (adapter_fragment != null) {
            adapter_fragment = new AdapterFragment(getdata(k), in, k,true);
            adapter_fragment.notifyDataSetChanged();
            lsview.setAdapter(adapter_fragment);
        }
    }

}
