package org.usfirst.frc.team6704.robot;

import edu.wpi.first.wpilibj.*;


public class MotorsTalon {

	Victor leftFront;
	Victor rightFront;
	Victor leftMiddle;
	Victor rightMiddle;
	double speedController;



	public MotorsTalon(){
		 leftFront = new Victor(8);
		 rightFront = new Victor(9);
		 leftMiddle = new Victor(2);
		 rightMiddle = new Victor(3);
		 //rightMiddle = new Talon(5);
		 //rightBack = new Talon(6);
//		Talon leftFront = new Talon(1);

	}

	public MotorsTalon(int port1, int port2, int port3, int port4){
		  leftFront = new Victor(port1);
		 rightFront = new Victor(port4);
		 leftMiddle = new Victor(port2);
		 //leftBack = new Talon(port3);
		 rightMiddle = new Victor(port3);
		 //rightBack = new Talon(port6);
	}


	public void Driving(double speed1, double speed2){

		leftFront.set(speed1);
		leftMiddle.set(speed1);
//		leftBack.set(speed);
		rightFront.set(speed2);
		rightMiddle.set(speed2);
//		rightBack.set(speed);
	}

//	public initializeAllMotors(){
//		leftFront.initSpark();
//		rightFront.initSpark();
//	}

	public void drivingHalfSpeed(double speed1, double speed2){
		Driving(speed1/2, speed2/2);
//		speedController = speed/2;
//		leftFront.set(speed1/2);
		//leftMiddle.set(speedController);
//		leftBack.set(speedController);
//		rightFront.set(speed2/2);
//		rightMiddle.set(speedController);
//		rightBack.set(speedController);
	}

	public void drivingThirdSpeed(double speed1, double speed2){
		Driving(speed1/4, speed2/4);
	}
	
	
	

}
