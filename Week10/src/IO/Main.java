package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //MAIN
    public static void main(String[] args) {
        //Input Scanner
        Scanner keyboard = new Scanner(System.in);
        //Prompt main option
        System.out.println("Do you want to 1 - create/update a file or 2-read a file?");
        //Get Choice
        String choice = keyboard.nextLine();
        //Check Main Choice
        if(choice.equalsIgnoreCase("1")) {
            //Get filename
            System.out.println("Enter the name of the class to save the list to: ");
            String className = keyboard.nextLine();
            //Add correct extension
            File file = new File(className + ".txt");

            //File does not exist
            if (!file.exists()) {
                ArrayList<Student> students = new ArrayList<>();
                //Add Names
                addStudentsToList(keyboard, students);
                //Write to a file
                writeFile(className, students);
            }
            //File Does Exist
            else {
                ArrayList<Student> students = new ArrayList<>();
                readFileIntoList(file, students);

                System.out.println("Names currently in the file: ");

                for (Student student : students) {
                    System.out.println(student.getName());
                }

                System.out.println("Do you want to add any? y/n");
                String add = keyboard.nextLine();
                if (add.equalsIgnoreCase("y")) {
                    addStudentsToList(keyboard, students);
                }
                    //Write the file again
                    writeFile(className, students);
            }
        }
        else if(choice.equalsIgnoreCase("2")){
            ArrayList<Student> students = new ArrayList<>();
            //Get filename
            System.out.println("Enter the name of the class to save the list to: ");
            String className = keyboard.nextLine();

            //Add correct extension
            File file = new File(className + ".txt");

            readFileIntoList(file,students);

            //Print them out
            for(Student student: students){
                System.out.println(student.getStringForFileOutput());
            }


        }

    } //End main function

    private static void readFileIntoList(File file, ArrayList<Student> students) {
        try {
            //Read the file
            BufferedReader inputFile = new BufferedReader(
                    new FileReader(file));
            //Read the file
            String line = inputFile.readLine();
            while (line != null) {
                //If it is not empty skip writing
                if (!line.isEmpty()) {
                   String[] values =  line.split("\\|");
                    students.add(new Student(values[0],Integer.parseInt(values[1])));
                }
                line = inputFile.readLine();
            }
            //Close the file
            inputFile.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //METHODS
    private static void addStudentsToList(Scanner keyboard, ArrayList<Student> students) {
        System.out.println("Enter a student name or DONE to be all done: ");
        String name = keyboard.nextLine();

        System.out.println("Enter their Score ");
        int score = Integer.parseInt(keyboard.nextLine());

        while (!name.equalsIgnoreCase("Done")) {
            students.add(new Student(name,score));
            System.out.println("Enter a student name or DONE when finished: ");
            name = keyboard.nextLine();
            System.out.println("Enter their Score ");
            score = Integer.parseInt(keyboard.nextLine());
        }
    }
    private static void writeFile(String className, ArrayList<Student> students) {
        try {
            //Write a file out - open file - doesn't exist creates a new file
            PrintWriter fileOutput = new PrintWriter(new BufferedWriter(new FileWriter(className + ".txt")));
            //Write to the file
            for (Student student: students) {
                fileOutput.println(student.getStringForFileOutput());
            }
            //Close the file
            fileOutput.close();
        } catch (IOException ex) {
            //Print out the exception.
            System.out.println(ex);
        }
    }
    public static void fileExample(){
        //Write to a file
        try {
            //Write a file out - open file - doesn't exist creates a new file
            //Erases what was their before
            PrintWriter fileOutput = new PrintWriter(new BufferedWriter(new FileWriter("test.txt")));
            //Write to the file
            fileOutput.println("Test Test Test");
            fileOutput.println("1 2 3");
            //Close the file
            fileOutput.close();
        } catch (IOException ex) {
            //Print out the exception.
            System.out.println(ex);
        }

        //Read from a file
        File file = new File("test.txt");
        //Make sure the file exist
        if(file.exists()){
            try{
                //Open the file
                BufferedReader inputFile = new BufferedReader(
                        new FileReader(file));
                //Read the file
                String line = inputFile.readLine();
                while(line!=null){
                    System.out.println(line);
                    line = inputFile.readLine();
                }
                //Close the file
                inputFile.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        else{
            System.out.println("Doesn't exist");
        }
    }

}//End Main Class