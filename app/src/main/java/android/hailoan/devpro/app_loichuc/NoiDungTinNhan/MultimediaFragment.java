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
    public MultimediaFragment(int k) {
        // Required empty public constructor
    this.k=k;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multimedia, container, false);
        listMulti = (ListView) view.findViewById(R.id.listMulti);
        adapter_multi = new Adapter_fragment(getdatannoel(),inflater);
        listMulti.setAdapter(adapter_multi);

        // Inflate the layout for this fragment
        return view;
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
