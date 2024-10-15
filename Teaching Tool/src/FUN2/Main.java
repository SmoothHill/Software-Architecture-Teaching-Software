package FUN2;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.input("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\icture_File\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\output.txt");

    }
}
