package com.desu.feed;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.desu.feed.logic.Logic_Stage;

public class MainCoreClass implements ApplicationListener {
	
	Mediator mediator;
	
	public Stage stage;
	
	public int showHeight;
	public int showWidth;
	
	
	@Override
	public void create () {
		
		stage = new Stage();
		
		mediator = new Mediator(stage);
		mediator.registerCore(this);
		
		Logic_Stage.constructStage(mediator);
		
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		mediator.widgets.drawWidgets();
		
		
	}

	
	//occurs once on initial display
	
	@Override
	public void resize(int width, int height) {
		showHeight = height;
		showWidth = width;
		
		
		mediator.displayHeight = height;
		mediator.displayWidth = width;
		
		Logic_Stage.constructStage(mediator);
		
		mediator.widgets.adjustBox();
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








