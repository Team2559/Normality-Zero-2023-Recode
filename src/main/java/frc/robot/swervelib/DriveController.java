package frc.robot.swervelib;

public interface DriveController {
    void setReferenceVoltage(double voltage);

    double getStateVelocity();

    double getStatePosition();

    double getMotorTemperature();
}
