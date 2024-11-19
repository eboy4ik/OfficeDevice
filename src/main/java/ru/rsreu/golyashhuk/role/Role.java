package ru.rsreu.golyashhuk.role;

import ru.rsreu.golyashhuk.command.ActionCommand;


public interface Role {
    public String getHeader();

    public boolean haveCommand(ActionCommand command);

    public int getAccessLevel();
}
