package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.BalanceCommand;
import frc.robot.commands.PositionArm;
import frc.robot.commands.PositionWrist;
import frc.robot.commands.SetIntake;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shoulder;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.Wrist;

public class DoubleScorePickupAuto extends SequentialCommandGroup {
    public DoubleScorePickupAuto(Swerve s_Swerve, Intake i_Intake, Shoulder s_Shoulder, Wrist w_Wrist){

        Command getCube = PathPlannerLoader.getAutoCommand(s_Swerve, "Node to Cube");
        Command returnToNode = PathPlannerLoader.getAutoCommand(s_Swerve, "Cube to Node");

        addCommands(
            // new PositionArm(s_Shoulder, w_Wrist, 2),
            // new WaitCommand(1),
            // new PositionWrist(w_Wrist, 2),
            // new WaitCommand(1),
            // new SetIntake(i_Intake, true, false),
            // new WaitCommand(0.5),
            // new SetIntake(i_Intake, false, false),
            // new WaitCommand(0.2),
            // new PositionArm(s_Shoulder, w_Wrist, 0),
            // new WaitCommand(3),
            getCube,
            new SetIntake(i_Intake, true, true),
            new WaitCommand(1),
            new SetIntake(i_Intake, false, true),
            returnToNode
        );
    }
}