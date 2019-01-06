import com.google.common.util.concurrent.FutureCallback;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import java.util.HashMap;

public class jam {

    public static void main(String[] args) {
        final HashMap<String,String> map = new HashMap<String, String>();
        DiscordAPI api = Javacord.getApi("Your Token",true);

        api.connect(new FutureCallback<DiscordAPI>() {
            public void onSuccess(final DiscordAPI api) {
                api.registerListener(new MessageCreateListener() {
                    public void onMessageCreate(DiscordAPI api, Message message) {
                        String data = message.getContent();
                        String[] datas = message.toString().split(":");
                        if(datas[0].contains("Chatbot")) return;

                        if (data.contains("심심")){
                            message.reply("제가 놀아드릴까요?");
                        }
                        else if(data.contains("ㅎㅇ") || data.contains("하이")|| data.contains("하위")|| data.contains("안녕")){
                            message.reply("안녕하세요. 반갑습니다.");
                        }
                        else if(data.contains("ㅂㅇ") || data.contains("바이")|| data.contains("ㅂㅂ")|| data.contains("ㅂ2")){
                            message.reply("잘가");
                        }
                    }
                });
            }

            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
