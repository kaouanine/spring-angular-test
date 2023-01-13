package lu.atozdigital.api;

import lu.atozdigital.api.entites.Articles;
import lu.atozdigital.api.entites.Orders;
import lu.atozdigital.api.repositories.ArticleRepository;
import lu.atozdigital.api.repositories.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ApiApplication  {


	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);


	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
