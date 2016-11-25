package school.controller;

import school.autentification.Autentification;
import school.db.Db;
import school.dbInitial.DbInitial;
import school.model.Director;
import school.model.Educator;
import school.model.Guest;
import school.model.Role;
import school.model.ScheduleSubject;
import school.model.Student;

public class Main {
  public static void main(String[] args) {
    Main main = new Main();
    Autentification autentification = new Autentification();
    SystemSchool sysSchool = new SystemSchool();
    Role role = new Role();

    DbInitial.initialUser();
    DbInitial.initialClases();
    DbInitial.initialALLSubject();
    DbInitial.initialAudience();
    // autentification.autentificationGuest();
    sysSchool.createShedule();

    for (int i = 0; i < Db.schedule.size(); i++) {
      ScheduleSubject sr = Db.schedule.get(i);
      System.out.println(sr.getClas() + " " + sr.getDayOfWeek() + sr.getNumbLesson() + " " + sr.getAudience() + " "
          + sr.getNameLesson());

    }

    Guest guest = Db.currentUser;

    if (guest.getRole() == role.getStudent()) {

      Student student = (Student) guest;
      System.out.println(student.getName());

    } else if (guest.getRole() == role.getEducator()) {
      Educator educator = (Educator) guest;
      System.out.println(educator.getName());

    } else if (guest.getRole() == role.getDirector()) {
      Director director = (Director) guest;
      System.out.println(director.getName());
    }
  }

}
