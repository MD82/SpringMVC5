package com.study.springMVC5test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class main {
    @RequestMapping(value="/")
    public String index(Model model){
        model.addAttribute("test","1234");
        return "/WEB-INF/jsp/index.jsp";
    }

    @RequestMapping(value="/{urlId}")
    public ModelAndView indexView(@PathVariable("urlId") String urlId, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        return new ModelAndView("/WEB-INF/jsp/" + urlId + ".jsp");
    }

    @RequestMapping(value="/json", produces = "application/json")
    @ResponseBody
    public Object json(){
        Map<String, String> m = new HashMap<>();
        m.put("test","1234");
        return m;
    }
}
