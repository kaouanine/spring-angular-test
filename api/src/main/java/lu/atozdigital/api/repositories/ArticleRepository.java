package lu.atozdigital.api.repositories;

import lu.atozdigital.api.dto.ArticleDTO;
import lu.atozdigital.api.entites.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Articles,Long> {

}
