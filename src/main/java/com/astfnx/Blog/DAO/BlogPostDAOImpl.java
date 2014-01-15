/**
 * 
 */
package com.astfnx.Blog.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.astfnx.Blog.Entities.BlogPostEntity;

import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

/**
 * @author sinhanurag
 *
 */

@Repository("BlogPostDAO")

public class BlogPostDAOImpl implements BlogPostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public BlogPostEntity getBlogPost(int postId) throws DataAccessException {
		
		return null;
	}

	
	@Override
	public void saveBlogPost(BlogPostEntity blogPost)
			throws DataAccessException {
		

	}

	
	@Override
	public void deleteBlogPost(int postId) throws DataAccessException {
		

	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}

}
