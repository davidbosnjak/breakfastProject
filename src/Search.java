import java.util.ArrayList;
import java.util.LinkedHashSet;

import static java.lang.Character.toLowerCase;

public class Search {
    static int MAX_SEARCH_TERM = 20;

    public static ArrayList<Breakfast> SearchBreakfast(String searchTerm, ArrayList<Breakfast> apps){
        //LinkedHasSet is being used because I need a list that doesn't have duplicates but also remains ordered
        LinkedHashSet<Breakfast> matchingEntries = new LinkedHashSet<>();
        ArrayList<Breakfast> list = new ArrayList<>();
        //don't make a search is its longer than max
        if(searchTerm.length()>MAX_SEARCH_TERM){
            return list;
        }

        //getting all app names
        for(Breakfast app: apps){
            //going through apps and seeing if the search term is exactly equal to the name of an app regardless of case
            if(searchTerm.equalsIgnoreCase(app.getPartyName())){
                //if found this will be the first result
                matchingEntries.add(app);
            }
        }
        for(int i =searchTerm.length(); i>0; i--){
            //slice the searchTerm so it keeps getting smaller
            String slicedSearchTerm = searchTerm.substring(0,i);
            for(Breakfast app: apps){
                //geting first chars regarldess of case
                String firstChar = String.valueOf(app.getPartyName().charAt(0));
                String firstCharSearch = String.valueOf(slicedSearchTerm.charAt(0));
                slicedSearchTerm = slicedSearchTerm.toLowerCase();
                String appCopy = app.getPartyName().toLowerCase();
                System.out.println(slicedSearchTerm);
                //if the app name contains the slice of the search term as a substring and the first characters are the same add it to the list
                if(appCopy.contains(slicedSearchTerm) && firstChar.equalsIgnoreCase(firstCharSearch)){
                    matchingEntries.add(app);
                }
            }
        }
        for(Breakfast app: apps){
            //going through apps and seeing if the app is a substring of the search term
            if(searchTerm.contains(app.getPartyName())){
                matchingEntries.add(app);
            }
        }
        for(Breakfast app: apps){
            //seeing if the first characters are the same
            if(toLowerCase(app.getPartyName().charAt(0)) == toLowerCase(searchTerm.charAt(0))){
                matchingEntries.add(app);

            }
        }
        ArrayList<Breakfast> returnList = new ArrayList<>();
        returnList.addAll(matchingEntries);
        return returnList;
    }
    public static ArrayList<MenuItem> SearchMenu(String searchTerm, ArrayList<MenuItem> apps){
        //LinkedHasSet is being used because I need a list that doesn't have duplicates but also remains ordered
        LinkedHashSet<MenuItem> matchingEntries = new LinkedHashSet<>();
        ArrayList<MenuItem> list = new ArrayList<>();
        //don't make a search is its longer than max
        if(searchTerm.length()>MAX_SEARCH_TERM){
            return list;
        }

        //getting all app names
        for(MenuItem app: apps){
            //going through apps and seeing if the search term is exactly equal to the name of an app regardless of case
            if(searchTerm.equalsIgnoreCase(app.getName())){
                //if found this will be the first result
                matchingEntries.add(app);
            }
        }
        for(int i =searchTerm.length(); i>0; i--){
            //slice the searchTerm so it keeps getting smaller
            String slicedSearchTerm = searchTerm.substring(0,i);
            for(MenuItem app: apps){
                //geting first chars regarldess of case
                String firstChar = String.valueOf(app.getName().charAt(0));
                String firstCharSearch = String.valueOf(slicedSearchTerm.charAt(0));
                slicedSearchTerm = slicedSearchTerm.toLowerCase();
                String appCopy = app.getName().toLowerCase();
                System.out.println(slicedSearchTerm);
                //if the app name contains the slice of the search term as a substring and the first characters are the same add it to the list
                if(appCopy.contains(slicedSearchTerm) && firstChar.equalsIgnoreCase(firstCharSearch)){
                    matchingEntries.add(app);
                }
            }
        }
        for(MenuItem app: apps){
            //going through apps and seeing if the app is a substring of the search term
            if(searchTerm.contains(app.getName())){
                matchingEntries.add(app);
            }
        }
        for(MenuItem app: apps){
            //seeing if the first characters are the same
            if(toLowerCase(app.getName().charAt(0)) == toLowerCase(searchTerm.charAt(0))){
                matchingEntries.add(app);

            }
        }
        ArrayList<MenuItem> returnList = new ArrayList<>();
        returnList.addAll(matchingEntries);
        return returnList;
    }
}
