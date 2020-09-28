package mapper.listUsers;

import java.util.List;

public class GetUsersResponse {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<ListData> data;
    private Ad ad;

    public Integer getPage() {
        return page;
    }
    public Integer getPerPage() {
        return per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotalPages() {
        return total_pages;
    }

    public List<ListData> getData() {
        return data;
    }

    public Ad getAd() { return ad; }

}
