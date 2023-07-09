package _07_Meeting_Scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MeetingScheduler {
	/*
	 * Your task is to code a method to find a meeting time for two people given
	 * their schedules.
	 * 
	 * Code the method below so that it returns a Schedule object that contains all
	 * the times during the week that are in BOTH people's schedules. The Schedule
	 * class is included in this package.
	 * 
	 * Example: person1 availability - Monday at 9, Tuesday at 14, and Friday 10
	 * person2 availability - Tuesday at 14, Friday 8, and Monday at 9 The returned
	 * HashMap should contain: Tuesday 14 and Monday 9
	 * 
	 * The returned Schedule object represents the times both people are available
	 * for a meeting.
	 * 
	 * Time availability is always at the top of the hour, so 9:30 is not valid Time
	 * availability always represents 1 hour Assume both schedules are in the same
	 * time zones
	 */
	public static Schedule getMutualAvailability(Schedule person1, Schedule person2) {
		HashMap<String, ArrayList<Integer>> schedule1 = person1.getSchedule();
		HashMap<String, ArrayList<Integer>> schedule2 = person2.getSchedule();
		Schedule availability = new Schedule();
		System.out.println(schedule1);
		for (String day : schedule1.keySet()) {
			System.out.println(day + " Times Available: " + schedule1.get(day));
			System.out.println(day + " Times Available: " + schedule2.get(day));
			for (int j = 0; j < schedule1.get(day).size(); j++) {
				System.out.println("this " + schedule1.get(day).get(j));
				
				for (int k = 0; k < schedule2.get(day).size(); k++) {
System.out.println("2nd this " + schedule2.get(day).get(k));

					if (schedule1.get(day).get(j) == schedule2.get(day).get(k)) {
						/*
						 * figure out how to return the schedule object that contains the times during
						 * the entire week that both peoples schedules have. This method finds if there
						 * is the same times for a single day but needs to be compiled into 1 schedule
						 * object to be returned
						 */

						availability.addAvailability(day, schedule1.get(day).get(j));
						System.out.println(" sched " + availability.getSchedule());

					}
				}

			}
			

		}
		return availability;
		
	}
}
