package com.astfnx.Blog.DAO;

import java.util.List;

import com.astfnx.Blog.Entities.TimeLineEntity;

public interface TimeLineDAO {
	
	public TimeLineEntity getTimeLineEntityByPostId(int postId);
	
	public List<TimeLineEntity> getTimeLineEntityListByYear(int year);
	
	

}
