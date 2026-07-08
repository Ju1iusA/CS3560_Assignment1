package iVoteSim;

import java.util.List;

public abstract class Question {
    private String questionText;
    private List<String> candidateAnswers;

    //Sets question and answers
    public Question(String inputText, List<String> inputCandidates) {
        questionText = inputText;
        candidateAnswers = inputCandidates;
    }

    //Returns question text
    public String getQuestionText() {
        return questionText;
    }

    //Returns list of answers
    public List<String> getCandidateAnswers() {
        return candidateAnswers;
    }

    //Ensures that submissions are valid
    public abstract boolean isValidAnswer(List<String> submission);
}
