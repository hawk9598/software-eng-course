/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hawk9598.exam_objects;

import java.io.IOException;
import org.xml.sax.SAXException;

/**
 *
 * @author Wayne
 */
public class Exam_Demo {

    
    /**
     * @param args the command line arguments
     */
    
    /* This main function is to test:
    1) Whether the XML written is in the correct format, as seen from the toXMLN function.
    2) Whether the XML written can be saved, as seen from the saveXMLFile function.
    2) Whether the XML written from an exam can be read again to reproduce the exact same exam as the original exam.
    3) Whether the exam can be implemented properly. 
    Feel free to add your own MCQ/Short Answer/Long Answer questions and try out this application!
    */
    public static void main(String[] args) throws SAXException, IOException {
        MCQ addition = new MCQ("What is 1 + 1?", "2", "2", "3", "4", "2", "1");
        MCQ subtraction = new MCQ("What is 10 - 5?", "2", "5", "2", "5", "10", "7");
        Short_Answer capital = new Short_Answer("What is the Capital of Malaysia?", "4", "KL");
        Short_Answer height = new Short_Answer("What is my height?", "4", "176.5 cm");
        Long_Answer demo = new Long_Answer("Who founded Singapore and in which year?", "5", "Lee Kuan Yew, 1965.");
        Long_Answer course = new Long_Answer("What are my courses?", "5", "Advanced Algorithms, FPP, Software Engineering");
        Exam demoExam = new Exam("Demo!");
        demoExam.addMCQ(addition);
        demoExam.addMCQ(subtraction);
        demoExam.addShortAns(capital);
        demoExam.addShortAns(height);
        demoExam.addLongAns(demo);
        demoExam.addLongAns(course);
        System.out.println("Original XML:\n" + demoExam.toXMLN());
        demoExam.saveXMLFile("Demo.xml");
        Exam demoExam2 = Exam.readXMLFile("Demo.xml");
        System.out.println("XML of Exam that is made from readXMLFile function:\n" + demoExam2.toXMLN());
        demoExam.implementExam();
        //demoExam2.implementExam();
        // TODO code application logic here
    }
    
}
