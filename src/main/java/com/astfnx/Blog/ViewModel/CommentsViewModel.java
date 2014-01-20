package com.astfnx.Blog.ViewModel;

import java.util.List;

import org.springframework.ui.ModelMap;

public class CommentsViewModel extends ModelMap {
	
	private static final String COMMENT_LIST = "comments";
	
	public CommentsViewModel(List<PostCommentViewModel> postCommentsList){
		
		super.addAttribute(COMMENT_LIST,postCommentsList);
	}

}
