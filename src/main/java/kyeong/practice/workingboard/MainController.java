package kyeong.practice.workingboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping(value = "/main")
    public String main (HttpServletRequest req, HttpServletResponse res, @ModelAttribute MainVO vo, Model model ){

        System.out.println("index>>>");
        if(req.getSession().getAttribute("boardList") == null){
            System.out.println("new>>>>>>>>>");

            Cookie cookie = new Cookie("JSESSIONID",req.getSession().getId());
            cookie.setMaxAge(60*60*24*365);
            res.addCookie(cookie);
            req.getSession().setAttribute("boardList",new ArrayList<MainVO>());
        }

        return "main";
    }

    @RequestMapping(value = "/read")
    public ModelAndView read (HttpServletRequest req, HttpServletResponse res, @ModelAttribute MainVO vo, Model model ){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("jsonView");

        List<MainVO> boardList = (List<MainVO>)req.getSession().getAttribute("boardList");
        Collections.sort(boardList);
        mv.addObject("boardList",boardList);

        System.out.println("read>>>>"+boardList);
        return mv;
    }

    @RequestMapping(value = "/create")
    public ModelAndView create (HttpServletRequest req, HttpServletResponse res, @ModelAttribute MainVO vo ){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("jsonView");


        List<MainVO> boardList = (List <MainVO>)req.getSession().getAttribute("boardList");

        for(int i = 0; i<boardList.size();i++){
            if(boardList.get(i).getRow_num() == vo.getRow_num()){
                boardList.remove(i);
            }
        }

        boardList.add(vo);
        Collections.sort(boardList);

        req.getSession().setAttribute("boardList",(List<MainVO>)boardList);
        System.out.println("insert>>>"+boardList);

        return mv;
    }

    @RequestMapping(value = "/delete")
    public ModelAndView delete (HttpServletRequest req, HttpServletResponse res, @ModelAttribute MainVO vo ){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("jsonView");

        List <MainVO> boardList = (List <MainVO>)req.getSession().getAttribute("boardList");

        for(int i = 0; i<boardList.size();i++){
            if(boardList.get(i).getRow_num() == vo.getRow_num()){
                boardList.remove(i);
            }
        }

        req.getSession().setAttribute("boardList",(List<MainVO>)boardList);
        System.out.println("delete>>>"+boardList);

        return mv;
    }
}
