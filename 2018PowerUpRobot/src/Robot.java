import java.util.Scanner;

//import org.bytedeco.javacpp.opencv_core;
public class Robot {

    public static void main(String[] args) {
        //System.loadLibrary(opencv_core.CV_VERSION);
    	Scanner in = new Scanner(System.in);
    	double a = in.nextDouble();
    	double b = in.nextDouble();
    	double aroc = (f(b) - f(a))/(b-a);
    	System.out.println(f(b));
    	System.out.println(f(a));
    	System.out.println("AROC = " + aroc);
    	
    }
    public static double f(double x) {
    	return -60*(Math.pow(x,2) - 30*x - 275);
    }
}