package samplearrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

public class ManageStudent {
    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if(Student.getNumStudent() == 0) return null;

        Student oldest = students[0];

        for(int i = 1; i < Student.getNumStudent(); ++i) {
            if(students[i].getAge() > oldest.getAge()) oldest = students[i];
        }

        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;

        for(Student stud : students) {
            if(stud.getAge() >= 18) count++;
        }

        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if(Student.getNumStudent() == 0) return Double.NaN;

        double average = 0.0;
        int n = Student.getNumStudent();

        for(Student stud : students) {
            average += (stud.getGrade() / n);
        }

        return average;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        if(Student.getNumStudent() == 0) return null;

        for(Student stud : students) {
            if(stud.getName().equals(name)) return stud;
        }

        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, Comparator.comparingInt(s -> -s.getGrade()));

    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        if(Student.getNumStudent() == 0) return;

        for(Student stud : students) {
            if(stud.getGrade() >= 15) stud.toString();
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        if(Student.getNumStudent() == 0) return false;

        for(Student stud : students) {
            if(stud.getId() == id) {
                stud.setGrade(newGrade);
                return true;
            } 
        }

        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        if(Student.getNumStudent() == 0) return false;

        Set<String> used_names = new HashSet<String>();

        for(Student stud : students) {
            if(used_names.contains(stud.getName()) ) {
                System.out.println("Found duplicates");
                return true;
            }
            used_names.add(stud.getName());
        }

        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        int n = students.length;
        Student[] newLst = new Student[n + 1];

        for(int i = 0; i < n; i++) {
            newLst[i] = students[i];
        }

        newLst[n] = newStudent;

        return newLst;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] studArr = new Student[5];
        studArr[0] = new Student(1, "Adam", 22, 12);
        studArr[1] = new Student(2, "Morad", 14, 17);
        studArr[2] = new Student(3, "Ilyass", 20, 15);
        studArr[3] = new Student(4, "Imad", 32, 15);
        studArr[4] = new Student(5, "Anas", 39, 21);


        System.out.println("Students:");
        for (Student stud : studArr) System.out.println(stud);

        System.out.println("Student count: " + Student.getNumStudent());

        // 2) Oldest
        ManageStudent.findOldest(studArr).toString();

        // 3) Count adults
        System.out.println(ManageStudent.countAdults(studArr));


        // 4) Average grade
        System.out.println(ManageStudent.averageGrade(studArr));


        // 5) Find by name
        System.out.println("Searching for Adam: " + ManageStudent.findStudentByName(studArr, "Adam"));   // true
        System.out.println("Searching for Mouad: " + ManageStudent.findStudentByName(studArr, "Mouad")); // false


        // 6) Sort by grade desc
        System.out.println("\nSorted by grade");
        for (Student stud : studArr) System.out.println(stud);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(studArr);

        // 8) Update grade by id
        boolean updated = ManageStudent.updateGrade(studArr, 4, 18);

        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(studArr, "Malak"));

        // 9) Duplicate names
        ManageStudent.hasDuplicateNames(studArr);

        // 10) Append new student
        System.out.println("Before adding a student: ");
        for(Student stud : studArr) stud.toString();

        System.out.println("After adding a student: ");
        studArr = ManageStudent.appendStudent(studArr, new Student(7, "Malak", 15, 17));
        for(Student stud : studArr) stud.toString();
    }
}
