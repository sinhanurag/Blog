package com.astfnx.Blog.ServiceFacade;

import com.astfnx.Blog.Entities.BlogPostEntity;

/**
 * @author sinhanurag
 *
 */
public interface BlogPostServiceFacade {
	
	public BlogPostEntity getBlogPost(int postId);
	
	public void saveBlogPost(BlogPostEntity blogPost);
	
	public void deleteBlogPost(int postId);

}
