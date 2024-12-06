package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
    private final CANSparkMax leftMotor = new CANSparkMax(1, CANSparkLowLevel.MotorType.kBrushless);  // Left motor on CAN ID 1
    private final CANSparkMax rightMotor = new CANSparkMax(2, CANSparkLowLevel.MotorType.kBrushless); // Right motor on CAN ID 2
    private final SparkPIDController leftPIDController = leftMotor.getPIDController();
    private final SparkPIDController rightPIDController = rightMotor.getPIDController();
    private final RelativeEncoder leftEncoder = leftMotor.getEncoder();
    private final RelativeEncoder rightEncoder = rightMotor.getEncoder();

    public ExampleSubsystem() {
        // Set motors to brake mode
        leftMotor.setIdleMode(CANSparkMax.IdleMode.kCoast);
        rightMotor.setIdleMode(CANSparkMax.IdleMode.kCoast);

        // Configure PID controllers with only the P term for simplicity
        leftPIDController.setP(0.00001); // P value for left motor
        rightPIDController.setP(0.00001); // P value for right motor
        leftPIDController.setFF(0.0005);
        rightPIDController.setFF(0.0005);
    }

    // Method to set a target velocity for both motors
    public void setTargetVelocity(double targetVelocity) {
        // Set target velocity for each motor using PID control
        leftPIDController.setReference(targetVelocity, CANSparkMax.ControlType.kVelocity);
        rightPIDController.setReference(targetVelocity, CANSparkMax.ControlType.kVelocity);
    }

    // Method to set motor speeds
    public void setSpeed(double leftSpeed, double rightSpeed) {
        leftMotor.set(leftSpeed);  // Set speed for left motor
        rightMotor.set(rightSpeed);  // Set speed for right motor
        // this will cause a conflict
        //This is for the speed of the robot
    }


    @Override
    public void periodic() {
        // Called periodically (e.g., every 20ms)
        // No additional actions needed here for now
    }
}
//hello