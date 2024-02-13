public class Student extends Human {
    private String faculty;

    Student() {
        super();
        this.faculty = "";
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    Student(String name, String surname, String fatherName, int age, String faculty) {
        super(name, surname, fatherName, age);
        this.faculty = faculty;
    }
}
