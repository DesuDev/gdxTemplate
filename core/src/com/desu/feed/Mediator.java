package com.desu.feed;

import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.desu.feed.MainCoreClass;
import com.desu.feed.screens.Widgets;

public class Mediator {
	
	
	public MainCoreClass core;
	
	
	
	public Model_General model;
	
	public Widgets widgets;
	
	public Stage stage;
	
	public int displayHeight;
	public int displayWidth;
	
	
	public Mediator(Stage newStage) {
		
		stage = newStage;
		
		//model = new Model_General(this);
		
		
		
		widgets = new Widgets(this);
		
		
		
		//model.fillModel();
		//tablepane.fillTable();
		
	}


	public void registerCore(MainCoreClass mainCoreClass) {
		// TODO Auto-generated method stub
		core = mainCoreClass;
	}
	
	
}
