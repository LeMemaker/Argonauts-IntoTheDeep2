package org.firstinspires.ftc.teamcode.routines.driver;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.routines.Routine;
import org.firstinspires.ftc.teamcode.subsystems.System;

@TeleOp(name = "Driver")
public class DriverRoutine extends Routine {
	public System system = new System(this);

	@Override
	public void onInit() {
		super.onInit();
	}

	@Override
	public void onStart() {
		super.onStart();
<<<<<<< Updated upstream
=======
		while(opModeIsActive()){
			viperSystem.moveOnTick(gamepad1.dpad_up, gamepad1.dpad_down);

			telemetry.addData("Left Viper Motor", viperSystem.getViper_motor_l().getCurrentPosition());
			telemetry.addData("Right Viper Motor", viperSystem.getViper_motor_r().getCurrentPosition());

			clawSystem.toggleClaw(gamepad1.right_bumper);
			telemetry.addData("Left Servo Claw", clawSystem.getClaw_servo_l().getPosition());
			telemetry.addData("Right Servo Claw", clawSystem.getClaw_servo_r().getPosition());

			clawSystem.shoulderOnTick(gamepad1.y, gamepad1.a);
			driveSystem.driveOnTick(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);

			telemetry.addData("left_stick_x", gamepad1.left_stick_x);
			telemetry.addData("left_stick_y", gamepad1.left_stick_x);
			telemetry.addData("right_stick_x", gamepad1.right_stick_x);

			telemetry.update();
		}

>>>>>>> Stashed changes
	}

	@Override
	public void onExit() {
		super.onExit();
		system.onExit();
	}
}
