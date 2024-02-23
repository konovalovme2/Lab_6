import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


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
        Assert.assertNotEquals(one,two);

        two.addAPhone(new Human(), "274387123");
        Assert.assertEquals(one,two);

        one.deleteAPhone("274387123");
        Assert.assertNotEquals(one,two);

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
        Human person = new Human();

        one.addAPhone(person, "274387123");
        ArrayList<String> a = new ArrayList<>();
        a.add("274387123");

        Assert.assertEquals(a, one.getAPhone(person));
    }

    @Test
    public void getAPerson() {
        PhoneBook one = new PhoneBook();
        Human person = new Human();

        one.addAPhone(person, "274387123");

        Assert.assertEquals(person, one.getAPerson("274387123"));
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