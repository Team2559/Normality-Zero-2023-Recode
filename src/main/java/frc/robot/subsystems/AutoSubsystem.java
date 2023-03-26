// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Servo;
import com.revrobotics.CANSparkMax;

public class AutoSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public AutoSubsystem() {

  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase autoMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
          // declare the shooter
          /* 
          //Method to Declare the motor controllers
          private CANSparkMax m_LeftShootMotor = new CANSparkMax(Constants.LEFT_SHOOTER, CANSparkMax.MotorType.kBrushed);
          private CANSparkMax m_RightShootMotor = new CANSparkMax(Constants.RIGHT_SHOOTER, CANSparkMax.MotorType.kBrushed);
          private Servo shooterServo = new Servo(Constants.ShootServo);
          
          //Set the speed for each shooter motor based on the constant speed 
          m_LeftShootMotor.set(speed);
          m_RightShootMotor.set(speed);

        //Push cube into the shooter with the servo
        shooterServo.setAngle(Constants.ShootServoAngle);

*/
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
