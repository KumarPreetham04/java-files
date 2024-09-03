abstract class calci1 {

    public abstract void add();

    public abstract void div();

    public abstract void mul();

    public abstract void sub();

    public void aboutproject() {
        System.out.println("calci program");
    }
}

class calci extends calci1 {
    public void add() {
        System.out.println(1 + 1);
    }

    public void div() {
        System.out.println(4 / 2);
    }

    public void mul()

    {
        System.out.println(2 * 3);
    }

    public void sub()

    {
        System.out.println(1 - 1);
    }
}

public class sts2 {
    public static void main(String[]args) {
        calci c = new calci();
        c.add();
        c.div();
        c.mul();
        c.sub();

    }
}
