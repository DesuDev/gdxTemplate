package com.desu.feed;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.desu.feed.logic.Logic_EventCalls;
import com.desu.feed.logic.Logic_Stage;
import com.desu.feed.screens.Widgets_FeedTest;

public class MainCoreClass implements ApplicationListener {
	
	Mediator mediator;
	
	public Stage stage;
	
	public int showHeight;
	public int showWidth;
	
	public Abstract_Screen currentScreen;
	
	public Model_General model;
	
	
	
	
	public Widgets_FeedTest loginWidgets2;
	
	
	
	
	@Override
	public void create () {
		
		model = new Model_General(this);
		
		
		stage = new Stage();
		
		
		loginWidgets2 = new Widgets_FeedTest(this);
		
		//loginWidgets2.fillTable2();
		
		Logic_EventCalls.OnStartUpEvent(this);
		//loginWidgets2.fillTable();
		
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//mediator.widgets.drawWidgets();
		
		if (this.currentScreen == null) {
			
			System.out.println("CURRENT SCREEN IS NULL");
			
			mediator.widgets.drawWidgets();
		}
		
		else {
			stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
			stage.draw();
		}
		
	}

	
	//occurs once on initial display
	
	@Override
	public void resize(int width, int height) {
		
		
		showHeight = height;
		showWidth = width;
		
		
		//mediator.displayHeight = height;
		//mediator.displayWidth = width;
		
		
		
		if (this.currentScreen == null) {
			
			System.out.println("CURRENT SCREEN IS NULL");
			
			/*
			mediator.displayHeight = height;
			mediator.displayWidth = width;
			
			Logic_Stage.constructStage(mediator);
			
			mediator.widgets.adjustBox();
			/**/
			
		}
		else {
			stage = new Stage();
			
			if (this.currentScreen instanceof Widgets_FeedTest) {
				this.currentScreen = new Widgets_FeedTest(this);
			}
		}
		
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
}








