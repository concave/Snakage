package com.me.snakage;

import java.util.Random;

public class fruit {
	
	int xCord;
	int yCord;
	int fruitCount;
	Random rand;
	Snake snake;
	
	public fruit(Snake snake) {
		
		this.snake = snake;
		fruitCount = 0;
		rand = new Random();
		generateFruit();
		
	}
	
	public void generateFruit(){
		
		fruitCount++;
		 xCord = (rand.nextInt(32)) * 30;
		 yCord = (rand.nextInt(16) + 2) * 30;
		 
		 //4 indicates for switch that x and y cord do not need to be updated based on direction
		 if (snake.checkForBody(xCord, yCord, 4)){
			 generateFruit();
		 }
		 
		
		
		
		
	}

}
