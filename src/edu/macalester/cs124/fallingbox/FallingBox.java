package edu.macalester.cs124.fallingbox;

import acm.graphics.*;
import acm.program.*;

public class FallingBox extends GraphicsProgram {
    
    public void run() {
    	
    	setSize(700, 400);
    	boolean down = true;
        GRect square = new GRect(0, 0, SQUARE_SIZE, SQUARE_SIZE);
        square.setFilled(true);
        add(square);
        System.out.println("test");
        double dx = 650 / N_STEPS;
        //double dy = (getHeight() - SQUARE_SIZE) / N_STEPS;
        double dy = 5.0;
        for(int i = 0; i < N_STEPS; i++) {
        	//if(dy + SQUARE_SIZE < getHeight())
        	if(down)
        	{
	        	if(square.getLocation().getY() + SQUARE_SIZE < getHeight()) {
	        		dy += i * .02;
	        		//dy *= 1.1;
	        		square.move(dx, dy);
	        	}
	        	else
	        	{
	        		square.move(dx, getHeight() - (square.getLocation().getY() + SQUARE_SIZE));
	        		down = false;
	        		dy = -dy;
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

    private static final double N_STEPS = 250;
    private static final double PAUSE_TIME = 20;
    private static final double SQUARE_SIZE = 50;
    private static final double APPLICATION_WIDTH = 700;
}
