package com.springvertex.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.springvertex.demo.model.Article;

public class ArticleService {
	
	private static List<Article> articles;
	
	static {
		articles = new ArrayList<>();
		articles.add(new Article(1, "Article1"));
		articles.add(new Article(2, "Article2"));
	}
	

	public List<Article> getAllArticle() {
		System.out.println("getAllArticle requests");
		return articles;
	}
	
	public List<Article> addArticle(Article article) {
		articles.add(article);
		System.out.println("New List: " + articles);
		return articles;
	}

}
