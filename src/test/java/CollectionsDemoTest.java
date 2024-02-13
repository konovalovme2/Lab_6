import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class CollectionsDemoTest {

    @Test
    public void getNumberOfStringsWithFirstLetter() {
        ArrayList<String> a = new ArrayList<>();
        Collections.addAll(a, "wewyfeg", "", "132daWD", " ", "W", "wsdasd", "ar", null, null);
        Assert.assertEquals(CollectionsDemo.getNumberOfStringsWithFirstLetter(a, 'w'),2);
        Assert.assertEquals(CollectionsDemo.getNumberOfStringsWithFirstLetter(a, 'a'),1);
        Assert.assertEquals(CollectionsDemo.getNumberOfStringsWithFirstLetter(a, 'c'),0);
    }

    @Test
    public void getNumberOfPeopleWithSameSurname() {
        ArrayList<Human> a = new ArrayList<>();
        Collections.addAll(a, new Human(), new Human("Oleg", "Petrov", "Ivanovich", 18), new Human("Alexey", "Petrov", "Kirillovich", 25), new Human("Arkadiy", "Petrov", "Valentinovich", 21), new Human("Oleg", "Orlov", "Ivanovich", 29));
        Human one = new Human("Alexandr", "Petrov", "Evgenevich", 35);
        Human two = new Human("Mikhail", "Ivanov", "Ivanovich", 18);
        Human three = new Human("Oleg", "Pushkin", "Ivanovich", 18);
        Assert.assertEquals(CollectionsDemo.getNumberOfPeopleWithSameSurname(a, one),3);
        Assert.assertEquals(CollectionsDemo.getNumberOfPeopleWithSameSurname(a, two),1);
        Assert.assertEquals(CollectionsDemo.getNumberOfPeopleWithSameSurname(a, three),0);
    }

    @Test
    public void removeHuman() {
        ArrayList<Human> a = new ArrayList<>();
        Collections.addAll(a, new Human(), new Human("Oleg", "Petrov", "Ivanovich", 18), new Human("Alexey", "Petrov", "Kirillovich", 25), new Human("Arkadiy", "Petrov", "Valentinovich", 21), new Human("Oleg", "Orlov", "Ivanovich", 29));
        Human one = new Human("Oleg", "Petrov", "Ivanovich", 18);
        Human two = new Human("Oleg", "Pushkin", "Ivanovich", 18);
        ArrayList<Human> b = new ArrayList<>(a);
        b.remove(one);
        Assert.assertEquals(CollectionsDemo.removeHuman(a, one), b);
        Assert.assertNotEquals(CollectionsDemo.removeHuman(a, one), a);
        Assert.assertEquals(CollectionsDemo.removeHuman(a, two), a);
    }

    @Test
    public void setsWithoutSameNumbers() {
        ArrayList<Set<Integer>> a = new ArrayList<>();
        ArrayList<Set<Integer>> b = new ArrayList<>();
        ArrayList<Set<Integer>> c = new ArrayList<>();
        Set<Integer> one = new HashSet<>();
        Set<Integer> two = new HashSet<>();
        Set<Integer> three = new HashSet<>();
        Set<Integer> four = new HashSet<>();
        Collections.addAll(one, 1,2,3,4,5,6);
        Collections.addAll(two, 1,0,10,14,17,18);
        Collections.addAll(three, 15,0,10,14,17,18);
        Collections.addAll(a,two,three,four);
        Collections.addAll(b,three, four);

        Assert.assertEquals(CollectionsDemo.setsWithoutSameNumbers(a,one),b);
        Assert.assertEquals(CollectionsDemo.setsWithoutSameNumbers(c,one),c);
    }

    @Test
    public void maxAgePeople() {
        ArrayList<Human> a = new ArrayList<>();
        ArrayList<Human> b = new ArrayList<>();
        ArrayList<Human> c = new ArrayList<>();
        Collections.addAll(a, new Student(), new Human("Oleg", "Petrov", "Ivanovich", 18), new Human("Alexey", "Petrov", "Kirillovich", 25), new Student("Arkadiy", "Petrov", "Valentinovich", 25, "FCTK"), new Human("Oleg", "Orlov", "Ivanovich", 25), new Human(), new Human("Oleg", "Orlov", "Ivanovich", 25));
        Collections.addAll(b, new Human("Alexey", "Petrov", "Kirillovich", 25), new Student("Arkadiy", "Petrov", "Valentinovich", 25, "FCTK"), new Human("Oleg", "Orlov", "Ivanovich", 25), new Human("Oleg", "Orlov", "Ivanovich", 25));
        Assert.assertEquals(CollectionsDemo.maxAgePeople(a), b);
        Assert.assertNotEquals(CollectionsDemo.maxAgePeople(a), a);
        Assert.assertEquals(CollectionsDemo.maxAgePeople(c), c);
    }
}