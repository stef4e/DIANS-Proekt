import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PipeAndFilterProblem{
    public static void main(String[] args) throws IOException {
        Pipe<String> pipe = new Pipe<>();
        FilterByName filterByName = new FilterByName();
        ToLowerCaseFilter toLowerCaseFilter = new ToLowerCaseFilter();
        pipe.addFilter(filterByName);
        pipe.addFilter(toLowerCaseFilter);

        Scanner scanner = new Scanner(new File("C:\\Users\\user\\Downloads\\DIANS\\DIANS\\src\\main\\resources\\map.csv"));
        scanner.useDelimiter(",");
        FileWriter writer = new FileWriter("C:\\Users\\user\\Downloads\\DIANS\\DIANS\\src\\main\\resources\\Output.csv");
        //List<String> lists = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String s = pipe.runFilter(scanner.nextLine());
            if(s!=null) {
                //lists.add(s);
                writer.write(s);
                writer.write("\n");
                writer.flush();
            }
        }
        writer.close();
    }
}