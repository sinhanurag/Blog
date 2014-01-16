/**
 * 
 */
package com.astfnx.Blog.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

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
	
	private static final Logger logger = LoggerFactory.getLogger(BlogPostDAOImpl.class); 
	
	
	@Override
	public BlogPostEntity getBlogPost(int postId) throws DataAccessException {
		
		BlogPostEntity blogPost = new BlogPostEntity();
		
		try {
			 blogPost = (BlogPostEntity)sessionFactory.getCurrentSession().get(BlogPostEntity.class, postId);
			return blogPost;
		}
		
		catch(DataAccessException ex){
			logger.info("Data Access Exception while retreiving blog Post ID : "+String.valueOf(postId)+" Stacktrace = ");
			ex.printStackTrace();
		}
		
		return blogPost;
	}

	
	@Override
	public void saveBlogPost(BlogPostEntity blogPost)
			throws DataAccessException {
		
		try{
			
			sessionFactory.getCurrentSession().save(blogPost);
		}
		
		catch(DataAccessException ex){
			logger.info("Data Access Exception while saving blog Post ID. Stacktrace = ");
			ex.printStackTrace();
		}
		

	}

	
	@Override
	public void deleteBlogPost(int postId) throws DataAccessException {
		
		try{
			
			BlogPostEntity blogPost = (BlogPostEntity) sessionFactory.getCurrentSession().load(BlogPostEntity.class,postId);
			
			if(null != blogPost){
				sessionFactory.getCurrentSession().delete(blogPost);
				logger.info("Deleted blogPost with ID "+ String.valueOf(postId));
			}
		}
		
		catch(DataAccessException ex){
			logger.info("Data Access Exception while deleting blog Post ID. "+String.valueOf(postId)+" Stacktrace = ");
			ex.printStackTrace();
		}
		

	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}

}
