// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Auto2023;
import frc.robot.commands.Autos;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.intakeCommand;
import frc.robot.subsystems.intakeSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

public class RobotContainer {
  // Creates the subSystem for example, not used in code just reference for learning.
  //private final ExampleSubsystem myExampleSubsystem = new ExampleSubsystem();
  
  // Creates an object of the drivetrainsubsystem, intakesubsystem and shootersubsystem
  private final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
  private final intakeSubsystem m_IntakeSubsystem = new intakeSubsystem();
  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();

  // Set the USB ports for the controllers.  Verify the Operator as #0
  private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  
  // Initialize operator controller
  private final XboxController m_operatorController = new XboxController(OperatorConstants.kOperatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    configureBindings();

    drivetrain.register();

    drivetrain.setDefaultCommand(new DriveCommand(drivetrain,
            () -> -modifyAxis(m_driverController.getLeftY()), // Axes are flipped here on purpose
            () -> -modifyAxis(m_driverController.getLeftX()),
            () -> -modifyAxis(m_driverController.getRightX())
    ));
  }

  public DrivetrainSubsystem getDrivetrain() {
    return drivetrain;
  }

  public ShooterSubsystem getShooterSubsystem() {
    return m_ShooterSubsystem;
  }

  public intakeSubsystem getIntakeCommand() {
    return m_IntakeSubsystem;
  }

  private static double deadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
        if (value > 0.0) {
            return (value - deadband) / (1.0 - deadband);
        } else {
            return (value + deadband) / (1.0 - deadband);
        }
    } else {
        return 0.0;
    }
}

private static double modifyAxis(double value) {
    // Deadband
    value = deadband(value, 0.05);

    // Square the axis
    value = Math.copySign(value * value, value);

    return value;
}

/**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Configure the trigger bindings


    // Intake button configurations
    new JoystickButton(m_operatorController, XboxController.Button.kA.value).onTrue(new intakeCommand(m_IntakeSubsystem, 1));
    
    // Expell from intake system
    new JoystickButton(m_operatorController, XboxController.Button.kB.value).onTrue(new intakeCommand(m_IntakeSubsystem, 2)); 
    
    // Stop button for intake
    new JoystickButton(m_operatorController, XboxController.Button.kX.value).onTrue(new intakeCommand(m_IntakeSubsystem, 0));

    // Run intake at higher speed
    new JoystickButton(m_operatorController, XboxController.Button.kY.value).onTrue(new intakeCommand(m_IntakeSubsystem, 3));

    // Start shooter low shot - Spins up the shooter motors for layer 2 shot
    new JoystickButton(m_operatorController, XboxController.Button.kLeftBumper.value).onTrue(new ShootCommand(m_ShooterSubsystem, 0));

    // Start shooter high shot - Spins up the shoorter motors for layer 3 shot
    new JoystickButton(m_operatorController, XboxController.Button.kRightBumper.value).onTrue(new ShootCommand(m_ShooterSubsystem, 1));
  
    // Stop the shooter
    // new JoystickButton(m_operatorController, XboxController.Button.kY.value).onTrue(new ShootCommand(m_ShooterSubsystem, 2));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    //return Autos.exampleAuto(m_ShooterSubsystem);
    //return ExampleCommand.exampleMethodCommand();
    //return new ShootCommand.(m_ShooterSubsystem, 0);
   

    //return new DriveCommand(drivetrain, null, null, null);

    //final DoubleSupplier dblMotor = 0.2;


    //return new SequentialCommandGroup(new DriveCommand(drivetrain, () -> 0.2, null, null));
    
    return new SequentialCommandGroup(new ShootCommand(m_ShooterSubsystem, 0), 
      new DriveCommand(drivetrain, () -> 0.2, () -> 0.0, () -> 0.0)); 
    
  
  } 
}