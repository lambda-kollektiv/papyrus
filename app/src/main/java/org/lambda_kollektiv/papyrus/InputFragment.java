package org.lambda_kollektiv.papyrus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by konny on 04.06.15.
 */
public class InputFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
       super.onActivityCreated(savedInstanceState);
        return inflater.inflate(R.layout.fragment_input,container,false);
    }

}
