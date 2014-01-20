package com.astfnx.Blog.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.astfnx.Blog.Entities.BlogPostEntity;
import com.astfnx.Blog.Entities.TimeLineEntity;
import com.astfnx.Blog.ServiceFacade.BlogPostServiceFacade;
import com.astfnx.Blog.ViewModel.BlogPostViewModel;


@Controller
public class DisplayBlogPostController {
	
	private BlogPostServiceFacade blogPostServiceFacade;
	private static final Logger logger = LoggerFactory.getLogger(DisplayBlogPostController.class);
	
	@RequestMapping(value="/blogPost/{postId}", method=RequestMethod.GET)
	
	public String displayBlogPost(@PathVariable String postId,Model datamodel){
		
		int postID = Integer.parseInt(postId);
		BlogPostEntity blogPost = blogPostServiceFacade.getBlogPost(postID);
		
		List<TimeLineEntity> titlesByYear = new ArrayList<TimeLineEntity> ();
		
		titlesByYear = blogPostServiceFacade.getTimeLineByYear(2014);

        logger.info(titlesByYear.toString());
		
		BlogPostViewModel blogPostViewModel = new BlogPostViewModel(blogPost);
		
		datamodel.addAttribute("blogPost",blogPostViewModel);
		return "home";
		
	}

	public BlogPostServiceFacade getBlogPostServiceFacade() {
		return blogPostServiceFacade;
	}

	public void setBlogPostServiceFacade(BlogPostServiceFacade blogPostServiceFacade) {
		this.blogPostServiceFacade = blogPostServiceFacade;
	}

}
