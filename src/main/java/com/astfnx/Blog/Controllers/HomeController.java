package com.astfnx.Blog.Controllers;

import com.astfnx.Blog.Entities.MiniBlogPostEntity;
import com.astfnx.Blog.ServiceFacade.BlogPostServiceFacade;
import com.astfnx.Blog.Util.content.ContentModel;
import com.astfnx.Blog.Util.content.populateXMLContent;
import com.astfnx.Blog.ViewModel.ArchiveViewModel;
import com.astfnx.Blog.ViewModel.BlogMiniViewModel;
import com.astfnx.Blog.Util.logger.BlogLogger;
import com.astfnx.Blog.Util.logger.ClientInfoLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */

    private BlogPostServiceFacade blogPostService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model dataModel,HttpServletRequest request) {

        HttpServletRequest requestObject = (HttpServletRequest) request;

         ClientInfoLog clientInfoLog = new ClientInfoLog(requestObject);

        BlogLogger.logInfo(HomeController.class,clientInfoLog);

        ArchiveViewModel archiveViewModel = new ArchiveViewModel();

        List<MiniBlogPostEntity> miniBlogPostEntities = blogPostService.getRecentMiniBlogPosts(6);

        List<BlogMiniViewModel> miniPostViewModels = new ArrayList<BlogMiniViewModel>();

        for(MiniBlogPostEntity miniBlogPostEntity:miniBlogPostEntities){

            BlogMiniViewModel blogMiniViewModel = new BlogMiniViewModel(miniBlogPostEntity);
            miniPostViewModels.add(blogMiniViewModel);
        }

        dataModel.addAttribute("archive",archiveViewModel);
        dataModel.addAttribute("miniPosts", miniPostViewModels);
		
		return "home";
	}

    public BlogPostServiceFacade getBlogPostService() {
        return blogPostService;
    }

    public void setBlogPostService(BlogPostServiceFacade blogPostService) {
        this.blogPostService = blogPostService;
    }


}
