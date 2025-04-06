package com.example.socialnetwork.model;

import java.util.Date;

public class Follow {
    private int followingUserId;
    private int followedUserId;
    private Date createdAt;

    // Getters và Setters
    public int getFollowingUserId() { return followingUserId; }
    public void setFollowingUserId(int followingUserId) { this.followingUserId = followingUserId; }

    public int getFollowedUserId() { return followedUserId; }
    public void setFollowedUserId(int followedUserId) { this.followedUserId = followedUserId; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
