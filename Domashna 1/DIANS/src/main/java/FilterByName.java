import java.io.StringBufferInputStream;

public class FilterByName implements Filter<String> {
    @Override
    public String execute(String input) {
        input = input.replace("\"", "");
        String[] parts = input.split(",", -1);
        if (parts.length < 20) {
            return null;
        }
        String barOrNightclub = parts[108];
        if (barOrNightclub.contains("nightclub") || barOrNightclub.contains("bar")) {
            String name = parts[18];
            String street = parts[106];
            String phone = parts[137];
            String email = parts[159];
            String website = parts[92];
            //TODO: separate in specific method
            StringBuilder contactInfo = new StringBuilder();
            if(!street.isEmpty()) {
                contactInfo.append("Address: ");
                contactInfo.append(street).append("; ");
            }
            if(!phone.isEmpty()) {
                contactInfo.append("Phone: ");
                contactInfo.append(phone).append("; ");
            }
            if(!email.isEmpty()) {
                contactInfo.append("E-mail: ");
                contactInfo.append(email).append("; ");
            }
            if(!website.isEmpty()){
                contactInfo.append("Website: ");
                contactInfo.append(website).append(";");
            }
            DatabaseInfo info;
            if (name.isEmpty()) {
                return null;
            }
            String coordinates = parts[749];
            if (coordinates.contains("POLYGON")) {
                String output = coordinates.replace("POLYGON ", "");
                output = output.replace("((", "");
                output = output.replace(" ", ",");
                if(output.isEmpty()){
                    return null;
                }
                info = new DatabaseInfo(name, barOrNightclub, output, contactInfo.toString());
            } else {
                String output = coordinates.replace("POINT ", "");
                output = output.replace("(", "");
                output = output.replace(" ", ",");
                output = output.replace(")", "");
                if(output.isEmpty()){
                    return null;
                }
                info = new DatabaseInfo(name, barOrNightclub, output, contactInfo.toString());
            }
            return info.toString();
        }
        return null;
    }
}
