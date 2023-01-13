package lu.atozdigital.api.controller;


import lu.atozdigital.api.dto.ArticleDTO;
import lu.atozdigital.api.entites.Articles;
import lu.atozdigital.api.repositories.ArticleRepository;
import lu.atozdigital.api.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/articles")
public class ArticleController {

    final
    ArticleRepository articleRepository;
    private final ModelMapper modelMapper;
    private final ArticleService articleService;

    public ArticleController(ArticleRepository articleRepository, ModelMapper modelMapper, ArticleService articleService) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
        this.articleService = articleService;
    }


    @GetMapping()
    public List<ArticleDTO> getAllArticles(){
        return articleService.getAllArticle().stream().map(article -> modelMapper.map(article, ArticleDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable(name = "id") Long id) {

        try {
            Articles article = articleService.getArticleById(id);
            ArticleDTO articledto= modelMapper.map(article,ArticleDTO.class);
            return ResponseEntity.ok().body(articledto);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);        }


    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ArticleDTO> addArticle(@RequestPart(value = "article") ArticleDTO articleDTO, @RequestPart(value = "image") MultipartFile image){


        try {
            Articles reqArticle= modelMapper.map(articleDTO,Articles.class);
            Articles savedArticle=articleService.createArticle(reqArticle,image);
            ArticleDTO savedArticledto= modelMapper.map(savedArticle,ArticleDTO.class);

            return ResponseEntity.ok().body(savedArticledto);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);        }


    }


@GetMapping("/image/{image}")
    public ResponseEntity<byte[]> getImage(@PathVariable("image") String image) throws IOException {

       String path="user-photos/"+image;
        byte[] img= Files.readAllBytes(new File(path).toPath());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(img);
    }




}
