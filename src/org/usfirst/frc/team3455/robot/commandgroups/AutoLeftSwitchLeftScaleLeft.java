package org.usfirst.frc.team3455.robot.commandgroups;

import org.usfirst.frc.team3455.robot.Robot;
import org.usfirst.frc.team3455.robot.commands.*;
import org.usfirst.frc.team3455.robot.utils.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 */
public class AutoLeftSwitchLeftScaleLeft extends CommandGroup {
	
    public AutoLeftSwitchLeftScaleLeft() {
    	requires(Robot.chassis);
    	requires(Robot.elevator);
    	requires(Robot.intake);

    	addSequential(new DriveForwardEncoderAuto(12*Constants.DIST_TO_SWITCH, 0.5)); //drive to the switch
    	addSequential(new Sleep(250));
    	addSequential(new TurnPointAuto(135, 0.35)); //turn toward the switch at an angle
    	addSequential(new Sleep(250));
    	addSequential(new DriveForwardEncoderAuto(12*0.5, 0.35)); //drive toward the switch
    	addSequential(new Sleep(250));
    	addParallel(new ManipulateTilt(500, -0.5)); //tilt intake down to switch
    	addSequential(new Sleep(250));
    	addSequential(new ManipulateBlock(2500, -0.5)); //shoot out block
    	addSequential(new Sleep(250));
    	addSequential(new DriveForwardEncoderAuto(12*1, -0.35)); //drive away from block
    	addSequential(new Sleep(250));
    	addSequential(new MoveElevatorToSwitchLevel(1000, -1.0));
    	addParallel(new ManipulateBlock(3000, 0.75));
    	addSequential(new DriveForwardEncoderAuto(12*1, -0.35)); //drive toward from block
    	addSequential(new Sleep(250));
    	addParallel(new MoveElevatorToMaxPosition(1.0));
    	addSequential(new ManipulateTilt(500, 0.5));
    	addSequential(new Sleep(250));
    	addSequential(new TurnPointAuto(-100, 0.35));
    	addSequential(new Sleep(250));
    	addSequential(new DriveForwardEncoderAuto(12*1, 0.5));
    	addParallel(new ManipulateTilt(500, -0.5)); //tilt intake down to switch
    	addSequential(new Sleep(250));
    	addSequential(new ManipulateBlock(2500, -0.5)); //shoot out block
    	
    	
    	
    	
    }
}
