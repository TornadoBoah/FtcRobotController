package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class DistanceSensor {
    private Rev2mDistanceSensor ds = null;
    private Rev2mDistanceSensor dso = null;
    public double distance = 0;
    public boolean found = false;
    public double idealdistance = 6;
    public boolean allignedTOp = false;
    public double pxlcount = 0;
    public double pxlmax= 2;


    public void initDistance(HardwareMap hardwareMap, String name) {
        ds = hardwareMap.get(Rev2mDistanceSensor.class,name);
    }
    public void rundistanceTeleop(Telemetry telemetry) {
        if (ds.getDistance(DistanceUnit.INCH) <= idealdistance) {
            allignedTOp = true;
            if ((pxlcount < pxlmax) && (!found)) {
                pxlcount += 1;
                found = true;
                if (dso.getDistance(DistanceUnit.INCH) <= idealdistance) {
                    allignedTOp = true;
                    if ((pxlcount < pxlmax) && (!found)) {
                        pxlcount -= 1;
                    }
            }
        } else {
            found = false;
            allignedTOp = false;
        }

            }
        get_Telemetry(telemetry);

        if (pxlcount >= pxlmax) {
            pxlcount = 2;
        }
    }

    public double getPxlcount() {
            return pxlcount;
    }

    public boolean isFound() {
        return found;
    }

    public void get_Telemetry (Telemetry telemetry) {
        telemetry.addData("Distance", ds.getDistance(DistanceUnit.INCH));
        telemetry.addData("alligned with pole", allignedTOp);
        telemetry.addData("pxlcount", pxlcount);
    }

    public double ds() {
        return distance;
    }
}



