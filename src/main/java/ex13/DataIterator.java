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
        return counterOne < data.getLength();
    }

    @Override
    public Integer next() {
        if(data.getArr()[counterOne].getLength() != 0){
            int counter = data.getArr()[counterOne].getArr()[counterTwo];
            if(counterTwo >= data.getArr()[counterOne].getLength() - 1){
                counterOne++;
                counterTwo = -1;
            }
            counterTwo++;
            return counter;
        }
        else{
            counterOne++;
            return null;
        }
    }
}
