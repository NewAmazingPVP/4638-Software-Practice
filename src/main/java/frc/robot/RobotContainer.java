package frc.robot;

import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer {
  // Define the subsystem and controller
  private final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
  private final XboxController controller = new XboxController(0);

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    ExampleCommand exampleCommand = new ExampleCommand(exampleSubsystem, controller);
    exampleSubsystem.setDefaultCommand(exampleCommand);
  }
}
