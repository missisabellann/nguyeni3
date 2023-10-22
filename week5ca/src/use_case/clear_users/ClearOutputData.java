package use_case.clear_users;

import java.util.ArrayList;

public class ClearOutputData {
    private ArrayList<String> deletedUsers;

    public ClearOutputData(ArrayList<String> deletedUsers) {
        this.deletedUsers = deletedUsers;
    }

    public ArrayList<String> getDeletedUsers() {
        return deletedUsers;
    }

}
