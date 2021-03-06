package model;

/**
 * Created by 86761 on 2017/6/8.
 */
public class ManagerEntity {
    private String managerId;
    private String managerName;
    private String managerPassword;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagerEntity that = (ManagerEntity) o;

        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;
        if (managerName != null ? !managerName.equals(that.managerName) : that.managerName != null) return false;
        if (managerPassword != null ? !managerPassword.equals(that.managerPassword) : that.managerPassword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = managerId != null ? managerId.hashCode() : 0;
        result = 31 * result + (managerName != null ? managerName.hashCode() : 0);
        result = 31 * result + (managerPassword != null ? managerPassword.hashCode() : 0);
        return result;
    }
}
