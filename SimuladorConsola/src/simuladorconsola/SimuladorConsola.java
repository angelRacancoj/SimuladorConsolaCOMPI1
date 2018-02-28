/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorconsola;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class SimuladorConsola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = "25+35;";
//        // TODO code application logic here
//        //AnalizadorLexico miLexer = new AnalizadorLexico(br);
//        AnalizadorLexico miLexer = new AnalizadorLexico(br);
//        //AnalizadorLexico miLexer = new AnalizadorLexico(new StringReader(input));
//        parser miParser = new parser(miLexer);
//        try {
//            miParser.parse();
//        } catch (Exception ex) {
//            Logger.getLogger(SimuladorConsola.class.getName()).log(Level.SEVERE, null, ex);
//        }
        consola cons = new consola();
        cons.setVisible(true);
    }

}
