package IO;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Week10 {
    //MAIN
     public static void main(String[] args) {

         //Create File
         try {
             PrintWriter fileOutput = new PrintWriter(
                     new BufferedWriter(
                             new FileWriter("kendallswishlist.txt")
                     )
             );
             fileOutput.println("1. A dog");
             fileOutput.println("2. A rice cooker");
             fileOutput.println("3. New heels");
             fileOutput.println("4. Water sleeping mask");
             fileOutput.println("5. A car");

             fileOutput.close();

         } catch (IOException ex) {
             System.out.println(ex);
         }
         //***New Code to get random wish list item and display**
         //Set file name
         String file = "kendallswishlist.txt";
         //Create file object
         File fileName = new File(file);
         //Open File and return a random WishList item
         String randomWishList = getRandomWishListItem(fileName);
         //Print out random wish list item
         System.out.println("Java has a good feeling you'll get ( "+randomWishList+" ) soon!");
          /*
         //Input Scanner
         Scanner keyboard = new Scanner(System.in);
         //Array list of Strings to hold wishlist items
         ArrayList<String> wishList = new ArrayList<String>();
         //Get Five Wish List Entries
         for(int itemCount = 1; itemCount<=5;itemCount++)
         {
             //Prompt for first wishlist item
             System.out.println("Enter wishlist item "+ itemCount+" : ");
             //Get first wishlist item from input stream
             String wishListItem = keyboard.nextLine();
             //Write first wishlist item to ArrayList
             wishList.add(wishListItem);
         }
         //Testing - Print out the wishList Array Items
 */
          /*  for(String wishListItems: wishList) {
             System.out.println(wishListItems);
         }

        */
         //Have user enter the name of the file to save to (.txt) file
        /*
         System.out.println("Enter the name of the file to write to (do not include extension): ");
         String fileName = keyboard.nextLine();
         //Add correct extension
         File file = new File(fileName);
         //Write to file
         writeWishListToFile(file,wishList);
*/
        /*
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
         */
    } //End main function

    //Java - Methods -
    //Open the given File read in Values and then return a random value
    private static String getRandomWishListItem(File fileName){
        //Array list of Strings to hold wishlist items
        ArrayList<String> wishList = new ArrayList<String>();
        //Open the file
        //Read in values to wishList
        readWishListFile(fileName,wishList);
        //Get random number 0 to Four
        int randomWish = getRandomInteger(5);
        System.out.println(randomWish);
        //Set random result
        String randomWishListItem = wishList.get(randomWish);
        //Return random wish
        return randomWishListItem;
    }
    //Read in wishlist from file and write to the wishlist
    private static void readWishListFile(File file, ArrayList<String> wishList) {
        try {
            //Read the file
            BufferedReader inputFile = new BufferedReader(
                    new FileReader(file));
            //Read the file
            String line = inputFile.readLine();
            while (line != null) {
                //If it is not empty skip writing
                if (!line.isEmpty()) {
                    wishList.add(line);
                }
                line = inputFile.readLine();
            }
            //Close the file
            inputFile.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }//end read wishList file
    //Return random number from 0 to maxValue
    public static int getRandomInteger(int maxValue){
        return (int) (Math.random()*maxValue);
    }








    private static void writeWishListToFile(File fileName, ArrayList<String> wishList) {
        try {
            //Write a file out - open file - doesn't exist creates a new file
            PrintWriter fileOutput = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".txt")));
            //Write to the file
            for (String wishListItem: wishList) {
                fileOutput.println(wishListItem);
            }
            //Close the file
            fileOutput.close();
        } catch (IOException ex) {
            //Print out the exception.
            System.out.println(ex);
        }
    }
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

}//End Week10 Class