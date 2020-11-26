package NetworkClasses;

import java.io.Serializable;

public class Category implements Serializable {
    protected String category1;
    protected String category2;
    protected String category3;
    protected String category4;
    protected String selectedCategory = null;

    public Category(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public Category(String category1, String category2, String category3, String category4) {
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.category4 = category4;
    }

    public String getCategory1() {
        return category1;
    }

    public String getCategory2() {
        return category2;
    }

    public String getCategory3() {
        return category3;
    }

    public String getCategory4() {
        return category4;
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }
}
