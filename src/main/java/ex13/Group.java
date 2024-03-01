package ex13;

import java.util.Arrays;
import java.util.Objects;

public class Group {
    private int id;
    private  int[] arr;

    public Group() {
    }
    public Group(int id, int... arr) {
        this.id = id;
        this.arr = arr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getLength() {
        return arr.length;
    }
}
