package skateam.mywele;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import skateam.model.Flashcard;

public class Page2 extends Fragment implements MainActivity.DataFromActivityToFragment {
    // Dùng để tạo trang 2 Flashcard
    static TextView txt2;


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


    @Override
    public void sendBundle(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Flashcard> flashcards = (ArrayList<Flashcard>) bundle.getSerializable("ds");
            Flashcard flashcard = flashcards.get(1);
            String e = flashcard.getMean();
            txt2.setText(e);


        }
    }
}