package frc.robot.swervelib;

public interface SwerveModule {
    double getDriveVelocity();

    double getSteerAngle();

    double getDriveMotorTemperature();

    double getSteerMotorTemperature();

    void set(double driveVoltage, double steerAngle);
}
