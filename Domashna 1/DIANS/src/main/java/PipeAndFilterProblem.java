import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PipeAndFilterProblem{
    public static void main(String[] args) throws IOException {
            Pipe<String> pipe = new Pipe<>();
            FilterByName filterByName = new FilterByName();
            CyrillicToLatinFilter latinToCyrillicFilter = new CyrillicToLatinFilter();
            pipe.addFilter(filterByName);
            pipe.addFilter(latinToCyrillicFilter);


            Scanner scanner = new Scanner(new File("C:\\Users\\pavel\\Desktop\\DIANS\\src\\main\\resources\\map.csv"));
            scanner.useDelimiter(",");
            FileWriter writer = new FileWriter("C:\\Users\\pavel\\Desktop\\DIANS\\src\\main\\resources\\Output.csv");

            while (scanner.hasNextLine()) {
                String s = pipe.runFilter(scanner.nextLine());
                if(s!=null) {
                    writer.write(s);
                    writer.write("\n");
                    writer.flush();
                }
            }
            writer.close();
        }
}