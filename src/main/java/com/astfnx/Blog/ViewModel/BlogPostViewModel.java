package com.astfnx.Blog.ViewModel;

import org.springframework.ui.ModelMap;
import com.astfnx.Blog.Entities.BlogPostEntity;

public class BlogPostViewModel extends ModelMap {
	
	public static final String POST_ID = "postid";
	public static final String DATE = "date";
	public static final String LOCATION = "location";
	public static final String TEXT_CONTENT = "text";
	public static final String TITLE = "title";
	
	public BlogPostViewModel(BlogPostEntity blogPostEntity){
		
		super.addAttribute(POST_ID, blogPostEntity.getPostId());
		super.addAttribute(DATE, blogPostEntity.getDate());
		super.addAttribute(LOCATION, blogPostEntity.getLocation());
		super.addAttribute(TEXT_CONTENT, blogPostEntity.getContent());
		super.addAttribute(TITLE, blogPostEntity.getTitle());
		
		
	}
	
	

}
