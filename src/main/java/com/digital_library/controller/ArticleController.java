package digitLibrary.controller;


import digitLibrary.domain.Article;
import digitLibrary.service.ArticleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
@RequestMapping("/article")
public class ArticleController {

    private final Logger logger = Logger.getLogger(this.getClass());
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public String getAllArticles(ModelMap model) {
        ArrayList<Article> articles = articleService.getAllArticles();
        model.addAttribute("articles", articles);
        return "article/article-all-view";
    }

    /*@PostMapping
    public String createArticle(@RequestParam String title,
                                @RequestParam String authorName) {
        int result = articleService.createArticle(title, authorName);
        return result > 0 ? "article/success" : "article/unsuccess";
    }*/

    @PostMapping
    public String createArticle(@ModelAttribute @Valid Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            logger.warn("Article have mistake");
            return "article/unsuccess";
        }
        int result = articleService.createArticle(article);
        return result > 0 ? "article/success" : "article/unsuccess";


    }

}