package com.astfnx.Blog.ViewModel;

import java.text.SimpleDateFormat;
import java.util.List;

import com.astfnx.Blog.Entities.TimeLineEntity;
import org.springframework.ui.ModelMap;

public class TimeLineViewModel extends ModelMap{
	
	private static final String DATE = "date";
    private static final String TITLE = "title";
    private static final String POSTID = "postid";

	public TimeLineViewModel(TimeLineEntity timeLineEntity){

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");

        super.addAttribute(DATE,dateFormat.format(timeLineEntity.getDate()));
		super.addAttribute(TITLE, timeLineEntity.getTitle());
        super.addAttribute(POSTID,timeLineEntity.getPostId());

	}
	
}
