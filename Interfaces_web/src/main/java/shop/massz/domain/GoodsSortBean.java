package shop.massz.domain;

public class GoodsSortBean {
    private String sort_id;
    private String sort_name;

    public GoodsSortBean() {
    }

    public GoodsSortBean(String sort_id, String sort_name) {
        this.sort_id = sort_id;
        this.sort_name = sort_name;
    }

    public String getSort_id() {
        return sort_id;
    }

    public void setSort_id(String sort_id) {
        this.sort_id = sort_id;
    }

    public String getSort_name() {
        return sort_name;
    }

    public void setSort_name(String sort_name) {
        this.sort_name = sort_name;
    }

    @Override
    public String toString() {
        return "GoodsSortBean{" +
                "sort_id='" + sort_id + '\'' +
                ", sort_name='" + sort_name + '\'' +
                '}';
    }
}
