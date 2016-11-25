package school.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import school.db.Db;
import school.model.Clas;
import school.model.ScheduleSubject;
import school.model.Subject;
import school.model.WorkWeek;

public class SystemSchool {

  public String enterNumber() {
    Scanner sc = new Scanner(System.in);
    String number = sc.nextLine();
    return number;
  }

  public void createShedule() {
    Random random = new Random();

    WorkWeek workWeek = new WorkWeek();

    for (int classIter = 0; classIter < Db.clases.size(); classIter++) {
      int classNumber = Db.clases.get(classIter).getNumb();
      for (int workWeekIter = 0; workWeekIter < workWeek.getListWorkWeek().size(); workWeekIter++) {
        int dayOfWeek = workWeek.getListWorkWeek().get(workWeekIter);

        int countLessonInDay = toGetCountLessonInDay(classNumber);

        for (int iterDay = 0; iterDay < countLessonInDay; iterDay++) {
          ScheduleSubject subjectForSchedule = new ScheduleSubject();
          subjectForSchedule.setClas(classNumber);
          subjectForSchedule.setDayOfWeek(dayOfWeek);
          subjectForSchedule.setNumbLesson(iterDay + 1);
          Db.schedule.add(toMakeUniqueLesson(subjectForSchedule));
        }

      }
    }
  }

  public int toGetCountLessonInDay(int classNumb) {
    int countLessonInDay = 0;
    if (classNumb == 1 || classNumb == 2 || classNumb == 3) {
      countLessonInDay = 4;
    } else {
      countLessonInDay = 5;
    }
    return countLessonInDay;
  }

  public ScheduleSubject toMakeUniqueLesson(ScheduleSubject lesson) {
    Random random = new Random();

    List<Subject> listSubject = toGetSubjectsForClass(lesson.getClas());

    int iterAudience = random.nextInt(Db.audiences.size());

    // test
    int listSizeSubject = listSubject.size();
    System.out.println(listSizeSubject);

    int iterSubject = random.nextInt(listSizeSubject);

    String nameSubject = listSubject.get(iterSubject).getName();
    int audienceSubject = Db.audiences.get(iterAudience).getNumber();
    lesson.setAudience(audienceSubject);
    lesson.setNameLesson(nameSubject);

    int lessonDay = lesson.getDayOfWeek();
    int countLesson = lesson.getNumbLesson();
    int audience = lesson.getAudience();
    String name = lesson.getNameLesson();

    if (Db.schedule.size() == 0) {
      return lesson;
    } else {
      boolean start = true;

      while (start) {
        for (int i = 0; i < Db.schedule.size(); i++) {
          ScheduleSubject schSub = Db.schedule.get(i);
          int schSubDay = schSub.getDayOfWeek();
          int schSubCountbLesson = schSub.getNumbLesson();
          int schSubAudience = schSub.getAudience();
          String schSubName = schSub.getNameLesson();

          if (lessonDay == schSubDay && countLesson == schSubCountbLesson && audience == schSubAudience) {
            iterAudience = random.nextInt(Db.audiences.size());
            audience = Db.audiences.get(iterAudience).getNumber();
            break;
          } else if (lessonDay == schSubDay && countLesson == schSubCountbLesson && schSubName.equals(name)) {
            iterSubject = random.nextInt(listSubject.size());
            nameSubject = listSubject.get(iterSubject).getName();
          } else {
            lesson.setAudience(audience);
            lesson.setNameLesson(nameSubject);
            start = false;
          }
        }
      }
    }
    return lesson;
  }

  public List<Subject> toGetSubjectsForClass(int clasNumb) {
    List<Subject> listSubjcet = new ArrayList<Subject>();
    for (int i = 0; i < Db.subjects.size(); i++) {
      Subject subjectForClas = Db.subjects.get(i);
      for (int j = 0; j < subjectForClas.getClasses().size(); j++) {
        Clas clasForSubject = new Clas();
        int numbOfClas = clasForSubject.getNumb();
        if (numbOfClas == clasNumb) {
          listSubjcet.add(subjectForClas);
        }
      }
    }
    return listSubjcet;
  }

}
