public class FilterByName implements Filter<String> {
    @Override
    public String execute(String input) {
        input = input.replace("\"", "");
        String[] parts = input.split(",", -1);
        if (parts.length < 20) {
            return null;
        }
        if (parts[108].contains("nightclub") || parts[108].contains("bar")) {
            DatabaseInfo info;
            if (parts[18].isEmpty()) {
                return null;
            }
            if (parts[749].contains("POLYGON")) {
                String output = parts[749].replace("POLYGON ", "");
                output = output.replace("((", "");
                output = output.replace(" ", ",");
                if(output.isEmpty()){
                    return null;
                }
                info = new DatabaseInfo(parts[18], parts[108], output);
            } else {
                String output = parts[749].replace("POINT ", "");
                output = output.replace("(", "");
                output = output.replace(" ", ",");
                output = output.replace(")", "");
                if(output.isEmpty()){
                    return null;
                }
                info = new DatabaseInfo(parts[18], parts[108], output);
            }
            return info.toString();
        }
        return null;
    }
}
