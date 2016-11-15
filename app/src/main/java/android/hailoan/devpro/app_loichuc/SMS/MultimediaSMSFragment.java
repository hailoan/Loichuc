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
public class MultimediaSMSFragment extends Fragment implements UpdateFragment {
    ListView listMulti;
    AdapterFragment adapter_multi;
    private int k;
    FrameLayout framelayout;
    private LayoutInflater in;
    ArrayList<ArrayList<ItemSMS>> lsdata;
    ArrayList<ItemSMS> noelhinh, valentinehinh, sinhnhathinh, nammoihinh, phunuhinh;
    public MultimediaSMSFragment(ArrayList<ArrayList<ItemSMS>> lsdata) {
        this.lsdata = lsdata;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multimedia, container, false);
        listMulti = (ListView) view.findViewById(R.id.listMulti);
        framelayout = (FrameLayout) view.findViewById(R.id.nen_fragment1);
        k = getArguments().getInt("K");
        nammoihinh = lsdata.get(0);
        noelhinh = lsdata.get(1);
        valentinehinh = lsdata.get(2);
        sinhnhathinh = lsdata.get(3);
        phunuhinh = lsdata.get(4);
        in = inflater;

        adapter_multi = new AdapterFragment(getdata(k), inflater, k,false);
        listMulti.setAdapter(adapter_multi);
        return view;
    }
    public ArrayList<ItemSMS> getdata(int k) {
        ArrayList<ItemSMS> lsdata = new ArrayList<ItemSMS>();
        switch (k) {
            case 1: {
                lsdata = valentinehinh;
                break;
            }
            case 2: {
                lsdata = noelhinh;
                break;
            }
            case 3: {
                lsdata = nammoihinh;
                break;
            }
            case 4: {
                lsdata = sinhnhathinh;
                break;
            }
            case 5: {
                lsdata = phunuhinh;
                break;
            }
        }
        return lsdata;
    }

    @Override
    public void update(int k) {
        if (adapter_multi != null) {
            adapter_multi = new AdapterFragment(getdata(k), in, k,false);
            adapter_multi.notifyDataSetChanged();
            listMulti.setAdapter(adapter_multi);
        }
    }

}

