package pojo;

//资产类别表
public class AssetCategory {
    private String assetCategoryNo;
    private String assetCategoryDescription;

    public String getAssetCategoryNo() {
        return assetCategoryNo;
    }

    public void setAssetCategoryNo(String assetCategoryNo) {
        this.assetCategoryNo = assetCategoryNo;
    }

    public String getAssetCategoryDescription() {
        return assetCategoryDescription;
    }

    public void setAssetCategoryDescription(String assetCategoryDescription) {
        this.assetCategoryDescription = assetCategoryDescription;
    }

    @Override
    public String toString() {
        return "AssetCategory{" +
                "assetCategoryNo='" + assetCategoryNo + '\'' +
                ", assetCategoryDescription='" + assetCategoryDescription + '\'' +
                '}';
    }
}
