import java.util.*;

/**
 * 
 * @author carlosandres.mendez
 */
public class Discrete_FitnessFunction {

	/** Should this funtion be maximized or minimized */
	boolean maximize;

	//-------------------------------------------------------------------------
	// Constructors
	//-------------------------------------------------------------------------

	/** Default constructor */
	public Discrete_FitnessFunction() {
		maximize = false; // Default: Maximize
	}

	/**
	 * Constructor 
	 * @param maximize : Should we try to maximize or minimize this function?
	 */
	public Discrete_FitnessFunction(boolean maximize) {
		this.maximize = maximize;
	}

	//-------------------------------------------------------------------------
	// Methods
	//-------------------------------------------------------------------------

	/**
	 * Evaluates a particles at a given position
	 * NOTE: You should write your own method!
	 * 
	 * @param position : Particle's position
	 * @return Fitness function for a particle
	 */
	public double evaluate(List<Allocation> position){
        double result = 0d;

		double sum = 0d;
		for(Allocation allocation : position){
			sum = sum + allocation.getVm().getCost();
		}
		result = sum;

        return result;
    }

	/**
	 * Evaluates a particles 
	 * @param particle : Particle to evaluate
	 * @return Fitness function for a particle
	 */
	public double evaluate(Discrete_Particle particle) {
		List<Allocation> position = particle.getPosition();
		double fit = evaluate(position);
		particle.setFitness(fit, maximize);
		return fit;
	}

	/**
	 * Is 'otherValue' better than 'fitness'?
	 * @param fitness
	 * @param otherValue
	 * @return true if 'otherValue' is better than 'fitness'
	 */
	public boolean isBetterThan(double fitness, double otherValue) {
		if (maximize) {
			if (otherValue > fitness) return true;
		} else {
			if (otherValue < fitness) return true;
		}
		return false;
	}

	/** Are we maximizing this fitness function? */
	public boolean isMaximize() {
		return maximize;
	}

	public void setMaximize(boolean maximize) {
		this.maximize = maximize;
	}
        
        

}