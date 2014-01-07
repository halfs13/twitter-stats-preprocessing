package com.tadbitstrange;

public class Tweet {
	
	public String text;
	public long userId;
	public String time;
	public long retweetCount;
	public boolean favorite;
	public String mentions;
	public String hashtags;

	public Tweet() {
		
	}
	
	public Tweet(String text, long id, String time, long ret, boolean fav, String mentions, String hashtags) {
		this.text = text;
		this.userId = id;
		this.time = time;
		this.retweetCount = ret;
		this.favorite = fav;
		this.mentions = mentions;
		this.hashtags = hashtags;
	}
}
