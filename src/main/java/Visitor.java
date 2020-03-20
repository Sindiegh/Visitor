import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import  java.time.LocalTime;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Visitor {

    private  String fullName;
    private  int age;
    private  String comments;
    private  String nameOfAssistant;
    private LocalDate dateOfVisit;
    private LocalTime timeOfVisit;



    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());

    public Visitor(String fullName, int age,
                   LocalDate dateOfVisit, LocalTime timeOfVisit,
                   String comments, String nameOfAssistant) {
        this.fullName = fullName;
        this.age = age;
        this.dateOfVisit = dateOfVisit;
        this.timeOfVisit = timeOfVisit;
        this.comments = comments;
        this.nameOfAssistant = nameOfAssistant;
    }


    public String Save()
    {
String FileName = "visitor_"+this.fullName + ".txt";
          try {
              File userFile = new File("visitor_{" + fullName + "}.txt");
              if (!fullName.isEmpty()) {

                  if (userFile.createNewFile()) {
                      FileWriter writeToVisitor = new FileWriter(FileName);
                      writeToVisitor.write("name: " + fullName + "\nAge:" + age + "\ndate:" + LocalDate.now() + "\ntime: " + LocalTime.now() + "\nComments :" + comments+"\nName of Assistant: "+nameOfAssistant);
                      writeToVisitor.close();
                      logger.info("Successfully wrote to the file.");
                  }
                  else{
                  logger.error("File already exist");
                   }
              }
              else {
                  logger.error("Full name cannot be empty");

              }
        }catch (IOException e)
        {
            logger.error("Could not create file.");
            e.printStackTrace();
        }
          return FileName;

    }



    public void Load(String name)
    {
        name = "visitor_{"+fullName+"}.txt";
        try {
            File myObj = new File(name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            System.out.println(myObj.getAbsolutePath());
        } catch (FileNotFoundException e) {
            logger.error("File not created");

        }

    }



}
