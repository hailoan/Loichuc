package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;


import android.hailoan.devpro.app_loichuc.Adapter_Lisview;
import android.hailoan.devpro.app_loichuc.R;
import android.hailoan.devpro.app_loichuc.UpdateFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultimediaFragment extends Fragment implements UpdateFragment {
    ListView listMulti;
    Adapter_fragment adapter_multi;
    private int k;

    private ArrayList<ItemListNDsms> lsdata;

    public MultimediaFragment() {
        // Required empty public constructor

    }

    private LayoutInflater in;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multimedia, container, false);
        listMulti = (ListView) view.findViewById(R.id.listMulti);

        k = getArguments().getInt("K");
        in = inflater;

        adapter_multi = new Adapter_fragment(getdata(k), inflater, k);
        listMulti.setAdapter(adapter_multi);

        // Inflate the layout for this fragment
        return view;
    }

    public ArrayList<ItemListNDsms> getdata(int k) {
        ArrayList<ItemListNDsms> lsdata = new ArrayList<ItemListNDsms>();
        switch (k) {
            case 1: {
                lsdata = getdatavalentine();
                break;
            }
            case 2: {
                lsdata = getdatannoel();
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
        return lsdata;
    }

    public ArrayList<ItemListNDsms> getdatavalentine() {
        ArrayList<ItemListNDsms> lsdata = new ArrayList<ItemListNDsms>();

        lsdata.add(new ItemListNDsms(1,"{@}\n" +
                "*{@} {@} {@}*\n" +
                ":* {@} * {@} * ;*\n" +
                "' @}* {@} *{@}'\n" +
                "* ; {@} * ;\n" +
                "\\ \\ \\ | / / /\n" +
                "\\ \\ Y / /\n" +
                "\\ | /\n" +
                "/()\\\n" +
                "☆♥14-2♥☆\n" +
                "chuc e valentine vui ve,\n" +
                "hah phuc naz!\n" +
                "»(¯°•.†l0v3U!.•°¯)« \n" +
                "»™ Forever ™«"));
        return lsdata;
    }

    public ArrayList<ItemListNDsms> getdatanewyear() {
        ArrayList<ItemListNDsms> lsdata = new ArrayList<ItemListNDsms>();
        lsdata.add(new ItemListNDsms(1,"chuc mung nam moi"));
        return lsdata;
    }

    public ArrayList<ItemListNDsms> getdatabirthday() {
        ArrayList<ItemListNDsms> lsdata = new ArrayList<ItemListNDsms>();
        lsdata.add(new ItemListNDsms(1,"chuc mung sinh nhat"));
        return lsdata;
    }

    public ArrayList<ItemListNDsms> getdatawomen() {
        ArrayList<ItemListNDsms> lsdata = new ArrayList<ItemListNDsms>();
        lsdata.add(new ItemListNDsms(1,"chuc mung phu nu"));
        return lsdata;
    }

    public ArrayList<ItemListNDsms> getdatannoel() {
        ArrayList<ItemListNDsms> lsdata = new ArrayList<ItemListNDsms>();
        lsdata.add(new ItemListNDsms(1,"chuc mung giang sinh"));
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
