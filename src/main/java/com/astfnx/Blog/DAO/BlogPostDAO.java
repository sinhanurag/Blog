
package com.astfnx.Blog.DAO;

import com.astfnx.Blog.Entities.BlogPostEntity;

import org.springframework.dao.DataAccessException;

/**
 * @author sinhanurag
 *
 */
public interface BlogPostDAO {
	
	public BlogPostEntity getBlogPost(int postId) throws DataAccessException;
	
	public void saveBlogPost(BlogPostEntity blogPost) throws DataAccessException;
	
	public void deleteBlogPost(int postId) throws DataAccessException;

}
