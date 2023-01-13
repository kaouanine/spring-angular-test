package lu.atozdigital.api.service;

import lu.atozdigital.api.entites.Articles;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ArticleService {

    List<Articles> getAllArticle();

    Articles getArticleById(Long id);


    void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException;

    Articles createArticle(Articles article,MultipartFile image) throws IOException;
}