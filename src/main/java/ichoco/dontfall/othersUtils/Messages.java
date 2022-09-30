package ichoco.dontfall.othersUtils;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;

import ichoco.dontfall.DontFall_Main;

public class Messages {
    private static HashMap<Formats, String> messages = new HashMap<>();
    private static FileConfiguration messagesConfig = DontFall_Main.getInstance().getMessages();
    
    public static void loadMessages(){
        messages.put(Formats.Location_Format, messagesConfig.getString("Location_Format"));
    }

    /*
    * if you want use:
    * - "Example1"
    * - "Example2"
    * - "Example3"
    *
    * Remember change messages.yml if you change this
    *
    * messages.put(Formats.Location_Format, transformToString("Location_Format"));
    *
    private static String transformToString(String section){
        String string = " ";
        for(String line : messagesConfig.getStringList(section)){
            string += line;
        }
        return string;
    }
    */

    public static String getMessage(Formats format){
        return messages.get(format);
    }
}