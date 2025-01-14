package w3.w3_6_oop.SRP.violating;

// 부동산 자산을 관리하기 위한 Asset 클래스 선언
public class Asset {
    String assetType;  // 토지("land") 또는 건물("building")
    int landArea; // 토지 평수

    // 토지 타입 자산의 경우 아래 건물면적 및 층수 필드가 무의미
    // => SRP 위반
    int floorArea;
    int floors;

    public Asset(String assetType, int landArea) {
        this.assetType = assetType;
        this.landArea = landArea;
    }

    public Asset(String assetType, int landArea, int floorArea, int floors) {
        this.assetType = assetType;
        this.landArea = landArea;
        this.floorArea = floorArea;
        this.floors = floors;
    }

    public int getLandArea() {
        return landArea;
    }

    public void setLandArea(int landArea) {
        this.landArea = landArea;
    }

    public int getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(int floorArea) {
        this.floorArea = floorArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }
}