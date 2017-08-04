package skateam.mywele;

import android.app.Activity;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import skateam.model.Flashcard;

public class Page2 extends Fragment  {
    // Dùng để tạo trang 2 Flashcard
    static TextView txt2;
    static  ArrayList<Flashcard> mData2;
    GetDataInterface sGetDataInterface2;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_page2, container, false);
        txt2 = (TextView) view.findViewById(R.id.txtPage2);
        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {sGetDataInterface2 = (GetDataInterface) activity;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + "must implement GetDataInterface Interface");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(sGetDataInterface2!=null){
            mData2 = sGetDataInterface2.getDataList();
        }
        Flashcard fc=mData2.get(0);
        String e=fc.getMean();
        txt2.setText(e);
    }



}
