package skateam.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Kien Nguyen on 6/22/2017.
 */

public   class  Flashcard  {
     String front;
     String ma;
     String back;

    public Flashcard(String front, String ma, String back) {
        this.front = front;
        this.ma = ma;
        this.back = back;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public Flashcard() {
    }
}

