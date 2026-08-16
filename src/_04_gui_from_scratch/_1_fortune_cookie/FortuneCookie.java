package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FortuneCookie implements ActionListener{
	public void showButton () {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton(); 
		
		frame.setVisible(true);
		frame.add(button);
		frame.pack();
		button.addActionListener(this);
		
		//System.out.println("Button clicked"); 
		
	
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int rand = new Random().nextInt(5);
		if(rand == 0) {
			JOptionPane.showMessageDialog(null, "you will get a gazillion dollars");
		}
		if(rand == 1) {
			JOptionPane.showMessageDialog(null, "you will start your two week minecraft phase soon");
		}
		if(rand == 2) {
			JOptionPane.showMessageDialog(null, "your lucks numbers are: 67, 69, 420, 41, 81");
		}
		if(rand == 3) {
			JOptionPane.showMessageDialog(null, "you will drink water in the next 5 days");
		}
		if(rand == 4) {
			JOptionPane.showMessageDialog(null, "you will lose 10000 aura points today");
		}
		
		
	} }

