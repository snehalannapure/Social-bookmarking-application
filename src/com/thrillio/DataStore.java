package com.thrillio;

import com.constants.Gender;
import com.constants.UserType;
import com.entities.Bookmark;
import com.entities.User;
import com.entities.UserBookmark;
import com.managers.BookmarkManager;
import com.managers.UserManager;
import com.util.IOUtil;

public class DataStore {
    public static final int TOTAL_USER_COUNT = 5;
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int BOOKMARK_PER_TYPE_COUNT= 5;
    public static final int USER_BOOKMARK_LIMIT = 5;

    private static User[] users = new User[TOTAL_USER_COUNT];
    public static User[] getUsers() {
        return users;
    }



    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_PER_TYPE_COUNT];
    public static Bookmark[][] getBookmarks() {
        return bookmarks;
    }

    private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
    private static int bookmarkIndex;

    public static void loadData() {
        loadUser();
        loadWebLinks();
        loadMovie();
        loadBooks();
    }

    private static void loadBooks() {
        /*bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000,"	Walden",	1854,"Wilder Publications",new String[]{"	Henry David Thoreau"}, "Philosophy",4.3);
        bookmarks[2][1] = BookmarkManager.getInstance().createBook(4001,"	Self-Reliance and Other Essays",	1854,"Wilder Publications",new String[]{"	Henry David Thoreau"}, "Philosophy",4.3);
        bookmarks[2][2] = BookmarkManager.getInstance().createBook(4002,"	Light From Many Lamps",	1854,"Wilder Publications",new String[]{"	Henry David Thoreau"}, "Philosophy",4.3);
        bookmarks[2][3] = BookmarkManager.getInstance().createBook(4003,"	Head First Design Patterns",	1854,"Wilder Publications",new String[]{"	Henry David Thoreau"}, "Philosophy",4.3);
        bookmarks[2][4] = BookmarkManager.getInstance().createBook(4004,"	Effective Java Programming Language Guide",	1854,"Wilder Publications",new String[]{"Prentice Hall","Joshua Bloch"}, "Philosophy",4.3);
*/

        String[] data = new String[BOOKMARK_PER_TYPE_COUNT];
        IOUtil.read(data, "Book");
        int colNum = 0;
        for (String row : data) {
            String[] values = row.split("\t");
            String[] authors = values[4].split(",");
            bookmarks[2][colNum++] = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3], authors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
        }
    }

    private static void loadMovie() {
        /*bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000	,"Citizen Kane","",1941,new String[]{"Orson Welles","Joseph Cotten"}, new String[] {"Orson Welles"},"Classics",8.5);
        bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001	,"The Grapes of Wrat","",	1940,new String[]{"Henry Fonda","Jane Darwell"}, new String[] {"John Ford	"},"Classics",8.2);
        bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002	,"A Touch of Greatnesse","",1941,new String[]{"Albert Cullum"}, new String[] {"Leslie Sullivan"},"Classics",8.5);
        bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003	,"The Big Bang Theory","",1941,new String[]{"Orson Welles,Joseph Cotten"}, new String[] {"Orson Welles"},"Classics",8.5);
        bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004	,"Ikiru","",1941,new String[]{"Orson Welles,Joseph Cotten"}, new String[] {"Orson Welles"},"Classics",8.5);
*/

        String[] data = new String[BOOKMARK_PER_TYPE_COUNT];
        IOUtil.read(data, "Movie");
        int colNum = 0;
        for (String row : data) {
            String[] values = row.split("\t");
            String[] cast = values[3].split(",");
            String[] directors = values[4].split(",");
            bookmarks[1][colNum++] = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), cast, directors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
        }
    }

    private static void loadWebLinks() {
        /*bookmarks[0][0] = BookmarkManager.getInstance().createWebLink(2000,	"Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com	unknown");
        bookmarks[0][1] = BookmarkManager.getInstance().createWebLink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com");
        bookmarks[0][2] = BookmarkManager.getInstance().createWebLink(2002,"nterface vs Abstract Class","http://mindprod.com/jgloss/interfacevsabstract.html","http://mindprod.com");
        bookmarks[0][3] = BookmarkManager.getInstance().createWebLink(2003,"NIO tutorial by Greg Travis","http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf","http://cs.brown.edu");
        bookmarks[0][4] = BookmarkManager.getInstance().createWebLink(2004,"Virtual Hosting and Tomcat","http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html","http://tomcat.apache.org");*/

        String[] data = new String[BOOKMARK_PER_TYPE_COUNT];
        IOUtil.read(data, "Web-Link");
        int colNum = 0;
        for (String row : data) {
            String[] values = row.split("\t");
            bookmarks[0][colNum++] = BookmarkManager.getInstance().createWebLink(Long.parseLong(values[0]), values[1], values[2], values[3]/*, values[4]*/);
        }

    }

    private static void loadUser() {
       /* users[0] = UserManager.getInstance().createUser(1000,"user0@semanticsquare.com", "test","John", Gender.MALE, UserType.USER);
        users[1] = UserManager.getInstance().createUser(1001,"user0@semanticsquare.com", "test","Sam", Gender.MALE, UserType.USER);
        users[2] = UserManager.getInstance().createUser(1002,"user0@semanticsquare.com", "test","Anita", Gender.FEMALE, UserType.EDITOR);
        users[3] = UserManager.getInstance().createUser(1003,"user0@semanticsquare.com", "test","Sara", Gender.FEMALE, UserType.EDITOR);
        users[4] = UserManager.getInstance().createUser(1004,"user0@semanticsquare.com", "test","Dheeru", Gender.FEMALE, UserType.CHIEFEDITOR);*/

        String[] data = new String[TOTAL_USER_COUNT];
        IOUtil.read(data, "User");
        int rowNum = 0;
        for (String row : data) {
            String[] values = row.split("\t");

            int gender = Gender.MALE;
            if (values[5].equals("f")) {
                gender = Gender.FEMALE;
            } else if (values[5].equals("t")) {
                gender = Gender.TRANSGENDER;
            }

            users[rowNum++] = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2], values[3], values[4], gender, values[6]);
        }

    }

    public static void add(UserBookmark userBookmark) {
        userBookmarks[bookmarkIndex] = userBookmark;
        bookmarkIndex++;

    }
}

