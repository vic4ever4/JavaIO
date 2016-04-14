package vic;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        File file = null;
        File file2 = null;
        try {
            file = new File(".\\out\\scores.txt");
            file2 = new File(".\\out\\scoresRename.txt");
            boolean fvar = file.createNewFile();
            if (fvar){
                System.out.println(file.getName() + " File has been created successfully");
            }
            else{
                System.out.println(file.getName() + " File already present at the specified location");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //File Renaming Code-----
        /*
        boolean flag = file.renameTo(file2);
        if(flag){
            System.out.println("File renamed successfully");
        }
        else{
            System.out.println("Rename operation failed");
        }*/
        //End File Renaming Code-----

        //File Write Code-----
        /*
        try {
            PrintWriter output = new PrintWriter(file);
            output.print("Vic Zhang ");
            output.println(100);
            output.print("Jack Gao ");
            output.println(100);
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        //End File Write Code-----

        //Copy File into File2
        FileInputStream inStream = null;
        FileOutputStream outStream = null;

        inStream = new FileInputStream(file);
        outStream = new FileOutputStream(file2);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inStream.read(buffer)) > 0) {
            outStream.write(buffer,0,length);
        }
        inStream.close();
        outStream.close();


        //***After Renaming the file to file2, reader must be reading file2 instead of file1!!!
        java.util.Scanner reader = null;
        try {
            reader = new java.util.Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (reader.hasNext()) {
            String fname = reader.next();
            String lname = reader.next();
            int score = reader.nextInt();
            System.out.println(fname + lname + " " + score);
        }
        reader.close();

        java.util.Scanner reader2 = null;
        try {
            reader2 = new java.util.Scanner(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (reader2.hasNext()) {
            String fname2 = reader2.next();
            String lname2 = reader2.next();
            int score2 = reader2.nextInt();
            System.out.println(fname2 + " " + lname2 + " " + score2);
        }
        reader.close();
    }
}
