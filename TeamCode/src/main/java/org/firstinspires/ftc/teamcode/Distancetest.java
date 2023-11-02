package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@TeleOp
public class Distancetest extends LinearOpMode {


    private final org.firstinspires.ftc.teamcode.DistanceSensor distanceSensor = new DistanceSensor();
    @Override
    public void runOpMode() throws InterruptedException {
        distanceSensor.initDistance(hardwareMap, "distance");

        waitForStart();


        while (opModeIsActive()) {


            //telemetry.addData("distancesensor",distanceSensor );

            //distanceSensor.getDistance(DistanceUnit.INCH);
            //distanceSensor.get_Telemetry(telemetry);
            distanceSensor.rundistanceTeleop(telemetry);
            telemetry.update();
        }
    }
}
