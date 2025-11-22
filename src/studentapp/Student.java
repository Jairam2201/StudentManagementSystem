package StudentManagementSystem.src.studentapp;

public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private String place;
    private int age;
    private String course;
    private String branch;

    public Student() {}

    public Student(String firstname, String lastname, String dateOfBirth,
                   String place, int age, String course, String branch) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.place = place;
        this.age = age;
        this.course = course;
        this.branch = branch;
    }

    public Student(int id, String firstname, String lastname, String dateOfBirth,
                   String place, int age, String course, String branch) {
        this(firstname, lastname, dateOfBirth, place, age, course, branch);
        this.id = id;
    }

    // Getters
    public int getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getPlace() { return place; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public String getBranch() { return branch; }

    // Setters (added)
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setPlace(String place) { this.place = place; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }
    public void setBranch(String branch) { this.branch = branch; }
}
