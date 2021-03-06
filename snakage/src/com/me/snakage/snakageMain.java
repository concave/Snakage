package com.me.snakage;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;

// Dave is cool
public class snakageMain extends Game {
	
	SnakePlayScreen playScreen;
	MainMenu mainScreen;


	public void create() {
		playScreen = new SnakePlayScreen();
		mainScreen = new MainMenu(this);
		
		setScreen(mainScreen);

	}
	
	public void playGame(){
		setScreen(playScreen);
	}

	@Override
	public void dispose() {

	}


	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {
	}
}
