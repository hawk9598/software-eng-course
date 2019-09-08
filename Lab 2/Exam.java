/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hawk9598.exam_objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Wayne
 */
public class Exam { //Initializes the Exam Class, which contains a Name, and the 3 types of questions.
    String Name;
    List <MCQ> MCQs;
    List <Short_Answer> Short_Ans;
    List <Long_Answer> Long_Ans;
    
    
    Exam(String name){ //Constructor with name as argument. Initializes empty lists to store questions.
        this.Name = name;
        this.MCQs = new ArrayList<>();
        this.Short_Ans = new ArrayList<>();
        this.Long_Ans = new ArrayList<>();
    }
    
    Exam(){ //Constructor with no argument. Initializes empty lists to store questions, with name as TBC.
        this.Name = "TBC";
        this.MCQs = new ArrayList<>();
        this.Short_Ans = new ArrayList<>();
        this.Long_Ans = new ArrayList<>();
    }
    
    void addMCQ (MCQ q){ //Adds MCQ questions into the exam.
        this.MCQs.add(q);
    }
    void addShortAns (Short_Answer q){ //Adds Short Answer questions into the exam.
        this.Short_Ans.add(q);
    }
    void addLongAns (Long_Answer q){ //Adds Long Answer questions into the exam.
        this.Long_Ans.add(q);
    }
    public String toXMLN (){ //Prints XML String of the Exam, which can be saved and then read back as an Exam.
        String xmlMCQ = "";
        for (MCQ q: MCQs){
          xmlMCQ+= q.toXMLN();
      }
        String xmlShortAns = "" ;
        for (Short_Answer q: Short_Ans){
          xmlShortAns+= q.toXMLN();
      }
        String xmlLongAns = "" ;
        for (Long_Answer q: Long_Ans){
          xmlLongAns+= q.toXMLN();
      }
        String xmlExam = "<Exam name='" + this.Name.replace("'", "") + "'>\n"  + xmlMCQ + xmlShortAns + xmlLongAns + "</Exam>\n";
        return xmlExam;
    }
    void saveXMLFile(String filename) { //Saves the XML String with name filename.
        String str = this.toXMLN();
          try {
              Files.write(Paths.get(filename), str.getBytes());
          } catch (IOException ex) {
              Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public static Exam readXMLFile(String filename) throws SAXException, IOException { 
        //Uses DOM from mkyong to read an XML file into an exam. The XML format must be the same as mkyong's.
        Exam resExam = new Exam();
        File fXmlFile = new File(filename);
        
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize(); // Combines the new lines in the XML file 
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
            NodeList pList = doc.getElementsByTagName("Exam");
            
            Element examE = doc.getDocumentElement();
            String TheExamName = examE.getAttribute("name");
            resExam= new Exam(TheExamName);
            
            NodeList mcqElements = examE.getElementsByTagName("MCQ");
            
            for (int i = 0; i < mcqElements.getLength(); i++){
                Node bNode = mcqElements.item(i);
                //System.out.println("\nCurrent Element :" + bNode.getNodeName());
                if (bNode.getNodeType() == Node.ELEMENT_NODE){
                    Element mcqE = (Element) bNode; //USUALLY cannot cast superclass to a subclass, the other way is ok.
                    String mcqDetails = mcqE.getAttribute("question");
                    String mcqAnswer = mcqE.getElementsByTagName("Answer").item(0).getTextContent();
                    String mcqMarks = mcqE.getElementsByTagName("Marks").item(0).getTextContent();
                    String mcqOption1 = mcqE.getElementsByTagName("Option1").item(0).getTextContent();
                    String mcqOption2 = mcqE.getElementsByTagName("Option2").item(0).getTextContent();
                    String mcqOption3 = mcqE.getElementsByTagName("Option3").item(0).getTextContent();
                    String mcqOption4 = mcqE.getElementsByTagName("Option4").item(0).getTextContent();
                    MCQ Q = new MCQ (mcqDetails, mcqAnswer, mcqMarks, mcqOption1, mcqOption2, mcqOption3, mcqOption4);
                    resExam.addMCQ(Q);
                }        
            } 
            NodeList shortansElements = examE.getElementsByTagName("ShortAns");
            
            for (int i = 0; i < shortansElements.getLength(); i++){
                Node bNode = shortansElements.item(i);
                //System.out.println("\nCurrent Element :" + bNode.getNodeName());
                if (bNode.getNodeType() == Node.ELEMENT_NODE){
                    Element shortAnsE = (Element) bNode; //USUALLY cannot cast superclass to a subclass, the other way is ok.
                    String shortAnsDetails = shortAnsE.getAttribute("question");
                    String shortAnsAnswer = shortAnsE.getElementsByTagName("Answer").item(0).getTextContent();
                    String shortAnsMarks = shortAnsE.getElementsByTagName("Marks").item(0).getTextContent();
                    Short_Answer Q = new Short_Answer(shortAnsDetails , shortAnsMarks , shortAnsAnswer);
                    resExam.addShortAns(Q);
                }        
            }      
            NodeList longansElements = examE.getElementsByTagName("LongAns");
            
            for (int i = 0; i < longansElements.getLength(); i++){
                Node bNode = longansElements.item(i);
                //System.out.println("\nCurrent Element :" + bNode.getNodeName());
                if (bNode.getNodeType() == Node.ELEMENT_NODE){
                    Element longAnsE = (Element) bNode; //USUALLY cannot cast superclass to a subclass, the other way is ok.
                    String longAnsDetails = longAnsE.getAttribute("question");
                    String longAnsAnswer = longAnsE.getElementsByTagName("Answer").item(0).getTextContent();
                    String longAnsMarks = longAnsE.getElementsByTagName("Marks").item(0).getTextContent();
                  
                    Long_Answer Q = new Long_Answer(longAnsDetails, longAnsMarks, longAnsAnswer);
                    resExam.addLongAns(Q);
                }        
            }      
            return resExam; 
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resExam;
     }
    
    void implementExam (){ /* Starts implementing the exam, beginning with the MCQ Questions and ending with the Long
                              answer questions. The long answer questions are not graded, and the student's marks are 
                              displayed at the end of the exam, excluding the long answer questions.
                            */
        int totalMarks = 0;
        int totalPossibleMarks = 0;
        int longAnsMarks = 0;
        for (MCQ q : MCQs){
            q.askMCQ();
            q.printMcqOptions();
            totalMarks += q.markAnswer();
            totalPossibleMarks += q.getMarks();
        }
        for (Short_Answer q : Short_Ans){
            q.askShortAnsQns();
            totalMarks += q.markAnswer();
            totalPossibleMarks += q.getMarks();
        }
        for (Long_Answer q : Long_Ans){
            q.askLongAnsQns();
            q.storeAnswer();
            totalPossibleMarks += q.getMarks();
            longAnsMarks += q.getMarks();
        }
        System.out.println("You have completed the exam. Congratulations!");
        System.out.println("Marking your answers... Take note that we are unable to grade "
                + "your Long Answer Questions for now, so your total marks shown is exclusive "
                + "of the marks for the Long Answer Questions, which amounts to " + longAnsMarks + " marks.");
        System.out.println("Marking Complete! Out of " + Integer.toString(totalPossibleMarks) + " marks, you have managed to get "
                + totalMarks +" for the non-Long Answer Questions.");
        
    }
}
