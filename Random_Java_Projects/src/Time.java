
public class Time {
	// This is in general for calculating the time of any given function
	public static void main(String[] arg) {
		timeofTanh();
		timeofAtan();
		timeofSig();
		timeofSqrt();
	}

	public static void timeofTanh() {
		double repeats = 100000;
		double sum = 0;
		for(int s = (int) -repeats; s < repeats; s+= repeats/10000) {
			double x = System.currentTimeMillis();
			double a = Math.tanh(s);
			sum += (System.currentTimeMillis() - x);
		}
		System.out.println("Hyperbolic Tan " + (100*sum/repeats));
	}

	public static void timeofAtan() {
		double repeats = 100000;
		double sum = 0;
		for(int s = (int) -repeats; s < repeats; s+= repeats/10000) {
			double x = System.currentTimeMillis();
			double a = ((2*Math.atan(s))/Math.PI);
			sum += (System.currentTimeMillis() - x);
		}
		System.out.println("ArcTan         " + (100*sum/repeats));
	}

	public static void timeofSig() {
		double repeats = 100000;
		double sum = 0;
		for(int s = (int) -repeats; s < repeats; s+= repeats/10000) {
			double x = System.currentTimeMillis();
			double a = 1/(1+Math.pow(Math.E, -s));
			sum += (System.currentTimeMillis() - x);
		}
		System.out.println("Sigmoid        " + (100*sum/repeats));
	}

	public static void timeofSqrt() {
		double repeats = 100000;
		double sum = 0;
		for(int s = (int) -repeats; s < repeats; s+= repeats/10000) {
			double x = System.currentTimeMillis();
			double a = 1/(Math.sqrt(1+Math.pow(s, 2)));
			sum += (System.currentTimeMillis() - x);
		}
		System.out.println("Sqrt Func      " + (100*sum/repeats));
	}
}
