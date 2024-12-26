import java.util.List;
import java.util.Optional;

public class fn04_Optional {

  public static void main(String[] args) {
    List<String> fruits = List.of("apple", "banana", "mango");
    Optional<String> optional = fruits
      .stream()
      .filter(fruit -> fruit.startsWith("b"))
      .findFirst();

    System.out.println(optional);
    System.out.println(optional.isEmpty());
    System.out.println(optional.isPresent());
    System.out.println(optional.get());

    Optional<String> optionalException = fruits
      .stream()
      .filter(fruit -> fruit.startsWith("d"))
      .findFirst();

    System.out.println(optionalException);
    System.out.println(optionalException.isEmpty());
    System.out.println(optionalException.isPresent());
    // Exception
    System.out.println(optionalException.get());
  }
}
