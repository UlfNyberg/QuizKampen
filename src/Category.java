import java.io.Serializable;

public class Category implements Serializable {
    protected String category1;
    protected String category2;
    protected String selectedCategory = null;

    public Category(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public Category(String category1, String category2) {
        this.category1 = category1;
        this.category2 = category2;
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
}
