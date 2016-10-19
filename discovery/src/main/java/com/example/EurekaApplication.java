package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import de.codecentric.boot.admin.config.EnableAdminServer;

import de.codecentric.boot.admin.notify.LoggingNotifier;
import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import de.codecentric.boot.admin.notify.filter.FilteringNotifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
@EnableAdminServer
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

	@Bean
	@Primary
	public RemindingNotifier remindingNotifier() {
		RemindingNotifier notifier = new RemindingNotifier(filteringNotifier(loggerNotifier()));
		notifier.setReminderPeriod(TimeUnit.SECONDS.toMillis(10));
		return notifier;
	}

	@Scheduled(fixedRate = 1_000L)
	public void remind() {
		remindingNotifier().sendReminders();
	}

	@Bean
	public FilteringNotifier filteringNotifier(Notifier delegate) {
		return new FilteringNotifier(delegate);
	}

	@Bean
	public LoggingNotifier loggerNotifier() {
		return new LoggingNotifier();
	}
}
