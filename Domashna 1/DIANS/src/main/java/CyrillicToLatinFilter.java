import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CyrillicToLatinFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        StringBuilder nameToLatin = new StringBuilder();
        StringBuilder contactInfoToLatin = new StringBuilder();
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
                String c = name.substring(i, i + 1);
                String l = cyrillicToLatin.get(c);
                nameToLatin.append(Objects.requireNonNullElse(l, c));
            }

            if(!Objects.equals(contactInfo, "")) {
            for(int i = 0; i < contactInfo.length(); i++){
                    String c1 = contactInfo.substring(i, i + 1);
                    String l1 = cyrillicToLatin.get(c1);
                    contactInfoToLatin.append(Objects.requireNonNullElse(l1, c1));
                }
            }

            String output = parts[2] + "," + parts[3];
            DatabaseInfo info;
            if (nameToLatin.toString().equals("epicetar")){
                name = "epicentar";
                info = new DatabaseInfo(name, parts[1], output, contactInfoToLatin.toString());
            } else if (nameToLatin.toString().equals("klub „privilidj“")) {
                name = "klub privilige";
                info = new DatabaseInfo(name, parts[1], output, contactInfoToLatin.toString());
            } else {
                info = new DatabaseInfo(nameToLatin.toString(), parts[1], output, contactInfoToLatin.toString());
            }
            return info.toString();
        }
        return null;
    }
}
