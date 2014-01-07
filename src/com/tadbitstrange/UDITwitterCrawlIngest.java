package com.tadbitstrange;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UDITwitterCrawlIngest {

	BufferedReader reader;
	
	public UDITwitterCrawlIngest(String filename) {
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (IOException e) {
			System.out.println("Error occurred while reading the file");
		}
	}
	
	public String readChunk() {
		String line;
		String text = null;
		Boolean found = false;
		
		try {
			while(!found) {
				line = reader.readLine();
				
				if(line == null){
					System.out.println("End of file");
				}
				
				if(line.contains("Origin: ")) {
					found = true;
					text = line.replace("Origin: ", "");
				}
			}
			
			return text;
		} catch(IOException e) {
			System.out.println("Error while reading file");
			return null;
		}
	}
	
	public Tweet readTweet() {
		String line;
		String text = null;
		Tweet result = new Tweet();
		
		try {
			while(true) {
				line = reader.readLine();
				
				if(line == null){
					return null;
				}
				
				if(line.startsWith("Origin: ")) {
					result.text = line.replace("Origin: ", "").trim();
				} else if(line.startsWith("ID: ")) {
					result.userId = Long.parseLong(line.replace("ID: ", ""));
				} else if(line.startsWith("Time: ")) {
					result.time = line.replace("Time: ", "");
				} else if(line.startsWith("RetCount: ")) {
					result.retweetCount = Long.parseLong(line.replace("RetCount: ", ""));
				} else if(line.startsWith("Favorite: ")) {
					result.favorite = Boolean.parseBoolean(line.replace("Favorite: ", ""));
				} else if(line.startsWith("MentionedEntities: ")) {
					result.mentions = line.replace("MentionedEntities: ", "").trim();
				} else if(line.startsWith("Hashtags: ")) {
					result.hashtags = line.replace("Hashtags: ", "").trim();
					return result;
				}
			}
		} catch(IOException e) {
			System.out.println("Error while reading file");
			return null;
		}
	}
	
	public Tweet[] readTweets() {
		ArrayList<Tweet> result = new ArrayList<Tweet>();
		Tweet tweet;
		while(true) {
			tweet = readTweet();
			if(tweet == null) {
				break;
			} else {
				result.add(tweet);
			}
		}
		if(result.size() > 0) {
			return result.toArray(new Tweet[0]);
		} else {
			return null;
		}
	}
}
