package com.astfnx.Blog.ViewModel;

import com.astfnx.Blog.Entities.MiniBlogPostEntity;
import org.springframework.ui.ModelMap;

public class BlogMiniViewModel extends ModelMap {
	
	private static final String TITLE = "title";
	private static final String SHORT_TEXT = "text";
    private static final String POST_ID = "postid";
	
	public BlogMiniViewModel(MiniBlogPostEntity blogPostEntity){
		
		super.addAttribute(TITLE, blogPostEntity.getTitle());
		super.addAttribute(SHORT_TEXT, blogPostEntity.getShortText());
        super.addAttribute(POST_ID, blogPostEntity.getPostId());
		
	}

}
