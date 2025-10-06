package ua.opnu;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Куриленко", "Ілона", 18, "AI-244", "STU001");
        Student s2 = new Student("Петренко", "Марія", 19, "AI-244", "STU002");
        Lecturer l1 = new Lecturer("Висоцький", "Олександр", 35, "Інформаційних систем", 35000);
        Lecturer l2 = new Lecturer("Іванов", "Ігор", 45, "Комп'ютерних наук", 42000);

        Person[] people = new Person[] { s1, l1, s2, l2 };

        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}