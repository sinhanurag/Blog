package com.astfnx.Blog.ViewModel;

import java.util.List;

import org.springframework.ui.ModelMap;

public class TimeLineViewModel extends ModelMap{
	
	private static final String YEAR_TITLE_LIST = "titles";
	
	public TimeLineViewModel(List<ChronoTitleViewModel> titles){
		
		super.addAttribute(YEAR_TITLE_LIST, titles);
		
	}
	
}
