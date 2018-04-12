package com.entities;

import com.managers.BookmarkManager;
import org.junit.Test;

import static org.junit.Assert.*;

public class WebLinkTest {

    @Test
    public void isKidFriendlyEligible() {

        //test 1: porn in url -- false
        WebLink webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com	unknown");

        boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertFalse("For porn in url - isKidFriendlyEligible() must return false", isKidFriendlyEligible);


        //test 2: porn in title -- false
        webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming porn, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com	unknown");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertFalse("For porn in title - isKidFriendlyEligible() must return false", isKidFriendlyEligible);


        //test 3: adult in host -- false
        webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.adult.com	unknown");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertFalse("For adult in host - isKidFriendlyEligible() must return false", isKidFriendlyEligible);


        //test 4: adult in url, but not in host part -- true
        webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html","http://www.javaworld.com	unknown");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertTrue("For adult in url but not host part- isKidFriendlyEligible() must return true", isKidFriendlyEligible);


        //test 5: adult in title only -- true
        webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming adult, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com	unknown");

        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        assertTrue("For adult in title only- isKidFriendlyEligible() must return true", isKidFriendlyEligible);
    }
}