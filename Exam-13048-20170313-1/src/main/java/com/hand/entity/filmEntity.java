package com.hand.entity;

public class filmEntity {
	private int film_id;
	private String title;
	private String desc;
	private String lang;
	private String lang_id;
	public filmEntity() {
		super();
	}
	public filmEntity(int film_id, String title, String desc, String lang, String lang_id) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.desc = desc;
		this.lang = lang;
		this.lang_id = lang_id;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getLang_id() {
		return lang_id;
	}
	public void setLang_id(String lang_id) {
		this.lang_id = lang_id;
	}
	
	
}
