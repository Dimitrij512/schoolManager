package school.db;

import java.util.ArrayList;
import java.util.List;

import school.model.Audience;
import school.model.Clas;
import school.model.Guest;
import school.model.ScheduleSubject;
import school.model.Subject;

public class Db {
	public static List<Guest> users = new ArrayList<Guest>();

	public static List<Subject> subjects = new ArrayList<Subject>();
	public static List<Audience> audiences = new ArrayList<Audience>();
	public static List<Clas> clases = new ArrayList<Clas>();
	public static List<ArrayList<ScheduleSubject>> schedule = new ArrayList<ArrayList<ScheduleSubject>>();
	public static Guest currentUser;

}
