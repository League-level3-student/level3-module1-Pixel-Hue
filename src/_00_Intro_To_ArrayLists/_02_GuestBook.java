package _00_Intro_To_ArrayLists;

import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class _02_GuestBook implements ActionListener {
	static JPanel panel; 
	static JFrame frame;
	static JButton button1;
	static JButton button2;
	static JLabel label1 = new JLabel();
	static JLabel label2 = new JLabel();
	
	public static void main(String[] args) {
		//setup frame
	panel = new JPanel();
	frame = new JFrame();
	button1 = new JButton();
	button2 = new JButton();
	frame.add(panel);
	panel.add(button1);
	panel.add(button2);
	
	label1.setText("Add Name");
	label2.setText("View Names");
	
	button1.add(label1);
	button2.add(label2);
	
	//pack and make frame visible
	frame.pack();
	frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//change this
		//JButton buttonClicked = e.getSource();
	}
	
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */

}
