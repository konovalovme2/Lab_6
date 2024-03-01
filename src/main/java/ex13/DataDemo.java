package ex13;

import java.util.ArrayList;
import java.util.Iterator;

public class DataDemo {
    public static ArrayList<Integer> getAll(Data data){
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        Iterator<Integer> dataItr= data.iterator();
        while(dataItr.hasNext()){
            numberList.add(dataItr.next());
        }
        return numberList;
    }
}
