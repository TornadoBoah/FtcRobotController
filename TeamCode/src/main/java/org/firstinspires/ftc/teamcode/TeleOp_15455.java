package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.*;
import org.firstinspires.ftc.teamcode.drivebase.*;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Call_Upon_Classes.*;
import org.firstinspires.ftc.teamcode.drivebase.MecanumDriver;

@TeleOp
public class TeleOp_15455 extends LinearOpMode {
    private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.Lift_15455 lift = new Lift_15455();
    private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.Intake_15455 intake = new Intake_15455();
    private final org.firstinspires.ftc.teamcode.drivebase.MecanumDrivingSample drive = new MecanumDrivingSample();
    //private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.Hang Hang = new Hang();
    public void runOpMode() throws InterruptedException {
        //Initialize objects
        lift.init_lift(hardwareMap, "lift");
        intake.init_intake(hardwareMap, "intake", "outCrs", "path");
        drive.init_drive(hardwareMap);
        //Hang.init_hang(hardwareMap, "Hang");

        waitForStart();
        while (opModeIsActive()) {
            lift.run_Lift(gamepad1, telemetry);
            intake.run_intake(gamepad2, telemetry);
            intake.run_outtake(gamepad2);
            intake.run_pasth(gamepad2);
            drive.run_drive(gamepad1, hardwareMap);
            //Hang.run_Hang(gamepad2, telemetry);
            telemetry.update();
        }
    }
}

