package practice4;

public enum Course {
    Mathematics(1),Physics(2),Chemistry(3),Computer(4),Biology(5);
    public final int label;

    Course(int label) {
        this.label = label;
    }

    public int getLabel() {
        return label;
    }


}
