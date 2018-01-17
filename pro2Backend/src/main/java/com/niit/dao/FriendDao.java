package com.niit.dao;

import java.util.List;

import com.niit.model.Friend;
import com.niit.model.User;

public interface FriendDao {
List<User>suggestedUsersList(String username);
void addFriendRequest(Friend friend);
List<Friend>pendingRequests(String username);
void updatePendingRequest(Friend friend);
List<User>listOfFriends(String username);
List<User>listOfMutualFriends(String loginId,String suggestedUsername);
}
