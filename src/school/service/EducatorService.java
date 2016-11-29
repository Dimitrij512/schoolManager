package school.service;

import school.controller.SystemSchool;
import school.db.Db;
import school.model.Educator;
import school.model.Guest;
import school.model.Role;
import school.model.Student;
import school.model.Subject;

public class EducatorService extends StudentService {

	@Override
	public void toShowAvaliableMethods() {
		System.out.println("Avaliable service for you : ");
		System.out.println("show schedule : press 1");
		System.out.println("show students : press 2");
		System.out.println("add raiting   : press 3");
	}

	public void toAddRaiting() {
		SystemSchool sysSchool = new SystemSchool();
		Role role = new Role();
		String educatorSubject = null;
		boolean isDirector = false;
		toShowStudentOfClasses();
		System.out.println("Enter student`s surname : ");
		String surname = sysSchool.enterNumber();
		if (Db.currentUser.getRole() == role.getEducator()) {
			Educator educator = (Educator) Db.currentUser;
			educatorSubject = educator.getSubject().getName();
		} else if (Db.currentUser.getRole() == role.getDirector()) {
			isDirector = true;
		}
		int iterUser = toFindUser(surname);
		Student student = (Student) Db.users.get(iterUser);
		if (educatorSubject != null || isDirector) {
			for (int i = 0; i < student.getLessons().size(); i++) {
				Subject subject = student.getLessons().get(i);
				String subjectName = subject.getName();
				if (educatorSubject != null && subjectName.equals(educatorSubject)) {
					System.out.println("Enter raiting for " + subjectName);
					int raiting = Integer.parseInt(sysSchool.enterNumber());
					subject.setRaiting(raiting);
					break;
				} else if (isDirector) {
					System.out.println(i + subjectName);
				}
			}
			if (isDirector) {
				System.out.println("Enter numb of subject : ");
				int numbeOfSubject = Integer.parseInt(sysSchool.enterNumber());
				String nameSubject = student.getLessons().get(numbeOfSubject).getName();
				System.out.println("Enter raiting for " + nameSubject);
				int raiting = Integer.parseInt(sysSchool.enterNumber());
				student.getLessons().get(numbeOfSubject).setRaiting(raiting);
			}
		}
	}

	// цей метод повертає індекс в колекції в якій є співпадіння фамілії
	public int toFindUser(String surname) {
		int result = -1;
		for (int i = 0; i < Db.users.size(); i++) {
			Guest guest = Db.users.get(i);
			String guestSurname = guest.getSurname();
			if (guestSurname.equals(surname)) {
				result = i;
				return result;
			}
		}
		if (result == -1) {
			System.out.println("ERROR FIND SURNAME HAVE NOT THIS SURNAME !!!!");
		}
		return result;
	}

}
