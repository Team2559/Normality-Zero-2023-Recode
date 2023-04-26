package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import com.revrobotics.CANSparkMax;


public class ShooterSubsystem extends SubsystemBase {


     /* Shooter subsystem.  
      *  - Spins up the motors based on inputs of high or low shot.
      *  - Pushes cube into the shooter with servo
      *  - Shoots the cube
      *  - Stops the motors & resets the pushing device 
      */

    //Method to Declare the motor controllers
    private CANSparkMax m_LeftShootMotor = new CANSparkMax(Constants.LEFT_SHOOTER, CANSparkMax.MotorType.kBrushed);
    private CANSparkMax m_RightShootMotor = new CANSparkMax(Constants.RIGHT_SHOOTER, CANSparkMax.MotorType.kBrushed);
    private Servo shooterServo = new Servo(Constants.ShootServo);

     // Insert command for the servo to push cube into shooter

    public ShooterSubsystem () {

    }

    // Method to shoot the cube
    public void engageShooter (double speed) {
   
      
        //Set the speed for each shooter motor based on the constant speed 
        m_LeftShootMotor.set(speed);
        m_RightShootMotor.set(speed);
        shooterServo.setAngle(Constants.ShootServoAngle);

        // Stop shooter, reset the servo
        //m_LeftShootMotor.stopMotor();
        //m_RightShootMotor.stopMotor();

        // Reset the cube pushing servo
        shooterServo.setAngle(Constants.ShootServoReset);
      
    }

     // Method to stop the shooter
     public void stop () {

        //Stop the shooter from shooting
        m_LeftShootMotor.stopMotor();
        m_RightShootMotor.stopMotor();

        // Reset the cube pushing servo
        shooterServo.setAngle(Constants.ShootServoReset);

     }

    
  
}
