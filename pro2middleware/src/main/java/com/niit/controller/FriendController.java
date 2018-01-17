package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.FriendDao;
import com.niit.model.ErrorClazz;
import com.niit.model.Friend;
import com.niit.model.User;

@Controller
public class FriendController {
@Autowired
private FriendDao friendDao;
@RequestMapping(value="/suggestedusers",method=RequestMethod.GET)
public ResponseEntity<?> getSuggestedUsers(HttpSession session){
	String username=(String)session.getAttribute("username");
	if(username==null){
		ErrorClazz error=new ErrorClazz(5,"Unauthorized access");
		return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
	}
	List<User>suggestedUsers=friendDao.suggestedUsersList(username);
	return new ResponseEntity<List<User>>(suggestedUsers,HttpStatus.OK);
}

@RequestMapping(value="/addfriendrequest/{toId}",method=RequestMethod.POST)
public ResponseEntity<?>addFriendRequest(@PathVariable String toId,HttpSession session){
	String username=(String)session.getAttribute("username");
	if(username==null){
		ErrorClazz error=new ErrorClazz(5,"Unauthorized access");
		return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
}
	Friend friend=new Friend();
	friend.setFromId(username);
	friend.setToId(toId);
	friend.setStatus('P');
	friendDao.addFriendRequest(friend);
	return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	
}
@RequestMapping(value="/pendingrequests",method=RequestMethod.GET)
public ResponseEntity<?>pendingRequests(HttpSession session){
	String username=(String)session.getAttribute("username");
	if(username==null){
		ErrorClazz error=new ErrorClazz(5,"Unauthorized access");
		return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
}
	List<Friend>pendingRequests=friendDao.pendingRequests(username);
	return new ResponseEntity<List<Friend>>(pendingRequests,HttpStatus.OK);
}
@RequestMapping(value="/updatependingrequest",method=RequestMethod.PUT)
public ResponseEntity<?>updatePendingRequest(@RequestBody Friend friend,HttpSession session){
	String username=(String)session.getAttribute("username");
	if(username==null){
		ErrorClazz error=new ErrorClazz(5,"Unauthorized access");
		return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
	}
	friendDao.updatePendingRequest(friend);
	return new ResponseEntity<Void>(HttpStatus.OK);
}

@RequestMapping(value="/getfriends",method=RequestMethod.GET)
public ResponseEntity<?>getListOfFriends(HttpSession session){
	String username=(String)session.getAttribute("username");
	if(username==null){
		ErrorClazz error=new ErrorClazz(5,"Unauthorized access");
		return new ResponseEntity<ErrorClazz>(error,HttpStatus.UNAUTHORIZED);
	}
	List<User> friends=friendDao.listOfFriends(username);
	return new ResponseEntity<List<User>>(friends,HttpStatus.OK);
	
}

}