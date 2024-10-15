package FUN3;

public class Main {
    public static void main(String[] args) {

        KWICSubject kwicSubject = new KWICSubject();

        Input input = new Input("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\icture_File\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getKwicList(), "C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\icture_File\\output.txt");


        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);

        kwicSubject.startKWIC();
    }
}
