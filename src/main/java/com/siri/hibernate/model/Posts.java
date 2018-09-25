package com.siri.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@NamedQueries(  
	    {  
	        @NamedQuery(  
	        		name = "postid7ormore",  
	        		query = "from Posts  where postName='Birthday post'"  
	        )  
	        
	    }  
	)  
@Entity
@Table(name = "posts")
public class Posts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id", nullable = false)
	private int postId;
	
	@Column(name = "post_name")
	private String postName;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private FbUser fbuser;

	
	public FbUser getUser() {
		return fbuser;
	}

	public void setUser(FbUser fbuser) {
		this.fbuser = fbuser;
	}

	
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}


	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", postName=" + postName + ", fbuser=" + fbuser + "]";
	}
	
	
}
