package skateam.mywele;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import skateam.model.Flashcard;

public class MainActivity extends AppCompatActivity {
    String DATABASE_NAME="dbVoca2.sqlite";
    String DB_PATH_SUFFIX="/databases/";
    SQLiteDatabase database=null;




    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;



    static ArrayList<Flashcard> dsFlashCard;

    DataFromActivityToFragment dataFromActivityToFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar= (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.Close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        xuLySaoChepCSDLvaoHT();
        xuLyLayDuLieuDatabase();



    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }


    private void xuLySaoChepCSDLvaoHT() {
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists()) {
            try {
                CopyDataBaseFromAsset();
                Toast.makeText(this, "Copy success from asset", Toast.LENGTH_LONG).show();

            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();

            }
        }

    }

    private void CopyDataBaseFromAsset() {
        try{
            InputStream inputStream=getAssets().open(DATABASE_NAME);
            String outfileName= layDuongDanLuuTru();
            File f=new File(getApplicationInfo().dataDir+DB_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();
            }
            OutputStream outputStream=new FileOutputStream(outfileName);
            byte[] buffer=new byte[1024];
            int length;
            while((length=inputStream.read(buffer))>0)
            {
                outputStream.write(buffer,0,length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();


        }
        catch(Exception ex)
        {
            Log.e("Loi sao chep",ex.toString());

        }
    }

    private String layDuongDanLuuTru(){
        return getApplicationInfo().dataDir+DB_PATH_SUFFIX+DATABASE_NAME;

    }
    private void xuLyLayDuLieuDatabase() {
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        Cursor cursor = database.query("Voca", null, null, null, null, null, null);
        dsFlashCard=new ArrayList<>();
        dsFlashCard.clear();

        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String main = cursor.getString(1);
            String mean = cursor.getString(2);
            Flashcard flashcard=new Flashcard();
            flashcard.setId(id);
            flashcard.setMain(main);
            flashcard.setMean(mean);

            dsFlashCard.add(flashcard);

        }
        cursor.close();

        Page1 page1=new Page1();
        android.app.FragmentManager fm = getFragmentManager();
        dataFromActivityToFragment= (DataFromActivityToFragment) page1;
        android.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment1,page1);
        ft.commit();
        Bundle bundle=new Bundle();
        bundle.putSerializable("ds",dsFlashCard);
        bundle.putInt("id", 0);
        dataFromActivityToFragment.sendBundle(bundle);

    }

    public interface DataFromActivityToFragment {
        void sendBundle(Bundle bundle);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);


        switch (action){
            case(MotionEvent.ACTION_DOWN):
                android.app.Fragment fr;
                fr=new Page2();
                android.app.FragmentManager fm = getFragmentManager();
                android.app.FragmentTransaction ft = fm.beginTransaction();


                ft.replace(R.id.fragment1, fr);
                ft.commit();
                Log.d("OK","Action was DOWN");






            default:
                return super.onTouchEvent(event);

        }


    }

}
