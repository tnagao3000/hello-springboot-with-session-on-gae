package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @see <a href="http://docs.spring.io/spring-session/docs/current/reference/html5/#api-redisoperationssessionrepository-sessiondestroyedevent">SessionDeletedEvent and SessionExpiredEvent</a>
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)
public class HelloSpringbootSessionConfig {

	@Bean
	public ConfigureRedisAction configureRedisAction() {
		return ConfigureRedisAction.NO_OP;
	}

	// イベントが飛んでくるかどうかを確認
	@EventListener
	public void confirmEvent(ApplicationEvent event) {
		System.out.println(LocalDateTime.now().toString() + " --> " + event.getClass().getSimpleName());
	}

}