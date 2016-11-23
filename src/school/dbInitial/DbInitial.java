package school.dbInitial;

import java.util.ArrayList;
import java.util.List;

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

  public static void initialUser() {
    Student student = new Student();
    student.setLogin("student");
    student.setPassword("password");
    student.setName("Anjey");
    student.setSurname("Petrenko");
    student.setClas(1);
    student.setAdress("Franuk");
    student.setLessons(Db.subjects);
    student.setRole(new Role().getStudent());

    Student student2 = new Student();
    student2.setLogin("student2");
    student2.setPassword("password");
    student2.setName("Roman");
    student2.setSurname("Pupkin");
    student2.setClas(1);
    student2.setAdress("Franuk");
    student2.setLessons(Db.subjects);
    student2.setRole(new Role().getStudent());

    Student student3 = new Student();
    student3.setLogin("student3");
    student3.setPassword("password");
    student3.setName("Ivan");
    student3.setSurname("Firman");
    student3.setClas(5);
    student3.setAdress("Franuk");
    student3.setLessons(Db.subjects);
    student3.setRole(new Role().getStudent());

    Student student4 = new Student();
    student4.setLogin("student4");
    student4.setPassword("password");
    student4.setName("Vaska");
    student4.setSurname("Barabash");
    student4.setClas(5);
    student4.setAdress("Franuk");
    student4.setLessons(Db.subjects);
    student4.setRole(new Role().getStudent());

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
    director.setName("Dima director");
    director.setLogin("director");
    director.setPassword("password");
    director.setRole(new Role().getDirector());

    Db.users.add(student);
    Db.users.add(student2);
    Db.users.add(student3);
    Db.users.add(student4);
    Db.users.add(educator);
    Db.users.add(director);

  }

  public static void initialALLSubject() {
    Subject math = new Subject("math");
    Db.subjects.add(math);
    Subject ukLang = new Subject("ukLang");
    Db.subjects.add(ukLang);
    Subject engLang = new Subject("engLang");
    Db.subjects.add(engLang);
    Subject nature = new Subject("nature");
    Db.subjects.add(nature);
    Subject paint = new Subject("paint");
    Db.subjects.add(paint);
    Subject reading = new Subject("reading");
    Db.subjects.add(reading);
    Subject music = new Subject("music");
    Db.subjects.add(music);
    Subject energy = new Subject("energy");
    Db.subjects.add(energy);
    Subject basykHealth = new Subject("basykHealth");
    Db.subjects.add(basykHealth);
    Subject algebra = new Subject("algebra");
    Db.subjects.add(algebra);
    Subject geometry = new Subject("geometry");
    Db.subjects.add(geometry);
    Subject geography = new Subject("geography");
    Db.subjects.add(geography);
    Subject physics = new Subject("physics");
    Db.subjects.add(physics);
    Subject chemistry = new Subject("chemistry");
    Db.subjects.add(chemistry);
    Subject working = new Subject("working");
    Db.subjects.add(working);
    Subject ukrliterature = new Subject("literature");
    Db.subjects.add(ukrliterature);
  }

  public static void initialAudience() {
    Audience a101 = new Audience(101);
    Db.audiences.add(a101);
    Audience a102 = new Audience(102);
    Db.audiences.add(a102);
    Audience a103 = new Audience(103);
    Db.audiences.add(a103);
    Audience a104 = new Audience(104);
    Db.audiences.add(a104);
    Audience a105 = new Audience(105);
    Db.audiences.add(a105);
    Audience a106 = new Audience(106);
    Db.audiences.add(a106);
    Audience a107 = new Audience(107);
    Db.audiences.add(a107);
    Audience a108 = new Audience(108);
    Db.audiences.add(a108);
    Audience a201 = new Audience(201);
    Db.audiences.add(a201);
    Audience a202 = new Audience(202);
    Db.audiences.add(a202);
    Audience a203 = new Audience(203);
    Db.audiences.add(a203);
    Audience a204 = new Audience(204);
    Db.audiences.add(a204);
    Audience a205 = new Audience(205);
    Db.audiences.add(a205);
    Audience a206 = new Audience(206);
    Db.audiences.add(a206);
    Audience a207 = new Audience(207);
    Db.audiences.add(a207);
    Audience a208 = new Audience(208);
    Db.audiences.add(a208);
    Audience a209 = new Audience(209);
    Db.audiences.add(a209);
    Audience a210 = new Audience(210);
    Db.audiences.add(a210);
  }

  public static void initialClases() {
    DbInitial dbi = new DbInitial();

    Clas clas1 = new Clas();
    clas1.setNumb(1);
    clas1.setStudents(dbi.addStudentsForClas(clas1.getNumb()));
    Db.clases.add(clas1);

    Clas clas2 = new Clas();
    clas2.setNumb(2);
    clas2.setStudents(dbi.addStudentsForClas(clas2.getNumb()));
    Db.clases.add(clas2);

    Clas clas5 = new Clas();
    clas5.setNumb(5);
    clas5.setStudents(dbi.addStudentsForClas(clas5.getNumb()));
    Db.clases.add(clas5);
  }

  public List<Student> addStudentsForClas(int clas) {
    List<Student> students = new ArrayList<Student>();
    for (int i = 0; i < Db.users.size(); i++) {
      Guest guest = Db.users.get(i);
      if (guest.getRole() == role.getStudent()) {
        Student student = (Student) guest;
        if (student.getClas() == clas) {
          students.add(student);
        }
      }
    }
    return students;
  }

}
