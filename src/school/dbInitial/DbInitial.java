package school.dbInitial;

import java.util.ArrayList;
import java.util.List;

import school.controller.SystemSchool;
import school.db.Db;
import school.model.Audience;
import school.model.Clas;
import school.model.Director;
import school.model.Educator;
import school.model.Guest;
import school.model.Role;
import school.model.Student;
import school.model.Subject;

public class DbInitial {
	Role role = new Role();
	SystemSchool sysScholl = new SystemSchool();

	public static void initialUser() {
		SystemSchool sysScholl = new SystemSchool();
		Student student = new Student();
		student.setLogin("student");
		student.setPassword("password");
		student.setName("Anjey");
		student.setSurname("Petrenko");
		student.setClas(1);
		student.setAdress("Franuk");
		student.setRole(new Role().getStudent());

		Student student2 = new Student();
		student2.setLogin("student2");
		student2.setPassword("password");
		student2.setName("Roman");
		student2.setSurname("Pupkin");
		student2.setClas(1);
		student2.setAdress("Franuk");
		student2.setRole(new Role().getStudent());

		Student student3 = new Student();
		student3.setLogin("student3");
		student3.setPassword("password");
		student3.setName("Ivan");
		student3.setSurname("Firman");
		student3.setClas(5);
		student3.setAdress("Franuk");
		student3.setRole(new Role().getStudent());

		Student student4 = new Student();
		student4.setLogin("student4");
		student4.setPassword("password");
		student4.setName("Vaska");
		student4.setSurname("Barabash");
		student4.setClas(5);
		student4.setAdress("Franuk");
		student4.setRole(new Role().getStudent());

		Student student5 = new Student();
		student5.setLogin("student5");
		student5.setPassword("password");
		student5.setName("Vasyl");
		student5.setSurname("BuYaYa");
		student5.setClas(2);
		student5.setAdress("Franuk");
		student5.setRole(new Role().getStudent());

		Student student6 = new Student();
		student6.setLogin("student6");
		student6.setPassword("password");
		student6.setName("Vasylyna");
		student6.setSurname("BuYaYa_Ya");
		student6.setClas(3);
		student6.setAdress("Franuk");
		student6.setRole(new Role().getStudent());

		Educator educator = new Educator();
		Subject subject = new Subject("math");
		educator.setLogin("educator");
		educator.setPassword("password");
		educator.setName("Pavlo Illich");
		educator.setSurname("Pavel");
		educator.setRole(new Role().getEducator());
		educator.setSubject(subject);
		educator.setAdress("adress");

		Director director = new Director();
		director.setName("Bogdan");
		director.setSurname("Director");
		director.setLogin("director");
		director.setPassword("password");
		director.setRole(new Role().getDirector());

		Db.users.add(student);
		Db.users.add(student2);
		Db.users.add(student3);
		Db.users.add(student4);
		Db.users.add(student5);
		Db.users.add(student6);
		Db.users.add(educator);
		Db.users.add(director);

	}

	public static void initialALLSubject() {
		DbInitial dbi = new DbInitial();
		Subject math = new Subject("math");
		math.setClasses(dbi.toGetClass(1));

		Subject ukLang = new Subject("ukLang");
		ukLang.setClasses(dbi.toGetClass(5));

		Subject engLang = new Subject("engLang");
		engLang.setClasses(dbi.toGetClass(1));
		engLang.setClasses(dbi.toGetClass(2));
		engLang.setClasses(dbi.toGetClass(5));

		Subject nature = new Subject("nature");
		nature.setClasses(dbi.toGetClass(1));
		nature.setClasses(dbi.toGetClass(2));
		nature.setClasses(dbi.toGetClass(3));

		Subject paint = new Subject("paint");
		paint.setClasses(dbi.toGetClass(1));
		paint.setClasses(dbi.toGetClass(2));
		paint.setClasses(dbi.toGetClass(3));

		Subject reading = new Subject("reading");
		reading.setClasses(dbi.toGetClass(1));
		reading.setClasses(dbi.toGetClass(2));
		reading.setClasses(dbi.toGetClass(3));

		Subject music = new Subject("music");
		music.setClasses(dbi.toGetClass(1));
		music.setClasses(dbi.toGetClass(2));
		music.setClasses(dbi.toGetClass(5));

		Subject energy = new Subject("energy");
		energy.setClasses(dbi.toGetClass(1));
		energy.setClasses(dbi.toGetClass(2));
		energy.setClasses(dbi.toGetClass(5));

		Subject basykHealth = new Subject("basykHealth");
		basykHealth.setClasses(dbi.toGetClass(1));
		basykHealth.setClasses(dbi.toGetClass(2));

		Subject algebra = new Subject("algebra");
		algebra.setClasses(dbi.toGetClass(5));

		Subject geometry = new Subject("geometry");
		geometry.setClasses(dbi.toGetClass(5));

		Subject geography = new Subject("geography");
		geography.setClasses(dbi.toGetClass(5));

		Subject physics = new Subject("physics");
		physics.setClasses(dbi.toGetClass(5));

		Subject chemistry = new Subject("chemistry");
		chemistry.setClasses(dbi.toGetClass(5));

		Subject working = new Subject("working");
		working.setClasses(dbi.toGetClass(5));

		Subject ukrliterature = new Subject("literature");
		ukrliterature.setClasses(dbi.toGetClass(5));

		Db.subjects.add(math);
		Db.subjects.add(ukLang);
		Db.subjects.add(engLang);
		Db.subjects.add(nature);
		Db.subjects.add(paint);
		Db.subjects.add(reading);
		Db.subjects.add(music);
		Db.subjects.add(energy);
		Db.subjects.add(basykHealth);
		Db.subjects.add(algebra);
		Db.subjects.add(geometry);
		Db.subjects.add(geography);
		Db.subjects.add(physics);
		Db.subjects.add(chemistry);
		Db.subjects.add(working);
		Db.subjects.add(ukrliterature);

	}

	public Clas toGetClass(int numbClas) {
		for (int i = 0; i < Db.clases.size(); i++) {
			Clas tempClass = Db.clases.get(i);
			if (tempClass.getNumb() == numbClas) {
				return tempClass;
			}
		}
		return null;
	}

	public static void initialAudience() {
		Audience a101 = new Audience(101);
		Audience a102 = new Audience(102);
		Audience a103 = new Audience(103);
		Audience a104 = new Audience(104);
		Audience a105 = new Audience(105);
		Audience a106 = new Audience(106);
		Audience a107 = new Audience(107);
		Audience a108 = new Audience(108);
		Audience a201 = new Audience(201);
		Audience a202 = new Audience(202);
		Audience a203 = new Audience(203);
		Audience a204 = new Audience(204);
		Audience a205 = new Audience(205);
		Audience a206 = new Audience(206);
		Audience a207 = new Audience(207);
		Audience a208 = new Audience(208);
		Audience a209 = new Audience(209);
		Audience a210 = new Audience(210);
		Db.audiences.add(a101);
		Db.audiences.add(a102);
		Db.audiences.add(a103);
		Db.audiences.add(a104);
		Db.audiences.add(a105);
		Db.audiences.add(a106);
		Db.audiences.add(a107);
		Db.audiences.add(a108);
		Db.audiences.add(a201);
		Db.audiences.add(a202);
		Db.audiences.add(a203);
		Db.audiences.add(a204);
		Db.audiences.add(a205);
		Db.audiences.add(a206);
		Db.audiences.add(a207);
		Db.audiences.add(a208);
		Db.audiences.add(a209);
		Db.audiences.add(a210);
	}

	public static void initialClases() {
		DbInitial dbi = new DbInitial();
		Clas clas1 = new Clas();
		clas1.setNumb(1);
		clas1.setStudents(dbi.addStudentsForClas(clas1.getNumb()));

		Clas clas2 = new Clas();
		clas2.setNumb(2);
		clas2.setStudents(dbi.addStudentsForClas(clas2.getNumb()));

		Clas clas3 = new Clas();
		clas3.setNumb(3);
		clas3.setStudents(dbi.addStudentsForClas(clas3.getNumb()));

		Clas clas5 = new Clas();
		clas5.setNumb(5);
		clas5.setStudents(dbi.addStudentsForClas(clas5.getNumb()));

		Db.clases.add(clas1);
		Db.clases.add(clas2);
		Db.clases.add(clas3);
		Db.clases.add(clas5);
	}

	public List<Student> addStudentsForClas(int clas) {
		List<Student> listStudents = new ArrayList<Student>();
		for (int i = 0; i < Db.users.size(); i++) {
			Guest guest = Db.users.get(i);
			if (guest.getRole() == role.getStudent()) {
				Student student = (Student) guest;
				if (student.getClas() == clas) {
					listStudents.add(student);
				}
			}
		}
		return listStudents;
	}

	public static void initialSubjectForStudent() {
		SystemSchool sysSchool = new SystemSchool();
		Role role = new Role();
		for (int i = 0; i < Db.users.size(); i++) {
			if (Db.users.get(i).getRole() == role.getStudent()) {
				Student student = (Student) Db.users.get(i);
				int clas = student.getClas();
				student.setLessons(sysSchool.toGetSubjects(clas));
				Db.users.set(i, student);
			}
		}

	}

}
