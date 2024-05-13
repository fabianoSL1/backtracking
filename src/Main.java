import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> toOrder = List.of("maças", "peras", "goiabas", "pessegos", "bananas");

        Backtracking backtracking = new Backtracking();

        var solutions = backtracking.resolve(toOrder);

        solutions.forEach(solution -> {
            solution.forEach(System.out::println);

            System.out.println("---------------");

            Collections.reverse(solution);
            int indexMacas = solution.indexOf("maças");

            System.out.printf("as maças estão na posição numero %d de baixo para cima%n", indexMacas + 1);

            System.out.println("---------------");
        });
    }


}