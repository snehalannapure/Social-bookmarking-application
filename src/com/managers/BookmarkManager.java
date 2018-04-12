package com.managers;

import com.dao.BookmarkDao;
import com.entities.*;

public class BookmarkManager {
    private static BookmarkManager instance = new BookmarkManager();
    private static BookmarkDao dao  = new BookmarkDao();

    private BookmarkManager () {}

    public static BookmarkManager getInstance () {
        return instance;
    }

    public Movie createMovie (long id, String title, String profileUrl, int releaseyear, String[] cast,
                              String[] directors, String genre, double imdbRating ) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileUrl(profileUrl);
        movie.setReleaseYear(releaseyear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdbRating(imdbRating);

        return movie;

    }

    public Bookmark createBook (long id, String title, int publicationYear, String publisher,
                                String[] authors, String genre, double amazonRating ) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPublicationyear(publicationYear);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);

        return book;

    }

    public WebLink createWebLink (long id, String title, String url, String host) {
        WebLink weblink = new WebLink();
        weblink.setId(id);
        weblink.setTitle(title);
        weblink.setUrl(url);
        weblink.setHost(host);

        return weblink;
    }

    public Bookmark[][] getBookmarks() {
        return dao.getBookmarks();
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        dao.saveUserBookmark(userBookmark);

    }

    public void setKidFriendlyStatus(String kidFriendlyStatus, Bookmark bookmark) {
        bookmark.setKidFriendlyStatus(kidFriendlyStatus);
        System.out.println("Kid friendly status is " + kidFriendlyStatus + " +" + bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        bookmark.setSharedBy(user);

        System.out.println("Data to be shared:");
        if(bookmark instanceof Book) {
           System.out.println (((Book)bookmark).getItemData());
        }
        else if(bookmark instanceof WebLink){
            System.out.println (((WebLink)bookmark).getItemData());
        }
    }
}
