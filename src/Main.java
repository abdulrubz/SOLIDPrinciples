public class Main {
    public static void main(String[] args) {
        //VIOLATION
        ViolationTester v = new ViolationTester();
        v.testViolation();

        //SOLUTION
        SolutionTester s = new SolutionTester();
        s.testSolution();
    }
}


