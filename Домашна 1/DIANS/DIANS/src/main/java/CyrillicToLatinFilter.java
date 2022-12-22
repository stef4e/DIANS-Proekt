import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class CyrillicToLatinFilter implements Filter<String> {
    @Override
    public String execute(String input) {
        StringBuilder latinString = new StringBuilder();
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

            for (int i = 0; i < name.length(); i++) {
                String c = name.substring(i, i + 1);
                String l = cyrillicToLatin.get(c);
                latinString.append(Objects.requireNonNullElse(l, c));
            }

            String output = parts[2] + "," + parts[3];
            String contactInfo = parts[4];
            DatabaseInfo info;
            if (latinString.toString().equals("klub „privilidj“")) {
                name = "klub privilige";
                info = new DatabaseInfo(name, parts[1], output, contactInfo);
            } else {
                info = new DatabaseInfo(latinString.toString(), parts[1], output, contactInfo);
            }
            return info.toString();
        }
        return null;
    }
}
