package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;
import android.hailoan.devpro.app_loichuc.Other.UpdateFragment;
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
public class MultimediaFragment extends Fragment implements UpdateFragment {
    ListView listMulti;
    Adapter_fragment adapter_multi;
    private int k;
    FrameLayout framelayout;
    private LayoutInflater in;
    ArrayList<ArrayList<ItemListViewFragment>> lsdata;
    ArrayList<ItemListViewFragment> noelhinh, valentinehinh, sinhnhathinh, nammoihinh, phunuhinh;
    public MultimediaFragment(ArrayList<ArrayList<ItemListViewFragment>> lsdata) {
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
        adapter_multi = new Adapter_fragment(getdata(k), inflater, k);
        listMulti.setAdapter(adapter_multi);
        return view;
    }
    public ArrayList<ItemListViewFragment> getdata(int k) {
        ArrayList<ItemListViewFragment> lsdata = new ArrayList<ItemListViewFragment>();
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
            adapter_multi = new Adapter_fragment(getdata(k), in, k);
            adapter_multi.notifyDataSetChanged();
            listMulti.setAdapter(adapter_multi);
        }
    }

}

