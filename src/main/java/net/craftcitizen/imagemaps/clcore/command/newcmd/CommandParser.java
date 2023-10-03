package net.craftcitizen.imagemaps.clcore.command.newcmd;

public interface CommandParser<T> {
    
    public Class<T> getType();
    
    public ParserResult<T> parse(String input);
}