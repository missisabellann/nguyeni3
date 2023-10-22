package use_case.clear_users;




import data_access.FileUserDataAccessObject;
import interface_adapter.clear_users.ClearPresenter;

import java.util.ArrayList;

public class ClearInteractor implements ClearInputBoundary{
    final ClearOutputBoundary clearPresenter;

    final FileUserDataAccessObject clearUserDataAccessObject;

    public ClearInteractor(FileUserDataAccessObject clearUserDataAccessObject,
                           ClearOutputBoundary clearOutputBoundary) {
        this.clearPresenter = clearOutputBoundary;
        this.clearUserDataAccessObject = clearUserDataAccessObject;
    }
    @Override
    public void execute() {
        try {
            ArrayList<String> deleted = clearUserDataAccessObject.delete();
            // Notify the output boundary of success
            ClearOutputData clearOutputData = new ClearOutputData(deleted);
            clearPresenter.prepareSuccessView(clearOutputData);
        } catch (Exception e) {
            // Notify the output boundary of failure
            clearPresenter.prepareFailView("Error");
        }

    }
}
