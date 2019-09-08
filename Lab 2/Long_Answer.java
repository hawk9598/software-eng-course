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
public class Long_Answer extends Question {
    String Answer;
    
    //Initializes the long answer question with the necessary details, with answer referring to the model answer.
    Long_Answer(String details, String marks, String answer){
        this.Details = details;
        this.Marks = marks;
        this.Answer = answer;
    }
    void askLongAnsQns () { //Function that asks the student the question, and also displays the question's number of marks.
        System.out.println(this.Details + " (" + this.Marks + " Marks)");
    }
    
    String storeAnswer (){ //Stores the answer of the Long answer question, and does not mark it.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your answer.\n");
        String studentAnswer = scanner.nextLine();
        return studentAnswer;
    }
 
    int getMarks () { //Returns the number of marks of the question in integer form.
        return Integer.parseInt(this.Marks);
    }
    public String toXMLN(){ //Prints XML String for the long answer questions, which contains all the details of the question.
      String stringAns = "\t\t<Answer>" + this.Answer + "</Answer>\n";
      String stringMarks = "\t\t<Marks>" + this.Marks + "</Marks>\n";
      String stringLongAnsQns = "\t<LongAns question ='" + this.Details.replace("'", "") + "'>\n" +  stringAns + 
              stringMarks + "\t</LongAns>\n";
      return stringLongAnsQns;
    }
}
