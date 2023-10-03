package net.craftcitizen.imagemaps.clcore.command.newcmd;

public class CommandHandlerException extends Exception {
    private static final long serialVersionUID = 8032821111561734735L;
    
    public CommandHandlerException(String message) {
        super(message);
    }
    
    public CommandHandlerException() {
        super();
    }
}