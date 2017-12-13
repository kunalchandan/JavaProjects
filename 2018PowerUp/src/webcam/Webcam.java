package webcam;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.opencv.core.*;
import org.opencv.videoio.VideoCapture;

public class Webcam extends JFrame{

	private static final long serialVersionUID = 2672572329437757848L;
	BufferedImage image;
	ImageIcon img;
	VideoCapture camera;
	
	public Webcam() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		camera = new VideoCapture(0);
		Mat frame = new Mat();
		
		initJFrame();
		checkCameraState();
		if(!camera.isOpened()){
		}
		else {
			camera.read(frame); 
			while(true){
				displayVideoFeed();
			}   
		}
		closeFeed();
	}
	private void closeFeed() {
		camera.release();
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		
	}
	private void displayVideoFeed() {
		Mat frame = new Mat();
		if (camera.read(frame)){
			BufferedImage image = MatToBufferedImage(frame);
			img = new ImageIcon(image);
			repaint();
		}
	}
	private void checkCameraState() {
		if(!camera.isOpened()){
			System.out.println("Somebody else is using the Camera");
		}
	}
	private void initJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("VIDEO Feeed");
		setSize(640, 400);
		setResizable(false);
		setLocation(0,0);
		setVisible(true);
		setLayout(new FlowLayout());
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		if(img != null) {
			g2.drawImage(img.getImage(),0,0, this);
		}
		else {
			System.out.println("Webcam is being used || Webcam is not booted");
		}
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
}