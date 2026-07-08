package iVoteSim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VotingService {
    private Question question;
    private Map<String, List<String>> submissions;
    private int counter = 0;

    //Creates hash map
    public VotingService() {
        submissions = new HashMap<>();
    }

    //Sets up question and clears previous submissions
    public void configureQuestion(Question targetQuestion) {
        question = targetQuestion;
        submissions.clear();
        counter = 0;
    }

    //Checks is answer is valid, then saves if valid
    public void submitAnswer(Student student, List<String> answer) {
    	if (question == null) {
            return;
        }
        counter++;

        if (question.isValidAnswer(answer)) {
            submissions.put(student.getId(), answer);
        } 
    }

    public int getCounter() {
        return counter;
    }

    //Displays student answers and total results
    public void displayResults() {
        Map<String, Integer> counts = new HashMap<>();
        for (String candidate : question.getCandidateAnswers()) {
            counts.put(candidate, 0);
        }

        //Tallying process
        for (List<String> studentAnswers : submissions.values()) {
            for (String answer : studentAnswers) {
                counts.put(answer, counts.getOrDefault(answer, 0) + 1);
            }
        }

        System.out.println("\n--- Results ---");
        System.out.println("Question: " + question.getQuestionText());
        System.out.println("Total Submissions: " + submissions.size());
        for (String candidate : question.getCandidateAnswers()) {
            System.out.println(candidate + " : " + counts.get(candidate));
        }
        System.out.println("-------------------------\n");
    }
}
