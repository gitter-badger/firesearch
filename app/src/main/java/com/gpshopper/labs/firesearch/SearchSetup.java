package com.gpshopper.labs.firesearch;

/**
 * Created by Emmanuel on 2/4/15.
 */
public class SearchSetup {

    //This is the value for the search menu icon
    public static int menuItemIcon = 0;


    //This is the value for the search menu container where all options menu in-app stay
    public static int menuContainer = 0;

    //This determines if the search type is a location or generic search, upon initiation
    public static boolean searchType = false;


    /* Constructor takes and assigns
    the value of options menu item
    and its menu container */
    public SearchSetup(final int menuItemIcon, final int menuContainer, final boolean searchType){
        
        this.menuItemIcon = menuItemIcon;
        this.menuContainer = menuContainer;
        this.searchType = searchType;

    }


    //Get the value of the set options menu icon
    public int getMenuItem () {
        return menuItemIcon;
    }


    //Get the value of the set menu container
    public int getMenuContainer () {
        return menuContainer;
    }


    //Get the search type. Set to false by default. If false, a generic dictionary search is initiated
    //If set to true, a user location search suggestion is initiated
    public boolean getSearchType () {
        return searchType;
    }


}
