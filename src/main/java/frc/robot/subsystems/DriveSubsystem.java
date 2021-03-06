/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

    public Spark frontLeft = new Spark(RobotMap.frontLeftMotor);
    public Spark backLeft = new Spark(RobotMap.backLeftMotor);
  public SpeedControllerGroup leftDrive = new SpeedControllerGroup(frontLeft, backLeft);
  
    public Spark frontRight = new Spark(RobotMap.frontrightMotor);
    public Spark backRight = new Spark(RobotMap.backRightMotor);
  public SpeedControllerGroup rightDrive = new SpeedControllerGroup(frontRight, backRight);


  public DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);


  public void teleopDrive(double moveHybrid, double turn) {
    
    if(Math.abs(moveHybrid) < 0.10) {
      moveHybrid = 0;
    }
    if(Math.abs(turn) < 0.10) {
      turn = 0;
    }
    
    
    drive.arcadeDrive(moveHybrid, turn);




  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }
}
