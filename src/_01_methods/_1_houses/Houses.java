package _01_methods._1_houses;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
		
	public void run() {
		// Check the recipe to find out what code to put here
		Robot robby = new Robot();
		robby.moveTo(50, 500);
		robby.hide();
		robby.setSpeed(100);
		
		drawHouse(60,false,"red",robby);
		drawHouse(20,true,"green",robby);
		drawHouse(50,false,"black",robby);
		drawHouse(120,true,"blue",robby);
		drawHouse(80,true,"red",robby);
		drawHouse(10,true,"black",robby);
		drawHouse(150,false,"green",robby);
		drawHouse(100,true,"blue",robby);
		drawHouse(70,false,"red",robby);
	}
		
	void drawHouse(int height, boolean pointy, String color, Robot rob) {
		System.out.println("drawing house...");
		if(color.equals("red")) {
			rob.setPenColor(255, 0, 0);
		}
		else if(color.equals("blue")) {
			rob.setPenColor(0, 0, 255);
		}
		else if(color.equals("green")) {
			rob.setPenColor(0, 150, 20);
		}
		else {
			rob.setPenColor(0, 0, 0);
		}
		rob.penDown();
		rob.setAngle(90);
		rob.move(20);
		rob.setAngle(0);
		rob.move(height);
		if(pointy) {
		rob.setAngle(45);
		rob.move(30);
		rob.setAngle(135);
		rob.move(30);
		}else {
		rob.setAngle(90);
		rob.move(50);
		}
		rob.setAngle(180);
		rob.move(height);
		rob.setAngle(90);
		rob.move(20);
	}
	
}
