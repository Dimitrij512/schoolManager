package school.model;

import java.util.List;

public class WorkWeek {
  private int monday = 1;
  private int tuesday = 2;
  private int wednesday = 3;
  private int thursday = 4;
  private int friday = 5;

  private List<Integer> listWorkWeek;

  public WorkWeek() {
    listWorkWeek.add(this.monday);
    listWorkWeek.add(this.tuesday);
    listWorkWeek.add(this.wednesday);
    listWorkWeek.add(this.thursday);
    listWorkWeek.add(this.friday);
  }

  public int getMonday() {
    return monday;
  }

  public int getTuesday() {
    return tuesday;
  }

  public int getFriday() {
    return friday;
  }

  public int getThursday() {
    return thursday;
  }

  public int getWednesday() {
    return wednesday;
  }

  public List<Integer> getListWorkWeek() {
    return listWorkWeek;
  }
}
