package school.controller;

import school.autentification.Autentification;
import school.db.Db;
import school.dbInitial.DbInitial;
import school.model.Director;
import school.model.Educator;
import school.model.Guest;
import school.model.Role;
import school.model.Student;

public class Main {
  public static void main(String[] args) {
    Main main = new Main();
    Autentification autentification = new Autentification();
    Role role = new Role();

    DbInitial.initialUser();
    DbInitial.initialClases();
    DbInitial.initialALLSubject();
    DbInitial.initialAudience();
    autentification.autentificationGuest();

    Guest guest = Db.currentUser;

    // System.out.println("Size subjects : " + Db.subjects.size());
    // for (int i = 0; i < Db.subjects.size(); i++) {
    // System.out.print(Db.subjects.get(i).getName() + " - ");
    // for (int j = 0; j < Db.subjects.get(i).getClasses().size(); j++) {
    // System.out.print(Db.subjects.get(i).getClasses().get(j).getNumb() + ",");
    // }
    // System.out.println();
    // }

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
