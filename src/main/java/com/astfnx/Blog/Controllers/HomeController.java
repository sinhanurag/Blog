package com.astfnx.Blog.Controllers;

import com.astfnx.Blog.Entities.MiniBlogPostEntity;
import com.astfnx.Blog.Entities.TimeLineEntity;
import com.astfnx.Blog.ServiceFacade.BlogPostServiceFacade;
import com.astfnx.Blog.ViewModel.BlogMiniViewModel;
import com.astfnx.Blog.ViewModel.TimeLineViewModel;
import com.astfnx.Blog.logger.BlogLogger;
import com.astfnx.Blog.logger.ClientInfoLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<TimeLineEntity> timeLineEntityList = blogPostService.getTimeLineByYear(2014);
        List<MiniBlogPostEntity> miniBlogPostEntities = blogPostService.getRecentMiniBlogPosts(6);

        Map<Integer,List<TimeLineViewModel>> timeLinePosts = new HashMap<Integer, List<TimeLineViewModel>>();

        List <TimeLineViewModel> timeLineViewModels = new ArrayList<TimeLineViewModel>();
        List<BlogMiniViewModel> miniPostViewModels = new ArrayList<BlogMiniViewModel>();

        for(TimeLineEntity timeLineEntity:timeLineEntityList){

            TimeLineViewModel timeLineViewModel = new TimeLineViewModel(timeLineEntity);
            timeLineViewModels.add(timeLineViewModel);
        }

        timeLinePosts.put(Integer.getInteger("2014"),timeLineViewModels);

        for(MiniBlogPostEntity miniBlogPostEntity:miniBlogPostEntities){

            BlogMiniViewModel blogMiniViewModel = new BlogMiniViewModel(miniBlogPostEntity);
            miniPostViewModels.add(blogMiniViewModel);
        }

        dataModel.addAttribute("timeLine",timeLinePosts);
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
