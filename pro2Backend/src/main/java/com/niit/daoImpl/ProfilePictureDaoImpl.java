package com.niit.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ProfilePictureDao;
import com.niit.model.ProfilePicture;

@Repository
@Transactional
public class ProfilePictureDaoImpl implements ProfilePictureDao{
@Autowired
private SessionFactory sessionFactory;
	public void saveOrUpdateProfilePicture(ProfilePicture profilePicture) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);
	}

	public ProfilePicture getProfilePicture(String username) {
		Session session=sessionFactory.getCurrentSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, username);
		return profilePicture;
	
	
	}
	

}
