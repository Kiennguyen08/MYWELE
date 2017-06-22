package skateam.mywele;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
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

public class Page1 extends Fragment{
    // Dùng Để Tạo trang 1 của Flashcard
    TextView txt1;




    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {




        View view= inflater.inflate(R.layout.activity_page1, container, false);
        txt1= (TextView) view.findViewById(R.id.txtPage1);
        Bundle bundle=getArguments();
        ArrayList<Flashcard> dsflashcards= (ArrayList<Flashcard>) bundle.getSerializable("flashcard");

        Flashcard flashcard=dsflashcards.get(1);

        txt1.setText(flashcard.getFront());
















      return view;






    }


}

