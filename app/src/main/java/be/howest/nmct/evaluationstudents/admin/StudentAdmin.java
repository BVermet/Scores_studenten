package be.howest.nmct.evaluationstudents.admin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stijn on 20/03/2015.
 */
public final class StudentAdmin {

    public static List<Student> getStudenten() {
        return studenten;
        }

    public static Student getStudent(String sEmailStudent) {
        for (Student student : getStudenten()) {
            if (student.getEmailStudent().equals(sEmailStudent)) return student;
            }
        return null;
    }

    public static List<Student> getStudenten(Student.DIPLOMAGRAAD diplomagraad) {
            List<Student> selectedStudenten = new ArrayList<>();

           for (Student s : getStudenten())
                if (s.getDiplomagraad().equals(diplomagraad)) selectedStudenten.add(s);

           return selectedStudenten;
    }

    private static List<Student> studenten;
    static{

        studenten = new ArrayList<Student>();

        Student s1 = new Student("stijn.walcarius@howest.be", "Stijn", "Walcarius");
        s1.voegScoreToe("Programming Skills", 6, 16);
        s1.voegScoreToe("Applied Math", 6, 15);
        s1.voegScoreToe("Design", 3, 8);
        s1.voegScoreToe("Web", 6, 13);
        s1.voegScoreToe("OOP", 6, 15);
        s1.voegScoreToe("Digital Maths", 6, 12);
        s1.voegScoreToe("Data Management", 6, 10);
        s1.voegScoreToe("Network Technology", 6, 10);

        Student s2 = new Student("steven.verborgh@howest.be", "Steven", "Verborgh");
        s2.voegScoreToe("Programming Skills", 6, 18);
        s2.voegScoreToe("Applied Math", 6, 12.7);
        s2.voegScoreToe("Design", 3, 16);
        s2.voegScoreToe("Web", 6, 13);
        s2.voegScoreToe("OOP", 6, 19);
        s2.voegScoreToe("Digital Maths", 6, 12);
        s2.voegScoreToe("Data Management", 6, 18);
        s2.voegScoreToe("Network Technology", 6, 14);

        Student s3 = new Student("dieter.reebock@howest.be", "Diederik", "Reebock");
        s3.voegScoreToe("Programming Skills", 6, 4);
        s3.voegScoreToe("Applied Math", 6, 8);
        s3.voegScoreToe("Design", 3, 19);
        s3.voegScoreToe("Web", 6, 12);
        s3.voegScoreToe("OOP", 6, 10);


        Student s4 = new Student("karel.deman@howest.be", "Karel", "Deman");
        s4.voegScoreToe("Programming Skills", 6, 4);
        s4.voegScoreToe("Applied Math", 6, 8);
        s4.voegScoreToe("Design", 3, 19);
        s4.voegScoreToe("Networking", 6, 15);
        s4.voegScoreToe("Server Side Scripting", 6, 12);
        s4.voegScoreToe("Web", 6, 13);
        s4.voegScoreToe("OOP", 6, 8);
        s4.voegScoreToe("Digital Maths", 6, 7);
        s4.voegScoreToe("Data Management", 6, 11);
        s4.voegScoreToe("Network Technology", 6, 16);

        Student s5 = new Student("Lies.Koninck@howest.be", "Lies", "Koninck");
        s5.voegScoreToe("Programming Skills", 6, 8);
        s5.voegScoreToe("Applied Math", 6, 4);
        s5.voegScoreToe("Design", 3, 10);
        s5.voegScoreToe("Networking", 6, 7);
        s5.voegScoreToe("Server Side Scripting", 6, 3);
        s5.voegScoreToe("Web", 6, 4);
        s5.voegScoreToe("OOP", 6, 10);
        s5.voegScoreToe("Digital Maths", 6, 2);
        s5.voegScoreToe("Data Management", 6, 6);
        s5.voegScoreToe("Network Technology", 6, 3);

        Student s6 = new Student("jonas.verspecht@howest.be", "Jonas", "Verspecht");
        s6.voegScoreToe("Programming Skills", 6, 12);
        s6.voegScoreToe("Applied Math", 6, 18);
        s6.voegScoreToe("Design", 3, 9);
        s6.voegScoreToe("Networking", 6, 10);
        s6.voegScoreToe("Server Side Scripting", 6, 17);
        s6.voegScoreToe("Web", 6, 10);
        s6.voegScoreToe("OOP", 6, 14);
        s6.voegScoreToe("Digital Maths", 6, 18);


        Student s7 = new Student("annelies.nuytten@howest.be", "Annelies", "Nuytten");
        s7.voegScoreToe("Programming Skills", 6, 4);
        s7.voegScoreToe("Applied Math", 6, 8);
        s7.voegScoreToe("Design", 3, 19);
        s7.voegScoreToe("Networking", 6, 8);
        s7.voegScoreToe("Web", 6, 13);
        s7.voegScoreToe("OOP", 6, 5);
        s7.voegScoreToe("Digital Maths", 6, 12);
        s7.voegScoreToe("Data Management", 6, 10);
        s7.voegScoreToe("Network Technology", 6, 8);

        Student s8 = new Student("Jan.DeNeut@howest.be", "Jan", "De Neut");
        s8.voegScoreToe("Programming Skills", 6, 5);
        s8.voegScoreToe("Applied Math", 6, 6);
        s8.voegScoreToe("Design", 3, 7);
        s8.voegScoreToe("Networking", 6, 8);
        s8.voegScoreToe("Web", 6, 5);
        s8.voegScoreToe("OOP", 6, 8);
        s8.voegScoreToe("Digital Maths", 6, 10);
        s8.voegScoreToe("Data Management", 6, 10);
        s8.voegScoreToe("Network Technology", 6, 2);

        Student s9 = new Student("bert.maes@howest.be", "Bert", "Maes");
        s9.voegScoreToe("Programming Skills", 6, 14);
        s9.voegScoreToe("Applied Math", 6, 8);
        s9.voegScoreToe("Design", 3, 10);
        s9.voegScoreToe("Networking", 6, 10);
        s9.voegScoreToe("Web", 6, 9);
        s9.voegScoreToe("OOP", 6, 9);
        s9.voegScoreToe("Digital Maths", 6, 8);
        s9.voegScoreToe("Data Management", 6, 8);
        s9.voegScoreToe("Network Technology", 6, 8);

        Student s10 = new Student("Kim.Volder@howest.be", "Kim", "Volder");
        s10.voegScoreToe("Programming Skills", 6, 16);
        s10.voegScoreToe("Applied Math", 6, 10);
        s10.voegScoreToe("Design", 3, 19);
        s10.voegScoreToe("Networking", 6, 16);
        s10.voegScoreToe("Web", 6, 13);
        s10.voegScoreToe("OOP", 6, 15);
        s10.voegScoreToe("Digital Maths", 6, 13);
        s10.voegScoreToe("Data Management", 6, 14);
        s10.voegScoreToe("Network Technology", 6, 15);

        studenten.add(s2);
        studenten.add(s3);
        studenten.add(s1);
        studenten.add(s4);
        studenten.add(s5);
        studenten.add(s6);
        studenten.add(s7);
        studenten.add(s8);
        studenten.add(s9);
        studenten.add(s10);

    }


}



