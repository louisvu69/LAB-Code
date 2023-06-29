/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author My PC
 */
public class Main {


    public static void main(String[] args) throws Exception {
        Menu menuList = new Menu();
        do {
            menuList.displayMenu();
            int choice = menuList.getChoice();
            menuList.run(choice);
        } while (!menuList.isExit);
        
    }
    
}
