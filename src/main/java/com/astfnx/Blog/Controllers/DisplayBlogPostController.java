package com.astfnx.Blog.Controllers;

import com.astfnx.Blog.ViewModel.ArchiveViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.astfnx.Blog.Entities.BlogPostEntity;
import com.astfnx.Blog.ServiceFacade.BlogPostServiceFacade;
import com.astfnx.Blog.ViewModel.BlogPostViewModel;

import javax.servlet.http.HttpServletRequest;


@Controller
public class DisplayBlogPostController {
	
	private BlogPostServiceFacade blogPostService;

    @RequestMapping(value="/blogPost/{postId}", method=RequestMethod.GET)
	
	public String displayBlogPost(@PathVariable String postId,Model dataModel,HttpServletRequest request){

        //BlogLogger.logInfo(DisplayBlogPostController.class,request);
		
		int postID = Integer.parseInt(postId);
		BlogPostEntity blogPost = blogPostService.getBlogPost(postID);
		
		BlogPostViewModel blogPostViewModel = new BlogPostViewModel(blogPost);

        ArchiveViewModel archiveViewModel = new ArchiveViewModel();


		dataModel.addAttribute("blogPost",blogPostViewModel);
        dataModel.addAttribute("archive",archiveViewModel);
		return "blogPost";
		
	}

	public BlogPostServiceFacade getBlogPostService() {
		return blogPostService;
	}

	public void setBlogPostService(BlogPostServiceFacade blogPostService) {
		this.blogPostService = blogPostService;
	}

}
