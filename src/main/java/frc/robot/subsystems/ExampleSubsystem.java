// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// WPI imports
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Other imports
import edu.wpi.first.wpilibj.Servo;
import com.revrobotics.CANSparkMax;

// Robot import statements
import frc.robot.Constants;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.ShooterSubsystem;


public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  final CANSparkMax m_LeftShootMotor = new CANSparkMax(Constants.LEFT_SHOOTER, CANSparkMax.MotorType.kBrushed);
  final CANSparkMax m_RightShootMotor = new CANSparkMax(Constants.RIGHT_SHOOTER, CANSparkMax.MotorType.kBrushed);
  final Servo shooterServo = new Servo(Constants.ShootServo);

  public ExampleSubsystem() {

  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    
    return runOnce(
        () -> {
          /* one-time action goes here */


          //Set the speed for each shooter motor based on the constant speed 
          m_LeftShootMotor.set(Constants.HighShot);
          m_RightShootMotor.set(Constants.HighShot);

          //Push cube into the shooter with the servo
          shooterServo.setAngle(Constants.ShootServoAngle);

          shooterServo.setAngle(Constants.ShootServoReset);

        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
