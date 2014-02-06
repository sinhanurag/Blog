package com.astfnx.Blog.ServiceFacade;

import java.util.Date;
import java.util.List;

import com.astfnx.Blog.Entities.BlogPostEntity;
import com.astfnx.Blog.Entities.MiniBlogPostEntity;
import com.astfnx.Blog.Entities.TimeLineEntity;

/**
 * @author sinhanurag
 *
 */
public interface BlogPostServiceFacade {
	
	public BlogPostEntity getBlogPost(int postId);
	
	public void saveBlogPost(BlogPostEntity blogPost);
	
	public void deleteBlogPost(int postId);
	
	public List<TimeLineEntity> getTimeLineByMonth(Date date);

    public List<MiniBlogPostEntity> getRecentMiniBlogPosts(int number);

}
