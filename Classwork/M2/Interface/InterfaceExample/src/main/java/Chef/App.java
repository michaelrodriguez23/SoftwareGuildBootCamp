/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chef;

/**
 *
 * @author michaelrodriguez
 */
public class App {

    public static void main(String[] args) {
        // new instance of a chef, and created a chef object
        Chef normalChef = new Chef();
        ItalianChef italianChef = new ItalianChef();
        ChineseChef chineseChef = new ChineseChef();
        
        italianChef.makesSpecialDish();
        chineseChef.makesSpecialDish();
        normalChef.makesSpecialDish();
        
        
        

    }
}
