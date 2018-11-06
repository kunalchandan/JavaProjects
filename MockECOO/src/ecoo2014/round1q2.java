package ecoo2014;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class round1q2 {
	public static void main(String[] args) {
		for(int x = 0; x < 10000; x++) {
			try {
				TimeUnit.MILLISECONDS.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				Robot robot = new Robot();
				// Simulate a key press
				robot.keyPress(KeyEvent.VK_CONTROL);
				TimeUnit.SECONDS.sleep(1);
				robot.keyPress(KeyEvent.VK_T);

				TimeUnit.MILLISECONDS.sleep(200);

				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_T);
				

				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_TAB);
				TimeUnit.MILLISECONDS.sleep(200);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_W);
				TimeUnit.MILLISECONDS.sleep(200);
				robot.keyRelease(KeyEvent.VK_W);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				

			} catch (AWTException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
