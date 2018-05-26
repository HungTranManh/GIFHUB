package circleindicator.hungtm.com.tablayoutdemo.Story;

public class ItemStory {
    private  int idImageStory;
    private String tvStory;
    private String content;

    public ItemStory(int idImageStory, String tvStory, String content) {
        this.idImageStory = idImageStory;
        this.tvStory = tvStory;
        this.content = content;
    }

    public int getIdImageStory() {
        return idImageStory;
    }

    public void setIdImageStory(int idImageStory) {
        this.idImageStory = idImageStory;
    }

    public String getTvStory() {
        return tvStory;
    }

    public void setTvStory(String tvStory) {
        this.tvStory = tvStory;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
