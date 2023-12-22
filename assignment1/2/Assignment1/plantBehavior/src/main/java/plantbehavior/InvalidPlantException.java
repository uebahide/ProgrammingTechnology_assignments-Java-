/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantbehavior;

/**
 *
 * @author uewashuuwa
 */
public class InvalidPlantException extends Exception {

    public InvalidPlantException(String token) {
        System.out.println("Invalid plant type: " + token);
    }
    
}
