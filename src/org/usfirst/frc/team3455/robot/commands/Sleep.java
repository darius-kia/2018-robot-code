package org.usfirst.frc.team3455.robot.commands;

import org.usfirst.frc.team3455.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Sleep extends Command {

	private double power;
	private long startTime;
	private double runTime;
	
    public Sleep(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	this.runTime = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    	Robot.chassis.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (System.currentTimeMillis()-startTime)>runTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
