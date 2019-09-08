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
public class Short_Answer extends Question{
    String Answer;
    
    /* Initializes the short answer Question with the necessary required details of the question. Answer
       refers to the model answer of the question.
    */
    Short_Answer(String details, String marks, String answer){
        this.Details = details;
        this.Marks = marks;
        this.Answer = answer;
    }
    void askShortAnsQns () { //Function that asks the student the question, and also displays the question's number of marks.
        System.out.println(this.Details + " (" + this.Marks + " Marks)");
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
    
    int getMarks () {//Gets the marks for the short answer Question.
        return Integer.parseInt(this.Marks);
    }
    public String toXMLN(){ //Prints the XML String for the short answer question, which includes all of its details.
      String stringAns = "\t\t<Answer>" + this.Answer + "</Answer>\n";
      String stringMarks = "\t\t<Marks>" + this.Marks + "</Marks>\n";
      String stringShortAnsQns = "\t<ShortAns question ='" + this.Details.replace("'", "") + "'>\n" +  stringAns + 
              stringMarks + "\t</ShortAns>\n";
      return stringShortAnsQns;
    }
}
