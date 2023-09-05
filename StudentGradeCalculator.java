import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeCalculator {

    static Scanner input = new Scanner(System.in);
    static int SUBJECTS_COUNT = 5;

    static List<Integer> inputMarks(){
        List<Integer> marks = new ArrayList<>();
        for(int i = 1; i <= SUBJECTS_COUNT; i++){
            System.out.print("Enter subject " + i + ": ");
            marks.add(input.nextInt());
        }
        return marks;
    }

    static int calcTotalMarks(List<Integer> marks){
        int totalMarks = 0;
        for (Integer mark: marks){
            totalMarks += mark;
        }
        return totalMarks;
    }

    static int calcAvgPercent(int totalMarks){
        return totalMarks/SUBJECTS_COUNT;
    }

    static char calcGrade(int averagePercentage){
        char finalGrade;
        if (averagePercentage >= 90) {
            finalGrade = 'A';
        } else if (averagePercentage >= 80) {
            finalGrade = 'B';
        } else if (averagePercentage >= 70) {
            finalGrade = 'C';
        } else if (averagePercentage >= 60) {
            finalGrade = 'D';
        } else {
            finalGrade = 'F';
        }
        return finalGrade;
    }

    static void displayResults(int totalMarks, int averagePercentage, char finalGrade){
        System.out.println("Total marks: " + totalMarks);
        System.out.println("Average percentage: " + averagePercentage + "%");
        System.out.println("Final grade: " + finalGrade);
    }

    public static void main(String[] args) {
        List<Integer> listOfMarks = inputMarks();
        int totalMarks = calcTotalMarks(listOfMarks);
        int averagePercentage = calcAvgPercent(totalMarks);
        char grade = calcGrade(averagePercentage);
        displayResults(totalMarks, averagePercentage, grade);
    }

}
