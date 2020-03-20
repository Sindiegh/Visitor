import com.sun.jmx.remote.util.ClassLogger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class main {



    public static void main(String[] args) throws IOException {


        Visitor Sindiswa = new Visitor("Sindiswa",42,LocalDate.now(),LocalTime.now(),"Status checked","Kat");
        Sindiswa.Save();
        Sindiswa.Load("Sindiswa");

    }
}
