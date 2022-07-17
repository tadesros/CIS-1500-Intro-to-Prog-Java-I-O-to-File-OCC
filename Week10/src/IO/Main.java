package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Do you want to 1-create/update a file or 2-read a file?");

        String choice = keyboard.nextLine();


        if(choice.equalsIgnoreCase(
                "1"))
        {

            ArrayList<String> names = new ArrayList<>();
            System.out.println("Enter a student name or DONE when finished: ");

            String name = keyboard.nextLine();
            while (!name.equalsIgnoreCase("Done")){
                names.add(name);
                System.out.println("Enter a student name or DONE when finished: ");
                name = keyboard.nextLine();
            }

            System.out.println("Enter the name of the class to save the list to: ");
            String className = keyboard.nextLine();

            //Write to a file
            try {
                //Write a file out - open file - doesn't exist creates a new file
                //Erases what was their before
                PrintWriter fileOutput = new PrintWriter(new BufferedWriter(new FileWriter(className +".txt")));
                //Write to the file
                for(String nameList : names)
                {
                    fileOutput.println(nameList);
                }
                //Close the file
                fileOutput.close();
            } catch (IOException ex) {
                //Print out the exception.
                System.out.println(ex);
            }

       }
        else {

        }






    } //End main function

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


}//End Class