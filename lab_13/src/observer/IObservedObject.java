package observer;

import solver.CSolver;
import solver.CStepData;

public interface IObservedObject {
    void addObserver(IObserver obs);
    void removeObserver(IObserver obs);
    void notifyObservers(CStepData data);
}
