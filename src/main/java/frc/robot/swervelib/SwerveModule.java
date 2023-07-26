package frc.robot.swervelib;

import edu.wpi.first.math.kinematics.SwerveModulePosition;

public interface SwerveModule {
    double getDriveVelocity();

    double getSteerAngle();

    SwerveModulePosition getPosition();

    double getDriveMotorTemperature();

    double getSteerMotorTemperature();

    void set(double driveVoltage, double steerAngle);
}
