package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TouchSensor {
    private RevTouchSensor toucher1 = null;
    private RevTouchSensor toucher2 = null;
    private boolean touched = false;
    private boolean touch1 = false;
    private boolean touch2 = false;

    public void initTouch(HardwareMap hardwareMap) {
        toucher1 = hardwareMap.get(RevTouchSensor.class,"ts1");
        toucher2 = hardwareMap.get(RevTouchSensor.class,"ts2");
    }

    public void runTouch() {
        if (toucher1.isPressed() || toucher2.isPressed()) {
            touched = true;
        }
        else {
            touched = false;
        }

        if (toucher1.isPressed()){
            touch1 = true;
        } else {
            touch1 = false;
        }

        if (toucher2.isPressed()) {
            touch2 = true;
        } else {
            touch2 = false;
        }
    }

    public void getTelemetry(Telemetry telemetry) {
        telemetry.addData("Is Pressed: ", touched);
        telemetry.addData("Toucher 1 Is Pressed: ", touch1);
        telemetry.addData("Toucher 2 Is Pressed: ", touch2);
    }
}
