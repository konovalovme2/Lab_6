import java.util.*;

public class Human {
    private String name;
    private String surname;
    private String fatherName;
    private int age;

    Human() {
        this.name = "Ivan";
        this.surname = "Ivanov";
        this.fatherName = "Ivanovich";
        this.age = 0;
    }

    Human(String name, String surname, String fatherName, int age) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return this.fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof Human)) {
            return false;
        } else {
            Human human = (Human)object;
            return this.age == human.age && Objects.equals(this.name, human.name) && Objects.equals(this.surname, human.surname) && Objects.equals(this.fatherName, human.fatherName);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name, this.surname, this.fatherName}) + this.age;
    }
}