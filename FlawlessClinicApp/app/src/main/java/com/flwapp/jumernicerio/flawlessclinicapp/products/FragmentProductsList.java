package com.flwapp.jumernicerio.flawlessclinicapp.products;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.flwapp.jumernicerio.flawlessclinicapp.R;

/**
 * Created by Jumer Nicerio on 3/3/2016.
 */
public class FragmentProductsList extends Fragment implements AdapterView.OnItemClickListener{
    ListView list;
    Communicator communicator;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products_list, container, false);
        list= (ListView) view.findViewById(R.id.listView);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(),R.array.array_list_products_title,android.R.layout.simple_list_item_activated_1);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        return view;
    }

    public void setCommunicator(Communicator communicator){

        this.communicator=communicator;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

        communicator.respond(i);

    }

    public interface Communicator
    {
        void respond(int index);
    }
}
