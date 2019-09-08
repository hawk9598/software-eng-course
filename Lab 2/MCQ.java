/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hawk9598.exam_objects;

import java.util.Scanner;
/**
 *
 * @author Wayne
 */
public class MCQ extends Question {
    String Option_1;
    String Option_2;
    String Option_3;
    String Option_4;
    String Answer;
    
    /* Initializes the MCQ Question with the necessary required details of the question, i.e. the MCQ Options. Answer
       refers to the model answer of the question.
    */
    MCQ(String details, String marks, String answer, String opt_1, String opt_2, String opt_3, String opt_4){
        this.Details = details;
        this.Marks = marks;
        this.Answer = answer;
        this.Option_1 = opt_1;
        this.Option_2 = opt_2;
        this.Option_3 = opt_3;
        this.Option_4 = opt_4;
    }
    
    void askMCQ(){ //Function that asks the MCQ questions during the exam.
        System.out.println(this.Details + " (" + this.Marks + " Marks)");
    }
    
    void printMcqOptions(){ //Prints the MCQ options.
        System.out.println("Option A is " + this.Option_1 + ".");
        System.out.println("Option B is " + this.Option_2 + ".");
        System.out.println("Option C is " + this.Option_3 + ".");
        System.out.println("Option D is " + this.Option_4 + ".");
    }
   
    int markAnswer(){ /*Function that asks for and marks a student's answer. Marking is done by comparing the 
                        student's answer and the model answer.
                       */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your answer.\n");
        String studentAnswer = scanner.nextLine();
        if (this.Answer.equals(studentAnswer)){
            return Integer.parseInt(this.Marks);
        }
        else {
            return 0;
        }   
    }
    
    int getMarks () { //Gets the marks for the MCQ Question.
        return Integer.parseInt(this.Marks);
    }
    
    public String toXMLN(){ //Prints the XML String for the MCQ question, which includes all of its details.
      String stringAns = "\t\t<Answer>" + this.Answer + "</Answer>\n";
      String stringMarks = "\t\t<Marks>" + this.Marks + "</Marks>\n";
      String stringOption1 = "\t\t<Option1>" + this.Option_1+ "</Option1>\n";
      String stringOption2 = "\t\t<Option2>" + this.Option_2+ "</Option2>\n";
      String stringOption3 = "\t\t<Option3>" + this.Option_3+ "</Option3>\n";
      String stringOption4 = "\t\t<Option4>" + this.Option_4+ "</Option4>\n";
      String stringMCQ = "\t<MCQ question ='" + this.Details.replace("'", "") + "'>\n" +  stringAns + 
              stringMarks + stringOption1 + stringOption2 + stringOption3 + stringOption4 + "\t</MCQ>\n";
      return stringMCQ;
    }
    
    
    
}
