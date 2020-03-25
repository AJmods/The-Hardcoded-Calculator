import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class writeCalc {

    /*This program writes a java program that hardcodes as many addition operations as possible
    The program takes two inputs from the user prints the output.
    See smallCalc.java for a sample program writen by this program.
     */


    static final double SIZE_IN_GB = .001; //1 MB  (Change this to whatever you feel like)

    static final String FILE_PATH = "C:\\temp"; //where this program is located
    static final String FILE_NAME = "testCalc"; //change this to whatever name you want
    static final String FILE_TYPE = ".java";

    static final int LINES_PER_GB = 22222222; //estimate number of lines of code that take up a gigabyte

    static final int LOOP_COUNT = (int) Math.sqrt(LINES_PER_GB * SIZE_IN_GB); //LOOP_COUNT is the biggest number the calculator will go to.

    public static void main(String[] args) throws IOException {

        //set up file system
        FileWriter fileWriter = new FileWriter(FILE_PATH +"\\"+ FILE_NAME + FILE_TYPE);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        //write code for the beginning of the program
        printWriter.println("import java.util.Scanner;");
        printWriter.println("public class " + FILE_NAME + " {");
        printWriter.println("   public static void main(String[] args) {");
        printWriter.println("      Scanner input = new Scanner(System.in); ");
        printWriter.println("      System.out.println(\"Enter First then second number\"); ");
        printWriter.println("       int n1 = input.nextInt();");
        printWriter.println("       int n2 = input.nextInt();");
        printWriter.println("       System.out.println(\"output is: \" + getOutput(n1,n2));");
        printWriter.println("   }");
        printWriter.println("   public static int getOutput(double n1, int n2) {");

        //these variables are used to output the percent done of
        double currentPercent = 0;
        double addPercentAmount = (1/Math.pow(LOOP_COUNT,2)) * 100;

        //write the calculator
        for (int i =0; i <LOOP_COUNT; i++)
        {
            for (int j=0; j<LOOP_COUNT; j++)
            {
                printWriter.println("       if (n1==" + i + " && n2==" + j + ") return " + (i+j)+";");
                currentPercent+=addPercentAmount;
                System.out.println("i: " + i +" j: " + j + " Percent done: " + currentPercent + "%");

            }
        }
        //finish the program.
        printWriter.println("       return -1;");
        printWriter.println("   }");
        printWriter.println("}");
        printWriter.close();

    }
}
