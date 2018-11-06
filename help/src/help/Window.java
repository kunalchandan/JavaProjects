package help;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	public static String name;
	public static BufferedImage wizard;
	public static int width = 640;
	public static int height = 400;
	public String write;
	public Window() { //first method that gets called from other class
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Good morning");

		setSize(width, height);
		setResizable(false);
		setLocation(0,0);
		setVisible(true);
		setLayout(new FlowLayout());
		setAlwaysOnTop(true);
		readWizard();
		name = JOptionPane.showInputDialog("What is your name");
		repaint();
	}

	private void readWizard() { //read wizard from file
		try {
			wizard = ImageIO.read(new File("magic.png"));
		} catch (IOException e) {
			System.out.println("Somebody ate my Wizard!");
		}
	}

	public void paint(Graphics g) //this is the god method, everything that you want to put onto the screen goes in here
	{
		int sBx = 100;
		int sBy = 100;
		int sBwid = 400;
		int sBhei = 200;
		int sBcurve = 50;
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0, 255, 155));
		g2.setBackground(new Color(255, 255, 255));
		if(wizard != null) {
			g2.drawImage(wizard,0,0, this);
		}else {
			//decided not to print because print statement runs before image can be loaded into memory
			//System.out.println("Wizard was eaten alive, have a box");
		}
		g2.fillRoundRect(sBx, sBy, sBwid, sBhei, sBcurve, sBcurve);
		g2.fillRect(100, 100, 100, 100);
		g2.setColor(new Color(0,0,0));
		int y = 200;
		if(write!= null)
			for(String line: write.split("\n"))
				g2.drawString(line, 200, y+= g.getFontMetrics().getHeight());
	}
}
