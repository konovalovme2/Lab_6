//package ex13;
//
//import java.util.Iterator;
//
//public class Data implements Iterable<Data>{
//    String name;
//    Group[] arr;
//
//    public Data(String name, Group ... arr) {
//        this.name = name;
//        this.arr = arr;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Group[] getArr() {
//        return arr;
//    }
//
//    public void setArr(Group[] arr) {
//        this.arr = arr;
//    }
//
//    public int getLength() {
//        return arr.length;
//    }
//
//
//    @Override
//    public Iterator<Data> iterator() {
//        return new Iterator<Data>(this) {
//
//
//
//            @Override
//            public boolean hasNext() {
//                return false;
//            }
//
//            @Override
//            public Data next() {
//                return null;
//            }
//        }
//    }
//}
