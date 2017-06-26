package skateam.mywele;

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

public class Page2 extends Fragment implements MainActivity.DataFromActivityToFragment,View.OnTouchListener{
    // Dùng để tạo trang 2 Flashcard
    static  TextView txt2;
    MainActivity.DataFromActivityToFragment dataFromActivityToFragment;
    ArrayList<Flashcard> flashcards;
    int id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_page2, container, false);
        txt2= (TextView) view.findViewById(R.id.txtPage2);
        txt2.setOnTouchListener(this);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void sendBundle(Bundle bundle) {
        if (bundle != null) {
            flashcards = (ArrayList<Flashcard>) bundle.getSerializable("ds");
            id = bundle.getInt("id");
            if(id < flashcards.size()){
                Flashcard flashcard = flashcards.get(id);
                String e = flashcard.getMean();
                txt2.setText(e);
            }else{
                txt2.setText("No String");
            }

        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            Toast.makeText(getActivity(),"Page2:" + id , Toast.LENGTH_LONG).show();
            Page1 page1 = new Page1();
            Bundle bundle=new Bundle();
            bundle.putSerializable("ds",flashcards);
            bundle.putInt("id", id +1);
            //dataFromActivityToFragment.sendBundle(bundle);
            page1.setArguments(bundle);
            android.app.FragmentManager fm = getFragmentManager();
            dataFromActivityToFragment= (MainActivity.DataFromActivityToFragment) page1;
            android.app.FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment1,page1);
            ft.commit();

            return true;
        }
        return false;
    }
    public interface DataFromActivityToFragment {
        void sendBundle(Bundle bundle);


}
}