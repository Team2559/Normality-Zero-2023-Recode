package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Timer;

public class ShootCommand extends CommandBase {
    
    private ShooterSubsystem m_ShooterSubsystem;
    private int ShotLevel = 0;
    private final Timer timer = new Timer(); 

    public ShootCommand (ShooterSubsystem m_ShooterSubsystem, int ShotLevel) {

        this.m_ShooterSubsystem = m_ShooterSubsystem;
        this.ShotLevel = ShotLevel;
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }


    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {        
        //Check the shot level that is passed from the controller command.
        if (ShotLevel == 1) {
            this.m_ShooterSubsystem.engageShooter(Constants.HighShot);
        }
        else if (ShotLevel == 0) {
            this.m_ShooterSubsystem.engageShooter(Constants.LowShot);
        }
        else if (ShotLevel == 2) {
            this.isFinished();
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return timer.hasElapsed(3.0);
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {}

}
