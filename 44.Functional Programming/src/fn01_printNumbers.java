import java.util.List;

public class fn01_printNumbers {

  public static void main(String[] args) {
    List<Integer> list = List.of(1, 2, 3, 4, 5);
    printAllNumbersTraditional(list);
    printAllNumbersStream(list);
    printAllNumbersStreamSimplerWay(list);
    printEvenNumbers(list);
    printEvenNumbersLambda(list);
  }

  //   Traditional Approach
  private static void printAllNumbersTraditional(List<Integer> list) {
    System.out.print("Traditional Approach : ");
    for (Integer num : list) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  // Stream
  private static void printAllNumbersStream(List<Integer> list) {
    System.out.print("Stream Approach : ");
    // Stream converrts into stream
    // className :: methord reference
    // printNumbers::printNum
    list.stream().forEach(fn01_printNumbers::printNum);
    System.out.println();
  }

  private static void printNum(int num) {
    System.out.print(num + " ");
  }

  // Simpler way
  private static void printAllNumbersStreamSimplerWay(List<Integer> list) {
    System.out.print("Stream Approach Simpler way : ");
    list.stream().forEach(System.out::print);
    System.out.println();
  }

  //Even numbers
  private static boolean isEven(int num) {
    return num % 2 == 0;
  }

  private static void printEvenNumbers(List<Integer> list) {
    System.out.print("Even Numbers : ");
    // using filter
    list.stream().filter(fn01_printNumbers::isEven).forEach(System.out::print);
    System.out.println();
  }

  // Lambda Expression
  private static void printEvenNumbersLambda(List<Integer> list) {
    System.out.print("Even Numbers using Lambda : ");
    // using Lambda
    list.stream().filter(num -> num % 2 == 0).forEach(System.out::print);
    System.out.println();
  }
}
