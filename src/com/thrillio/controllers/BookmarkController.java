package com.thrillio.controllers;

import com.entities.Bookmark;
import com.entities.User;
import com.managers.BookmarkManager;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();
    private BookmarkController() {}
    public static BookmarkController getInstance() {
        return instance;
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user, bookmark);

    }


    public void setKidFriendlyStatus(String kidFriendlyStatus, Bookmark bookmark) {
        BookmarkManager.getInstance().setKidFriendlyStatus(kidFriendlyStatus, bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().share(user,bookmark);
    }
}
