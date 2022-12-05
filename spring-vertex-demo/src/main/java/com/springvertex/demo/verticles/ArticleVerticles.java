package com.springvertex.demo.verticles;

import com.springvertex.demo.model.Article;
import com.springvertex.demo.service.ArticleService;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import rx.Observable;

public class ArticleVerticles extends AbstractVerticle {

	private ArticleService articleService;

	@Override
	public void start() throws Exception {
		super.start();
		System.out.println("Starting Router");
		Router router = Router.router(vertx);
		router.get("/api/article").handler(this::getArticles);
		router.route("/api/article*").handler(BodyHandler.create());
		router.post("/api/article").handler(this::postArticles);
		vertx.createHttpServer().requestHandler(router::accept).listen(config().getInteger("http.port", 8080));
		articleService = new ArticleService();
	}

	private void getArticles(RoutingContext routingContext) {
		Observable.just(articleService.getAllArticle())
		.subscribe(articles -> {
					routingContext.response().putHeader("content-type", "application/json; charset=utf-8")
					.end(Json.encodePrettily(articles));
				});
		;
	}

	private void postArticles(RoutingContext routingContext) {
		Article article = routingContext.getBodyAsJson().mapTo(Article.class);
		Observable.just(articleService.addArticle(article))
		.subscribe(response -> {
			routingContext.response().putHeader("content-type", "application/json; charset=utf-8")
			.end(Json.encodePrettily(response));
		});
		
	}

}
