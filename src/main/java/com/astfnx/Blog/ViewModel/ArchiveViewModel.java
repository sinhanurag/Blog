package com.astfnx.Blog.ViewModel;

import org.springframework.ui.ModelMap;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sinhanurag on 2/6/14.
 */
public class ArchiveViewModel extends ModelMap {

    private static final String TIMELIST = "timeList";

    public ArchiveViewModel(){

        Date currentDate = new Date();
        Calendar calendar = new GregorianCalendar(2014,1,2);
        Date endDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");

         List<String> timeLines = new ArrayList<String>();

        Date iterator = currentDate;

        while (iterator.after(endDate) || iterator.equals(endDate)){

            timeLines.add(dateFormat.format(iterator));
            calendar.setTime(iterator);
            calendar.add(GregorianCalendar.MONTH,-1);
            iterator = calendar.getTime();

        }

        super.addAttribute(TIMELIST,timeLines);
    }

}
