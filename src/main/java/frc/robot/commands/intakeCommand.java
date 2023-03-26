package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.intakeSubsystem;

import edu.wpi.first.wpilibj.Timer;

public class intakeCommand extends CommandBase {
    
    private intakeSubsystem m_IntakeSubsystem;
    

    // directionIntake int for in(1), out(2) or stop(0)
    private int directionIntake = 0;
    private double topIntakeSpeed = Constants.RollerSpeed;
    private double bottomIntakeSpeed = Constants.RollerSpeed * 0.5;
    private final Timer timer = new Timer();

    // Public method to calculate and intake the cube
    public intakeCommand (intakeSubsystem m_IntakeSubsystem, int directionIn) {

        this.m_IntakeSubsystem = m_IntakeSubsystem;
        this.directionIntake = directionIn;

    }

    public void stop () {
        // tell intake to stop
        m_IntakeSubsystem.stop();        
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        
        // Reset timer and start.
        timer.reset();
        timer.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute () {
        
        // Use the directionIntake to assign the direction of the ball
        if (this.directionIntake == 1) {
            this.topIntakeSpeed = Constants.RollerSpeed;
            this.bottomIntakeSpeed = Constants.RollerSpeed * 0.5;
        } else if (this.directionIntake == 2) {
            this.topIntakeSpeed = Constants.RollerSpeed * -1;
            this.bottomIntakeSpeed = Constants.RollerSpeed * -0.5;
        } else if (this.directionIntake == 0) {
            this.topIntakeSpeed = 0.0;
            this.bottomIntakeSpeed = 0.0;
        }

        //tell the intake to start up
        m_IntakeSubsystem.runIntake(topIntakeSpeed, bottomIntakeSpeed);
     }

     // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

        //Stop the intake
        m_IntakeSubsystem.stop();

        //End timer
        timer.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
       return timer.hasElapsed(3.0);
    }

}
