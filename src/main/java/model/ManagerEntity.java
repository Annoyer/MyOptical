package model;

/**
 * Created by 86761 on 2017/5/27.
 */
public class ManagerEntity {
    private int managerId;
    private String managerName;
    private String managerPassword;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
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

        if (managerId != that.managerId) return false;
        if (managerName != null ? !managerName.equals(that.managerName) : that.managerName != null) return false;
        if (managerPassword != null ? !managerPassword.equals(that.managerPassword) : that.managerPassword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = managerId;
        result = 31 * result + (managerName != null ? managerName.hashCode() : 0);
        result = 31 * result + (managerPassword != null ? managerPassword.hashCode() : 0);
        return result;
    }
}
