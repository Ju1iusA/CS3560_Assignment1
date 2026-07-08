package iVoteSim;

import java.util.List;

public class MultipleChoice extends Question {
    
	//Creates multiple choice question
    public MultipleChoice(String inputText, List<String> inputCandidates) {
        super(inputText, inputCandidates);
    }

    //Checks if answer contains 1 or more valid answer option
    public boolean isValidAnswer(List<String> submission) {
        if (submission == null || submission.isEmpty()) {
            return false;
        }
        
        //Loops through all answer submissions
        for (String choice : submission) {
            if (!getCandidateAnswers().contains(choice)) {
                return false;
            }
        }
        return true;
    }
}
