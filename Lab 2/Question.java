/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hawk9598.exam_objects;

/**
 *
 * @author Wayne
 */
abstract class Question { //Superclass of the three types of questions.
    String Details;
    String Marks;
    
    void printQuestion(){
        System.out.println("Question is " + this.Details + " and is worth " + this.Marks + " marks on the exam");
    }
    
}
