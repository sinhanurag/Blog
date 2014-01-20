package com.astfnx.Blog.ViewModel;

import org.springframework.ui.ModelMap;
import com.astfnx.Blog.Entities.BlogPostEntity;

public class BlogPostViewModel extends ModelMap {
	
	private static final String POST_ID = "postid";
	private static final String DATE = "date";
	private static final String LOCATION = "location";
	private static final String TEXT_CONTENT = "text";
	private static final String TITLE = "title";
	
	public BlogPostViewModel(BlogPostEntity blogPostEntity){
		
		super.addAttribute(POST_ID, blogPostEntity.getPostId());
		super.addAttribute(DATE, blogPostEntity.getDate());
		super.addAttribute(LOCATION, blogPostEntity.getLocation());
		super.addAttribute(TEXT_CONTENT, blogPostEntity.getContent());
		super.addAttribute(TITLE, blogPostEntity.getTitle());
		
		
	}
	
	

}
