package com.springvertex.demo;


import com.springvertex.demo.verticles.ArticleVerticles;
import io.vertx.core.Vertx;

public class SpringVertexDemoApplication {
	
	//Reference Articles
	//https://developers.redhat.com/blog/2018/03/29/rest-vert-x#vert_x_web
	//https://www.baeldung.com/spring-vertx
	
	
	public static void main(String[] args) {
		ArticleVerticles articleVerticles = new ArticleVerticles();
		final Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(articleVerticles);
	}
	
}
