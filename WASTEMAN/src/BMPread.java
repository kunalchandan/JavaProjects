import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class BMPread {
	public static void main(String[] args) throws Throwable {
		BufferedImage image = ImageIO.read(new File("tiny.bmp"));
		int[][] array2D = new int[image.getWidth()][image.getHeight()];

		for (int xPixel = 0; xPixel < image.getWidth(); xPixel++)
		{
			for (int yPixel = 0; yPixel < image.getHeight(); yPixel++)
			{
				int color = image.getRGB(xPixel, yPixel);
				if (color==Color.WHITE.getRGB()) {
					array2D[xPixel][yPixel] = 1;
				} else {
					array2D[xPixel][yPixel] = 0;
				}
			}
		}
		for(int x = 0; x < array2D.length; x++) {
			for(int y = 0; y < array2D.length; y++) {
				System.out.print(array2D[x][y]);
			}
			System.out.println("");
		}
	}
}
