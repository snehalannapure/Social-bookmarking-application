package com.entities;

import com.partner.Shareable;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Book extends Bookmark implements Shareable{
    private int publicationyear;
    private String publisher;
    private String[] authors;
    private String genre;
    private double amazonRating;

    public int getPublicationyear() {
        return publicationyear;
    }

    public void setPublicationyear(int publicationyear) {
        this.publicationyear = publicationyear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(double amazonRating) {
        this.amazonRating = amazonRating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "publicationyear=" + publicationyear +
                ", publisher='" + publisher + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", genre='" + genre + '\'' +
                ", amazonRating=" + amazonRating +
                '}';
    }


    @Override
    public boolean isKidFriendlyEligible() {
        return false;
    }

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
            builder.append("<type>book</type>");
            builder.append("<title>").append(getTitle()).append("</title>");
            builder.append("<author>").append(StringUtils.join(authors,"'")).append("</author>");
            builder.append("<publisher>").append(publisher).append("</publisher>");
            builder.append("<publicationyear>").append(publicationyear).append("</publicationyear>");

        builder.append("</item>");

        return builder.toString();


    }
}
