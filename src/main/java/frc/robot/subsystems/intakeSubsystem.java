package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;

public class intakeSubsystem extends SubsystemBase {
     
    // Manages the motors for the intake system.  

    private CANSparkMax m_IntakeTopMotor = new CANSparkMax(Constants.TOP_ROLLER_MOTOR, CANSparkMax.MotorType.kBrushed);
    private CANSparkMax m_IntakeBottomMotor = new CANSparkMax(Constants.BOTTOM_ROLLER_MOTOR, CANSparkMax.MotorType.kBrushed);

    public void runIntake (double topIntakeSpeed, double bottomIntakeSpeed) {

        //run the motors to the intake
        m_IntakeBottomMotor.set(bottomIntakeSpeed);
        m_IntakeTopMotor.set(topIntakeSpeed);

    }

    public void stop () {

        // Stop the intake
        m_IntakeBottomMotor.set(0);
        m_IntakeTopMotor.set(0);
    }

}
