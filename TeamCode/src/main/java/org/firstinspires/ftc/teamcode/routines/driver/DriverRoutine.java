package org.firstinspires.ftc.teamcode.routines.driver;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.routines.Routine;
import org.firstinspires.ftc.teamcode.subsystems.ClawSystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSystem;
import org.firstinspires.ftc.teamcode.subsystems.System;
import org.firstinspires.ftc.teamcode.subsystems.ViperSystem;

@TeleOp(name = "Driver")
public class DriverRoutine extends Routine {
	public ViperSystem viperSystem;
	public ClawSystem clawSystem;
	DriveSystem driveSystem;

	@Override
	public void onInit() {
		super.onInit();
		viperSystem = new ViperSystem(this);
		clawSystem = new ClawSystem(this);
		driveSystem = new DriveSystem(this);
	}

	@Override
	public void onStart() {
		super.onStart();
		while(opModeIsActive()){
			viperSystem.moveOnTick(gamepad1.y, gamepad1.a);

			telemetry.addData("Left Viper Motor", viperSystem.getViper_motor_l().getCurrentPosition());
			telemetry.addData("Right Viper Motor", viperSystem.getViper_motor_r().getCurrentPosition());

			clawSystem.toggleClaw(gamepad1.b);
			telemetry.addData("Left Servo Claw", clawSystem.getClaw_servo_l().getPosition());
			telemetry.addData("Right Servo Claw", clawSystem.getClaw_servo_r().getPosition());

			clawSystem.shoulderOnTick(gamepad1.dpad_right, gamepad1.dpad_left);
			driveSystem.driveOnTick(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

			telemetry.addData("left_stick_x", gamepad1.left_stick_x);
			telemetry.addData("left_stick_y", gamepad1.left_stick_x);
			telemetry.addData("right_stick_x", gamepad1.right_stick_x);

			telemetry.update();
		}

	}

}
