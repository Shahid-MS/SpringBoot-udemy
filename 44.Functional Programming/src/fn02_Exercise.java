import java.util.List;

public class fn02_Exercise {

  public static void main(String[] args) {
    List<String> courses = List.of(
      "Spring",
      "Spring Boot",
      "API",
      "Microservices",
      "AWS",
      "Docker",
      "Kubernetes"
    );
    System.out.println("All Courses");
    courses.stream().forEach(System.out::println);
    System.out.println("Courses containing Spring");
    courses
      .stream()
      .filter(course -> course.contains("Spring"))
      .forEach(System.out::println);
    System.out.println("Courses name having atleast four letters");
    courses
      .stream()
      .filter(course -> course.length() >= 4)
      .forEach(System.out::println);

    System.out.println("Length of each courses : ");

    courses
      .stream()
      .map(course -> course + " : " + course.length())
      .forEach(System.out::println);
  }
}
