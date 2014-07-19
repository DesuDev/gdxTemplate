package com.desu.feed.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.desu.feed.Abstract_Screen;
import com.desu.feed.MainCoreClass;
import com.desu.feed.logic.Logic_EventCalls;

public class Widgets_FeedTest extends Abstract_Screen {
	
	//Mediator mediator;
	
	//public List startDateList;
	//public List endDateList;
	
	//ScrollPane startPane;
	//ScrollPane endPane;
	
	
	
	
	
	//MainCoreClass core;
	
	//public Stage stage;
	//public Skin skin;
	
	Window window;
	TextField urlText;
	
	TextField filenameText;
	
	//TextField userText;
	
	
	public ScrollPane tablePane;
	public Table table;
	
	List targetList;
	
	
	
	public Widgets_FeedTest(MainCoreClass coreIn) {
		
		
		super(coreIn);
		//core.currentScreen = this;
		
		
		
		
		
		
		window = new Window("Log In Options", skin);
		
		window.defaults().pad(5.0f);
		
		
		
		
		
		filenameText = new TextField("", skin);
		
		filenameText.setMessageText("File Name (i.e. staff.txt)");
		window.add(filenameText).colspan(2);
		
		//this.addWidget(userText);
		
		
		
		
		window.row();
		
		
		
		
		urlText = new TextField("", skin);
		
		urlText.setMessageText("User's URL");
		window.add(urlText).colspan(2);
		
		//this.addWidget(userText);
		
		
		
		
		window.row();
		
		
		
		
		
		
		TextButton addURLbutton = new TextButton("Add URL", skin);
		
		addURLbutton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				
				
				String filename = getFilename();
				System.out.println(filename);
				
				String userURL = getUser();
				System.out.println(userURL);
				
				Logic_EventCalls.AddUrlEvent(core, filename, userURL);
				
			}
		});
		window.add(addURLbutton);
		
		
		
		
		
		
		//=====================================================
		
		
		
		//window.setBounds(300, 300, 350, 350);
		window.setBounds(300, 300, 350, 250);
		
		
		
		
		
		
		table = new Table();
		
		/*
		Label temp = new Label("Target List", skin);
		table.add(temp).expandX().fillX().colspan(2);
		table.row();
		/**/
		
		tablePane = new ScrollPane(table, skin);
		
		
		tablePane.setBounds(100, 100, 600, 300);
		//window.add(tablePane);
		
		//this.thisAddWidget(tablePane);
		
		
		
		
		/*
		Label temp = new Label("Target List", skin);
		table.add(temp).expandX().fillX().colspan(2);
		table.row();
		/**/
		
		
		
		
		targetList = new List( skin );
		
		
		
		
		
		
		
		//stage.addActor(window);
		this.thisAddWidget(window);
		
		
		/*
		Label temp = new Label("Target List", skin);
		table.add(temp).expandX().fillX().colspan(2);
		table.row();
		/**/
		
		
		
		/*
		TextButton testButton = new TextButton("Add URL", skin);
		
		testButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("Test");
			}
		});
		//window.add(testButton);
		testButton.setBounds(100, 100, 300, 300);
		stage.addActor(testButton);
		/**/
		
		
		
		/*
		Label temp = new Label("Target List", skin);
		table.add(temp).expandX().fillX().colspan(2);
		table.row();
		/**/
		
		
		
		this.thisAddWidget(tablePane);
		
		
		
		if (this.core.model.urlsLoaded == false) {
			fillTable();
		}
		else {
			fillTableURLs();
		}
		
		//fillTable();
		
		
		
		/*
		Label temp = new Label("Target List", skin);
		table.add(temp).expandX().fillX().colspan(2);
		table.row();
		
		
		Object[] dateEntries = new Object[3];
		
		dateEntries[0] = "something 1";
		dateEntries[1] = "something 2";
		dateEntries[2] = "something 3";
		
		
		//targetList.setItems("a", "b", "c");
		targetList.setItems(dateEntries);
		
		table.add(targetList);
		/**/
		
	}
	
	
	public void fillTable() {
		Label temp = new Label("Target List", skin);
		table.add(temp).expandX().fillX().colspan(2);
		table.row();
		
		
		Object[] dateEntries = new Object[3];
		
		dateEntries[0] = "something 1";
		dateEntries[1] = "something 2";
		dateEntries[2] = "something 3";
		
		
		//targetList.setItems("a", "b", "c");
		targetList.setItems(dateEntries);
		
		table.add(targetList);
	}
	
	
	
	public void fillTableURLs() {
		Label temp = new Label("Target List", skin);
		table.add(temp).expandX().fillX().colspan(2);
		table.row();
		
		
		int arraySize = core.model.records.size();
		
		
		Object[] dateEntries = new Object[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			//
			dateEntries[i] = core.model.records.get(i).url;
		}
		
		/*
		dateEntries[0] = "something 1";
		dateEntries[1] = "something 2";
		dateEntries[2] = "something 3";
		/**/
		
		//targetList.setItems("a", "b", "c");
		targetList.setItems(dateEntries);
		
		table.add(targetList);
	}
	
	
	
	public String getFilename() {
		return filenameText.getText();
	}
	
	
	public String getUser() {
		return urlText.getText();
	}
	
	
	
}




