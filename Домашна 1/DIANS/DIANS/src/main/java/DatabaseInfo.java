public class DatabaseInfo {

    String name, identifier, pointOrPolygon;

    public DatabaseInfo(String engName, String identifier, String pointOrPolygon) {
        this.name = engName;
        this.identifier = identifier;
        this.pointOrPolygon = pointOrPolygon;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", name, identifier, pointOrPolygon);
    }
}
