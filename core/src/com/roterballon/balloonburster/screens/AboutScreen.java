package com.roterballon.balloonburster.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.roterballon.balloonburster.Background;
import com.roterballon.balloonburster.MenuBalloons;

public class AboutScreen implements Screen{
	
	private com.roterballon.balloonburster.BalloonBursterGame game;
	private AssetManager assetmanager;
	private SpriteBatch batch;
	private MenuBalloons balloons;
	private Background background;
	private OrthographicCamera camera;
	private Viewport viewport;
	private com.roterballon.balloonburster.scenes.AboutHUD hud;
	
	public AboutScreen (com.roterballon.balloonburster.BalloonBursterGame game){
		this.game = game;
		this.assetmanager = game.getAssetManager();
		this.batch = game.getSpriteBatch();
		
		this.camera = new OrthographicCamera();
		this.viewport = new FitViewport(com.roterballon.balloonburster.BalloonBursterGame.V_WIDTH, com.roterballon.balloonburster.BalloonBursterGame.V_HEIGHT, this.camera);
		this.camera.translate(com.roterballon.balloonburster.BalloonBursterGame.V_WIDTH/2, com.roterballon.balloonburster.BalloonBursterGame.V_HEIGHT/2);
		this.camera.update();
		
		this.background = new Background(assetmanager);
		this.balloons = new MenuBalloons(assetmanager);
		this.hud = new com.roterballon.balloonburster.scenes.AboutHUD(game);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void update(float dt){
		background.update(dt);
		balloons.update(dt);
		hud.update(dt);
	}

	@Override
	public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		background.render(batch);
		balloons.render(batch);
		batch.end();
		hud.render();
	}

	@Override
	public void resize(int width, int height) {
		this.viewport.update(width, height);
		this.hud.resize(width, height);
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
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		this.hud.dispose();
	}

}
