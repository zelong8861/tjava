package InnerClass;

public class OuterClass {
    private String name = "li";
    private Integer age = 10;

    public class InnerClass {
        String name = "wang";
        Integer age = 12;
        void printMsg() {
            System.out.println("name : " + name + "age : " + age);
        }
    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.printMsg();


        System.out.println("--");
        outerClass.getInnerClass().printMsg();


    }
}
