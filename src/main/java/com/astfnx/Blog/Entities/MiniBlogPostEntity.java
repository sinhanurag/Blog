package com.astfnx.Blog.Entities;

import javax.persistence.*;

/**
 * Created by sinhanurag on 1/30/14.
 */

@Entity
@Table(name="blogentries")
public class MiniBlogPostEntity {

    @Id
    @Column(name="postID")
    private int postID;

    @Column(name="title")
    private String title;

    @Column(name="shorttext")
    private String shortText;

    public String getTitle(){
        return this.title;
    }

    public String getShortText(){
        return this.shortText;
    }

    public int getPostId(){
        return this.postID;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setShortText(String shortText){
        this.shortText = shortText;
    }

    public void setPostID(int postID){
        this.postID = postID;
    }

}
