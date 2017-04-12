package com.invento.somesh.invento2k17;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CulturalFragment extends ListFragment {

    public final static String MESSAGE_KEY ="androidbelieve.message_key";
    public String d = "null";

    ListView listView;
    Intent i;

    String[] events={"Show Bizz(movie Making)","cut Throat(Solo Singing)","Feel THe BEat(Dance)",
            "Rock the Range(Battle of Bands","vouge(The Fashion show)"};


    public CulturalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_cultural, container,false);




        ListAdapter adapter=new ArrayAdapter<String>(getActivity(), R.layout.row_layout,R.id.txtitem,events);
        setListAdapter(adapter);

        return  rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch(position) {
            case 0:
                d="Blog";
                Intent intent = new Intent(getActivity(), ShowBizz.class);
                intent.putExtra(MESSAGE_KEY,d);
                startActivity(intent);
                break;

            case 1:
                d="Event2";
                Intent intent2 = new Intent(getActivity(), ShowBizz.class);
                intent2.putExtra(MESSAGE_KEY,d);
                startActivity(intent2);
                break;

            case 2:
                d="Event3";
                Intent intent3 = new Intent(getActivity(), ShowBizz.class);
                intent3.putExtra(MESSAGE_KEY,d);
                startActivity(intent3);
                break;

            case 3:
                d="Event4";
                Intent intent4 = new Intent(getActivity(), ShowBizz.class);
                intent4.putExtra(MESSAGE_KEY,d);
                startActivity(intent4);
                break;

            case 4:
                d="Event5";
                Intent intent5 = new Intent(getActivity(), ShowBizz.class);
                intent5.putExtra(MESSAGE_KEY,d);
                startActivity(intent5);
                break;
        }
    }


}
