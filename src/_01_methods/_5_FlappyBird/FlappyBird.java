package _01_methods._5_FlappyBird;

import java.util.Random;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    int birdY = 200;
    int birdYvel = 0;
    boolean gameStarted = false;
    int gravity = 5;
    int pipesX = 800;
    int pipesAddedY = 100;
    int gap = 100;
    Random ran = new Random();
    boolean gameOver = false;
    int score = 0;

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        
    }

    @Override
    public void draw() {
    	//clear
        background(150, 230, 255);
        

        // gravity stuff/main loop
        if(gameStarted) {
        	birdY-=birdYvel;
        	birdY+=gravity;
        	if(birdYvel > -3) {
        		birdYvel = birdYvel - 1;}
        	if(!gameOver) {
        		pipesX -=3;
        	}
        	if(pipesX < -100) {
        		pipesX = 800;
        		pipesAddedY = ran.nextInt(400)-200;
        		score++;
        		if(gap >=50) {
        			gap-=5;
        		}}}
        
        //collisions
        if(birdY > 300 + pipesAddedY + gap && birdY < 900 + pipesAddedY + gap) {
        	if(200 > pipesX && 200 < pipesX+100) {
        		//collided with bottom pipe
        		//System.out.println("bottom");
        		if(!gameOver) { endGame();}
        }
        	}
        if(birdY > 300 + pipesAddedY-600 - gap && birdY < 300 + pipesAddedY - gap) {
        	if(200 > pipesX && 200 < pipesX+100) {
        		//collided with top pipe
        		//System.out.println("top");
        		if(!gameOver) { endGame();}
        		
        	}
        }
        
        //keeping on screen
        if(birdY < 0) {
        	birdY = 1;}
        if(birdY>600) {
        	if(!gameOver) { endGame();}
        }
        
        //drawing pipes
        fill(0,180,0);
        rect(pipesX, 300 + pipesAddedY + gap, 100, 600);
        rect(pipesX, 300 + pipesAddedY-600 - gap, 100, 600);
        
      //drawing bird
        fill(255,255,30);
        ellipse(200,birdY,30,30);
        ellipse(200,birdY+3,20,10);
        fill(0,0,0);
        ellipse(205,birdY-6,7,7);
        fill(255,100,0);
        triangle(215,birdY-5, 215,birdY+5, 225,birdY);
        
       //UI
        fill(255,255,255);
        rect(370,45,40,30);
        fill(0, 0, 0);
        textSize(20);
        text(score,385,65);
        if(gameOver) {
            fill(0, 0, 0);
            textSize(100);
            text("GAME OVER",100,270);
            textSize(40);
            text("your score:" + score,200,400);
        }
        
    }
    public void mousePressed() {
    	//jump
    	if(!gameOver) {
    		gameStarted = true;
    		gravity = 5;
            birdYvel = 15;
    	}
    	if(gameOver) {
    		gameStarted = true;
    		gravity = 5;
            birdYvel = 15;
            score = 0;
            pipesX = 800;
            gap = 100;
            gameOver = false;
            gameStarted = false;
            birdY = 300;
    	}
        
    }
    public void endGame() {
    	gravity = 10;
    	gameOver = true;
        birdYvel = 20;  }
        

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
