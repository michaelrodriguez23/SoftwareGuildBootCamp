/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.dvdlibrary.ui;

import com.mr.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public class DvdPlayerView {

    public DvdPlayerView(UserIO io) {
        this.io = io;
    }

    UserIO io = new UserIOConsoleImpl();
// This method prompts a Menu & Waits for User Selection 
    private String title;

    public int printMenuAndGetSelection() {
        
        io.print("Main Menu");
        io.print("1. LIST DVDS IN COLLECTION");
        io.print("2. ADD DVD TO COLLECTION");
        io.print("3. FIND DVD BY TITLE");
        io.print("4. REMOVE DVD FROM COLLECTION");
        io.print("5. EDIT DVD INFO FROM CURRENT LIBRARY");
        io.print("6. FIND DVD BY DIRECTOR");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }
// This method gets & sets userInput to instantiate DVD objects.

    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter title");
        String releaseDate = io.readString("Please enter RELEASE DATE ");
        String mpaaRating = io.readString("Please MPAA RATING ");
        String directorsName = io.readString("Please enter the DIRECTORS NAME ");
        String studio = io.readString("Please enter the Studios Name ");
        String usersNote = io.readString("Please enter a Custom NOTE perhaps a rating? ");
        Dvd currentDvd = new Dvd(title);
        currentDvd.setTitle(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setStudio(studio);
        currentDvd.setUserCustomNote(usersNote);

        return currentDvd;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            io.print(currentDvd.getTitle() + " "
                    + currentDvd.getReleaseDate() + " "
                    + currentDvd.getMpaaRating() + " "
                    + currentDvd.getDirectorsName() + " "
                    + currentDvd.getStudio() + " "
                    + currentDvd.getUserCustomNote() + " "
            );
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvds ===");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDvdByTitle() {
        return io.readString("Please enter the Title that you are looking for.");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle()); ////// ****** MAKES SURE TO ALWAYS USE .getTitle() 
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserCustomNote());
        } else {
            io.print("No such DVD .");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!! \n" + "\"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\\n\"\n" +
"                + \"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\\n\"\n" +
"                + \"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\\n\"\n" +
"                + \":::::::::::://////////////////////////////////:::::::::::::::////////////////////////:::::::::::::::\\n\"\n" +
"                + \":::::::::::/yyyyyyyyyyyyyyyyhhhhhhhhhhhhhhhhdh::::::::::::::+hmmmmmmmmmmmmmmmmmmmmmmmdhyo//:::::::::\\n\"\n" +
"                + \":::::::::::oyyyyyyyyyyyyyyhhhhhhhhhhhhhhhhhddd+:::::::::::/sdmmmmmmmmmmmmNNNNNNNNNNNNNNNNNds/:::::::\\n\"\n" +
"                + \"::::::::::/oooooooooooooossyyyyyyyyyyyyyyhhhhhy::::::::::+ydddddddhssssssssssyyyyhdmmmmmmmNNdo::::::\\n\"\n" +
"                + \"::::::::::+o+++++++::::::::/oyyyyyyyyyyyyyyyyyyo:::::::/oyhhhhhhyo++ooooooo::::::::+sddddddmmmo:::::\\n\"\n" +
"                + \":::::::::/yyyyyyyyy.:::::::::oyyyyyyyyy+yyyyyyyy::::::+yyyyyyyyo::yhhhhhhhs.:::::::::+hhhdddddh-::::\\n\"\n" +
"                + \":::::::::oyyyyyyyy/-:::::::::/yyyyyyyyy/+yyyyyyys:::/syyyyyyys:-:syyyyyyyy:::::::::::/yhhhhhhhh-::::\\n\"\n" +
"                + \"::::::::/oooooooo+.:::::::::/+oooooooo+-:+ooooooo::/+oooooo+:-::/oooooooo+.:::::::::/+oooooooo/.::::\\n\"\n" +
"                + \"::::::::+oooooooo:-:::::::/++oooooooo+--:/ooooooo++oooooo+/--:::+oooooooo:-:::::::/++oooooooo/.:::::\\n\"\n" +
"                + \":::::::/ooooooooo.:////++ooooooooooo/--:::+ooooooooooooo+--::::/ooooooooo.//////+oooooooooo+:.::::::\\n\"\n" +
"                + \":::::::+ssssssssooossssssssssssoo/:--::::::+sssssssssso--::::::+ssssssssoosssssssssssssso+:-::::::::\\n\"\n" +
"                + \"::::::/ssssssssssssssssssso++/:---:::::::::/ossssssss/.:::::::/ssssssssssssssssssssso+/:--::::::::::\\n\"\n" +
"                + \"::::::/+//+++////////:::----::::::::::::::::/ssssss+--:::::::://////////////////::---:::::::::::::::\\n\"\n" +
"                + \":::::::::::::::::::::::::::::::::::::::::::::+yyyo--::::::::::::::::::::::::::::::::::::::::::::::::\\n\"\n" +
"                + \"::::::::::::::::::::::::::::::::::::::::::::::ss:-::::::::::::::::::::::::::::::::::::::::::::::::::\\n\"\n" +
"                + \"::::::::::::::::::////++++o+ooosssssssssssyyyyyssyyysssssssssssoooooo++++////:::::::::::::::::::::::\\n\"\n" +
"                + \":::::::://+oossyyyyys+shhhyoshhhhoohhhhsoooosyhhhhhyooooooshhhhhyo++ooshhyyyyyyssoo++//:::::::::::::\\n\"\n" +
"                + \"::::/osyhhhhhhhhhhhhh+/yhy-/yhhhh.+hhhh/:syyo/+hhhho-/ssssyhhhh/:oyyys/+hhhhhhhhhhhhhhyys+::::::::::\\n\"\n" +
"                + \"::::shhhhhhhhhhhhhhhhh+/s-+hhhhhh.ohhhh+:hhhh-/yhhho-/soooyhhhy-+hhhhh:/yhhhhhhhhhhhhhhhhy::::::::::\\n\"\n" +
"                + \":::://+osyyhhhhhhhhhhhho/ohhhhhhh:ohhhh+/o++/+yhhhhs:+ooooyhhhhyoo+++//yhhhhhhhhhhhhyso+/--:::::::::\\n\"\n" +
"                + \":::::::::::://++oosssyyyyhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhyyyyyyyssso++//::::::::::::::::::\\n\"\n" +
"                + \"::::::::::::::::::::::::::::://////++++++++++o++++++++++++++/////:::::::::::::::::::::::::::::::::::\\n\"\n" +
"                + \"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\\n\"\n" +
"                + \"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\\n\"\n" +
"                + \"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\\n\"\n" +
"                + \":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\"\n" +
"                + \"\" + \"\"");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayEditDvdbanner() {
        io.print("=== EDIT DVD ===");
    }
    public void displayEditDvdSlotWiped() {
        io.print("I clean the slot where the DVD Info existed. Please update the follow DVD fields . ");
    }

    public void displayEditSuccessBanner() {
        io.print("DVD succesfully edited. Please hit enter to continue. ");
    }

    public void displayEditConfirmation() {
        io.print("You have Selected");
    }
    public int printConfirmationAndGetSelection(Dvd dvd){
        io.print(dvd.getTitle());
        
        return io.readInt("Is this the correct dvd you would like to edit. \n"
                
                + "1. Yes\n"
                + "2. No\n"
                + "Please select from the above choices.", 1, 2);
    }

    public void displayEditDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle()); ////// ****** MAKES SURE TO ALWAYS USE .getTitle() 

        } else {
            io.print("No such DVD .");

        }io.readString("Please hit enter to continue.");
    }
    public String getByDirector(){
        return io.readString("Please Enter Directors Name. ");
        
    }
    public void displayDirector(String director){
  
        if (director != null){
           
            io.print("Director Selected : " + director );
           
       
            
        
            
           
        } else {
            io.print("No Such Director ");
        }
        io.readString("Please hit enter to continue"); 
    }
    public void displayDvdByDirector(Dvd dvd){
     String directorsName = dvd.getDirectorsName(); 
     io.print(dvd.getDvd(dvd.getDirectorsName()));
    }
        public void displayFindBanner() {
            io.print("===FIND DVD BY DIRECTOR===");
          
                    
        }
       
        
        
    
    }



