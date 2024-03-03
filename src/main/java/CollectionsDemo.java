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
        ArrayList<Human> peopleCopy = new ArrayList<>();
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

    public static <T extends Human> ArrayList <T> setToList (Set<T> setOfPeople){
        ArrayList<T> listOfPeople = new ArrayList<>();
        HumanComporator comp = new HumanComporator();

        for (T item : setOfPeople) {
            int i = 0;
            for (int j = 0; j < listOfPeople.size(); j++) {
                if (comp.compare(listOfPeople.get(j), item) > 0) {
                    i = j;
                    break;
                } else {
                    i = listOfPeople.size();
                }
            }

            listOfPeople.add(i, item);
        }

        return listOfPeople;
    }

    public static Set<Human> peopleSetList(Map<Integer,Human> people, Set<Integer> keys){
        Set<Human> peopleSet = new HashSet<>();
        for(int person: keys){
            Human a = people.get(person);
            if(a != null){
                peopleSet.add(a);
            }
        }
        return peopleSet;
    }

    public static ArrayList<Integer> getPeopleOlder18(Map<Integer,Human> people){
        ArrayList<Integer> listOfIDs = new ArrayList<>(people.size());
        for(Map.Entry<Integer,Human> person: people.entrySet()){
            if (person.getValue().getAge()>=18){
                listOfIDs.add(person.getKey());
            }
        }
        return listOfIDs;
    }

    public static Map<Integer,Integer> getMapOfAges(Map<Integer,Human> people){
        Map<Integer,Integer> ageMap = new LinkedHashMap<>(people.size());
        for(Map.Entry<Integer,Human> person: people.entrySet()){
            ageMap.put(person.getKey(),person.getValue().getAge());
        }
        return ageMap;
    }

    public static Map<Integer,ArrayList<Human>> getAgesToListPeople(Set<Human> people){
        Map<Integer,ArrayList<Human>> ageMap = new LinkedHashMap<>(people.size());
        for(Human person: people){
            ArrayList<Human> oneAge;
            if (ageMap.containsKey(person.getAge())){
                oneAge = ageMap.get(person.getAge());
            }
            else{
                oneAge = new ArrayList<>(people.size());
            }
            oneAge.add(person);
            ageMap.put(person.getAge(), oneAge);
        }
        return ageMap;
    }

    public static Map<Integer,Map<Character,ArrayList<Human>>> getAgesToLetterToListPeople(Set<Human> people){
        Map<Integer,Map<Character,ArrayList<Human>>> ageToLetterMap = new LinkedHashMap<>(people.size());
        Map<Integer,ArrayList<Human>> ageMap = getAgesToListPeople(people);
        HumanComporator comp = new HumanComporator();
        for(Map.Entry<Integer,ArrayList<Human>> agePeople: ageMap.entrySet()){
            Map<Character,ArrayList<Human>> ageLMap = new LinkedHashMap<>(agePeople.getValue().size());

            for(Human person: agePeople.getValue()){
                ArrayList<Human> oneAge;
                if (ageLMap.containsKey(person.getSurname().charAt(0))){
                    oneAge = ageLMap.get(person.getSurname().charAt(0));
                }
                else{
                    oneAge = new ArrayList<>(people.size());
                }

                int i=0;

                for (int j = 0; j < oneAge.size(); j++) {
                    if(comp.compare(oneAge.get(j),person) < 0){
                        i = j;
                        break;
                    }
                    else{
                        i=oneAge.size();
                    }
                }

                oneAge.add(i,person);
                ageLMap.put(person.getSurname().charAt(0), oneAge);
            }

            ageToLetterMap.put(agePeople.getKey(),ageLMap);
        }

        return ageToLetterMap;
    }
}
