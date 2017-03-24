package org.usfirst.frc.team1626.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import com.ctre.CANTalon;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.cscore.UsbCamera;
import org.opencv.core.Mat;

import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends IterativeRobot {
	
	private Thread visionThread;

	
	@Override
	public void robotInit() {
//		visionProcessing		 = new Pipeline();
		visionThread = new Thread(() -> {
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(640, 480);
			
//			CvSink cvSink = CameraServer.getInstance().getVideo();
//			CvSource outputStream = CameraServer.getInstance().putVideo("Contours", 640, 480);
//			
//			Mat mat = new Mat();
//			
//			while (!Thread.interrupted()) {
//				// If grab frame makes set 
//				if (cvSink.grabFrame(mat) == 0) {
//					outputStream.notifyError(cvSink.getError());
//					continue;
//				}
//				
//				visionProcessing.process(mat);
//			}
		});
		visionThread.setDaemon(true);
		visionThread.start();
	}


	@Override
	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		
	}
}

