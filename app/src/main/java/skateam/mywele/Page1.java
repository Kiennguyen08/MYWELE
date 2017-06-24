package skateam.mywele;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import skateam.model.Flashcard;

import static android.content.Context.MODE_PRIVATE;

public class Page1 extends Fragment implements MainActivity.DataFromActivityToFragment{
    // Dùng Để Tạo trang 1 của Flashcard
    static  TextView txt1;







    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.activity_page1, container, false);
        txt1= (TextView) view.findViewById(R.id.txtPage1);





        return view;







    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }




    @Override
    public void sendBundle(Bundle bundle) {
        if(bundle!=null){
            ArrayList<Flashcard> flashcards= (ArrayList<Flashcard>) bundle.getSerializable("ds");
            Flashcard flashcard=flashcards.get(1);
            String e=flashcard.getMain();
            txt1.setText(e);





    }
    }
}

