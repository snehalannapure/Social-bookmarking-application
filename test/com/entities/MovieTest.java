package com.entities;

import com.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void isKidFriendlyEligible() {

        //test1 : horror genre --false
        Movie movie = BookmarkManager.getInstance().createMovie(3000	,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},"Horror",8.5);
         boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

         assertFalse("Horror genre-- must return false",isKidFriendlyEligible);

         //test2 : thriller genre
        movie = BookmarkManager.getInstance().createMovie(3000	,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},"Thrillers",8.5);
        isKidFriendlyEligible = movie.isKidFriendlyEligible();

        assertFalse("Thriller genre - must return false",isKidFriendlyEligible);
    }
}