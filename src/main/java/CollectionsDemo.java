import java.util.*;

public class CollectionsDemo {
    public static int getNumberOfStringsWithFirstLetter(ArrayList<String> strings, char c) {
        int num = 0;

        for(String string: strings){
            if(string != null && !string.isEmpty() && string.charAt(0)==c){
                num++;
            }
        }

        return num;
    }

    public static int getNumberOfPeopleWithSameSurname(ArrayList<Human> people, Human one) {
        int num = 0;

        for(Human human: people){
            if (human.getSurname().equals(one.getSurname())) {
                num++;
            }
        }

        return num;
    }

    public static ArrayList<Human> removeHuman(ArrayList<Human> people, Human one) {
        ArrayList<Human> newPeople = new ArrayList<>(people);
        if (newPeople.contains(one)) {
            newPeople.remove(one);
        }

        return newPeople;
    }

    public static ArrayList<Set<Integer>> setsWithoutSameNumbers(ArrayList<Set<Integer>> setOfNumbers, Set<Integer> number) {
        ArrayList<Set<Integer>> newSetOfNumbers = new ArrayList<>(setOfNumbers);

        for(Set<Integer> i: setOfNumbers){
            for(int j: number){
                if (i.contains(j)) {
                    newSetOfNumbers.remove(i);
                }
            }
        }

        return newSetOfNumbers;
    }

    public static ArrayList<Human> maxAgePeople(ArrayList<Human> people) {
        ArrayList<Human> peopleCopy = new ArrayList();
        int maxAge = 0;
        for(Human one: people){
            if (one.getAge() > maxAge) {
                maxAge = one.getAge();
            }
        }

        for(Human one: people){
            if (one.getAge() == maxAge) {
                peopleCopy.add(one);
            }
        }

        return peopleCopy;
    }
}
