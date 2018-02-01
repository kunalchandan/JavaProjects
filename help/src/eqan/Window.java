package eqan;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	public static int width = 640;
	public static int height = 400;
	JButton addUse, remUse, delUse, updUse, serUse;
	
	public Window() {
		createButtons();
		initJframe();
	}


	private void createButtons() {
		addUse = new JButton("Add User");
		addUse.setVerticalTextPosition(AbstractButton.CENTER);
		addUse.setHorizontalTextPosition(AbstractButton.LEADING);
	    addUse.setActionCommand("add");
		addUse.addActionListener(this);
		this.add(addUse);
		
		remUse = new JButton("Remove User");
		remUse.setVerticalTextPosition(AbstractButton.CENTER);
		remUse.setHorizontalTextPosition(AbstractButton.LEADING);
	    remUse.setActionCommand("remove");
		remUse.addActionListener(this);
		this.add(remUse);
		
		delUse = new JButton("Delete User");
		delUse.setVerticalTextPosition(AbstractButton.CENTER);
		delUse.setHorizontalTextPosition(AbstractButton.LEADING);
	    delUse.setActionCommand("delete");
		delUse.addActionListener(this);
		this.add(delUse);
		
		updUse = new JButton("Update User");
		updUse.setVerticalTextPosition(AbstractButton.CENTER);
		updUse.setHorizontalTextPosition(AbstractButton.LEADING);
	    updUse.setActionCommand("update");
		updUse.addActionListener(this);
		this.add(updUse);
		
		serUse = new JButton("Search User");
		serUse.setVerticalTextPosition(AbstractButton.CENTER);
		serUse.setHorizontalTextPosition(AbstractButton.LEADING);
	    serUse.setActionCommand("search");
		serUse.addActionListener(this);
		this.add(serUse);
	}

	private void initJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Good morning");

		setSize(width, height);
		setResizable(false);
		setLocation(0,0);
		setVisible(true);
		setLayout(new FlowLayout());
		setAlwaysOnTop(true);
	}
	/*
	public void paint(Graphics g) //this is the god method, everything that you want to put onto the screen goes in here
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(new Color(255, 255, 255));

	}*/
	
	public void actionPerformed(ActionEvent e) {
	    if ("add".equals(e.getActionCommand())) {
	    	String inputValue = JOptionPane.showInputDialog("Name of User to add");
    	}
	    else if ("remove".equals(e.getActionCommand())) {
	    	String inputValue = JOptionPane.showInputDialog("Name of User to add");
	    }
	    else if ("delete".equals(e.getActionCommand())) {
	    	String inputValue = JOptionPane.showInputDialog("Name of User to add");
	    }
	    else if ("update".equals(e.getActionCommand())) {
	    	String inputValue = JOptionPane.showInputDialog("Name of User to add");
	    }
	    else if ("search".equals(e.getActionCommand())) {
	    	String inputValue = JOptionPane.showInputDialog("Name of User to add");
	    }
	}
}
