package org.firstinspires.ftc.teamcode.routines.driver;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.routines.Routine;
import org.firstinspires.ftc.teamcode.subsystems.ClawSystem;
import org.firstinspires.ftc.teamcode.subsystems.System;
import org.firstinspires.ftc.teamcode.subsystems.ViperSystem;

@TeleOp(name = "Driver")
public class DriverRoutine extends Routine {
	public ViperSystem viperSystem;
	public ClawSystem clawSystem;

	@Override
	public void onInit() {
		super.onInit();
		viperSystem = new ViperSystem(this);
		clawSystem = new ClawSystem(this);

	}

	@Override
	public void onStart() {
		super.onStart();
		while(opModeIsActive()){
			viperSystem.moveOnTick(gamepad1.y, gamepad1.a);

			telemetry.addData("Left Viper Motor", viperSystem.getViper_motor_l().getCurrentPosition());
			telemetry.addData("Right Viper Motor", viperSystem.getViper_motor_r().getCurrentPosition());
			telemetry.update();
		}
		while(opModeIsActive()){
			clawSystem.toggleClaw(gamepad1.b);
			telemetry.addData("Left Servo Claw", clawSystem.getClaw_servo_l().getPosition());
			telemetry.addData("Right Servo Claw", clawSystem.getClaw_servo_r().getPosition());
			telemetry.update();
		}

	}

}
