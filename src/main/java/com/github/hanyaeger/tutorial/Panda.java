package com.github.hanyaeger.tutorial;

import java.util.Random;
import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;

public class Panda extends Character implements KeyListener, Collider, Collided{
	
	KillerPanda killerPanda;
	
	private HealthText healthText;
	private int health = 9;
	
	private PointsText pointsText;
	private int points = 0;
	
	private Weapon weapon;
	
	public long startTime = System.currentTimeMillis();

	public Panda(Coordinate2D initialLocation, HealthText healthText, KillerPanda killerPanda, PointsText pointsText) {
		super("sprites/walkingPanda.png", initialLocation, new Size(40, 80), 1, 3);
		
		this.healthText = healthText;
	    healthText.setHealthText(health);
	    
	    this.pointsText = pointsText;
	    pointsText.setText(points);
	    
	    this.killerPanda = killerPanda;
	}

	@Override
	public void notifyBoundaryTouching(SceneBorder border) {
		setSpeed(0);

	    switch(border){
	        case TOP:
	            setAnchorLocationY(1);
	            break;
	        case BOTTOM:
	            setAnchorLocationY(getSceneHeight() - getHeight() - 1);
	            break;
	        case LEFT:
	            setAnchorLocationX(1);
	            break;
	        case RIGHT:
	            setAnchorLocationX(getSceneWidth() - getWidth() - 1);
	        default:
	            break;
	        }
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if (collidingObject instanceof Animal && (System.currentTimeMillis() - startTime) > 1000){
	        points++;
	        startTime = System.currentTimeMillis();
		}
		if (collidingObject instanceof Farmer) {
			health--;
			setAnchorLocation(
			        new Coordinate2D(new Random().nextInt((int)(getSceneWidth() - getWidth())),
			        new Random().nextInt((int)(getSceneHeight() - getHeight()))));
		}
		if (health == 0) {
			killerPanda.setActiveScene(2);
		}
		healthText.setHealthText(health);
		pointsText.setText(points);
		
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if(pressedKeys.contains(KeyCode.LEFT)){
	        setMotion(3,270d);
	        setCurrentFrameIndex(0);
	    } else if(pressedKeys.contains(KeyCode.RIGHT)){
	        setMotion(3,90d);
	        setCurrentFrameIndex(0);
	    } else if(pressedKeys.contains(KeyCode.UP)){
	        setMotion(3,180d);
	        setCurrentFrameIndex(1);
	    } else if(pressedKeys.contains(KeyCode.DOWN)){
	        setMotion(3,0d);
	        setCurrentFrameIndex(2);
	    } 
		
	}

}