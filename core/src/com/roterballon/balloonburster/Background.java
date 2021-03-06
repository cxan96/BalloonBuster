package com.roterballon.balloonburster;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.roterballon.balloonburster.sprites.Sun;

/**
 * Created by Chris on 06.03.2016.
 */
public class Background {
    private boolean paused;
    private CloudManager clouds;
    private Sun sun;
    private com.roterballon.balloonburster.sprites.Sky sky;
    private AssetManager assetmanager;

    public Background(AssetManager assetmanager){
        this.assetmanager = assetmanager;
        
        //Create Sky
        sky = new com.roterballon.balloonburster.sprites.Sky(assetmanager.get("img/sky.png", Texture.class), BalloonBursterGame.V_HEIGHT);
        sky.setCenter(BalloonBursterGame.V_WIDTH / 2, BalloonBursterGame.V_HEIGHT / 2);
        
        //Create Clouds
        clouds = new CloudManager(assetmanager);
        
        //Create Sun
        sun = new Sun(assetmanager.get("img/sun.png", Texture.class), 400);
        sun.setCenter(BalloonBursterGame.V_WIDTH*0.8f, 1100f);
        sun.setOrigin(sun.getWidth()/2, sun.getHeight()/2);
    }

    public void update(float dt){
    	if(!paused){
	    	sky.update(dt);
	    	sun.update(dt);
	    	clouds.update(dt);
    	}
    }

    public void render(SpriteBatch batch){
        sky.draw(batch);
        sun.draw(batch);
        clouds.render(batch);
    }

    public void pause(){
    	this.paused = true;
    }
    
    public void resume(){
    	this.paused = false;
    }
}
