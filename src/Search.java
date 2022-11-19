import java.util.ArrayList;
import java.util.LinkedHashSet;

import static java.lang.Character.toLowerCase;

public class Search {
    static int MAX_SEARCH_TERM = 20;

    public static ArrayList<Breakfast> SearchBreakfast(String searchTerm, ArrayList<Breakfast> breakfasts){
        //LinkedHasSet is being used because I need a list that doesn't have duplicates but also remains ordered
        LinkedHashSet<Breakfast> matchingEntries = new LinkedHashSet<>();
        ArrayList<Breakfast> list = new ArrayList<>();
        //don't make a search is its longer than max
        if(searchTerm.length()>MAX_SEARCH_TERM){
            return list;
        }

        //getting all breakfast names
        for(Breakfast breakfast: breakfasts){
            //going through breakfasts and seeing if the search term is exactly equal to the name of a breakfast regardless of case
            if(searchTerm.equalsIgnoreCase(breakfast.getPartyName())){
                //if found this will be the first result
                matchingEntries.add(breakfast);
            }
        }
        for(int i =searchTerm.length(); i>0; i--){
            //slice the searchTerm so it keeps getting smaller
            String slicedSearchTerm = searchTerm.substring(0,i);
            for(Breakfast breakfast: breakfasts){
                //geting first chars regarldess of case
                String firstChar = String.valueOf(breakfast.getPartyName().charAt(0));
                String firstCharSearch = String.valueOf(slicedSearchTerm.charAt(0));
                slicedSearchTerm = slicedSearchTerm.toLowerCase();
                String breakfastCopy = breakfast.getPartyName().toLowerCase();
                System.out.println(slicedSearchTerm);
                //if the breakfast name contains the slice of the search term as a substring and the first characters are the same add it to the list
                if(breakfastCopy.contains(slicedSearchTerm) && firstChar.equalsIgnoreCase(firstCharSearch)){
                    matchingEntries.add(breakfast);
                }
            }
        }
        for(Breakfast breakfast: breakfasts){
            //going through breakfasts and seeing if the breakfast is a substring of the search term
            if(searchTerm.contains(breakfast.getPartyName())){
                matchingEntries.add(breakfast);
            }
        }
        for(Breakfast breakfast: breakfasts){
            //seeing if the first characters are the same
            if(toLowerCase(breakfast.getPartyName().charAt(0)) == toLowerCase(searchTerm.charAt(0))){
                matchingEntries.add(breakfast);

            }
        }
        ArrayList<Breakfast> returnList = new ArrayList<>();
        returnList.addAll(matchingEntries);
        return returnList;
    }
    public static ArrayList<MenuItem> SearchMenu(String searchTerm, ArrayList<MenuItem> items){
        //LinkedHasSet is being used because I need a list that doesn't have duplicates but also remains ordered
        LinkedHashSet<MenuItem> matchingEntries = new LinkedHashSet<>();
        ArrayList<MenuItem> list = new ArrayList<>();
        //don't make a search is its longer than max
        if(searchTerm.length()>MAX_SEARCH_TERM){
            return list;
        }

        //getting all item names
        for(MenuItem item: items){
            //going through items and seeing if the search term is exactly equal to the name of an item regardless of case
            if(searchTerm.equalsIgnoreCase(item.getName())){
                //if found this will be the first result
                matchingEntries.add(item);
            }
        }
        for(int i =searchTerm.length(); i>0; i--){
            //slice the searchTerm so it keeps getting smaller
            String slicedSearchTerm = searchTerm.substring(0,i);
            for(MenuItem item: items){
                //geting first chars regarldess of case
                String firstChar = String.valueOf(item.getName().charAt(0));
                String firstCharSearch = String.valueOf(slicedSearchTerm.charAt(0));
                slicedSearchTerm = slicedSearchTerm.toLowerCase();
                String itemCopy = item.getName().toLowerCase();
                System.out.println(slicedSearchTerm);
                //if the item name contains the slice of the search term as a substring and the first characters are the same add it to the list
                if(itemCopy.contains(slicedSearchTerm) && firstChar.equalsIgnoreCase(firstCharSearch)){
                    matchingEntries.add(item);
                }
            }
        }
        for(MenuItem item: items){
            //going through items and seeing if the item is a substring of the search term
            if(searchTerm.contains(item.getName())){
                matchingEntries.add(item);
            }
        }
        for(MenuItem item: items){
            //seeing if the first characters are the same
            if(toLowerCase(item.getName().charAt(0)) == toLowerCase(searchTerm.charAt(0))){
                matchingEntries.add(item);

            }
        }
        ArrayList<MenuItem> returnList = new ArrayList<>();
        returnList.addAll(matchingEntries);
        return returnList;
    }
}
