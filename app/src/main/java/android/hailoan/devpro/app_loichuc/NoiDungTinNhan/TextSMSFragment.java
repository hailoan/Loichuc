package android.hailoan.devpro.app_loichuc.NoiDungTinNhan;


import android.hailoan.devpro.app_loichuc.Main2_;
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

public class TextSMSFragment extends Fragment implements UpdateFragment {
    ListView lsview;
    Adapter_fragment adapter_fragment;
    private ArrayList<ItemListNDsms> lsdata;
    private int k;

    public TextSMSFragment() {
        // Required empty public constructor

    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    private View view;
    private LayoutInflater in;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_text_sm, container, false);
        lsview = (ListView) view.findViewById(R.id.lsviewtxt);
        k = getArguments().getInt("K");
        in=inflater;
        adapter_fragment = new Adapter_fragment(getdata(k), inflater,k);
        lsview.setAdapter(adapter_fragment);
        return view;
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
        lsdata.add(new ItemListNDsms(2,"le tinh ye"));
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
    @Override
    public void update(int k) {
        if (adapter_fragment!=null){
            adapter_fragment=new Adapter_fragment(getdata(k),in,k);
            adapter_fragment.notifyDataSetChanged();
            lsview.setAdapter(adapter_fragment);
        }
    }
}
