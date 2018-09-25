package com.siri.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.siri.hibernate.model.FbUser;
import com.siri.hibernate.model.Posts;
import com.siri.hibernate.session.HibernateSession;

public class Test {
	static SessionFactory factory = null;
	public static void main(String[] args) {
		factory = HibernateSession.buildSessionFactory();
		//addUser();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("postid7ormore");
		
		
		@SuppressWarnings("unchecked")
		List<Posts> post = (List<Posts>)query.list();
		post.forEach(item->System.out.println(item));
		System.out.println("End");
		
	}
	
	
	
	
	public static void addUser() {
		Session session =  factory.getCurrentSession();
		session.beginTransaction();
		
		FbUser fbuser = new FbUser();
		
		Posts post1 = new Posts();
		//post1.setPostId(100);
		post1.setPostName("Birthday post");
		post1.setUser(fbuser);
		
		Posts post2 = new Posts();
		//post2.setPostId(101);
		post2.setPostName("Vacation post");
		post2.setUser(fbuser);
		
		
		List<Posts> posts = new ArrayList<Posts>();
		posts.add(post1);
		posts.add(post2);
		
		//fbuser.setUserId(1);
		fbuser.setUserName("Alexander Brahmanandam");
		fbuser.setPosts(posts);
		session.saveOrUpdate(fbuser);
		
		
		
		session.getTransaction().commit();
		
	}

}
