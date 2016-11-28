package school.service;

import school.db.Db;
import school.model.Director;
import school.model.Educator;
import school.model.Role;
import school.model.ScheduleSubject;
import school.model.Student;

public class GuestService {

	public void showSchedule() {
		int clasNumb = 0;
		String subjectName = null;
		Role role = new Role();
		int directorRole = 0;
		int currentRole = Db.currentUser.getRole();
		if (role.getStudent() == currentRole) {
			Student student = (Student) Db.currentUser;
			clasNumb = student.getClas();
		} else if (role.getEducator() == currentRole) {
			Educator educator = (Educator) Db.currentUser;
			subjectName = educator.getSubject().getName();
		} else if (role.getDirector() == currentRole) {
			Director director = (Director) Db.currentUser;
			directorRole = director.getRole();
		}

		int equalClass = 0;
		int equalDayOfWeek = 0;

		for (int i = 0; i < Db.schedule.size(); i++) {
			ScheduleSubject subject = Db.schedule.get(i);
			int subjectClasNumb = subject.getClas();
			String subjectLesson = subject.getNameLesson();
			int subjectDayOfWeek = subject.getDayOfWeek();
			int subjectCountLesson = subject.getNumbLesson();
			int subjectAudience = subject.getAudience();

			if (directorRole != 0 || clasNumb != 0 || subjectName != null) {
				if (directorRole != 0 || clasNumb == subjectClasNumb || subjectName != null && subjectName.equals(subjectLesson)) {
					if (equalClass != subjectClasNumb) {
						System.out.println("-------------------");
						System.out.println("Class : " + subjectClasNumb);
						equalClass = subjectClasNumb;
					}
					if (equalDayOfWeek != subjectDayOfWeek) {
						System.out.println("-------------------");
						System.out.println("DAY: " + subjectDayOfWeek);
						System.out.println("-------------------");
						equalDayOfWeek = subjectDayOfWeek;
					}
					System.out.print(subjectCountLesson + " " + subjectAudience + " " + subjectLesson);
					System.out.println();

				}
			}
		}
	}
}
