package com.astfnx.Blog.ViewModel;

import org.springframework.ui.ModelMap;

public class BlogMiniViewModel extends ModelMap {
	
	private static final String TITLE = "title";
	private static final String SHORT_TEXT = "text";
	
	public BlogMiniViewModel(String title, String text){
		
		super.addAttribute(TITLE, title);
		super.addAttribute(SHORT_TEXT,text);
		
	}

}
