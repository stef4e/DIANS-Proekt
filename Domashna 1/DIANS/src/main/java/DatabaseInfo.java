public class DatabaseInfo {

    String name, barOrClub, coordinates, contactInfo;

    public DatabaseInfo(String name, String barOrClub, String coordinates, String contactInfo) {
        this.name = name;
        this.barOrClub = barOrClub;
        this.coordinates = coordinates;
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", name, barOrClub, coordinates, contactInfo);
    }
}
