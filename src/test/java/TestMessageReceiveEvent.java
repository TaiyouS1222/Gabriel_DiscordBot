import com.bot.entities.LoginInfo;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.junit.Test;

public class TestMessageReceiveEvent extends ListenerAdapter {
    @Test
    public static void main(String[] args) throws Exception{
        LoginInfo loginInfo = new LoginInfo();
        JDA jda = JDABuilder.createDefault(loginInfo.getToken()).build();
        JDABuilder jdaBuilder = JDABuilder.createDefault(args[0]);
        jdaBuilder.setActivity(Activity.playing("IntelliJ IDEA"))
                .addEventListeners(new TestMessageReceiveEvent());

    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContentRaw().equalsIgnoreCase("Ping")){
            event.getChannel().sendMessage("Pong").queue();
        }
    }

}
