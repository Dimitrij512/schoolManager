package school.service;

public class DirectorService extends EducatorService {
	@Override
	public void toShowAvaliableMethods() {
		System.out.println("Avaliable service for you : ");
		System.out.println("show schedule : press 1");
		System.out.println("show students : press 2");
	}

}
