package interface_adapter.clear_users;

// TODO Complete me

import interface_adapter.login.LoginState;
import use_case.clear_users.ClearInputData;

public class ClearState {
    private boolean clearAll;

    public ClearState() {
    }

    public boolean isClearAll() {
        return clearAll;
    }
    public void setClearAll(boolean clearAll) {
        this.clearAll = clearAll;
    }

}

