package app;

import data_access.FileUserDataAccessObject;
import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearPresenter;
import interface_adapter.clear_users.ClearViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearInteractor;
import use_case.clear_users.ClearOutputBoundary;

import javax.swing.*;
import java.io.IOException;

public class ClearUseCaseFactory {

    /** Prevent instantiation. */
    private ClearUseCaseFactory() {}

    public static ClearController createClearUseCase(
            ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, ClearViewModel clearViewModel, FileUserDataAccessObject userDataAccessObject) {

        try {
            ClearInteractor clearInteractor = createClearInteractor(viewManagerModel, signupViewModel, clearViewModel, userDataAccessObject);
            return new ClearController(clearInteractor);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static ClearInteractor createClearInteractor(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, ClearViewModel clearViewModel,
                                                         FileUserDataAccessObject userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the OutputBoundary.
        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(viewManagerModel, signupViewModel, clearViewModel);

        return new ClearInteractor(userDataAccessObject, clearOutputBoundary);
    }
}
