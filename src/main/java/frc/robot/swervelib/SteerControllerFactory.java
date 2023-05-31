package frc.robot.swervelib;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;

@FunctionalInterface
public interface SteerControllerFactory<Controller extends SteerController, SteerConfiguration> {
    default void addDashboardEntries(
            ShuffleboardContainer container,
            Controller controller
    ) {
        container.addNumber("Current Angle", () -> Math.toDegrees(controller.getStateAngle()));
        container.addNumber("Target Angle", () -> Math.toDegrees(controller.getReferenceAngle()));
        container.addNumber("Steer Temperature (\u00B0C)", controller::getMotorTemperature);
    }

    default Controller create(
            ShuffleboardContainer dashboardContainer,
            SteerConfiguration steerConfiguration,
            ModuleConfiguration moduleConfiguration
    ) {
        var controller = create(steerConfiguration, moduleConfiguration);
        addDashboardEntries(dashboardContainer, controller);

        return controller;
    }

    Controller create(SteerConfiguration steerConfiguration, ModuleConfiguration moduleConfiguration);
}
