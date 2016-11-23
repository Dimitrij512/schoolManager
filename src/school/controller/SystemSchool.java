package school.controller;

import java.util.Scanner;

import school.db.Db;

public class SystemSchool {

	public String enterNumber() {
		Scanner sc = new Scanner(System.in);
		String number = sc.nextLine();
		return number;
	}

	public void createShedule() {
		for (int i = 0; i < Db.clases.size(); i++) {

		}
	}
}
