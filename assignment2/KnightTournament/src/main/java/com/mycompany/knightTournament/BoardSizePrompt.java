/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.knightTournament;

import javax.swing.JOptionPane;

/**
 *
 * @author uewashuuwa
 */
public class BoardSizePrompt {
    public static int promptForBoardSize() {
        String[] options = {"4", "6", "8"};
        String selectedSize = (String) JOptionPane.showInputDialog(null,
                "Choose board size", "Board Size",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (selectedSize != null) {
            return Integer.parseInt(selectedSize);
        } else {
            // Default to 4 if the user cancels the input
            return 4;
        }
    }
}
