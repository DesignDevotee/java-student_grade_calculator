import java.util.Arrays;
import java.util.Scanner;

class Students {

    String names;
    int studentIds;
    int[] allMarks;
    int total;
    int percentage;
    char grade;

    public Students(String names, int studentIds, int[] allMarks) {
        this.names = names;
        this.studentIds = studentIds;
        this.allMarks = allMarks;
        this.total = calculateTotal(allMarks);
        this.percentage = calculatePercentage(total);
        this.grade = calculateGrade(percentage);
    }

    private int calculateTotal(int[] marks) {
        int t = 0;
        for (int mark : marks) {
            t += mark;
        }
        return t;
    }

    private int calculatePercentage(int total) {
        return total / allMarks.length;
    }

    private char calculateGrade(int percentage) {
        if (percentage > 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void displayDetails() {
        System.out.println("-------------------------------------------------");
        System.out.println("Name: " + names);
        System.out.println("Student ID: " + studentIds);
        System.out.println("Marks for subjects: " + Arrays.toString(allMarks));
        System.out.println("Total: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
    }
}

public class Gradecal {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of students: ");
            int noofStudents = sc.nextInt();
            sc.nextLine(); 

            Students[] s = new Students[noofStudents];
            for (int i = 0; i < noofStudents; i++) {
                String name = enterName(sc);
                int id = enterId(sc);
                int[] marks = enterMarks(sc);

                s[i] = new Students(name, id, marks);

                System.out.println();
            }
            for (Students item : s) {
                item.displayDetails();
            }
        }
    }

    public static String enterName(Scanner sc) {
        System.out.print("Enter student name: ");
        return sc.nextLine();
    }

    public static int enterId(Scanner sc) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        return id;
    }

    public static int[] enterMarks(Scanner sc) {
        int[] marks = new int[3];
        for (int j = 0; j < 3; j++) {
            System.out.print("Enter marks for subject " + (j + 1) + ": ");
            marks[j] = sc.nextInt();
        }
        sc.nextLine(); 
        return marks;
    }
}
