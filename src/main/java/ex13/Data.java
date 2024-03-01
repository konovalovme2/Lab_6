package ex13;

import java.util.Iterator;

public class Data implements Iterable<Integer> {
    private String name;
    private Group[] arr;

    public Data(String name, Group ... arr) {
        this.name = name;
        this.arr = arr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group[] getArr() {
        return arr;
    }

    public void setArr(Group[] arr) {
        this.arr = arr;
    }

    public int getLength() {
        return arr.length;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new DataIterator(this);
    }
}
