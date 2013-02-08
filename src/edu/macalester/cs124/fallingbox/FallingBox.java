package edu.macalester.cs124.fallingbox;

import acm.graphics.*;
import acm.program.*;

public class FallingBox extends GraphicsProgram {
    
    public void run() {
    	boolean down = true;
        GRect square = new GRect(0, 0, SQUARE_SIZE, SQUARE_SIZE);
        square.setFilled(true);
        add(square);
        System.out.println("test");
        double dx = (getWidth()  - SQUARE_SIZE) / N_STEPS;
        double dy = (getHeight() - SQUARE_SIZE) / N_STEPS;
        for(int i = 0; i < N_STEPS; i++) {
        	//if(dy + SQUARE_SIZE < getHeight())
        	if(down)
        	{
	        	if(square.getLocation().getY() + SQUARE_SIZE < getHeight()) {
	        		dy += i * .02;
	        		square.move(dx, dy);
	        	}
	        	else
	        	{
	        		down = false;
	        		dy = -15;
	        	}
        	}
	        else
	        {
	        	if(dy < 0)
	        	{
	        		dy += i * .02;
	        		square.move(dx, dy);
	        	}
	        	else
	        		down = true;
	        }
	        	
            pause(PAUSE_TIME);
        }
    }

    private static final double N_STEPS = 200;
    private static final double PAUSE_TIME = 20;
    private static final double SQUARE_SIZE = 50;
}
