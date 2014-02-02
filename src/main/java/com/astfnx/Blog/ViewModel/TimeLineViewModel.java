package com.astfnx.Blog.ViewModel;

import java.util.List;

import com.astfnx.Blog.Entities.TimeLineEntity;
import org.springframework.ui.ModelMap;

public class TimeLineViewModel extends ModelMap{
	
	private static final String TITLE = "title";
    private static final String POSTID = "postid";

	public TimeLineViewModel(TimeLineEntity timeLineEntity){
		
		super.addAttribute(TITLE, timeLineEntity.getTitle());
        super.addAttribute(POSTID,timeLineEntity.getPostId());
		
	}
	
}
