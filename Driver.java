package iVoteSim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        VotingService votingService = new VotingService();
        Random random = new Random();

        //Randomly generates the amount of students
        int totalStudents = 10 + random.nextInt(11);
        List<Student> students = new ArrayList<>();
        
        //Random generates IDs
        for (int i = 1; i <= totalStudents; i++) {
            students.add(new Student("STU_" + (1000 + i)));
        }

        //Section 1: Multiple Choice Question
        System.out.println("=== Section 1: Multiple Choice ===");
        
        List<String> multipleOptions = Arrays.asList("1. Java", "2. C++", "3. Python", "4. C#");
        Question multipleQuestion = new MultipleChoice("What is your favorite programmign language?:", multipleOptions);
        votingService.configureQuestion(multipleQuestion);

        //Submits multiple choice answers
        for (Student student : students) {
            int choicesToSelect = 1 + random.nextInt(3);
            List<String> randomAnswers = new ArrayList<>();
            while (randomAnswers.size() < choicesToSelect) {
                String randomChoice = multipleOptions.get(random.nextInt(multipleOptions.size()));
                if (!randomAnswers.contains(randomChoice)) {
                    randomAnswers.add(randomChoice);
                }
            }
            votingService.submitAnswer(student, randomAnswers);
        }

        //Whenever a student changes their answer
        String dynamicChoice1 = multipleOptions.get(random.nextInt(multipleOptions.size()));
        String dynamicChoice2 = multipleOptions.get(random.nextInt(multipleOptions.size()));

        votingService.submitAnswer(students.get(0), Arrays.asList(dynamicChoice1, dynamicChoice2));

        votingService.displayResults();


        //Section 2: Single Choice Question
        System.out.println("=== Section 2: Single Choice ===");
        
        List<String> singleOptions = Arrays.asList("1. Yes", "2. No");
        Question singleQuestion = new SingleChoice("Does this program use OOP?", singleOptions);
        votingService.configureQuestion(singleQuestion);

        //Submits single choice answers
        for (Student student : students) {
            String randomChoice = singleOptions.get(random.nextInt(singleOptions.size()));
            votingService.submitAnswer(student, Arrays.asList(randomChoice));
        }

        //Whenever a student changes their answer
        String dynamicSingleChoice = singleOptions.get(random.nextInt(singleOptions.size()));

        votingService.submitAnswer(students.get(0), Arrays.asList(dynamicSingleChoice));

        
        votingService.displayResults();
    }
}
