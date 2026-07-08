package iVoteSim;

import java.util.List;

public class SingleChoice extends Question {
    
	//Creates single choice question
    public SingleChoice(String inputText, List<String> inputCandidates) {
        super(inputText, inputCandidates);
    }

    //Checks if submission contains 1 valid answer option
    public boolean isValidAnswer(List<String> submission) {
        if (submission == null || submission.size() != 1) {
            return false;
        }
        return getCandidateAnswers().contains(submission.get(0));
    }
}
