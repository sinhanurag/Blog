package com.astfnx.Blog.Controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.astfnx.Blog.Entities.BlogPostEntity;
import com.astfnx.Blog.InputModel.BlogPostInputModel;
import com.astfnx.Blog.ServiceFacade.BlogPostServiceFacade;



@Controller
@SessionAttributes
public class CreateBlogPostController {
	
	private BlogPostServiceFacade blogPostServiceFacade;
	private static final Logger logger = LoggerFactory.getLogger(CreateBlogPostController.class);
	
	@RequestMapping(value="/createBlogPost", method=RequestMethod.POST)
	
	public String createBlogPost(@ModelAttribute BlogPostInputModel blogPostInput,BindingResult result){
		
		BlogPostEntity blogPostEntity = new BlogPostEntity();
		
		Date date = new Date();
		
		blogPostEntity.setDate(date);
		blogPostEntity.setLocation(blogPostInput.getLocation());
		blogPostEntity.setContent(blogPostInput.getContent());
		blogPostEntity.setTitle(blogPostInput.getTitle());
		
		blogPostServiceFacade.saveBlogPost(blogPostEntity);
		
		return "home";
		
	}
	
	@RequestMapping(value="/addBlogPost")
	
	public ModelAndView showAddBlogPage(){
		
		return new ModelAndView("CreateBlogPost","command",new BlogPostInputModel());
	}

	public BlogPostServiceFacade getBlogPostServiceFacade() {
		return blogPostServiceFacade;
	}

	public void setBlogPostServiceFacade(BlogPostServiceFacade blogPostServiceFacade) {
		this.blogPostServiceFacade = blogPostServiceFacade;
	}

}
