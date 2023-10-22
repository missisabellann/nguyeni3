package use_case.clear_users;




import data_access.FileUserDataAccessObject;
import interface_adapter.clear_users.ClearPresenter;
import use_case.signup.SignupUserDataAccessInterface;

import java.util.ArrayList;

public class ClearInteractor implements ClearInputBoundary{
    final ClearOutputBoundary clearPresenter;
    final ClearUserDataAccessInterface userDataAccessObject;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessObject,
                           ClearOutputBoundary clearOutputBoundary) {
        this.clearPresenter = clearOutputBoundary;
        this.userDataAccessObject = userDataAccessObject;
    }
    @Override
    public void execute() {
        try {
            ArrayList<String> deleted = userDataAccessObject.delete();
            // Notify the output boundary of success
            ClearOutputData clearOutputData = new ClearOutputData(deleted);
            clearPresenter.prepareSuccessView(clearOutputData);
        } catch (Exception e) {
            // Notify the output boundary of failure
            clearPresenter.prepareFailView("Error");
        }

    }
}
