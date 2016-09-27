package business.demo

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import org.springframework.web.client.RestOperations
import org.springframework.web.client.RestTemplate
import org.springframework.context.annotation.Bean
// import org.springframework.context.annotation.ComponentScan
// import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.cloud.client.loadbalancer.LoadBalanced
// import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableAutoConfiguration
// @SpringBootApplication
// @Configuration
// @ComponentScan
@EnableDiscoveryClient
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }


	@Bean
    @LoadBalanced
    RestOperations loadBalanced() {
        return new RestTemplate();
    }

    @Bean
    @Primary
    RestOperations restTemplate() {
        return new RestTemplate();
    }
}