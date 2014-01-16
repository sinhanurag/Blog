/**
 * 
 */
package com.astfnx.Blog.ServiceFacade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.astfnx.Blog.Entities.BlogPostEntity;
import com.astfnx.Blog.DAO.BlogPostDAO;

/**
 * @author sinhanurag
 *
 */
@Service
public class BlogPostServiceFacadeImpl implements BlogPostServiceFacade {

	private BlogPostDAO blogPostDAO;
	
	@Override
	@Transactional
	public BlogPostEntity getBlogPost(int postId) {
		
		BlogPostEntity blogPost = blogPostDAO.getBlogPost(postId);
		
		return blogPost;
	}

	
	@Override
	@Transactional
	public void saveBlogPost(BlogPostEntity blogPost) {
		
		blogPostDAO.saveBlogPost(blogPost);
		

	}

	
	@Override
	@Transactional
	public void deleteBlogPost(int postId) {
		
		blogPostDAO.deleteBlogPost(postId);
		

	}


	public BlogPostDAO getBlogPostDAO() {
		return blogPostDAO;
	}


	public void setBlogPostDAO(BlogPostDAO blogPostDAO) {
		this.blogPostDAO = blogPostDAO;
	}

}
