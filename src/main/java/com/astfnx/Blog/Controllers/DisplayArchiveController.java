package com.astfnx.Blog.Controllers;

import com.astfnx.Blog.Entities.TimeLineEntity;
import com.astfnx.Blog.ServiceFacade.BlogPostServiceFacade;
import com.astfnx.Blog.ViewModel.ArchiveViewModel;
import com.astfnx.Blog.ViewModel.TimeLineViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by sinhanurag on 2/6/14.
 */

@Controller
public class DisplayArchiveController {

    private BlogPostServiceFacade blogPostService;

    Date date = new Date();

    @RequestMapping(value="archive/{time}" , method = RequestMethod.GET)

    public String getArchiveForMonth(@PathVariable String time,Model dataModel){

        try{

              date = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH).parse(time);
        }

        catch(Exception ex){

            System.out.println("Invalid date passed");
            ex.printStackTrace();
        }

        List<TimeLineEntity> timeLineEntities = blogPostService.getTimeLineByMonth(date);

        List<TimeLineViewModel> timeLineViewModels = new ArrayList<TimeLineViewModel>();

        ArchiveViewModel archiveViewModel = new ArchiveViewModel();

        for(TimeLineEntity timeLineEntity : timeLineEntities){

            timeLineViewModels.add(new TimeLineViewModel(timeLineEntity));
         }

        dataModel.addAttribute("timeLines",timeLineViewModels);
        dataModel.addAttribute("time",time);
        dataModel.addAttribute("archive",archiveViewModel);

        return "archive";
      }


    public BlogPostServiceFacade getBlogPostService() {
        return blogPostService;
    }

    public void setBlogPostService(BlogPostServiceFacade blogPostService) {
        this.blogPostService = blogPostService;
    }
}
