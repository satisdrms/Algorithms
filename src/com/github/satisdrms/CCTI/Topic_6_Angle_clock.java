package com.github.satisdrms.CCTI;

//angle between minutes and hour clock

public class Topic_6_Angle_clock {
	public static void main(String[] args){
		int hr=4;
		int min=23;
		float hr_moved_angle=(float)0.5*min;
		float hr_angle=(float)(hr*30)+hr_moved_angle;
		float min_angle=(float)min*6;
		float angle_between_clock=hr_angle-min_angle;
		System.out.println(Math.abs(angle_between_clock));
	}

}
