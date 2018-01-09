package org.usfirst.frc.team6704.robot;

import edu.wpi.first.wpilibj.Victor;

public class MotorsVictors {
	
	

	Victor leftFront;
	Victor rightFront;
	Victor leftMiddle;
	Victor rightMiddle;
	double speedController;



	public MotorsVictors(){
		 leftFront = new Victor(8);
		 rightFront = new Victor(9);
		 leftMiddle = new Victor(2);
		 rightMiddle = new Victor(3);

	}

	public MotorsVictors(int port1, int port2, int port3, int port4){
		  leftFront = new Victor(port1);
		 rightFront = new Victor(port4);
		 leftMiddle = new Victor(port2);
		 rightMiddle = new Victor(port3);
	}


	public void Driving(double speed1, double speed2){

		leftFront.set(speed1);
		leftMiddle.set(speed1);
		rightFront.set(speed2);
		rightMiddle.set(speed2);
	}



	public void drivingHalfSpeed(double speed1, double speed2){
		Driving(speed1/2, speed2/2);

	}

	public void drivingThirdSpeed(double speed1, double speed2){
		Driving(speed1/4, speed2/4);
	}
	
	
	

}
