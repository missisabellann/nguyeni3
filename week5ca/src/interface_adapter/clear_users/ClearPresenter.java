package interface_adapter.clear_users;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;

import javax.swing.*;
import java.beans.PropertyChangeEvent;

public class ClearPresenter implements ClearOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final ClearViewModel clearViewModel;
    private final SignupViewModel signupViewModel;

    public ClearPresenter(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel,  ClearViewModel clearViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.clearViewModel = clearViewModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData response) {
        // on success, go back to signup view
        StringBuilder users = new StringBuilder();
        for (String user: response.getDeletedUsers()){
            users.append(user).append("\n");
        }
        JOptionPane.showMessageDialog(null, users, "Users Deleted:", JOptionPane.INFORMATION_MESSAGE);

    }

    @Override
    public void prepareFailView(String errorMessage) {
        viewManagerModel.setActiveView(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            clearViewModel.setState((ClearState) evt.getNewValue());
            clearViewModel.firePropertyChanged();
        }
    }
}
