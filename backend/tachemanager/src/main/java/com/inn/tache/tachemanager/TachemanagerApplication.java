package com.inn.tache.tachemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TachemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TachemanagerApplication.class, args);
	}
/*
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
*/

	//@Bean
	/*CommandLineRunner start(tacheServicesImp tacheservice){
		return args -> {
			Stream.of("B2B","CHANGE","TAVS").forEach(nom->{
				domainDTO domainDTO=new domainDTO();
				domainDTO.setNom(nom);
				tacheservice.savedomain(domainDTO);
			});

			Stream.of("DEV","QA","PROD","PRE PROD").forEach(nom->{
				platformeDTO platformeDTO=new platformeDTO();
				platformeDTO.setNom(nom);
				tacheservice.saveplatforme(platformeDTO);
			});

			Stream.of("RFC","TO","AR").forEach(nom->{
				typeDTO typeDTO=new typeDTO();
				typeDTO.setNom(nom);
				tacheservice.savetype(typeDTO);
			});

		tacheservice.ListDomain().forEach(domain->{
			tacheservice.ListPlatforme().forEach(platform->{
				tacheservice.ListType().forEach(type->{
					try {
						for (int i=0;i<4;i++){
							tacheservice.savetache(new Date(), new Date(), "tache1","commentsExmpl","des taches "
									,domain.getId(),platform.getId(),type.getId());
						}
					} catch (DPTNotFoundExeption e) {
						throw new RuntimeException(e);
					}

				});

			});

		});
		};
	}*/

}
