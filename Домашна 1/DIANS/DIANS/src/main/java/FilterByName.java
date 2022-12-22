public class FilterByName implements Filter<String> {
    @Override
    public String execute(String input) {
        input = input.replace("\"", "");
        String[] parts = input.split(",", -1);
        if (parts.length < 20) {
            return null;
        }
        if (parts[108].contains("nightclub") || parts[108].contains("bar")) {
            String street = parts[106];
            String phone = parts[137];
            String email = parts[159];
            String website = parts[92];
            //TODO: separate in specific method
            StringBuilder stringBuilder = new StringBuilder();
            if(!street.isEmpty()) {
                stringBuilder.append("Address: ");
                stringBuilder.append(street).append("; ");
            }
            if(!phone.isEmpty()) {
                stringBuilder.append("Phone: ");
                stringBuilder.append(phone).append("; ");
            }
            if(!email.isEmpty()) {
                stringBuilder.append("E-mail: ");
                stringBuilder.append(email).append("; ");
            }
            if(!website.isEmpty()){
                stringBuilder.append("Website: ");
                stringBuilder.append(website).append(";");
            }
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
                info = new DatabaseInfo(parts[18], parts[108], output, stringBuilder.toString());
            } else {
                String output = parts[749].replace("POINT ", "");
                output = output.replace("(", "");
                output = output.replace(" ", ",");
                output = output.replace(")", "");
                if(output.isEmpty()){
                    return null;
                }
                info = new DatabaseInfo(parts[18], parts[108], output, stringBuilder.toString());
            }
            return info.toString();
        }
        return null;
    }
}
