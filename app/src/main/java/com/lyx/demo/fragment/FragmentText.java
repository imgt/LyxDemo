package com.lyx.demo.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyx.demo.R;

/**
 * Created by lqj on 2020/8/14.
 */
public class FragmentText  extends Fragment {
    private View view;

    private static FragmentText instance=null;
    public static FragmentText newInstance() {
        if(instance==null){
            instance= new FragmentText();
        }
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_texts,container, false);

        return view;
    }
}
