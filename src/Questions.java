import java.util.ArrayList;
import java.util.List;

public class Questions {
    private String question;
    private Answers answers;

    public Questions() {
    }

    public String getQuestion() {
        return question;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

    public static class Answers {
        private List<String> answers = new ArrayList<>();
       private int correctAnswer;

        public Answers() {
        }

        public void setAnswers(List<String> answers) {
            this.answers = answers;
        }

        public void setCorrectAnswer(int correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        public void addAnswers(String answer) {
            answers.add(answer);
        }

        public List<String> getAnswers() {
            return answers;
        }

        public int getCorrectAnswer() {
            return correctAnswer;
        }
    }
}
