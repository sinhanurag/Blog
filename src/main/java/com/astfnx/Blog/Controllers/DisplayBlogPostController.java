package com.astfnx.Blog.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.astfnx.Blog.Entities.BlogPostEntity;
import com.astfnx.Blog.ServiceFacade.BlogPostServiceFacade;



@Controller
public class DisplayBlogPostController {
	
	private BlogPostServiceFacade blogPostServiceFacade;
	private static final Logger logger = LoggerFactory.getLogger(DisplayBlogPostController.class);
	
	@RequestMapping(value="/blogPost/{postId}", method=RequestMethod.GET)
	
	public String displayBlogPost(@PathVariable String postId,Model datamodel){
		
		int postID = Integer.parseInt(postId);
		BlogPostEntity blogPost = blogPostServiceFacade.getBlogPost(postID);
		
		datamodel.addAttribute("serverTime", blogPost.getContent());
		
		return "home";
		
	}

	public BlogPostServiceFacade getBlogPostServiceFacade() {
		return blogPostServiceFacade;
	}

	public void setBlogPostServiceFacade(BlogPostServiceFacade blogPostServiceFacade) {
		this.blogPostServiceFacade = blogPostServiceFacade;
	}

}
