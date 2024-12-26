import java.util.List;

public class fn03_map {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    System.out.println("Squares of numbers");
    numbers.stream().map(num -> num * num).forEach(System.out::println);

    System.out.println("cubes of odd numbers");
    numbers
      .stream()
      .filter(num -> num % 2 != 0)
      .map(num -> num * num * num)
      .forEach(System.out::println);
  }
}
