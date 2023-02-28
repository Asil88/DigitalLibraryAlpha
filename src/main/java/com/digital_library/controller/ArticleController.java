package com.digital_library.controller;

import com.digital_library.domain.Article;
import com.digital_library.exception.ArticleNotFoundException;
import com.digital_library.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import java.sql.Date;
import java.util.ArrayList;


@RestController
@RequestMapping(value = "/article", produces = MediaType.APPLICATION_JSON_VALUE)
public class ArticleController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Article>> getAllArticles() {
        return new ResponseEntity<>(articleService.getAllArticles(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<HttpStatus> createArticle(@RequestBody @Valid Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                logger.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        int countChangedRows = articleService.createArticle(article);
        return new ResponseEntity<>(countChangedRows != 0 ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateArticleById(@RequestBody Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                logger.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        int countChangedRows = articleService.updateArticleById(article);
        return new ResponseEntity<>(countChangedRows != 0 ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    /* @ResponseBody*/
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        return new ResponseEntity<>(articleService.deleteArticleById(id) > 0 ? HttpStatus.NO_CONTENT : HttpStatus.CONFLICT);
    }

    @Operation(description = "Ищет артикл в бд по id",summary = "И  щем пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode="200",description = "Все ок,Артикл есть"),
            @ApiResponse(responseCode = "409",description = "Конфликт нарисовался,э?")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(
            @Parameter(description = "это id пользователя")@PathVariable int id,
            @Parameter(description = "это для массовки") String name) {
        Article article = articleService.getArticleById(id);
        return new ResponseEntity<>(article, article.getId() != 0 ? HttpStatus.OK : HttpStatus.CONFLICT);
    }







   /* @GetMapping("/{id}")
    public String getArticleById(@PathVariable int id, ModelMap model) throws ArticleNotFoundException {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "article/article-one-view";
    }

    @GetMapping
    public String getAllArticles(ModelMap model) {
        ArrayList<Article> articles = articleService.getAllArticles();
        model.addAttribute("articles", articles);
        return "article-all";
    }

    @PostMapping
    public String createArticle(@ModelAttribute @Valid Article article, BindingResult bindingResult) {
       logger.info("HELLO");
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                logger.warn(o.getDefaultMessage());
            }
            return "article/unsuccess";
        }
            int result = articleService.createArticle(article);
        return result > 0 ? "article/success" : "article/unsuccess";
    }

    @PutMapping
    @ResponseBody
    public String updateArticleById(@RequestParam long id,
                                    @RequestParam String title,
                                    @RequestParam Date dateOfCreation,
                                    @RequestParam long authorId,
                                    @RequestParam String text,
                                    @RequestParam String download) {
        int result = articleService.updateArticleById(id,title,dateOfCreation,authorId,text,download);
        return result > 0 ? "Article was updated!" : "Article wasn't updated!";
    }

   *//* @PutMapping
    @ResponseBody
    public String updateArticleById(@ModelAttribute Article article) {
        int result = articleService.updateArticleById(article);
        return result > 0 ? "Article was updated!" : "Article wasn't updated!";
    }*//*

    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable int id) {
        int result = articleService.deleteArticleById(id);
        return result > 0 ? "Article was deleted!" : "Article wasn't deleted!";
    }*/
}