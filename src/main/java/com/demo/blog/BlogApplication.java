package com.demo.blog;

import com.demo.blog.client.PostClient;
import com.demo.blog.model.Post;
import com.demo.blog.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	PostClient postClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(PostClient.class);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostClient client, PostRepository repository) {
		return args -> {
			List<Post> posts = client.findAll();
			repository.saveAll(posts);
		};
	}

}
