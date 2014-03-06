package com.astfnx.Blog.Controllers;

import com.astfnx.Blog.Entities.BlogPostEntity;
import com.astfnx.Blog.ServiceFacade.BlogPostServiceFacade;
import com.astfnx.Blog.Util.content.ContentModel;
import com.astfnx.Blog.Util.content.populateXMLContent;
import com.astfnx.Blog.ViewModel.ArchiveViewModel;
import com.astfnx.Blog.ViewModel.BlogPostViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by sinhanurag on 2/9/14.
 */
@Controller
public class DisplayOthersController {

    private populateXMLContent populateXMLContent;

    @RequestMapping(value={"/about","/contact","/pageNotFound"}, method= RequestMethod.GET)

    public String displayBlogPost(Model dataModel,HttpServletRequest request){

        //BlogLogger.logInfo(DisplayBlogPostController.class,request);

        String resourceName = request.getRequestURI();
        ContentModel contentModel = new ContentModel();

        ArchiveViewModel archiveViewModel = new ArchiveViewModel();

        try {
            contentModel = populateXMLContent.readContentFromKey(resourceName);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        dataModel.addAttribute("archive",archiveViewModel);
        dataModel.addAttribute("content",contentModel.getValue());

        return "othersDisplay";

    }


    public populateXMLContent getPopulateXMLContent() {
        return populateXMLContent;
    }

    public void setPopulateXMLContent(populateXMLContent populateXMLContent) {
        this.populateXMLContent = populateXMLContent;
    }
}
