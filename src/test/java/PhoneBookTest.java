import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;


public class PhoneBookTest {

    @Test
    public void addAPhone() {
        PhoneBook one = new PhoneBook();
        PhoneBook two = new PhoneBook();
        Assert.assertEquals(one,two);

        one.addAPhone(new Human(), "274387123");
        Assert.assertNotEquals(one,two);

        two.addAPhone(new Human(), "274387123");
        Assert.assertEquals(one,two);
    }

    @Test
    public void deleteAPhone() {
        PhoneBook one = new PhoneBook();
        PhoneBook two = new PhoneBook();
        Assert.assertEquals(one,two);

        one.addAPhone(new Human(), "274387123");
        one.addAPhone(new Human(), "911");
        one.addAPhone(new Human(), "01");
        one.addAPhone(new Human(), "02");
        Assert.assertNotEquals(one,two);

        two.addAPhone(new Human(), "274387123");
        two.addAPhone(new Human(), "911");
        two.addAPhone(new Human(), "01");
        two.addAPhone(new Human(), "02");
        Assert.assertEquals(one,two);

        one.deleteAPhone("274387123");
        Assert.assertNotEquals(one,two);

        one.deleteAPhone("911");
        one.deleteAPhone("01");
        one.deleteAPhone("02");

        two.deleteAPhone("274387123");
        two.deleteAPhone("911");
        two.deleteAPhone("01");
        two.deleteAPhone("02");
        Assert.assertEquals(one,two);

        try{
            one.deleteAPhone("274387123");
        }
        catch (Exception exception){
            System.out.println("Error one");
        }
    }

    @Test
    public void getAPhone() {
        PhoneBook one = new PhoneBook();
        PhoneBook two = new PhoneBook();
        Human person = new Human();

        one.addAPhone(person, "274387123");
        one.addAPhone(person, "01");
        one.addAPhone(person, "02");
        one.addAPhone(person, "03");
        ArrayList<String> a = new ArrayList<>();
        Collections.addAll(a,"274387123","01","02","03");

        Assert.assertEquals(a, one.getAPhone(person));
        Assert.assertNull(two.getAPhone(new Human("F", "F", "F", 13)));
    }

    @Test
    public void getAPerson() {
        PhoneBook one = new PhoneBook();
        PhoneBook two = new PhoneBook();
        Human person = new Human();
        Human person2 = new Human();

        one.addAPhone(person, "274387123");
        one.addAPhone(person, "01");
        one.addAPhone(person2, "01");

        Assert.assertEquals(person, one.getAPerson("274387123"));
        Assert.assertEquals(person, one.getAPerson("01"));
        Assert.assertNull(two.getAPerson("01"));
        Assert.assertEquals(person2, one.getAPerson("01"));
    }

    @Test
    public void getSearchedPhoneBook() {
        PhoneBook one = new PhoneBook();
        PhoneBook two = new PhoneBook();

        Human person1 = new Human();
        Human person2 = new Human("Alexey","Iv", "Evgenich",47);
        Human person3 = new Human("Larisa","Ivanova", "Pertrovna",47);

        one.addAPhone(person1, "01");
        one.addAPhone(person1, "02");
        one.addAPhone(person2, "03");
        one.addAPhone(person2, "04");
        one.addAPhone(person2, "05");
        one.addAPhone(person2, "06");
        one.addAPhone(person3, "07");
        one.addAPhone(person3, "08");
        one.addAPhone(person3, "09");

        two.addAPhone(person1, "01");
        two.addAPhone(person1, "02");
        two.addAPhone(person3, "07");
        two.addAPhone(person3, "08");
        two.addAPhone(person3, "09");

        Assert.assertEquals(two,one.getSearchedPhoneBook("Ivan"));
        Assert.assertEquals(one,one.getSearchedPhoneBook("Iv"));
        Assert.assertEquals(new PhoneBook(),one.getSearchedPhoneBook("Petr"));
    }
}