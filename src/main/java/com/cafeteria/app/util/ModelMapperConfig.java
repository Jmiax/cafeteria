package com.cafeteria.app.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
@Configuration
@Component
public class ModelMapperConfig {
	@Bean
	ModelMapper modelMapper() {
		return new  ModelMapper();
	}

=======
@Component
@Configuration
public class ModelMapperConfig {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
>>>>>>> d789a5c5870d414fe05cca28bfaa6483ad41266f
}
