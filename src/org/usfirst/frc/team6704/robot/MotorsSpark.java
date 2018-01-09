package org.usfirst.frc.team6704.robot;

import edu.wpi.first.wpilibj.*;


public class MotorsSpark {

	Spark leftFront;
	Spark leftMiddle;
	Spark leftBack ;
	Spark rightFront;
	Spark rightMiddle;
	Spark rightBack ;
	double speedController1;
	double speedController2;



	public MotorsSpark(){
		 leftFront = new Spark(2);
		 rightFront = new Spark(0);
//		 leftMiddle = new Spark(3);
		 //leftBack = new Talon(3);
//		 rightMiddle = new Spark(1);
		 //rightBack = new Talon(6);
//		Talon leftFront = new Talon(1);

	}

	public MotorsSpark(int port1, int port2){
		  leftFront = new Spark(port1);
		 rightFront = new Spark(port2);
//		 leftMiddle = new Spark(port2);
		 //leftBack = new Talon(port3);
//		 rightMiddle = new Spark(port4);
		 //rightBack = new Talon(port6);
	}


	public void Driving(double speed){
		
		leftFront.set(speed);
//		leftMiddle.set(speed1);
//		leftBack.set(speed);
		speedController2 = speed * (-1);
		rightFront.set((speedController2));
//		rightMiddle.set(speed2);
//		rightBack.set(speed);
	}

//	public void initializeAllMotors(){
//		leftFront.initSpark();
//		rightFront.initSpark();
//	}

	public void drivingHalfSpeed(double speed1){
		speedController1 = speed1/2;
		Driving(speedController1);
	}

//	public void drivingThirdSpeed(double speed1, double speed2){
//		speedController1 = speed1/3;
//		speedController2 = speed2/3;
//		Driving(speedController1, speedController2);
//	}

}
