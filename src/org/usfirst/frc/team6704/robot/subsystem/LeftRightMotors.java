package org.usfirst.frc.team6704.robot.subsystem;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This subsystem represents the motors of the robot, the motor at the front and the
 * motor at the back.
 */
public class LeftRightMotors extends Subsystem {
    
	public double leftFactor = 1.0;
	SpeedController leftMotor;
	SpeedController rightMotor;
	
	/**
	 * Constructs on instance of LeftRightMotors, passing it two motor controllers
	 * that represent the left and right motors.
	 * @param leftMotor
	 * @param rightMotor
	 */
	public LeftRightMotors(SpeedController leftMotor, SpeedController rightMotor) {
		this.leftMotor = leftMotor;
		this.rightMotor = rightMotor;
	}

	/**
	 * Sets the speed of the left motor.
	 * @param speed in the range -1 to 1 inclusive.
	 */
	public void setLeftSpeed(double speed) {
		// This motor is backwards
		this.leftMotor.set(-speed * leftFactor);
	}

	/**
	 * Sets the speed of the right motor.
	 * @param speed in the range -1 to 1 inclusive.
	 */
	public void setRightSpeed(double speed) {
		this.rightMotor.set(speed);
	}
	
	/**
	 * Sets the speed of both left and right motors at the same time, so the robot can move
	 * forwards or backwards.
	 * @param speed in the range -1 to 1 inclusive.
	 */
	public void setSpeed(double speed) {
		setLeftSpeed(speed);
		setRightSpeed(speed);
	}
	
	/**
	 * Stops left and right motors.
	 */
	public void stop() {
		setSpeed(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
