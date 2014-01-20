package com.astfnx.Blog.ViewModel;

import org.springframework.ui.ModelMap;

public class ChronoTitleViewModel extends ModelMap {
	
	private static final String YEAR = "year";
	private static final String TITLE = "title";
	
	public ChronoTitleViewModel(String year, String title){
		
		super.addAttribute(YEAR, year);
		super.addAttribute(TITLE, title);
	}

}
