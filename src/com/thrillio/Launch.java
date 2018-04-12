package com.thrillio;
import com.entities.Bookmark;
import com.entities.User;
import com.managers.BookmarkManager;
import com.managers.UserManager;

public class Launch {
    private static User[] users;
    private static Bookmark[][] bookmarks;

    public static void LoadData() {
        System.out.println("loading data...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

      /*  System.out.println("Printing data....");
        printUserData();
        printBookmarkData();*/
    }

    private static void printBookmarkData() {
        for (Bookmark[] bookmarkList : bookmarks){
            for (Bookmark bookmark : bookmarkList) {
                 System.out.println(bookmark);

            }

        }
    }
    private static void printUserData() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void startBookmarking() {
       // System.out.println("\n 2. Bookmarking....");
        for (User user : users){
            View.browse(user,bookmarks);
        }
    }


    public static void main(String[] args) {
        LoadData();
        startBookmarking();

    }


}
