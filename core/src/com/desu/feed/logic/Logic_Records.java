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

public class Logic_Records {
	
	
	//check the records all have corresponding files
	public static void establishRecords() {
		
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
	
	
	
}




