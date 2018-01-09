package org.usfirst.frc.team6704.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6704.robot.*;
import org.usfirst.frc.team6704.robot.GamePad.GamepadAxis;
import org.usfirst.frc.team6704.robot.GamePad.GamepadButton;
import org.usfirst.frc.team6704.robot.subsystem.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	final int zero = 0;
	final int one = 1;
	final int two = 2;
	final int three = 3;
	final int four = 4;
	final int five = 5;
	final int six = 6;
	final int seven = 7;
	final int eight = 8;
	final int nine = 9;
	double sight;
	boolean yes;
	boolean halfSpeed;
	boolean overdrive;
	SpeedController speedy;
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	GamePad gamepad = new GamePad(zero);
	MotorsSpark spark = new MotorsSpark(five,six);
	MotorsTalon talon = new MotorsTalon(one,two,three,four);
	LeftRightMotors motorsRow1 = new LeftRightMotors(speedy,speedy);
	static CameraServer cam;
	Ultrasonic sonic;
	SmartDashboard dashing;
	Sensors sensor1 = new Sensors(zero);
	Sensors sensor2 = new Sensors(one);
	int measureThisDistance1;
	int measureThisDistance2;
	











	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);
		yes = false;
		halfSpeed = false;
		overdrive = false;
		
		//Camera instance
		cam = CameraServer.getInstance();
		cam.addAxisCamera("10.67.4.54");
		cam.startAutomaticCapture();
		
		
		//Sensor instance

		
		sonic = new Ultrasonic(9,8);
		sonic.setEnabled(true);
		sonic.setAutomaticMode(true);
		
		
	}





	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}







	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		switch (autoSelected) {
		case customAuto:
			// Put custom auto code here
			break;
		case defaultAuto:
		default:
			// Put default auto code here
			break;
		}
	}









	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {



	}



	@Override
	public void disabledPeriodic(){
		yes = false;
		halfSpeed = false;
		overdrive = false;
		
		SmartDashboard.putString("DB/String 0", "                     ");
		SmartDashboard.putString("DB/String 1", "                     ");
		SmartDashboard.putString("DB/String 2", "                     ");
		SmartDashboard.putString("DB/String 3", "                     ");
		SmartDashboard.putString("DB/String 4", "                     ");
		SmartDashboard.putString("DB/String 5", "                     ");
		SmartDashboard.putString("DB/String 6", "                     ");
		SmartDashboard.putString("DB/String 7", "                     ");
		SmartDashboard.putString("DB/String 8", "                     ");
		SmartDashboard.putString("DB/String 9", "                     ");
		
	}

	@Override
	public void testInit(){
		

		
	}





	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		sensor1.act();
		sensor1.setScaling(0.1);
		measureThisDistance1 =(int)sensor1.getDistance();
		//SmartDashboard.putString("DB/String 5", "distance " +measureThisDistance1);
		//SmartDashboard.putString("DB/String 6", "voltage " + sensor1.getRaw());
		sensor2.act();
		measureThisDistance2 = (int)sensor2.getDistance();
		sensor2.setScaling(0.3);
		//SmartDashboard.putString("DB/String 7", "distance " +measureThisDistance2);
		//SmartDashboard.putString("DB/String 8", "voltage " + sensor2.getRaw());
		
		
		

		
		yes = gamepad.getButton(GamepadButton.A);

			if(!yes){
				spark.Driving(0.0);
				SmartDashboard.putString("DB/String 1", "Not in action");
			}else{
				spark.Driving(2.0);
				SmartDashboard.putString("DB/String 1", "NERF THIS");
			}

			if(gamepad.getButton(GamepadButton.LB) && gamepad.getButton(GamepadButton.RB)){
				overdrive = true;
				halfSpeed = false;
				
			}
		
		if(gamepad.getButton(GamepadButton.Y)){	
			halfSpeed = true;
			overdrive = false;
			SmartDashboard.putString("DB/String 0", "In HalfSpeed");
		}
		
		if(gamepad.getButton(GamepadButton.B)){
			halfSpeed = false;
			overdrive = false;
			SmartDashboard.putString("DB/String 0", "Not in HalfSpeed");
		}
		
		
		if(halfSpeed == false && overdrive == true ){
				
			if (halfSpeed == false && overdrive == false){
			talon.drivingHalfSpeed(gamepad.getAxis(GamepadAxis.RightY), (gamepad.getAxis(GamepadAxis.LeftY)) * -1);
			} else
			{
				talon.Driving(gamepad.getAxis(GamepadAxis.RightY), (gamepad.getAxis(GamepadAxis.LeftY)) * -1);
			}
		}
		else {

				
			talon.drivingThirdSpeed(gamepad.getAxis(GamepadAxis.RightY),( gamepad.getAxis(GamepadAxis.LeftY)) * -1 );
		}
	}

	


}
