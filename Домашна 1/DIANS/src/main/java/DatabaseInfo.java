public class DatabaseInfo {

    String name, identifier, pointOrPolygon, contactInfo;

    public DatabaseInfo(String engName, String identifier, String pointOrPolygon, String contactInfo) {
        this.name = engName;
        this.identifier = identifier;
        this.pointOrPolygon = pointOrPolygon;
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", name, identifier, pointOrPolygon, contactInfo);
    }
}
