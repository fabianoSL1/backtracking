import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    private int invocations = 0;

    public List<List<String>> resolve(List<String> toOrder) {
        List<List<String>> solutions = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        solve(toOrder, answer, solutions);

        System.out.printf("a função solve foi invocada %d%n%n", invocations);

        return solutions;
    }

    public void solve(List<String> toOrder, List<String> answer, List<List<String>> solutions) {
        invocations++;

        if (isCorrect(answer)) {
            solutions.add(new ArrayList<>(answer));
            return;
        }

        for (String word : toOrder) {
            if (!answer.contains(word)) {
                answer.add(word);

                solve(toOrder, answer, solutions);

                answer.remove(word);
            }
        }
    }

    public boolean isCorrect(List<String> answer) {
        if (answer.size() < 5) {
            return false;
        }

        if (answer.indexOf("bananas") != 3) {
            return false;
        }

        int indexGoiabas = answer.indexOf("goiabas");
        int indexPeras  = answer.indexOf("peras");

        if (Math.abs(indexGoiabas - indexPeras) != 4) {
                return false;
        }

        int indexPessegos = answer.indexOf("pessegos");

        var sub = answer.subList(indexPessegos + 1, answer.size());

        if (sub.size() != 2 || !sub.contains("peras")) {
            return false;
        }

        return true;
    }
}
