package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class ExampleCommand extends Command {
  private final ExampleSubsystem subsystem;
  private final XboxController controller;

  public ExampleCommand(ExampleSubsystem subsystem, XboxController controller) {
    this.subsystem = subsystem;
    this.controller = controller;
    addRequirements(subsystem);  // Declare subsystem dependency
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    // Get joystick values for motor control
    double leftSpeed = controller.getLeftY();  // Left joystick Y-axis for left motor (sends values from -1 to 1)
    double rightSpeed = controller.getRightY();  // Right joystick Y-axis for right motor (sends values from -1 to 1)

    if (controller.getAButton()){
      subsystem.setTargetVelocity(4000); // RPM the motors should rotate at (perferred way to do since its using PID)
    } else if (controller.getBButton()){
      // Non-prefered way of directly setting the motor speed
      subsystem.setSpeed(leftSpeed, rightSpeed);  // Call setSpeed to control motors (From -1 to 1 where 1 is max speed and 0 is no speed and -1 is max reverse)
    } else {
      subsystem.setSpeed(0, 0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    // Stop motors if the command ends
    subsystem.setSpeed(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;  // Command doesn't finish on its own
  }
}
