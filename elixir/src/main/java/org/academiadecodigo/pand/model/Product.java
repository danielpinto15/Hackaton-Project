package org.academiadecodigo.pand.model;


public class Product {

    private String id;
    private String name;
    private String smallDescription;
    private String bigDescription;
    private User user;
    private String photoUrl;
    private String testimonialsPhotoUrl;

    public Product(String id, String name, String smallDescription, String bigDescription, String photoUrl, String testimonialsPhotoUrl){

        this.id = id;
        this.name = name;
        this.smallDescription = smallDescription;
        this.bigDescription = bigDescription;
        this.photoUrl = photoUrl;
        this.testimonialsPhotoUrl = testimonialsPhotoUrl;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getBigDescription() {
        return bigDescription;
    }

    public void setBigDescription(String bigDescription) {
        this.bigDescription = bigDescription;
    }

    public String getTestimonialsPhotoUrl() {
        return testimonialsPhotoUrl;
    }

    public void setTestimonialsPhotoUrl(String testimonialsPhotoUrl) {
        this.testimonialsPhotoUrl = testimonialsPhotoUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
