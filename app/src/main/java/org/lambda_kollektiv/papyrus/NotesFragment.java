package org.lambda_kollektiv.papyrus;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A fragment representing the latest notes list
 */
public class NotesFragment extends ListFragment {

    public void onActivityCreated(Bundle savedInstanceState) {
       super.onActivityCreated(savedInstanceState);
       String[] values = new String[] {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrott"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        System.out.println(position);
    }

}
