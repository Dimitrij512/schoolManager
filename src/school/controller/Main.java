package school.controller;

import school.autentification.Autentification;
import school.db.Db;
import school.dbInitial.DbInitial;
import school.model.Director;
import school.model.Educator;
import school.model.Guest;
import school.model.Role;
import school.model.Student;
import school.service.GuestService;

public class Main {
	public static void main(String[] args) {
		Autentification autentification = new Autentification();
		SystemSchool sysSchool = new SystemSchool();
		Role role = new Role();
		GuestService gueService = new GuestService();

		DbInitial.initialUser();
		DbInitial.initialClases();
		DbInitial.initialALLSubject();
		DbInitial.initialAudience();
		autentification.autentificationGuest();
		sysSchool.createShedule();

		gueService.showSchedule();

		Guest guest = Db.currentUser;

		if (guest.getRole() == role.getStudent()) {

			Student student = (Student) guest;
			System.out.println(student.getName());
			System.out.println(student.getClas());

		} else if (guest.getRole() == role.getEducator()) {
			Educator educator = (Educator) guest;
			System.out.println(educator.getName());
			System.out.println(educator.getSubject().getName());

		} else if (guest.getRole() == role.getDirector()) {
			Director director = (Director) guest;
			System.out.println(director.getName());
		}
	}

}
