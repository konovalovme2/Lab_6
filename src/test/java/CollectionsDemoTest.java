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

    //6 задание

    @Test
    public void peopleSetList() {
        Map<Integer, Human> one = new LinkedHashMap<>();
        one.put(1, new Student("Arkadiy", "Petrov", "Valentinovich", 25, "FCTK"));
        one.put(24,  new Human("Oleg", "Petrov", "Ivanovich", 18));
        one.put(15,  new Human());

        Set<Integer> oneKeys = new HashSet<>();
        Collections.addAll(oneKeys, 1, 325, 23, 15, 34, 64);

        Set<Integer> twoKeys = new HashSet<>();

        Set<Human>answerOne = new HashSet<>();
        Collections.addAll(answerOne, new Student("Arkadiy", "Petrov", "Valentinovich", 25, "FCTK"), new Human());
        Assert.assertEquals(answerOne, CollectionsDemo.peopleSetList(one,oneKeys));
        Assert.assertEquals(new HashSet<Human>(), CollectionsDemo.peopleSetList(one,twoKeys));
    }

    @Test
    public void getPeopleOlder18() {
        Map<Integer, Human> one = new LinkedHashMap<>();
        one.put(1, new Student("Arkadiy", "Petrov", "Valentinovich", 25, "FCTK"));
        one.put(24,  new Human("Oleg", "Petrov", "Ivanovich", 46));
        one.put(15,  new Human());

        Map<Integer, Human> two = new LinkedHashMap<>();
        two.put(1, new Student("Arkadiy", "Petrov", "Valentinovich", 5, "FCTK"));
        two.put(24,  new Human("Oleg", "Petrov", "Ivanovich", 5));
        two.put(15,  new Human());

        ArrayList<Integer> answerOne = new ArrayList<>(2);
        Collections.addAll(answerOne, 1, 24);

        Assert.assertEquals(answerOne, CollectionsDemo.getPeopleOlder18(one));
        Assert.assertEquals(new ArrayList<Integer>(), CollectionsDemo.getPeopleOlder18(two));
    }

    @Test
    public void getMapOfAges() {
        Map<Integer, Human> one = new LinkedHashMap<>();
        one.put(1, new Student("Arkadiy", "Petrov", "Valentinovich", 25, "FCTK"));
        one.put(24,  new Human("Oleg", "Petrov", "Ivanovich", 46));
        one.put(15,  new Human());

        Map<Integer, Human> two = new LinkedHashMap<>();

        Map<Integer,Integer> answerOne = new LinkedHashMap<>();
        answerOne.put(1,25);
        answerOne.put(24,46);
        answerOne.put(15,0);

        Assert.assertEquals(answerOne,CollectionsDemo.getMapOfAges(one));
        Assert.assertEquals(new LinkedHashMap<Integer,Integer>(),CollectionsDemo.getMapOfAges(two));
    }

    @Test
    public void getAgesToListPeople() {
        Set<Human> one = new LinkedHashSet<>();
        Collections.addAll(one,new Student("Arkadiy", "Petrov", "Valentinovich", 25, "FCTK"),new Human("Oleg", "Petrov", "Ivanovich", 25),new Human(),new Student("Hello","Ok","World",0,"FCTK"),new Human("f","f","f", 25));

        Set<Human> two = new LinkedHashSet<>();

        Map<Integer, ArrayList<Human>> answerOne = new LinkedHashMap<>();
        ArrayList<Human> anOneOne = new ArrayList<>();
        ArrayList<Human> anOneTwo = new ArrayList<>();
        Collections.addAll(anOneOne,new Student("Arkadiy", "Petrov", "Valentinovich", 25, "FCTK"),new Human("Oleg", "Petrov", "Ivanovich", 25),new Human("f","f","f", 25));
        Collections.addAll(anOneTwo,new Human(),new Student("Hello","Ok","World",0,"FCTK"));
        answerOne.put(25,anOneOne);
        answerOne.put(0,anOneTwo);

        Assert.assertEquals(answerOne,CollectionsDemo.getAgesToListPeople(one));
        Assert.assertEquals(new LinkedHashMap<Integer, ArrayList<Human>>(),CollectionsDemo.getAgesToListPeople(two));
    }

    @Test
    public void getAgesToLetterToListPeople() {
        Set<Human> one = new LinkedHashSet<>();
        Collections.addAll(one,new Student("Arkadiy", "Petrov", "Valentinovich", 25, "FCTK"),new Human("Arkadiy", "Pktrov", "Valentinovich", 25),new Human(),new Student("Hello","Ok","World",25,"FCTK"),new Human("F","F","F", 25));

        Set<Human> two = new LinkedHashSet<>();

        Map<Integer,Map<Character,ArrayList<Human>>> answerOne = new LinkedHashMap<>();
        Map<Character,ArrayList<Human>> a = new LinkedHashMap<>();
        Map<Character,ArrayList<Human>> a1 = new LinkedHashMap<>();
        ArrayList<Human> b = new ArrayList<>();
        Collections.addAll(b,new Student("Arkadiy", "Pktrov", "Valentinovich", 25, "FCTK"),new Human("Arkadiy", "Petrov", "Valentinovich", 25));
        ArrayList<Human> c = new ArrayList<>();
        Collections.addAll(c,new Human());
        ArrayList<Human> d = new ArrayList<>();
        Collections.addAll(d,new Student("Hello","Ok","World",25,"FCTK"));
        ArrayList<Human> e = new ArrayList<>();
        Collections.addAll(e,new Human("F","F","F", 25));

        a.put('P', b);
        a.put('O', d);
        a.put('F', e);
        a1.put('I', c);

        answerOne.put(25,a);
        answerOne.put(0,a1);

        Assert.assertEquals(answerOne,CollectionsDemo.getAgesToLetterToListPeople(one));
        Assert.assertEquals(new LinkedHashMap<Integer,Map<Character,ArrayList<Human>>>(),CollectionsDemo.getAgesToLetterToListPeople(two));
    }

    @Test
    public void setToList() {
        Set<Student> one = new HashSet<>();
        one.add(new Student("Arkadiy", "Petrov", "Valentinovich", 25, "FCTK"));
        one.add(new Student("Arkadiy", "Pktrov", "Valentinovich", 25,""));
        one.add(new Student());
        one.add(new Student("F","F","F", 25,""));
        Set<Human> two = new HashSet<>();

        ArrayList<Human> oneEx = new ArrayList<>();
        Collections.addAll(oneEx, new Student("F","F","F", 25,""), new Student(),new Student("Arkadiy", "Petrov", "Valentinovich", 25, "FCTK"),new Student("Arkadiy", "Pktrov", "Valentinovich", 25,""));

        Assert.assertEquals(oneEx,CollectionsDemo.setToList(one));
        Assert.assertEquals(new ArrayList<Human>(),CollectionsDemo.setToList(two));
    }
}