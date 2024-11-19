package ru.rsreu.golyashhuk.role;

import ru.rsreu.golyashhuk.datastructure.DoubleSideMap;

public class RoleConverter {
    private static final DoubleSideMap<Role, Integer> ROLE_TO_USERROLEID = new DoubleSideMap<Role, Integer>() {
        {
            put(RoleEnum.ADMIN, 1);
            put(RoleEnum.MODERATOR, 2);
            put(RoleEnum.OFFICEEMPLOYEE, 3);
            put(RoleEnum.SYSADMIN, 4);
        }
    };

    public static Role getRoleByUserRoleId(int userRoleId) {
        return ROLE_TO_USERROLEID.getKey(userRoleId);
    }

    public static int getUserRoleIdByRole(Role role) {
        return ROLE_TO_USERROLEID.getValue(role);
    }

    public static Role getRoleByString(String role) {
        switch (role) {
            case "admin":
                return RoleEnum.ADMIN;
            case "moderator":
                return RoleEnum.MODERATOR;
            case "office_employee":
                return RoleEnum.OFFICEEMPLOYEE;
            case "sysadmin":
                return RoleEnum.SYSADMIN;
            default:
                return RoleEnum.NULL;
        }
    }
}
