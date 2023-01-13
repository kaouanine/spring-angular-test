package lu.atozdigital.api.service;

import lu.atozdigital.api.entites.Articles;
import lu.atozdigital.api.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Random;

@Service
public class ArticleServiceImp implements ArticleService{
   @Autowired
     ArticleRepository articleRepository;



    @Override
    public List<Articles> getAllArticle() {

        return articleRepository.findAll();
    }

    @Override
    public Articles getArticleById(Long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }

    @Override
    public Articles createArticle(Articles article,MultipartFile image) throws IOException {
        Random random = new Random();

        String fileName = StringUtils.cleanPath(random.nextInt(1000000000)+image.getOriginalFilename());
        article.setPicture(fileName);

        Articles savedArticle = articleRepository.save(article);
        String uploadDir = "user-photos";

        saveFile(uploadDir, fileName, image);


        return savedArticle;
    }
}
