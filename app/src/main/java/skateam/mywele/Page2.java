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

public class Page2 extends Fragment implements MOve {
    // Dùng để tạo trang 2 Flashcard
    static TextView txt2;
    ArrayList<Flashcard> flashcards2;





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
            flashcards2 = (ArrayList<Flashcard>) bundle.getSerializable("ds");
            Flashcard fl = flashcards2.get(0);
            String e = fl.getMean();
            txt2.setText(e);
        }
    }
}
