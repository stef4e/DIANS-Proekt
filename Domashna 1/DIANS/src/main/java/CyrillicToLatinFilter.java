import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CyrillicToLatinFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        StringBuilder nameToLatin = new StringBuilder(); //initializes the StringBuilder which will return the converted name from cyrillic to latin
        StringBuilder contactInfoToLatin = new StringBuilder(); //initializes the StringBuilder which will return the converted contactInfo from cyrillic to latin

        if (input != null) {
            input = input.toLowerCase();
            String[] parts = input.split(",", -1);
            String name = parts[0];
            Map<String, String> cyrillicToLatin = new HashMap<>();
            cyrillicToLatin.put("а", "a");
            cyrillicToLatin.put("б", "b");
            cyrillicToLatin.put("в", "v");
            cyrillicToLatin.put("г", "g");
            cyrillicToLatin.put("д", "d");
            cyrillicToLatin.put("ѓ", "gj");
            cyrillicToLatin.put("е", "e");
            cyrillicToLatin.put("ж", "zh");
            cyrillicToLatin.put("з", "z");
            cyrillicToLatin.put("и", "i");
            cyrillicToLatin.put("ј", "j");
            cyrillicToLatin.put("к", "k");
            cyrillicToLatin.put("л", "l");
            cyrillicToLatin.put("љ", "lj");
            cyrillicToLatin.put("м", "m");
            cyrillicToLatin.put("н", "n");
            cyrillicToLatin.put("њ", "nj");
            cyrillicToLatin.put("о", "o");
            cyrillicToLatin.put("п", "p");
            cyrillicToLatin.put("р", "r");
            cyrillicToLatin.put("с", "s");
            cyrillicToLatin.put("т", "t");
            cyrillicToLatin.put("ќ", "kj");
            cyrillicToLatin.put("у", "u");
            cyrillicToLatin.put("ф", "f");
            cyrillicToLatin.put("х", "h");
            cyrillicToLatin.put("ц", "c");
            cyrillicToLatin.put("ч", "ch");
            cyrillicToLatin.put("џ", "dj");
            cyrillicToLatin.put("ш", "sh");

            String contactInfo = parts[4];

            for (int i = 0; i < name.length(); i++) {
                String c = name.substring(i, i + 1); //Gets a single character from the name
                String l = cyrillicToLatin.get(c); //Checks if the character exists in the HashMap, if it exists it gets the character, if not it is initialized to null
                nameToLatin.append(Objects.requireNonNullElse(l, c)); //Depending on whether l is null, it appends a character.
                //If l is not null it appends l, if l is null it appends c.
            }

            if(!Objects.equals(contactInfo, "")) {
            for(int i = 0; i < contactInfo.length(); i++){ //same process as the one in the previous comments, but for contact info.
                    String c1 = contactInfo.substring(i, i + 1);
                    String l1 = cyrillicToLatin.get(c1);
                    contactInfoToLatin.append(Objects.requireNonNullElse(l1, c1));
                }
            }
            String barOrClub = parts[1];
            String xCoordinates = parts[2];
            String yCoordinates = parts[3];
            String output = xCoordinates + "," + yCoordinates;
            DatabaseInfo info;
            if (nameToLatin.toString().equals("epicetar")){ //due to data corruption in the CSV file one of the letters was lost, thus we had to manually change it
                name = "epicentar";
                info = new DatabaseInfo(name, barOrClub, output, contactInfoToLatin.toString());
            } else if (nameToLatin.toString().equals("klub „privilidj“")) { // changing the name from the CSV so that the name in the database is more accurate
                name = "klub privilige";
                info = new DatabaseInfo(name, barOrClub, output, contactInfoToLatin.toString());
            } else {
                info = new DatabaseInfo(nameToLatin.toString(), barOrClub, output, contactInfoToLatin.toString());
            }
            return info.toString();
        }
        return null;
    }
}
