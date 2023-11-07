package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake_15455 {

    private DcMotor intake = null;
    private DcMotor pasth = null;
    private CRServo outCrs = null;


    private Telemetry telemetry = null;
    private double pw = 0;

    public void init_intake(HardwareMap map, String name, String name1, String name2) {
        intake = map.get(DcMotor.class, name);
        outCrs = map.get(CRServo.class, name1);
        pasth = map.get(DcMotor.class, name2);
    }


    public void run_intake(Gamepad gp, Telemetry telemetry) {
        double left = gp.left_trigger;
        double right = gp.right_trigger;

        if (left > 0) {
            pw = left;
        } else if (right > 0) {
            pw = -right;
        } else {
            pw = 0;
        }
        intake.setPower(pw);
    }

    public void run_pasth(Gamepad gp) {
        double move = gp.left_stick_y;
        if (move > .2 || move < -.2) {
            pasth.setPower(move);
        } else {
            pasth.setPower(0);
        }
    }

    public void run_outtake(Gamepad gp) {
        boolean but_x = gp.x;
        if (but_x) {
            outCrs.setPower(1);
        } else {
            outCrs.setPower(0);
        }
    }


    public void get_telemetry(Telemetry telemetry) {
        telemetry.addData("Intake Power", pw);
    }

    public void auto_intake(boolean open) {

    }
}

