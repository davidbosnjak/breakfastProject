import jdk.dynalink.StandardOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Authenticator {

    public static boolean Authenticate(String userName, String password){
        File file = new File("src/accounts.txt");
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.equals(userName+ " "+password)){
                    System.out.println("line "+line+" IS equal to "+userName+" "+password);

                    return true;
                }
                else{
                    System.out.println("line "+line+" is not equal to "+userName+" "+password);
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void makeAccount(String userName, String password){
        //add to database
        String userInfo = userName+" "+password+"\n";
        try {
            Files.write(Paths.get("src/accounts.txt"), userInfo.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
