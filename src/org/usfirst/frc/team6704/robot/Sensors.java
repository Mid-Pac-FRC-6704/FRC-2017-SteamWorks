package org.usfirst.frc.team6704.robot;

import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team6704.robot.*;

public class Sensors {
	
	AnalogInput sonic;
	public static final double SCALING_FACTOR = 0.1176;
	private double scalingSetter;
	private double measuredVoltage;
	
	public Sensors(){
		sonic = new AnalogInput(0);
		scalingSetter = SCALING_FACTOR;
	}
	public Sensors(int input){
		sonic = new AnalogInput(input);
		scalingSetter = SCALING_FACTOR;
	}
	
	
		public void setScaling(double input){
			scalingSetter = input;
		}
		public void act() {
	        measuredVoltage = sonic.getVoltage();
	    }

	    /**
	     * @return Distance to the target, in feet
	     */
	    public double getDistance() {
	        return measuredVoltage / scalingSetter;
	    }

	    /**
	     * @return Voltage output from the ultrasonic
	     */
	    public double getRaw() {
	        return measuredVoltage;
	    }
}
