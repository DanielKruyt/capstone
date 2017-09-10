package stumasys;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.boot.autoconfigure.web.ErrorController;
import java.util.Hashtable;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;

@RestController         // response functionality
@RequestMapping("/course/**")
public class CourseController {
    /*

    @Autowired      // links this with the CourseService
    CourseService cs;

    @RequestMapping(value = "/all")
    public Hashtable<String, Courses> getAll(){
        return cs.getAll();
    }
    @RequestMapping(value = "/{key}")       // something is wrong here...to tired to know what
    public Courses getCourse(@PathVariable("key") String key){
        return cs.getCourse(key);
    }
    */
    @RequestMapping(value = "/course/{year}/{courseCode}") // sorry for commenting out all of your code
    public String courseHandler(
            @PathVariable String year,
            @PathVariable String courseCode,
            Model model,
            HttpServletResponse servletRes
    ){
        model.addAttribute("courseCode", courseCode);
        model.addAttribute("year", year);

        // TODO: load more actual content into the Model (requires simultaneous work on the HTML template)

        return "course";
    }
}
