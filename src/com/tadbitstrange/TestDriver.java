package com.tadbitstrange;

import java.io.File;





public class TestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		File folder = new File("/home/halfs13/Downloads/tweets/tweets/1/1/1");
		listFilesForFolder(folder);
		
		//UDITwitterCrawlIngest ingest = new UDITwitterCrawlIngest("/home/halfs13/workspace/flaming-bear/data/testfile2");
		
		
		
		//System.out.println(ingest.readChunk());
	}
	
	public static void listFilesForFolder(File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	        }
	    }
	}

}
