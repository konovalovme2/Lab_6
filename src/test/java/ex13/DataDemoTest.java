package ex13;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class DataDemoTest {

    @Test
    public void getAll() {
        Data data = new Data ("Array", new Group(12, 1, 2, 3), new Group(15, 6, 0, 2), new Group(322, 1, 56, 42));

        ArrayList<Integer>  a = new ArrayList<>();
        Collections.addAll(a,1,2,3,6,0,2,1,56,42);
        Assert.assertEquals(DataDemo.getAll(data), a);
    }
}