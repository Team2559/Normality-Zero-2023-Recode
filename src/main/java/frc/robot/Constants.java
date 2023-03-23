// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static final double DRIVETRAIN_TRACKWIDTH_METERS = 0.2794;
  public static final double DRIVETRAIN_WHEELBASE_METERS = 0.2794;

  public static final int DRIVETRAIN_PIGEON_ID = 0;

  public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 7;
  public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 8;
  public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 13;
  public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(34.54);

  public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 1;
  public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 2;
  public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 10;
  public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(118.52);

  public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 5;
  public static final int BACK_LEFT_MODULE_STEER_MOTOR = 6;
  public static final int BACK_LEFT_MODULE_STEER_ENCODER = 12;
  public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(71.99);

  public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 3;
  public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 4;
  public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 11;
  public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(261.71);

  //These are the shooter can IDs for the robot
  public static final int LEFT_SHOOTER = 15;
  public static final int RIGHT_SHOOTER = 16;

  //And these are the intake IDs, use them carefully
  public static final int TOP_ROLLER_MOTOR = 17;
  public static final int BOTTOM_ROLLER_MOTOR = 14;
  public static final int INCLINE_MOTOR = 18;
}