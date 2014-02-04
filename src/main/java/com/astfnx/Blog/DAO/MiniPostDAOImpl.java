package com.astfnx.Blog.DAO;

import com.astfnx.Blog.Entities.MiniBlogPostEntity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by sinhanurag on 1/31/14.
 */
@Repository("MiniPostDAO")
public class MiniPostDAOImpl implements MiniPostDAO {

    @Autowired
    SessionFactory sessionFactory;

    private Logger logger = LoggerFactory.getLogger(MiniPostDAOImpl.class);

    @Override
    public List<MiniBlogPostEntity> getMiniBlogPostsList(int number) {

        int totalRecords = 0;
        Long total_rec = new Long(0);
        String queryString = new String();
        List<Object> resultSet;
        ArrayList<MiniBlogPostEntity> miniPostList = new ArrayList<MiniBlogPostEntity>();

        String countRecordsQueryString = "SELECT COUNT(*) FROM MiniBlogPostEntity B";

        try{

            Query queryNumberOfRecords = sessionFactory.getCurrentSession().createQuery(countRecordsQueryString);
            total_rec = (Long) queryNumberOfRecords.uniqueResult();
            totalRecords = total_rec.intValue();
           }

        catch(Exception ex){

            logger.info("Exception raised while trying to get total records in DataBase");
            ex.printStackTrace();

        }

        if(totalRecords<number) {

            queryString = "SELECT B FROM MiniBlogPostEntity B ";
        }

        else{

            queryString = "SELECT B FROM MiniBlogPostEntity B WHERE B.postID>="+(totalRecords-number);
        }

        try{

            Query queryMiniBlogPosts = sessionFactory.getCurrentSession().createQuery(queryString);
            resultSet = queryMiniBlogPosts.list();

            for(Object result:resultSet){
                miniPostList.add((MiniBlogPostEntity)result);
            }

        }

        catch(Exception ex){
            logger.info("Exception raised while trying to get list of miniBlogPosts");
            ex.printStackTrace();
        }

        return miniPostList;
    }

    @Override
    public MiniBlogPostEntity getMiniBlogPost(int postId) {

        MiniBlogPostEntity miniBlogPost = new MiniBlogPostEntity();

        String queryString = "SELECT B FROM MiniBlogPostEntity B WHERE B.postID = "+postId;

        try{
            Query miniPostQuery = sessionFactory.getCurrentSession().createQuery(queryString);
            miniBlogPost = (MiniBlogPostEntity) miniPostQuery.uniqueResult();


        }

        catch(Exception ex){

            logger.info("Exception raised while querying for Mini Blog Post with postID = "+postId);
        }


        return miniBlogPost;
    }
}
