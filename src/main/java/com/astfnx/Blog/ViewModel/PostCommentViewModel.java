package com.astfnx.Blog.ViewModel;

import org.springframework.ui.ModelMap;

public class PostCommentViewModel extends ModelMap {
	
	private static final String POSTID = "postId";
	private static final String USERNAME = "user";
	private static final String COMMENT = "comment";
	
	public PostCommentViewModel(String postId,String user, String comment){
		
		super.addAttribute(POSTID, postId);
		super.addAttribute(USERNAME, user);
		super.addAttribute(COMMENT,comment);
	}

}
