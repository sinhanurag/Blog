package com.astfnx.Blog.DAO;

import com.astfnx.Blog.Entities.TimeLineEntity;

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
		
		String queryString = "SELECT B FROM TimeLineEntity B WHERE B.postId = "+postId;
		
		try {
			
			Query queryPostId = sessionFactory.getCurrentSession().createQuery(queryString);
			timeLineEntity = (TimeLineEntity)queryPostId.uniqueResult();
		}
		
		catch(Exception ex){
			logger.info("Exception raised while getting Time Line object for postID = "+postId);
			ex.printStackTrace();
		}
		
		return timeLineEntity;
	}

	@Override
	public List<TimeLineEntity> getTimeLineEntityListByMonth(Date date) {
		
		ArrayList <TimeLineEntity>titleByYear = new ArrayList<TimeLineEntity>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List <Object> resultSet;

        Calendar dateExtractor = Calendar.getInstance();
        dateExtractor.clear();

        dateExtractor.setTime(date);

        Calendar calendar = Calendar.getInstance();
		calendar.clear();
        calendar.setTime(date);
		calendar.set(Calendar.MONTH,dateExtractor.get(Calendar.MONTH));
		calendar.set(Calendar.YEAR, dateExtractor.get(Calendar.YEAR));
		calendar.set(Calendar.DATE, 1);
		
		Date startDate = calendar.getTime();

        calendar.set(Calendar.DATE,31);
		
		Date endDate = calendar.getTime();
		
		String queryString = "SELECT B FROM TimeLineEntity B WHERE B.date >= '"+sdf.format(startDate)+"' AND B.date <= '"+sdf.format(endDate)+"'";
		
		try {
			
			Query queryYear = sessionFactory.getCurrentSession().createQuery(queryString);
			resultSet = queryYear.list();
			
			for (Object result : resultSet){
				
				titleByYear.add((TimeLineEntity)result);
			}
			

			
		}
		
		catch(Exception ex){
			logger.info("Exception raised while getting Titles for Date = "+date.toString());
			ex.printStackTrace();
		}
		
		return titleByYear;
		
		}

}
