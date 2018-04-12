package com.thrillio;

import com.constants.KidFriendlyStatus;
import com.constants.UserType;
import com.entities.Bookmark;
import com.entities.User;
import com.partner.Shareable;
import com.thrillio.controllers.BookmarkController;

public class View {

    public static void browse(User user, Bookmark[][] bookmarks){
        System.out.println("\n " + user.getEmail() + " is browsin items....");

        int bookmarkCount = 0;

        for (Bookmark[] bookmarkList : bookmarks) {
            for (Bookmark bookmark : bookmarkList) {
                if( bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
                    boolean isBookmark = getBookmarkDecision(bookmark);
                    if(isBookmark){
                        bookmarkCount++;
                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                        System.out.println("new item bookmark" + bookmark);
                    }

                }
                // marking as kid friendly
            if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEFEDITOR)){
                    if(bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
                      String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
                      if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)){
                          BookmarkController.getInstance().setKidFriendlyStatus(kidFriendlyStatus,bookmark);
                          bookmark.setKidFriendlyStatus(kidFriendlyStatus);
                          System.out.println("Kid friendly status is " + kidFriendlyStatus + " +" + bookmark);
                      }
                    }

                    //sharing!!
                    if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
                        && bookmark instanceof Shareable ) {
                        boolean isShared = getShareDecision();
                        if(isShared) {
                            BookmarkController.getInstance().share(user,bookmark);
                        }

                }
            }


            }
        }

    }
    //TODO: Below methds simulate user inputs. after IO we take input via console
    private static boolean getShareDecision() {
        return Math.random() < 0.5? true: false;

    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
    return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED :
            (Math.random() >=0.4 && Math.random() <0.8) ? KidFriendlyStatus.REJECT :
                    KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5 ? true : false;
    }

/*

    public static void bookmark(User user, Bookmark[][] bookmarks){
        System.out.println("\n " + user.getEmail() + " is bookmarking..");
        for (int i=0; i<DataStore.USER_BOOKMARK_LIMIT; i++){
            int typeOffset = (int)(Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffset = (int)(Math.random() * DataStore.BOOKMARK_PER_TYPE_COUNT);

            Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];

            BookmarkController.getInstance().saveUserBookmark(user, bookmark);

            System.out.println(bookmark);

            }
        }
*/

    }

