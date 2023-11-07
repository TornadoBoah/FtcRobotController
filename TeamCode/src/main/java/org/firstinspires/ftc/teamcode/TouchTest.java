package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.TouchSensor;


@TeleOp
public class TouchTest extends LinearOpMode {


    private final org.firstinspires.ftc.teamcode.Call_Upon_Classes.TouchSensor touchSensor = new TouchSensor();
    @Override
    public void runOpMode() throws InterruptedException {
        touchSensor.initTouch(hardwareMap);

        waitForStart();


        while (opModeIsActive()) {
            touchSensor.runTouch();
            touchSensor.getTelemetry(telemetry);
            telemetry.update();
        }
    }
}
