package school.service;

import java.util.List;

import school.db.Db;
import school.model.Clas;
import school.model.Director;
import school.model.Educator;
import school.model.Role;
import school.model.Student;
import school.model.Subject;

public class StudentService {
	public void toShowAvaliableMethods() {
		System.out.println("Avaliable service for you : ");
		System.out.println("show schedule : press 1");
		System.out.println("show students : press 2");
	}

	public void toShowStudentOfClasses() {
		Role role = new Role();
		int currentRole = Db.currentUser.getRole();
		int studentClasNumb = 0;
		String nameSubject = null;
		int directorRole = 0;
		if (role.getStudent() == currentRole) {
			Student student = (Student) Db.currentUser;
			studentClasNumb = student.getClas();

		} else if (role.getEducator() == currentRole) {
			Educator educator = (Educator) Db.currentUser;
			nameSubject = educator.getSubject().getName();

		} else if (role.getDirector() == currentRole) {
			Director director = (Director) Db.currentUser;
			directorRole = director.getRole();
		}
		int equalClass = 0;

		for (int i = 0; i < Db.clases.size(); i++) {
			Clas clas = Db.clases.get(i);
			int clasNumber = clas.getNumb();
			List<Student> listStudents = clas.getStudents();

			if (directorRole != 0 || studentClasNumb != 0 || nameSubject != null) {
				System.out.println("test - " + nameSubject);
				if (directorRole != 0 || studentClasNumb == clasNumber || isSubjecInStudent(listStudents, nameSubject)) {
					if (equalClass != clasNumber) {
						System.out.println("-------------------");
						System.out.println("Class : " + clasNumber);
						equalClass = clasNumber;
					}
					for (int j = 0; j < listStudents.size(); j++) {
						Student student = listStudents.get(j);
						String name = student.getName();
						String surname = student.getSurname();
						System.out.println("Clas numb : " + i + " student numb : " + j + " name : " + name + " " + surname);

					}
				}
			}

		}
	}

	public boolean isSubjecInStudent(List<Student> listStudent, String nameSubject) {
		boolean result = false;
		if (nameSubject != null && listStudent.size() > 0) {
			outer: for (int i = 0; i < listStudent.size(); i++) {
				List<Subject> listSubject = listStudent.get(i).getLessons();
				for (int j = 0; j < listSubject.size(); j++) {
					String name = listSubject.get(j).getName();
					System.out.println(listStudent.get(i).getName());
					System.out.println(name);
					if (nameSubject.equals(name)) {
						result = true;
						break outer;
					}
				}
			}
		}
		System.out.println(result);
		return result;
	}

}
