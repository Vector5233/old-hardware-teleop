package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by CCA on 3/8/2016.
 */
public class TestBotK92 extends OpMode{

    DcMotorController wheels;
    DcMotorController.DeviceMode devMode;
    DcMotor motorBackRight;
    DcMotor motorBackLeft;

    @Override
    public void init() {
        motorBackRight = hardwareMap.dcMotor.get("motorBR");
        motorBackLeft = hardwareMap.dcMotor.get("motorBL");

        motorBackRight.setDirection(DcMotor.Direction.FORWARD);
        motorBackLeft.setDirection(DcMotor.Direction.FORWARD);

        wheels = hardwareMap.dcMotorController.get("wheels");
    }

    @Override
    public void init_loop() {

        devMode = DcMotorController.DeviceMode.WRITE_ONLY;

        motorBackLeft.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        motorBackRight.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
    }

    @Override
    public void loop() {

        if(allowedToWrite()) {
            motorBackRight.setPower(gamepad1.right_stick_y);
            motorBackLeft.setPower(gamepad1.left_stick_y);
        }
    }

    private boolean allowedToWrite(){
        return (devMode == DcMotorController.DeviceMode.WRITE_ONLY);
    }

}