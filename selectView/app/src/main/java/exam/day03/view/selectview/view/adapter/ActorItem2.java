package exam.day03.view.selectview.view.adapter;

public class ActorItem2 {
    public int myImg;
    public String name;
    public String date;
    public String info;

    public ActorItem2(int myImg, String name, String date, String info) {
        this.myImg = myImg;
        this.name = name;
        this.date = date;
        this.info = info;
    }

    @Override
    public String toString() {
        return "ActorItem{" +
                "myImg=" + myImg +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}