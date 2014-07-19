package com.desu.feed;

import java.util.ArrayList;

public class Model_General {
	
	//Mediator mediator;
	
	MainCoreClass core;
	
	public ArrayList<Record> records;
	
	public boolean urlsLoaded = false;
	
	
	
	public class Record {
		public String filename;
		public String url;
		public boolean read;
	}
	
	public Model_General(MainCoreClass c) {
		//mediator = med;
		
		core = c;
		
		records = new ArrayList<Record>();
		
	}
	
	public void fillModel() {
		//
	}
	
	
	public void addRecord(String file, String url, String read) {
		Record tempRec = new Record();
		
		tempRec.filename = file;
		tempRec.url = url;
		
		if (read.contains("y")) {
			tempRec.read = true;
		} else {
			tempRec.read = false;
		}
		
		records.add(tempRec);
	}
	
	
	
}
