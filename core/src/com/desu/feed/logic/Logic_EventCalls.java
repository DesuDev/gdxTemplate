package com.desu.feed.logic;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
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
import com.desu.feed.screens.Widgets_FeedTest;

public class Logic_EventCalls {
	
	
	
	public static void OnStartUpEvent(MainCoreClass c) {
		System.out.println("On Start Up Event");
		
		//widgets are already set up
		
		//set up external files/check that they exist
		Logic_Files.externalFolder();
		
		
		//read in targets.txt
		//load results into widgets
		
		//will the table of targets need to be records for a multi-column table?
		//((Widgets_FeedTest) c.currentScreen).fillTable();
		//((Widgets_FeedTest) c.currentScreen).fillTable2();
		//c.loginWidgets2.fillTable2();
		
		
		Logic_Files.readInExternal(c);
		
	}
	
	
	
	
	public static void AddUrlEvent(MainCoreClass c, String file, String url) {
		System.out.println("Add URL Event");
		
		Logic_Files.addURLtoTargets(c, file, url);
	}
	
	
	public static void UpdateFilesEvent(MainCoreClass c) {
		System.out.println("Add URL Event");
		
		//Logic_Files.addURLtoTargets(c, url);
	}
	
}




