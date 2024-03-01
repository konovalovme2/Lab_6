import java.util.Comparator;

public class HumanComporator implements Comparator<Human>{
    public int compare(Human human1, Human human2) {
        if(!human1.getSurname().equals(human2.getSurname())){
            return human1.getSurname().compareTo(human2.getSurname());
        }
        if(!human1.getName().equals(human2.getName())){
            return human1.getName().compareTo(human2.getName());
        }
        return human1.getFatherName().compareTo(human2.getFatherName());
    }
}