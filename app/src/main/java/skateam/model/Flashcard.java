package skateam.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kien Nguyen on 6/22/2017.
 */

public   class  Flashcard  {

     String id;
     String main;
     String mean;


    public Flashcard(String id, String main, String mean) {

        this.id = id;
        this.main = main;
        this.mean = mean;
    }

    public Flashcard() {
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}

