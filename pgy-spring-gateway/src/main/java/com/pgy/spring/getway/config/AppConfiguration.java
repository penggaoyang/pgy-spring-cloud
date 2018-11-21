package com.pgy.spring.getway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/*@Configuration*/
public class AppConfiguration {
	 /* @Bean*/
	  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		  

			//@formatter:off
			return builder.routes()
					.route("path_route", r -> r.path("/get").uri("http://www.xbniao.com"))
					//.route("rewrite_route", r -> r.path("*.myhost.org").filters(f -> f.rewritePath("/foo/(?<segment>.*)","/${segment}")).uri("http://www.baidu.com"))
					.route("host_route", r -> r.host("*.myhost.org").uri("http://httpbin.org"))
					.route("rewrite_route", r -> r.host("*.rewrite.org").filters(f -> f.rewritePath("/foo/(?<segment>.*)","/${segment}")).uri("http://httpbin.org"))
					.route("hystrix_route", r -> r.host("*.hystrix.org").filters(f -> f.hystrix(c -> c.setName("slowcmd"))).uri("http://httpbin.org"))
					.route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org").filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback"))).uri("http://httpbin.org"))
					/*.route("limit_route", r -> r
						.host("*.limited.org").and().path("/anything/**")
							.filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
						.uri("http://httpbin.org"))*/
					/*.route("websocket_route", r -> r.path("/echo")
						.uri("ws://localhost:9000"))*/
					.build();
		  
	   /* return builder.routes().
	      .route("test")
	          .uri("http://httpbin.org:80")
	          .predicate(host("**.abc.org").and(path("/image/png")))
	          .addResponseHeader("X-TestHeader", "foobar")
	          .and()
	      .route("test2")
	          .uri("http://httpbin.org:80")
	          .predicate(path("/image/webp"))
	          .add(addResponseHeader("X-AnotherHeader", "baz"))
	          .and()
	      .build();*/
	  }
}
