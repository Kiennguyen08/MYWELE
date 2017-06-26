package skateam.mywele;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import skateam.model.Flashcard;

import static android.content.Context.MODE_PRIVATE;

public class Page1 extends Fragment implements MainActivity.DataFromActivityToFragment, View.OnTouchListener{
    // Dùng Để Tạo trang 1 của Flashcard
    static  TextView txt1;
    MainActivity.DataFromActivityToFragment dataFromActivityToFragment;
    ArrayList<Flashcard> flashcards;
    int id;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_page1, container, false);
        txt1= (TextView) view.findViewById(R.id.txtPage1);
        txt1.setOnTouchListener(this);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void sendBundle(Bundle bundle) {
        if(bundle!=null){
            flashcards= (ArrayList<Flashcard>) bundle.getSerializable("ds");
            id = bundle.getInt("id");
            if(id < flashcards.size()){
                Flashcard flashcard = flashcards.get(id);
                String e = flashcard.getMain();
                txt1.setText(e);
            }else{
                txt1.setText("No String");
            }
    }

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            Toast.makeText(getActivity(),"Page1:" + id, Toast.LENGTH_LONG).show();
            Page2 page2 = new Page2();
            Bundle bundle=new Bundle();
            bundle.putSerializable("ds",flashcards);
            bundle.putInt("id", id +1);
           // dataFromActivityToFragment.sendBundle(bundle);
            page2.setArguments(bundle);
            android.app.FragmentManager fm = getFragmentManager();
            dataFromActivityToFragment= (MainActivity.DataFromActivityToFragment) page2;
            android.app.FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment1,page2);
            ft.commit();
            //dataFromActivityToFragment.sendBundle(bundle);
            return  true;
        }
        return false;
    }
    public interface DataFromActivityToFragment {
        void sendBundle(Bundle bundle);
    }
}

