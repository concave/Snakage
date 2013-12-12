package com.me.snakage;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.TimeUtils;

public class SnakePlayScreen implements Screen {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture background;
	private Texture head;
	private Texture fruitImage;
	private Texture bodyImage;

	private Sprite sprite;
	TextureRegion region;

	fruit fruit;
	Snake snake;

	int headX;
	int headY;
	

	long lastTick;

	int direction; // Left = 0, up = 1, right = 2, down = 3;

	boolean gamePaused;


	public SnakePlayScreen() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 960, 540);

		batch = new SpriteBatch();

		snake = new Snake(480, 270);
		fruit = new fruit(snake);

		background = new Texture(Gdx.files.internal("Grid.png"));
		head = new Texture(Gdx.files.internal("Head.png"));
		fruitImage = new Texture(Gdx.files.internal("Fruit.png"));
		bodyImage = new Texture(Gdx.files.internal("Body.png"));

		lastTick = 0;
		direction = 1;

		gamePaused = false;

	}

	@Override
	public void dispose() {
		batch.dispose();
		background.dispose();
	}

	public void render(float delta) {

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		

		batch.begin();
		batch.draw(background, 0.0f, 0.0f);
		batch.draw(fruitImage, fruit.xCord, fruit.yCord);

		for (int i = 1; i < snake.body.size(); i++) {

			batch.draw(bodyImage, snake.body.get(i).bpX, snake.body.get(i).bpY);

		}
		batch.draw(head, snake.head.bpX, snake.head.bpY);

		batch.end();
		

		
		

		if (!gamePaused) {

			if (Gdx.input.isKeyPressed(Keys.LEFT) && direction != 2)
				direction = 0;
			if (Gdx.input.isKeyPressed(Keys.RIGHT) && direction != 0)
				direction = 2;
			if (Gdx.input.isKeyPressed(Keys.DOWN) && direction != 1)
				direction = 3;
			if (Gdx.input.isKeyPressed(Keys.UP) && direction != 3)
				direction = 1;
			

			
			
	

			

			if (TimeUtils.nanoTime() - lastTick > 100000000) {

				if (snake.checkForBody(snake.head.bpX, snake.head.bpY,
						direction)) {

					gamePaused = true;

				} else {

					lastTick = TimeUtils.nanoTime();

					snake.update(direction);
				}

			}

			if (snake.head.bpX == fruit.xCord && snake.head.bpY == fruit.yCord) {
				fruit.generateFruit();
				snake.addPart();
			}

		}

		else {

		}

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

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}
}
