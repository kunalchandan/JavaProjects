
public class Neuron {
	/**
	 * This is the Neuron, Each one contains
	 * %% An array of connections
	 * %% Outgoing connections
	 * %% A weight on each of it's outgoing connections
	 * %% Probably other stuff
	 * 
	 * The neuron will sum together all of the incoming connections
	 * that will be mapped on a sigmoid as a probability of firing
	 * the probability of firing will be applied to each outgoing connection
	 * a weight will be applied to each connection
	 * the outgoing signal will be given by
	 * weight * x + bias
	 * I'll eventually figure out what x and bias are.
	 */
	double probability;
	public Neuron() {
	}
	/**
	 * Put input in here
	 * @param sumIns is the sum of inputs
	 */
	public void input(double sumIns) {
		probability = 1/(1+Math.tanh(sumIns));
	}
}