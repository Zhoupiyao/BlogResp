package com.zhoupiyao.controller;

import com.zhoupiyao.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/search")
    public String search(@PageableDefault(size = 2, sort = {"views"},
            direction = Sort.Direction.DESC) Pageable pageable, Model model, @RequestParam String queryContent) {
        model.addAttribute("page", blogService.listQueryBlog(pageable, "%" + queryContent + "%"));
        model.addAttribute("queryContent", queryContent);
        System.out.println(blogService.listQueryBlog(pageable, "%" + queryContent + "%"));
        return "searchResult";
    }
}
