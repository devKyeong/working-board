package kyeong.practice.workingboard;

public class MainVO implements Comparable<MainVO>{

    private int row_num;
    private String title;
    private String desc;
    private String progress;
    private String start_date;
    private String end_date;

    public int getRow_num() {
        return row_num;
    }

    public void setRow_num(int row_num) {
        this.row_num = row_num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Override
    public int compareTo(MainVO mainVO) {

        if(this.row_num < mainVO.getRow_num()) return -1;
        else if(this.row_num > mainVO.getRow_num()) return 1;

        return 0;
    }
}
