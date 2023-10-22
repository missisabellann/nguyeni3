package use_case.clear_users;

import java.beans.PropertyChangeEvent;

public interface ClearOutputBoundary {
    void prepareSuccessView(ClearOutputData outputData);
    void prepareFailView(String error);

    void propertyChange(PropertyChangeEvent evt);
}
