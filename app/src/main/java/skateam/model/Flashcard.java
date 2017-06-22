package skateam.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kien Nguyen on 6/22/2017.
 */

public   class  Flashcard  {
    static String front;
    static String ma;
    static String back;

    public static String getFront() {
        return front;
    }

    public static void setFront(String front) {
        Flashcard.front = front;
    }

    public static String getMa() {
        return ma;
    }

    public static void setMa(String ma) {
        Flashcard.ma = ma;
    }

    public static String getBack() {
        return back;
    }

    public Flashcard() {
    }

    public static void setBack(String back) {
        Flashcard.back = back;

    }
}

