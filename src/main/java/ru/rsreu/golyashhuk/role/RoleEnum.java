package ru.rsreu.golyashhuk.role;


import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.command.CommandEnum;
import ru.rsreu.golyashhuk.config.ConfigurationManager;

public enum RoleEnum implements Role {
    ADMIN(1) {
        @Override
        public String getHeader() {
            return ConfigurationManager.getProperty("path.page.header.admin");
        }

        @Override
        public boolean haveCommand(ActionCommand command) {
            return CommandEnum.GENERAL_COMMANDS.contains(command) || CommandEnum.ADMIN_COMMANDS.contains(command);
        }
    },

    MODERATOR(2) {
        @Override
        public String getHeader() {
            return ConfigurationManager.getProperty("path.page.header.moderator");
        }

        @Override
        public boolean haveCommand(ActionCommand command) {
            return CommandEnum.GENERAL_COMMANDS.contains(command) || CommandEnum.MODERATOR_COMMANDS.contains(command);
        }
    },

    OFFICEEMPLOYEE(3) {
        @Override
        public String getHeader() {
            return ConfigurationManager.getProperty("path.page.header.officeemployee");
        }

        @Override
        public boolean haveCommand(ActionCommand command) {
            return CommandEnum.GENERAL_COMMANDS.contains(command) || CommandEnum.OFFICEEMPLOYEE_COMMANDS.contains(command);
        }
    },

    SYSADMIN(3) {
        @Override
        public String getHeader() {
            return ConfigurationManager.getProperty("path.page.header.sysadmin");
        }

        @Override
        public boolean haveCommand(ActionCommand command) {
            return CommandEnum.GENERAL_COMMANDS.contains(command) || CommandEnum.SYS_ADMIN_COMMANDS.contains(command);
        }
    },

    NULL(4) {
        @Override
        public String getHeader() {
            return ConfigurationManager.getProperty("path.page.home.nulluser");
        }

        @Override
        public boolean haveCommand(ActionCommand command) {
            return false;
        }
    };
    private int accessLevel;

    RoleEnum(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public int getAccessLevel() {
        return accessLevel;
    }

    public static boolean isHigher(Role first, Role other) {
        return first.getAccessLevel() < other.getAccessLevel();
    }

}
