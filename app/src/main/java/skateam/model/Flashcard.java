package skateam.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kien Nguyen on 6/22/2017.
 */

public   class  Flashcard implements Parcelable {
     String main;
     String id;
     String mean;

    public Flashcard(Parcel in) {
        super();
        readFromParcel(in);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(main);
        dest.writeString(id);
        dest.writeString(mean);


    }
    public static Parcelable.Creator<Flashcard> CREATOR=new Parcelable.Creator<Flashcard>() {
        @Override
        public Flashcard createFromParcel(Parcel source) {
            return new Flashcard(source);

        }

        @Override
        public Flashcard[] newArray(int size) {
            return new Flashcard[size];
        }
    };

    public void readFromParcel(Parcel in) {
        main = in.readString();
        id = in.readString();
        mean = in.readString();
    }

    public Flashcard(String main, String id, String mean) {
        this.main = main;
        this.id = id;
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

