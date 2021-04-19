package utils;

public class ZodiacDetails {
    private String name;
    private String startDate;
    private String endDate;

    public ZodiacDetails(String name, String startDate, String endDate){
        this.name=name;
        this.startDate=startDate;
        this.endDate=endDate;
    }

    public String getName() {
        return name;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
}
