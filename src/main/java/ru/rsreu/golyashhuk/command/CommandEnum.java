package ru.rsreu.golyashhuk.command;

import ru.rsreu.golyashhuk.command.admin.*;
import ru.rsreu.golyashhuk.command.general.LoginCommand;
import ru.rsreu.golyashhuk.command.general.LogoutCommand;
import ru.rsreu.golyashhuk.command.moderator.BlockUserCommand;
import ru.rsreu.golyashhuk.command.moderator.ModeratorViewQueriesCommand;
import ru.rsreu.golyashhuk.command.moderator.ModeratorViewUsersCommand;
import ru.rsreu.golyashhuk.command.moderator.UnblockUserCommand;
import ru.rsreu.golyashhuk.command.officeemployee.*;
import sun.awt.HKSCS;

import java.util.HashSet;
import java.util.Set;

public enum CommandEnum {

    //    GENERAL
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },

    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },

    //    ADMIN
    VIEWQUERIES {
        {
            this.command = new ViewQueriesCommand();
        }
    },

    VIEWUSERS {
        {
            this.command = new ViewUsersCommand();
        }
    },

    CREATEDEVICE {
        {
            this.command = new CreateDeviceCommand();
        }
    },

    DELETEDEVICE {
        {
            this.command = new DeleteDeviceCommand();
        }
    },

    VIEWDEVICES {
        {
            this.command = new ViewDevicesCommand();
        }
    },

    CREATEUSER {
        {
            this.command = new CreateUserCommand();
        }
    },

    EDITUSER {
        {
            this.command = new EditUserCommand();
        }
    },

    DELETEUSER {
        {
            this.command = new DeleteUserCommand();
        }
    },

    GIVEDEVICE {
        {
            this.command = new GiveDeviceCommand();
        }
    },

    REFUSEGIVEDEVICE {
        {
            this.command = new RefuseGiveDeviceCommand();
        }
    },

    ACCEPTDEVICE {
        {
            this.command = new AcceptDeviceCommand();
        }
    },

    REFUSEACCEPTDEVICE {
        {
            this.command = new RefuseAcceptDeviceCommand();
        }
    },

    REPAIRDEVICE {
        {
            this.command = new RepairDeviceCommand();
        }
    },

    REFUSEREPAIRDEVICE {
        {
            this.command = new RefuseRepairDeviceCommand();
        }
    },

    CLOSEQUERY {
        {
            this.command = new CloseQueryCommand();
        }
    },

    // MODERATOR

    MODERATORVIEWQUERIES {
        {
            this.command = new ModeratorViewQueriesCommand();
        }
    },

    MODERATORVIEWUSERS {
        {
            this.command = new ModeratorViewUsersCommand();
        }
    },

    BLOCKUSER {
        {
            this.command = new BlockUserCommand();
        }
    },

    UNBLOCKUSER {
        {
            this.command = new UnblockUserCommand();
        }
    },

    //    OFFICE EMPLOYEE
    VIEWFREEDEVICES {
        {
            this.command = new ViewFreeDevicesCommand();
        }
    },

    VIEWUSERDEVICES {
        {
            this.command = new ViewUserDevicesCommand();
        }
    },

    VIEWUSERQUERIES {
        {
            this.command = new ViewUserQueriesCommand();
        }
    },

    CREATEQUERY {
        {
            this.command = new CreateQueryCommand();
        }
    };

    public static final Set<ActionCommand> GENERAL_COMMANDS = new HashSet<ActionCommand>() {
        {
            add(CommandEnum.LOGIN.getCurrentCommand());
            add(CommandEnum.LOGOUT.getCurrentCommand());
        }
    };

    public static final Set<ActionCommand> ADMIN_COMMANDS = new HashSet<ActionCommand>() {
        {
            add(CommandEnum.VIEWUSERS.getCurrentCommand());
            add(CommandEnum.CREATEUSER.getCurrentCommand());
            add(CommandEnum.EDITUSER.getCurrentCommand());
            add(CommandEnum.DELETEUSER.getCurrentCommand());
        }
    };

    public static final Set<ActionCommand> MODERATOR_COMMANDS = new HashSet<ActionCommand>() {
        {
            add(CommandEnum.MODERATORVIEWUSERS.getCurrentCommand());
            add(CommandEnum.MODERATORVIEWQUERIES.getCurrentCommand());
            add(CommandEnum.BLOCKUSER.getCurrentCommand());
            add(CommandEnum.UNBLOCKUSER.getCurrentCommand());
        }
    };

    public static final Set<ActionCommand> OFFICEEMPLOYEE_COMMANDS = new HashSet<ActionCommand>() {
        {
            add(CommandEnum.VIEWFREEDEVICES.getCurrentCommand());
            add(CommandEnum.VIEWUSERQUERIES.getCurrentCommand());
            add(CommandEnum.VIEWUSERDEVICES.getCurrentCommand());
            add(CommandEnum.CREATEQUERY.getCurrentCommand());
        }
    };

    public static final Set<ActionCommand> SYS_ADMIN_COMMANDS = new HashSet<ActionCommand>() {
        {
            add(CommandEnum.VIEWDEVICES.getCurrentCommand());
            add(CommandEnum.VIEWQUERIES.getCurrentCommand());
            add(CommandEnum.CREATEDEVICE.getCurrentCommand());
            add(CommandEnum.DELETEDEVICE.getCurrentCommand());
            add(CommandEnum.CLOSEQUERY.getCurrentCommand());
            add(CommandEnum.ACCEPTDEVICE.getCurrentCommand());
            add(CommandEnum.REFUSEACCEPTDEVICE.getCurrentCommand());
            add(CommandEnum.REPAIRDEVICE.getCurrentCommand());
            add(CommandEnum.REFUSEREPAIRDEVICE.getCurrentCommand());
            add(CommandEnum.GIVEDEVICE.getCurrentCommand());
            add(CommandEnum.REFUSEGIVEDEVICE.getCurrentCommand());

        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return this.command;
    }
}
