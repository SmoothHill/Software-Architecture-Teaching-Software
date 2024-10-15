package FUN4;

import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        File inFile = new File("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\icture_File\\input.txt");
        File outFile = new File("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\icture_File\\input.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile,pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();

    }
}
