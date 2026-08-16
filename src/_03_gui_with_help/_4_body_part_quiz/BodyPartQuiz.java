package _03_gui_with_help._4_body_part_quiz;

import java.io.File;
import java.io.IOException;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BodyPartQuiz {

	// You can use the celebrity photos we have placed in the recipe java
	// package,or if you prefer, get celebrity photos from the Internet,
	// place them in the recipe package(body_part_quiz), and change the names below.

	String firstImage = "src/_03_gui_with_help/_4_body_part_quiz/arnold.jpeg";
	String secondImage = "src/_03_gui_with_help/_4_body_part_quiz/leonardo.jpeg";
	String thirdImage = "src/_03_gui_with_help/_4_body_part_quiz/morgan.jpeg";
	String fourthImage = "src/_03_gui_with_help/_4_body_part_quiz/jack.jpeg";

	JFrame window = new JFrame();
	JPanel panel = new JPanel();

	public void run() {
		initializeGui();
		startQuiz();
	}

	private void initializeGui() {
		initializeImageList();
		imageIterator = imageList.iterator();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel);

		// 3. Change the size of the window so that you can only see part of the
		// image.
		window.setSize(500, 100);

		showNextImage();

	}

	private void startQuiz() {

		// 1. Make an int variable to hold the score.
		int score = 0;
		// 2. Set the size of the window in the initializeGui() method 
		initializeGui();
		// 4. Ask the user who this person is and store their answer
		

		// 5. Check their answer. If they guessed correctly:
		// -- Tell them they are right and increase the score by 1
		String guess = JOptionPane.showInputDialog("who is this?");
		if(guess.equals("arnold")) {
			score++;
			JOptionPane.showMessageDialog(null, "you are correct!");
		} else {
			JOptionPane.showMessageDialog(null, "wrong it was arnold");
		} 
		showNextImage();
		// 6. Otherwise:
		// -- Tell them they are wrong and who the person is

		// 7. Use the showNextImage() method below to get the next image
		String guess2 = JOptionPane.showInputDialog("who is this?");
		if(guess2.equals("leonardo")) {
			score++;
			JOptionPane.showMessageDialog(null, "you are correct!");
		} else {
			JOptionPane.showMessageDialog(null, "wrong it was leonardo");
		} 
		showNextImage();

		// 8. .... repeat 4-7 for all your images.....
		String guess3 = JOptionPane.showInputDialog("who is this?");
		if(guess3.equals("morgan")) {
			score++;
			JOptionPane.showMessageDialog(null, "you are correct!");
		} else {
			JOptionPane.showMessageDialog(null, "wrong it was morgan");
		} 
		showNextImage();
		
		String guess4 = JOptionPane.showInputDialog("who is this?");
		if(guess4.equals("jack")) {
			score++;
			JOptionPane.showMessageDialog(null, "you are correct!");
		} else {
			JOptionPane.showMessageDialog(null, "wrong it was jack");
		} 
		
		// 9. Show them their current score
		
		JOptionPane.showMessageDialog(null, "Your score is " + score);

	}

	public void showNextImage() {
		panel.removeAll();
		panel.add(getNextImage());
		window.setVisible(true);
	}

	private JLabel loadImage(String fileName) {
		Icon icon = null;
		try {
			//File fileOne = new File("src/_03_gui_with_help/_4_body_part_quiz/jack.jpeg");
			//System.out.println(fileOne.exists());
			icon = new ImageIcon(ImageIO.read(new File(fileName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel label = new JLabel(icon);
		return label;
	}

	ArrayList<JLabel> imageList = new ArrayList<JLabel>();
	Iterator<JLabel> imageIterator;

	private void initializeImageList() {
		JLabel imageLabel = loadImage(firstImage);
		imageList.add(imageLabel);
		System.out.println(imageLabel);
		imageLabel = loadImage(secondImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(thirdImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(fourthImage);
		imageList.add(imageLabel);
	} 

	private JLabel getNextImage() {
		if (imageIterator.hasNext())
			return imageIterator.next();

		return new JLabel("No more images");
	}
}