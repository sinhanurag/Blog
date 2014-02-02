package com.astfnx.Blog.DAO;

import com.astfnx.Blog.Entities.MiniBlogPostEntity;

import java.util.List;

/**
 * Created by sinhanurag on 1/30/14.
 */
public interface MiniPostDAO {

    public List<MiniBlogPostEntity> getMiniBlogPostsList(int number);
    public MiniBlogPostEntity getMiniBlogPost(int postId);


}
