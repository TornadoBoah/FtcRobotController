package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.DistanceSensor;

@TeleOp
public class Distancetest extends LinearOpMode {

    private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.DistanceSensor distanceSensor = new DistanceSensor();
    @Override
    public void runOpMode() throws InterruptedException {
        distanceSensor.initDistance(hardwareMap, "ds");

        waitForStart();

        while (opModeIsActive()) {

            distanceSensor.rundistanceTeleop(telemetry);
            telemetry.update();
        }
    }
}
