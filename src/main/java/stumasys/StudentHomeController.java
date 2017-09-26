package stumasys;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.boot.autoconfigure.web.ErrorController;

import stumasys.db.Student;

@Controller
public class StudentHomeController {

    private Database db;

    @Autowired
    public void setDatabase(Database db) {
        this.db = db;
    }

    @RequestMapping(value = "/StudentHome")
    public String homeHandler(
            Model model,
            HttpServletResponse servletRes
    ){
        // TODO: return different (non-student/student) homepages depending on authorisation level
        // TODO: retrieve the list of "relevant" courses (for both non-students/students)
        Student stu = db.get
        return "StudentHome";
    }
}
