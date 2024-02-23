import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneBook {
    Map<Human, ArrayList<String>> phoneBook;
    PhoneBook(){
        this.phoneBook = new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneBook phoneBook1)) return false;
        return Objects.equals(phoneBook, phoneBook1.phoneBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneBook);
    }

    public void addAPhone(Human person, String phone) {
        ArrayList<String> one;
        if(phoneBook.containsKey(person)){
            one = new ArrayList<>(phoneBook.get(person));
        }
        else{
            one = new ArrayList<>();
        }
        one.add(phone);
        phoneBook.put(person,one);
    }

    public void deleteAPhone(String phone) {
        Human person = getAPerson(phone);
        if(phoneBook.get(person).size()!=1){
            ArrayList<String> one = new ArrayList<>(phoneBook.get(person));
            one.remove(phone);
            phoneBook.put(person,one);
        }
        else{
            phoneBook.remove(person);
        }
    }

    public ArrayList<String> getAPhone(Human person){
        return phoneBook.get(person);
    }

    public Human getAPerson(String phone){
        for (Map.Entry<Human,ArrayList<String>> phoneString: phoneBook.entrySet()) {
            if(phoneString.getValue().contains(phone)){
                return phoneString.getKey();
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public PhoneBook getSearchedPhoneBook(String begin){
        PhoneBook searchedPhoneBook = new PhoneBook();
        for (Map.Entry<Human,ArrayList<String>> phoneString: phoneBook.entrySet()) {
            if(phoneString.getKey().getSurname().startsWith(begin)){
                for (String phone: phoneString.getValue()) {
                    searchedPhoneBook.addAPhone(phoneString.getKey(),phone);
                }
            }
        }
        return searchedPhoneBook;
    }

}
