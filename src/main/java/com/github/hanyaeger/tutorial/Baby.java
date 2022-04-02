package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Baby extends Animal{

	protected Baby(Coordinate2D initialLocation) {
		super("sprites/baby.png", initialLocation, new Size(35, 70), 1, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		distraction();
	}
	
	public void distraction() {
		
	}

}
