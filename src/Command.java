import java.util.HashMap;
import java.util.Map;


public enum Command {
	UPDATE("u"), EXIT("e"), RESTART("r");
	
	private final String command;
	
	private static final Map<String, Command> map;
    static {
        map = new HashMap<String, Command>();
        for (Command cmd : Command.values()) {
            map.put(cmd.command, cmd);
        }
    }
    
	Command(final String command) {
		this.command = command;
	}
    
    public static Command findByKey(String i) {
        return map.get(i);
    }
}
