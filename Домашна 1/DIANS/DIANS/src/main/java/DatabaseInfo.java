public class DatabaseInfo {

    String id, engName, identifier, pointOrPolygon;

    public DatabaseInfo(String id, String engName, String identifier, String pointOrPolygon) {
        this.id = id;
        this.engName = engName;
        this.identifier = identifier;
        this.pointOrPolygon = pointOrPolygon;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", id, engName, identifier, pointOrPolygon);
    }
}
