package ichoco.dontfall.othersUtils;

import org.bukkit.configuration.file.FileConfiguration;

import ichoco.dontfall.DontFall_Main;

public class Messages {
    private static FileConfiguration messagesConfig = DontFall_Main.getInstance().getMessages();
    public static String Location_Format = transformToString(messagesConfig.getString("Location_Format"));
    public static String Golden_Apple = transformToString(messagesConfig.getString("Golden_Apple"));
    public static String Golden_Head = transformToString(messagesConfig.getString("Golden_Head"));
    
    private static String transformToString(String section){
        String string = "";
        for(String line : messagesConfig.getStringList(section)){
            string += line + "\n";
        }
        return string.replace('&', '§');
    }
}