/**
 * 
 */
package com.astfnx.Blog.ServiceFacade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.astfnx.Blog.Entities.BlogPostEntity;
import com.astfnx.Blog.Entities.TimeLineEntity;
import com.astfnx.Blog.DAO.BlogPostDAO;
import com.astfnx.Blog.DAO.TimeLineDAO;

/**
 * @author sinhanurag
 *
 */
@Service
public class BlogPostServiceFacadeImpl implements BlogPostServiceFacade {

	private BlogPostDAO blogPostDAO;
	private TimeLineDAO timeLineDAO;
	
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
	
	@Override
	@Transactional
	public List<TimeLineEntity> getTimeLineByYear(int year){
		
		List<TimeLineEntity> titlesByYear = new ArrayList<TimeLineEntity>();
		
		titlesByYear = timeLineDAO.getTimeLineEntityListByYear(year);
		
		return titlesByYear;
		
	}


	public BlogPostDAO getBlogPostDAO() {
		return blogPostDAO;
	}


	public void setBlogPostDAO(BlogPostDAO blogPostDAO) {
		this.blogPostDAO = blogPostDAO;
	}


	public TimeLineDAO getTimeLineDAO() {
		return timeLineDAO;
	}


	public void setTimeLineDAO(TimeLineDAO timeLineDAO) {
		this.timeLineDAO = timeLineDAO;
	}

}
