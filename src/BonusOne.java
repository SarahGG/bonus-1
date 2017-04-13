import java.util.ArrayList;
import java.util.Scanner;

/**
 * A program that converts a percentage
 * into a corresponding letter grade
 * then repeats as the user requires
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class BonusOne {
    private static Scanner scnr = new Scanner(System.in);
    private static boolean doAgain = true;

    // creating my array objects
    private static ArrayList<String> letterGrades = new ArrayList<>();
    private static ArrayList<Integer> gradeMaximum = new ArrayList<>();
    private static ArrayList<Integer> gradeMinimum = new ArrayList<>();
    /**
     * defines and initializeds the grade tables
     */
    private static void loadGrades() {
        // initializing the tables
        // Maximum percentage    // Minimum percentage  //Corresponding Letters
        gradeMaximum.add(59);   gradeMinimum.add(0);   letterGrades.add("F");
        gradeMaximum.add(62);   gradeMinimum.add(60);  letterGrades.add("D-");
        gradeMaximum.add(66);   gradeMinimum.add(63);  letterGrades.add("D");
        gradeMaximum.add(69);   gradeMinimum.add(67);  letterGrades.add("D+");
        gradeMaximum.add(72);   gradeMinimum.add(70);  letterGrades.add("C-");
        gradeMaximum.add(76);   gradeMinimum.add(73);  letterGrades.add("C");
        gradeMaximum.add(79);   gradeMinimum.add(77);  letterGrades.add("C+");
        gradeMaximum.add(82);   gradeMinimum.add(80);  letterGrades.add("B-");
        gradeMaximum.add(86);   gradeMinimum.add(83);  letterGrades.add("B");
        gradeMaximum.add(89);   gradeMinimum.add(87);  letterGrades.add("B+");
        gradeMaximum.add(92);   gradeMinimum.add(90);  letterGrades.add("A-");
        gradeMaximum.add(99);   gradeMinimum.add(93);  letterGrades.add("A");
        gradeMaximum.add(130);  gradeMinimum.add(100); letterGrades.add("A+");
    }

    /**
     * asks user if they want to continue and then checks their input
     * for yes, no, a test result, or an incorrect input
     */
    private static void inputCheck() {
        boolean correctInput; // will check that user has input 'n', 'N', 'y', or 'Y'
        char userContinueCheck = 'z'; // will check that user wants to repeat the program

        /* asks user if they want to continue and then checks their input
        for yes, no, a test result, or an incorrect input */
        do {
            System.out.print("Continue? (y/n): ");
            userContinueCheck = scnr.next("[a-zA-Z]").charAt(0); // accepts a letter as input

            switch (userContinueCheck) {
                case 'y':
                case 'Y':
                    correctInput = true; // 'y' and 'Y' are correct input
                    doAgain = true; // will repeat the main program
                    break;
                case 'n':
                case 'N':
                    correctInput = true; // 'n' and 'N' are correct input
                    doAgain = false; // will exit the main program
                    break;
                case 'z':
                    correctInput = true; // can repeat test if tester wants
                    System.out.println("Your userContinueCheck has failed.");
                    break;
                default:
                    correctInput = false; // makes the doWhile loop ask for another input
                    System.out.println("Incorrect Input!"); // yells at you for misbehavin'
                    System.out.println("");
                    break;
            }
        }
        // repeats the loop if the user gave the wrong input
        while (!correctInput);
    }

    public static void main(String[] args) {
        loadGrades();
        int numberGrade = 0;
        boolean moveUp = false;
        int i = 0;

        do {
            System.out.print("Please enter a numerical grade: ");
            numberGrade = scnr.nextInt();
            do {
                if (numberGrade < 0) {
                    moveUp = false; // exits the loop, something went wrong
                    System.out.println("Please enter a positive integer.");
                }
                else if ( (numberGrade > gradeMinimum.get(i)) && (numberGrade > gradeMaximum.get(i)) ) {
                    moveUp = true;
                    i++;
                }
                else if ( (numberGrade >= gradeMinimum.get(i)) && (numberGrade <= gradeMaximum.get(i)) ) {
                    moveUp = false;
                    System.out.println("Letter Grade: " + letterGrades.get(i));
                }
                else {
                    moveUp = false;
                    System.out.println("Letter Grade: " + letterGrades.get(i));
                }
            }
            while (moveUp);

            System.out.println("");

            // asks user to continue, and checks for correct input
            inputCheck();

            // resets int counter i
            i = 0;
        }
        // repeats code only if the user enters 'y' or 'Y'
        while (doAgain);
    }
}