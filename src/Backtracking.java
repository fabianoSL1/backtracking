import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    private final List<String> input;
    private final List<List<String>> results;

    public Backtracking(List<String> input) {
        this.input = input;
        this.results = new ArrayList<>();
    }

    public List<List<String>> execute() {
        this.backtrack(new ArrayList<>());
        return this.results;
    }

    private void backtrack(List<String> partial) {
        if (isCorrect(partial)) {
            results.add(List.copyOf(partial));
            return;
        }

        for (String word: input) {
            if (!partial.contains(word)) {
                partial.add(word);

                backtrack(partial);

                partial.remove(word);
            }
        }
    }

    public boolean isCorrect(List<String> partial) {
        if (partial.size() < 5) {
            return false;
        }

        if (partial.indexOf("bananas") != 3) {
            return false;
        }

        if (Math.abs(partial.indexOf("goiabas") - partial.indexOf("peras")) != 4) {
                return false;
        }

        var sub = partial.subList(partial.indexOf("pessegos") + 1, partial.size());

        return sub.size() == 2 && sub.contains("peras");
    }
}
