import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "Questions";


        Scanner in = new Scanner(System.in);

        List<Questions> questions = new ArrayList<>();

        List<String> strings = Files.readAllLines(Path.of(path));
        Questions question = null;
        Questions.Answers answers = new Questions.Answers();
        List<Integer> userAnswers = new ArrayList<>();
        for (String string : strings) {
            if (string.matches("\\d+\\).*")) {
                if (string.endsWith("*")) {
                    int size = answers.getAnswers().size();
                    answers.setCorrectAnswer(size + 1);
                    answers.addAnswers(string.substring(0, string.length() - 2));
                } else {
                    answers.addAnswers(string);
                }
            } else {
                if (question != null) {
                    questions.add(question);
                }
                question = new Questions();
                question.setQuestion(string);
                answers = new Questions.Answers();
                question.setAnswers(answers);
            }
        }
        questions.add(question);
        int correctUserAnswer = 0;
        for (Questions str : questions
        ) {
            System.out.println(str.getQuestion());
            for (String answer : str.getAnswers().getAnswers()) {
                System.out.println(answer);
            }
            int userAnswer = in.nextInt();
            int correctAnswer = str.getAnswers().getCorrectAnswer();
            if (userAnswer == correctAnswer)
                correctUserAnswer++;
        }
        System.out.println("ты ответил правильно на " + correctUserAnswer);
        System.out.println();
    }
}