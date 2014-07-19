package com.desu.feed.logic;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.desu.feed.MainCoreClass;
import com.desu.feed.Mediator;
import com.desu.feed.Model_General;
import com.desu.feed.Model_General.Record;

public class Logic_Files {
	
	
	
	public static void externalFolder() {
		
		System.out.println("Files Testing 2");
		
		
		
		FileHandle desuFile = Gdx.files.internal("desu.txt");
		FileHandle desuFolder = desuFile.parent();
		
		
		
		//FileHandle desuFile = Gdx.files.internal("desu.txt");
		//String empty = desuFile.readString();
		//System.out.println(empty);
		
		
		
		FileHandle emptyFile = Gdx.files.local("empty.txt");
		String empty = emptyFile.readString();
		System.out.println(empty);
		
		
		
		//false
		boolean exists = Gdx.files.external("DesuDev/").exists();
		
		if (exists == false) {
			System.out.println("Making External Folder");
			
			emptyFile.copyTo(Gdx.files.external("DesuDev/desu.txt"));
		}
		else {
			System.out.println("External Folder Exists");
		}
		
		
		
		FileHandle targetsFile = Gdx.files.local("targets.txt");
		//String empty = emptyFile.readString();
		//System.out.println(empty);
		
		
		boolean exists2 = Gdx.files.external("DesuDev/targets.txt").exists();
		
		if (exists2 == false) {
			System.out.println("Making External Folder 2");
			
			targetsFile.copyTo(Gdx.files.external("DesuDev/targets.txt"));
		}
		else {
			System.out.println("External Folder Exists 2");
		}
		
	}
	
	
	
	
	public static void readInExternal(MainCoreClass c) {
		
		
		
		FileHandle targetsFile = Gdx.files.external("DesuDev/targets.txt");
		//targetsFile = Gdx.files.external("DesuDev/targets.txt");
		
		String targetsBlob = targetsFile.readString();
		
		System.out.println(targetsBlob);
		
		
		
		
		
		int indexPerc = -1;
		int indexDolr = -1;
		
		int indexLine = targetsBlob.indexOf("\n");
		System.out.println(indexLine);
		
		//ArrayList<String> targetList = new ArrayList<String>();
		
		
		
		String record = "";
		
		String file = "";
		String url = "";
		String read = "";
		
		//Record tempRec = new Record();
		Record tempRec;
		
		
		int i = 0;
		
		/**/
		while (indexLine > 0) {
			
			i++;
			
			if (i == 100) {
				break;
			}
			
			//======================================================
			
			indexLine = targetsBlob.indexOf("\n");
			
			//indexPerc = record.indexOf("%");
			//indexDolr = record.indexOf("$");
			
			
			if (indexLine > 0) {
				record = targetsBlob.substring(0, indexLine);
			} else {
				record = targetsBlob;
			}
			//record = targetsBlob.substring(0, indexLine);
			
			
			indexPerc = record.indexOf("%");
			indexDolr = record.indexOf("$");
			
			
			//indexSeparate = record.indexOf("%");
			//System.out.println("3 file: " + file);
			//System.out.println("3 url" + url);
			//System.out.println("3 read" + read);
			
			System.out.println("3 record: " + record);
			System.out.println(indexPerc);
			
			file = record.substring(0, indexPerc);
			url = record.substring(indexPerc + 1, indexDolr);
			read = record.substring(indexDolr + 1);
			
			System.out.println("3 file: " + file);
			System.out.println("3 url" + url);
			System.out.println("3 read" + read);
			
			
			/*
			tempRec = new Record();
			
			tempRec.filename = file;
			tempRec.url = url;
			
			if (read.contains("y")) {
				tempRec.read = true;
			} else {
				tempRec.read = false;
			}
			/**/
			
			c.model.addRecord(file, url, read);
			
			
			
			//remove the newline character
			targetsBlob = targetsBlob.substring(indexLine + 1);
			
			
			
			
			
			System.out.println(indexLine);
			
			
		}
		/**/
		
		
		
		
		
		
		//c.model.records = targetList;
		c.model.urlsLoaded = true;
	}
	
	
	
	
	public static void addURLtoTargets(MainCoreClass c, String file, String url) {
		
		
		
		FileHandle targetsFile = Gdx.files.external("DesuDev/targets.txt");
		//targetsFile = Gdx.files.external("DesuDev/targets.txt");
		
		String targetsBlob = targetsFile.readString();
		
		System.out.println(targetsBlob);
		
		
		
		targetsBlob = targetsBlob + "\n" + file + "%" + url + "$" + "y";
		//targetsBlob = targetsBlob + "\n" + url;
		targetsFile.writeString(targetsBlob, false);
		
		
		//c.model.records.add(url);
		c.model.addRecord(file, url, "y");
		
		
		c.resize(c.showWidth, c.showHeight);
	}
	
	
}




