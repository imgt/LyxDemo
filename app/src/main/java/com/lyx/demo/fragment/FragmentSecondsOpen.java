package com.lyx.demo.fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lyx.demo.R;
import com.lyx.demo.adapter.MyRecyclerViewAdapter;
import com.lyx.demo.view.LoadMoreRecyclerView;


public class FragmentSecondsOpen extends Fragment {

    private static FragmentSecondsOpen instance=null;
    public static FragmentSecondsOpen newInstance() {
        if(instance==null){
            instance= new FragmentSecondsOpen();
        }
        return instance;
    }
    public FragmentSecondsOpen(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        LoadMoreRecyclerView mRecyclerView = (LoadMoreRecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        int[]mImgList = new int[]{R.drawable.g1,R.drawable.g2,R.drawable.g3,R.drawable.g4,R.drawable.g5,R.drawable.g6,R.drawable.g7,R.drawable.g8,R.drawable.g9,R.drawable.g10};
        String [] mTag = getActivity().getResources().getStringArray(R.array.test);
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(getActivity(), mImgList,mTag));
        return view;
    }


}
