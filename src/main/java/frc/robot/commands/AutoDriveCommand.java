package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.math.controller.HolonomicDriveController;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.Timer;

public class AutoDriveCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrain;
    private final HolonomicDriveController controller;
    // private final DoubleSupplier translationXSupplier;
    // private final DoubleSupplier translationYSupplier;
    // private final DoubleSupplier rotationSupplier;
    private final Trajectory path;
    private final Timer timer = new Timer(); 

    public AutoDriveCommand(
            DrivetrainSubsystem drivetrain,
            Trajectory path
    ) {
        this.drivetrain = drivetrain;
        this.controller = new HolonomicDriveController(Constants.xController, Constants.yController, Constants.omegaController);
        this.path = path;

        addRequirements(drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        timer.reset();
        timer.start();
        drivetrain.resetPosition();
    }

    @Override
    public void execute() {
        Trajectory.State goal = path.sample(timer.get());

        ChassisSpeeds speeds = controller.calculate(drivetrain.getPose(), goal, Rotation2d.fromDegrees(0));

        drivetrain.drive(
                ChassisSpeeds.fromFieldRelativeSpeeds(
                        speeds,
                        drivetrain.getRotation()
                )
        );
    }

    @Override
    public void end(boolean interrupted) {
        // Stop the drivetrain
        drivetrain.drive(new ChassisSpeeds(0.0, 0.0, 0.0));

    }
    // The command runs until a set time has elapsed, where the set timer is set in the "has elapsed" function/if statement.
    @Override
    public boolean isFinished() {
        if (timer.hasElapsed(path.getTotalTimeSeconds()))
            return true;
        else
            return false;
        
         
    }

}