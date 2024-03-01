package ex13;

import java.util.Iterator;

public class DataIterator implements Iterator<Integer> {

    private Data data;
    private int counterOne;
    private int counterTwo;

    public DataIterator(Data data){
        this.data = data;
        counterOne = 0;
        counterTwo = 0;
    }

    @Override
    public boolean hasNext() {
        if(counterOne > data.getLength() || counterTwo > data.getArr()[data.getLength()-1].getLength()){
            return false;
        }
        return true;
    }

    @Override
    public Integer next() {
        counterOne++;
        counterTwo++;
        return data.getArr()[counterOne].getArr()[counterTwo];
    }
}
