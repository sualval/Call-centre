public class Call {
    private static int count = 0;
    private final String name;

    public Call() {
        name = "Call " + count;
        System.out.println("new Call " + count);
        count++;
    }

    @Override
    public String toString() {
        return "Call{" +
                "name='" + name + '\'' +
                '}';
    }
}
