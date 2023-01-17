package com.bookclub.club.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    
    //**************************************** */
    //  Entity Properties
    //**************************************** */

    @Id //Denotes this property as the id/primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //auto generates
    public Integer id;

    public String title;

    public String author;

    public String published;

    public Boolean read;

    @Column(columnDefinition = "TEXT")
    public String description;

    @Column(columnDefinition = "TEXT")
    public String image;

    //**************************************** */
    //  Constructors
    //**************************************** */

    public Book(){

    }

    public Book(String title, String author, String published, Boolean read, String description, String image){
        this.title = title;
        this.author = author;
        this.published = published;
        this.read = read;
        this.description = description;
        this.image = image;
    }

    //**************************************** */
    //  GETTERS AND SETTERS
    //**************************************** */

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    // title
    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    // author
    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    // published
    public String getPublished(){
        return this.published;
    }

    public void setPublished(String published){
        this.published = published;
    }

    // read 
    public Boolean isRead(){
        return this.read;
    }

    public void setRead(Boolean read){
        this.read = read;
    }

    // description
    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    // image
    public String getImage(){
        return this.image;
    }

    public void setImage(String image){
        this.image = image;
    }
}
