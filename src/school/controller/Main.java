package school.controller;

import school.autentification.Autentification;
import school.db.Db;
import school.dbInitial.DbInitial;
import school.model.Director;
import school.model.Educator;
import school.model.Guest;
import school.model.Role;
import school.model.Student;
import school.service.DirectorService;
import school.service.EducatorService;
import school.service.GuestService;
import school.service.StudentService;

public class Main {
	public static void main(String[] args) {
		Autentification autentification = new Autentification();
		SystemSchool sysSchool = new SystemSchool();
		Role role = new Role();
		GuestService guestService = new GuestService();
		StudentService studentService = new StudentService();
		EducatorService educatorService = new EducatorService();
		DirectorService directorService = new DirectorService();

		DbInitial.initialUser();
		DbInitial.initialSubjectForStudent();
		DbInitial.initialClases();
		DbInitial.initialALLSubject();
		DbInitial.initialSubjectForStudent();
		DbInitial.initialAudience();

		autentification.autentificationGuest();
		sysSchool.createShedule();
		Guest guest = Db.currentUser;
		sysSchool.toShowWelcomePage();

		int paramert = 0;

		if (guest.getRole() == role.getStudent()) {
			Student student = (Student) guest;
			studentService.toShowAvaliableMethods();
			paramert = Integer.parseInt(sysSchool.enterNumber());

			if (paramert == 1) {
				guestService.showSchedule();
			} else if (paramert == 2) {
				studentService.toShowStudentOfClasses();
			}

		} else if (guest.getRole() == role.getEducator()) {
			Educator educator = (Educator) guest;
			educatorService.toShowAvaliableMethods();
			paramert = Integer.parseInt(sysSchool.enterNumber());

			if (paramert == 1) {
				guestService.showSchedule();
			} else if (paramert == 2) {
				educatorService.toShowStudentOfClasses();
			} else if (paramert == 3) {
				educatorService.toAddRaiting();
			}

		} else if (guest.getRole() == role.getDirector()) {
			Director director = (Director) guest;
			directorService.toShowAvaliableMethods();
			paramert = Integer.parseInt(sysSchool.enterNumber());

			if (paramert == 1) {
				guestService.showSchedule();
			} else if (paramert == 2) {
				directorService.toShowStudentOfClasses();
			} else if (paramert == 3) {
				directorService.toAddRaiting();
			}

		}
	}

}
