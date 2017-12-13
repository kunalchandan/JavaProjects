package useless;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.ImageObserver;
import java.awt.image.WritableRaster;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.opencv.core.*;
import org.opencv.videoio.VideoCapture;

public class test extends JPanel implements ImageObserver, MouseListener{

	private static final long serialVersionUID = -2517194114423352002L;

	BufferedImage image;

	static int recordX = 0;
	static int recordY = 0;

	public static void main (String args[]) throws InterruptedException{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		double r1 = 0,g1 = 0,b1 = 0,difference = 0;
		double record = 500;
		System.out.println(r1 + g1 + b1 + difference + record);

		double[] rgb = new double[3];

		test t = new test();
		VideoCapture camera = new VideoCapture(0);

		Mat frame = new Mat();
		camera.read(frame);

		//JFrame window = new JFrame();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("image");
		window.setSize(640, 400);
		window.setVisible(true);
		
		BufferedImage image;

		if(!camera.isOpened()){
			System.out.println("Error");
		}
		else {             
			myPoint mp1 = new myPoint();
			System.out.println(mp1);
			while(true){        

				if (camera.read(frame)){


					if(!myPoint.rgbRecorded && myPoint.mouseClicked){
						rgb = frame.get(myPoint.myX, myPoint.myY); // save rgb values of initial mouseclick in rgb
						myPoint.rgbRecorded = true;
						System.out.println(rgb[0] + " " + rgb[1] + " " + rgb[2]);
					}

					/*record = 500;
					if(myPoint.myX != 0 && myPoint.myY != 0){
						for(int x = 0; x < frame.width(); x++){
							for(int y = 0; y < frame.height(); y++){
								double[] pixel = frame.get(y, x);
								r1 = Math.abs(rgb[0]-pixel[0]); //find difference in rgb values
								g1 = Math.abs(rgb[1]-pixel[1]);
								b1 = Math.abs(rgb[2]-pixel[2]);
								difference = b1; //add differences for net difference in colour
								if(difference < record){
									record = difference; //set new closest pixel to be new record
									recordX = x; //save x and y of new best pixel
									recordY = y;
								}
							}
						}
						//System.out.println(record);
					}*/
					//Imgproc.cvtColor(frame, newFrame, Imgproc.COLOR_RGB2HSV);
					image = t.MatToBufferedImage(frame);
					//BufferedImage imageHSV = t.MatToBufferedImage(newFrame);

					/*
                    window.getContentPane().removeAll();
                    window.getContentPane().add(new test(imageHSV));
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setTitle("image");
                    window.setSize(imageHSV.getWidth(), imageHSV.getHeight() + 30);
                    window.setVisible(true);
					 */

					window.getContentPane().removeAll();
					window.getContentPane().imageUpdate(image, recordX, recordX, recordX, recordX, recordX);
				}
			}   
		}
		camera.release();
	}
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
		g.drawOval(recordX, recordY, 50, 50);
	}

	public test() {
	}

	public test(BufferedImage img) {
		image = img;
	}  

	public BufferedImage MatToBufferedImage(Mat frame) {
		//Mat() to BufferedImage
		int type = 0;
		if (frame.channels() == 1) {
			type = BufferedImage.TYPE_BYTE_GRAY;
		} else if (frame.channels() == 3) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		BufferedImage image = new BufferedImage(frame.width(), frame.height(), type);
		WritableRaster raster = image.getRaster();
		DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
		byte[] data = dataBuffer.getData();
		frame.get(0, 0, data);

		return image;
	}
	//static variables to be used everywhere
	public static class myPoint{
		static int myX = 0;
		static int myY = 0;
		static boolean rgbRecorded = false;
		static boolean mouseClicked = false;
	}
	public void mouseClicked(MouseEvent arg0) {
		int mouseY = arg0.getY();
		int mouseX = arg0.getX();
		myPoint.myX = mouseX;
		myPoint.myY = mouseY;
		myPoint.mouseClicked = true;
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		
		return true;
		
	}

}