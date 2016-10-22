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
public class MultimediaFragment extends Fragment {
    ListView listMulti;
    Adapter_fragment adapter_multi;
    private int k;

private ArrayList<String> lsdata;
    public MultimediaFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multimedia, container, false);
        listMulti = (ListView) view.findViewById(R.id.listMulti);
        k=getArguments().getInt("K");
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
        adapter_multi = new Adapter_fragment(lsdata, inflater);
        adapter_multi.notifyDataSetChanged();
        listMulti.setAdapter(adapter_multi);

        // Inflate the layout for this fragment
        return view;
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

    public ArrayList<String> getdatannoel() {
        ArrayList<String> lsdata = new ArrayList<String>();
        lsdata.add("{@}\n" +
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
                "»™ Forever ™«");
        lsdata.add(",*\"\"\"\"*, ,*\"\"\"\"*,\n" +
                "   (0 ' _ ' ) ( '_ ' * )\n" +
                "=(,,)=(,,)=(,,)=(,,)=!!!\n" +
                "*(¨`•.•´¨)(¨`•.•´¨)*\n" +
                "**`•.(¨`•.•´¨)..•´**\n" +
                "  ***`•.¸.•´*** \n" +
                "mai mai ben nhau!\n" +
                "»™ ¶_ove ß@ßY ™«\n" +
                "`'•.¸(`'•.¸*¤*¸.•'´)¸.•'´\n" +
                " Happy♥Valentine\n" +
                "`'•.¸(`'•.¸*¤*¸.•'´)¸.•'´");
        lsdata.add("Merry chrismast");
        return lsdata;
    }
}
