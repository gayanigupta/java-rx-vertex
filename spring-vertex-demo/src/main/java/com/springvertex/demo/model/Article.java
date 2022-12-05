package com.springvertex.demo.model;

public class Article {
	public Article(int id, String name) {
		this.id = id;
		this.name = name;
	}

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + "]";
	}

	public Article() {
	}

}
