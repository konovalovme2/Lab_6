package ex13;

import java.util.ArrayList;
import java.util.Iterator;

public class DataDemo {
    public static ArrayList<Integer> getAll(Data data){
        ArrayList<Integer> numberList = new ArrayList<>();

        Iterator<Integer> dataItr= data.iterator();
        while(dataItr.hasNext()){
            Integer a = dataItr.next();
            if(a != null){
                numberList.add(a);
            }
        }
        return numberList;
    }
}
