package com.astfnx.Blog.DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.astfnx.Blog.Entities.TimeLineEntity;


@Repository("TimeLineDAO")
public class TimeLineDAOImpl implements TimeLineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = LoggerFactory.getLogger(TimeLineDAOImpl.class);

	@Override
	public TimeLineEntity getTimeLineEntityByPostId(int postId) {
		
		TimeLineEntity timeLineEntity = new TimeLineEntity();
		
		String queryString = "SELECT B.postId, B.date, B.title FROM TimeLineEntity B WHERE B.postId = "+postId;
		
		try {
			
			Query queryPostId = sessionFactory.getCurrentSession().createQuery(queryString);
			timeLineEntity = (TimeLineEntity)queryPostId.uniqueResult();
			
			return timeLineEntity;
			
		}
		
		catch(Exception ex){
			logger.info("Excpetion raised while getting Time Line object for postID = "+postId);
			ex.printStackTrace();
		}
		
		return timeLineEntity;
	}

	@Override
	public List<TimeLineEntity> getTimeLineEntityListByYear(int year) {
		
		ArrayList <TimeLineEntity>titleByYear = new ArrayList<TimeLineEntity>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List <Object> resultSet;
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.MONTH,Calendar.JANUARY);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DATE, 1);
		
		Date startDate = calendar.getTime();
		
		calendar.clear();
		
		calendar.set(Calendar.MONTH,Calendar.DECEMBER);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DATE,31);
		
		Date endDate = calendar.getTime();
		
		String queryString = "SELECT B FROM TimeLineEntity B WHERE B.date >= '"+sdf.format(startDate)+"' AND B.date <= '"+sdf.format(endDate)+"'";
		
		try {
			
			Query queryYear = sessionFactory.getCurrentSession().createQuery(queryString);
			resultSet = queryYear.list();
			
			for (Object result : resultSet){
				
				titleByYear.add((TimeLineEntity)result);
			}
			
			return titleByYear;
			
		}
		
		catch(Exception ex){
			logger.info("Excpetion raised while getting Titles for year = "+year);
			ex.printStackTrace();
		}
		
		return titleByYear;
		
		}

}
