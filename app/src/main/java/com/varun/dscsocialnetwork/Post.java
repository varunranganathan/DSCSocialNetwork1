package com.varun.dscsocialnetwork;

/**
 * Created by vvvro on 2/14/2018.
 */

public class Post {
    public String userName;
    public String postText;
    public String postID;

    public Post(){

    }

    public Post(String userName, String postText, String postID) {
        this.userName = userName;
        this.postText = postText;
        this.postID = postID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }
}
