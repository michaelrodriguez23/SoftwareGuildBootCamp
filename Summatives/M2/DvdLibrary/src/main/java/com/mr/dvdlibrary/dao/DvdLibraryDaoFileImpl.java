package com.mr.dvdlibrary.dao;

import com.mr.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    private Map<String, Dvd> Dvds = new HashMap<String, Dvd>();
    public static final String DVD_LIBRARY_FILE = "dvdLibrary.txt";
    public static final String DELIMITER = "::";

    /**
     *
     * @param title
     * @param dvd
     * @param A String is being pass in the first parameter,
     *
     * @param Dvd Dvd object into the 2nd parameter.
     * @return returning Dvd type instantiating a newDvd.
     *
     */
    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryPersistenceException {
        loadLibrary();
        Dvd newDvd = Dvds.put(title, dvd);
        writeLibrary();
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryPersistenceException {
        loadLibrary();
        return new ArrayList<Dvd>(Dvds.values());
    }

    @Override
    public Dvd getDvd(String title) throws DvdLibraryPersistenceException {
        loadLibrary();
        return Dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryPersistenceException {
        loadLibrary();
        Dvd removeDvd = Dvds.remove(title);
        writeLibrary();
        return removeDvd;
    }

    @Override
    public Dvd editDvd(String title, Dvd dvd) throws DvdLibraryPersistenceException {
       loadLibrary();
       Dvds.remove(title);
       Dvd editDvd = Dvds.put(title, dvd);
       writeLibrary();
       return editDvd; 
    }

  


    private Dvd unmarshallDvd(String dvdAsText) {
        // studentAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // 1234::Ada::Lovelace::Java-September1842
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in studentTokens.
        // Which should look like this:
        // __________________________________________________________________________
        // |     |      |        |                  |                |
        // |james| 0211 |  PG13  |    Wes Anderson  |    Walt Disney | 10 Rotten Tomotoes
        // |Bond |      |        |                  |                |
        // ---------------------------------------|-----------------------------------
        //  [0]  [1]    [2]         [3]                     [4]             [5]
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        // Given the pattern above, the student Id is in index 0 of the array.
        String title = dvdTokens[0];

        // Which we can then use to create a new Dvd object to satisfy
        // the requirements of the DVD constructor.
        Dvd dvdFromFile = new Dvd(title);

        // However, there are 3 remaining tokens that need to be set into the
        // new student object. Do this manually by using the appropriate setters.
        // Index 1 - Release Date
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        //Index 2 - Rating
        dvdFromFile.setMpaaRating(dvdTokens[2]);

        // Index 3 - Director
        dvdFromFile.setDirectorsName(dvdTokens[3]);

        // Index 4 - Studio
        dvdFromFile.setStudio(dvdTokens[4]);

        // Index 5 - Users Note
        dvdFromFile.setUserCustomNote(dvdTokens[5]);

        // We have now created a student! Return it!
        return dvdFromFile;

    }

    private void loadLibrary() throws DvdLibraryPersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryPersistenceException(
                    "-_____- Could not load dvd collection data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        Dvd currentDvd;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentDvd = unmarshallDvd(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            Dvds.put(currentDvd.getTitle(), currentDvd); 
       }
        // close scanner
        scanner.close();
    }
    private String marshallDvd(Dvd aDvd){
    // We need to turn a Student object into a line of text for our file.
    // For example, we need an in memory object to end up like this:
    // 4321::Charles::Babbage::Java-September1842

    // It's not a complicated process. Just get out each property,
    // and concatenate with our DELIMITER as a kind of spacer. 

    // Start with the Dvd Title, since that's supposed to be first.
    String dvdAsText = aDvd.getTitle() + DELIMITER; 
 

    // add the rest of the properties in the correct order:

    // Release Date
    dvdAsText += aDvd.getReleaseDate() + DELIMITER;

    // mpaaRating
    dvdAsText += aDvd.getMpaaRating() + DELIMITER; 
    
   // Directors Name
    dvdAsText += aDvd.getDirectorsName() + DELIMITER; 
    
    // Studio
    dvdAsText +=aDvd.getStudio() + DELIMITER; 

    // UserCustomNote - don't forget to skip the DELIMITER here.
    dvdAsText += aDvd.getUserCustomNote(); 

    // We have now turned a student to text! Return it!
    return dvdAsText;
    
}
    /**
 * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
 * for file format.
 * 
 * @throws ClassRosterDaoException if an error occurs writing to the file
 */
private void writeLibrary() throws DvdLibraryPersistenceException {
    // NOTE FOR APPRENTICES: We are not handling the IOException - but
    // we are translating it to an application specific exception and 
    // then simple throwing it (i.e. 'reporting' it) to the code that
    // called us.  It is the responsibility of the calling code to 
    // handle any errors that occur.
    PrintWriter out;

    try {
        out = new PrintWriter(new FileWriter(DVD_LIBRARY_FILE));
    } catch (IOException e) {
        throw new DvdLibraryPersistenceException(
                "Could not save dvd data.", e);
    }

    // Write out the Student objects to the roster file.
    // NOTE TO THE APPRENTICES: We could just grab the student map,
    // get the Collection of Students and iterate over them but we've
    // already created a method that gets a List of Students so
    // we'll reuse it.
    String dvdAsText;
    List<Dvd> dvdList = this.getAllDvds();
    for (Dvd currentDvd : dvdList) {
        // turn a DVD object into a String
        dvdAsText = marshallDvd(currentDvd);
        // write the Student object to the file
        out.println(dvdAsText);
        // force PrintWriter to write line to the file
        out.flush();
    }
    // Clean up
    out.close();
}

    @Override
    public Dvd findByDirector(Dvd dvd) throws DvdLibraryPersistenceException {
    loadLibrary();
    Dvd dvdDirector = Dvds.get(dvd.getDirectorsName());

    return dvdDirector;
    }

     
}
