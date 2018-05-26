package circleindicator.hungtm.com.testcircleindicator;

public class ItemFaceData {
    private int idImageItem;
    private String tvItem;
    private Boolean isClick;

    public ItemFaceData(int idImageItem, String tvItem, Boolean isClick) {
        this.idImageItem = idImageItem;
        this.tvItem = tvItem;
        this.isClick = isClick;
    }

    public int getIdImageItem() {
        return idImageItem;
    }

    public void setIdImageItem(int idImageItem) {
        this.idImageItem = idImageItem;
    }

    public String getTvItem() {
        return tvItem;
    }

    public void setTvItem(String tvItem) {
        this.tvItem = tvItem;
    }

    public Boolean getClick() {
        return isClick;
    }

    public void setClick(Boolean click) {
        isClick = click;
    }
}
