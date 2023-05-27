package observer;

import solver.CStepData;

public class CConsoleObserver implements IObserver{

    @Override
    public void update(CStepData data) {
        System.out.printf("%-6.4f. %-10.7f %-10.7f\n",
                data.T, data.Alpha, data.Omega);
    }
}
