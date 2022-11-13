public class FilterByName implements Filter<String> {
    @Override
    public String execute(String input) {
        String[] parts = input.split(",", -1);
        if (parts.length < 20) {
            return null;
        }
        if (parts[108].contains("\"nightclub\"") || parts[108].contains("\"bar\"")) {
            DatabaseInfo info;
            if (parts[18].isEmpty()) {
                return null;
            }
            if (parts[749].contains("POLYGON")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(parts[749]);
                stringBuilder.append(",");

                for (int i = 750; i < parts.length; i++) {
                    stringBuilder.append(parts[i]);
                    stringBuilder.append(",");
                }
                info = new DatabaseInfo(parts[0], parts[18], parts[108], stringBuilder.toString());
            } else {
                info = new DatabaseInfo(parts[0], parts[18], parts[108], parts[parts.length-1]);
            }
            return info.toString();
        }
        return null;
    }
}
