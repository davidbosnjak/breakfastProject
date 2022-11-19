import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

class MenuAndReservations{
    public ArrayList<Breakfast> breakfasts= new ArrayList<>();
    public ArrayList<MenuItem> menuItems = new ArrayList<>();

}

public class Parser {

    //method that parses a text file into two lists
    static MenuAndReservations parseFileIntoLists(File file){
        MenuAndReservations returnValues = new MenuAndReservations();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            boolean onMenu = false;
            boolean onBreakfast = false;
            //loop through every line of the file and then split those lines into individual words. Parse those strings into the correct type and then make an object and add it to the list
            while((line = br.readLine())!= null){
                if(!onMenu && line.equals("Menu:")){onMenu=true; onBreakfast=false; continue;}
                if(!onBreakfast && line.equals("Breakfast:")){onBreakfast=true; onMenu=false; continue;}
                if(onMenu){
                    String[] menuComponents = line.split(" ");
                    int eggs = Integer.parseInt(menuComponents[1]);
                    float cost = Float.parseFloat(menuComponents[2]);
                    int milk = Integer.parseInt(menuComponents[3]);
                    int butter = Integer.parseInt(menuComponents[4]);
                    MenuItem menuItem = new MenuItem(menuComponents[0],eggs,cost,milk,butter);
                    returnValues.menuItems.add(menuItem);
                }
                //every breakfast also requires the full
                if(onBreakfast){
                    String[] breakfastComponents = line.split(" ");
                    boolean bigPortion = Boolean.parseBoolean(breakfastComponents[1]);
                    int numOfPeople = Integer.parseInt(breakfastComponents[2]);
                    String mealName = breakfastComponents[3];
                    int eggs = Integer.parseInt(breakfastComponents[4]);
                    double cost = Double.parseDouble(breakfastComponents[5]);
                    int milk = Integer.parseInt(breakfastComponents[6]);
                    int butter = Integer.parseInt(breakfastComponents[7]);
                    MenuItem item  = new MenuItem(mealName, eggs, cost, milk, butter);
                    Breakfast breakfast = new Breakfast(breakfastComponents[0], bigPortion, numOfPeople, item);
                    returnValues.breakfasts.add(breakfast);
                }

            }
            return returnValues;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    static void addInfoToFile(File file, ArrayList<Breakfast> breakfasts, ArrayList<MenuItem> menuItems){
        //start with breakfasts
        try {
            Files.write(Paths.get(file.getAbsolutePath()), "Breakfast:\n".getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //loop through breakfasts, call the toString method and add them to the file
        for(Breakfast breakfast : breakfasts){

            try {
                Files.write(Paths.get(file.getAbsolutePath()), breakfast.toString().getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            Files.write(Paths.get(file.getAbsolutePath()), "Menu:\n".getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //loop through menuItems call the toString method and add them to the file
        for(MenuItem item : menuItems){

            try {
                Files.write(Paths.get(file.getAbsolutePath()), item.toString().getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }



}
