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
import com.desu.feed.Mediator;

public class Logic_Stage {

	public static void constructStage(Mediator mediator) {
		// TODO Auto-generated method stub
		
		
		/*
		ShapeRenderer newShapes = new ShapeRenderer();
		mediator.widgets.shapes = newShapes;
		
		SpriteBatch newBatch = new SpriteBatch();
		mediator.widgets.batch = newBatch;
		/**/
		
		
		
		
		Stage newStage = new Stage();
		
		mediator.core.stage = newStage;
		mediator.stage = newStage;
		mediator.widgets.stage = newStage;
		
		Gdx.input.setInputProcessor(newStage);
		
		
		
		newStage.addActor(mediator.widgets.startDateBox);
		
		
		
		
	}
	
	
	
	
	
	
}




