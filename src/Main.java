import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = List.of("maças", "peras", "goiabas", "pessegos", "bananas");

        Backtracking backtracking = new Backtracking(input);

        var solutions = backtracking.execute();

        for (var solution : solutions) {
            for (var word : solution) {
                System.out.println(word);
            }
        }
    }


}