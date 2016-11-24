package school.autentification;

import school.controller.SystemSchool;
import school.db.Db;
import school.model.Guest;

public class Autentification {

  public void autentificationGuest() {
    boolean start = true;
    while (start) {
      SystemSchool sysSchool = new SystemSchool();
      System.out.println("Enter login : ");
      String login = sysSchool.enterNumber();
      System.out.println("Enter password : ");
      String password = sysSchool.enterNumber();

      Guest guest = checkGuest(login, password);
      if (guest != null) {
        Db.currentUser = guest;
        return;
      } else {
        System.out.println("ERROR autentification !!!");
        System.out.println("retrying authentication press : 1 ");
        System.out.println("EXIT press : other key ");
        int parametr = Integer.parseInt(sysSchool.enterNumber());
        if (parametr != 1) {
          start = false;
        }
      }
    }
  }

  public Guest checkGuest(String login, String password) {
    Guest guest = null;
    for (int i = 0; i < Db.users.size(); i++) {
      Guest guestTemp = Db.users.get(i);
      if (guestTemp.getLogin().equalsIgnoreCase(login) && guestTemp.getPassword().equals(password)) {
        guest = guestTemp;
        return guest;
      }
    }
    return guest;
  }

}
