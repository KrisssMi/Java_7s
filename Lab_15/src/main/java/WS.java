import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;

@ServerEndpoint("/ws")
public class WS {
    @OnOpen
    public void onOpen(Session session)
    {
        try
        {
            while (true)
            {
                String message = new SimpleDateFormat("HH:mm:ss").format(new Date());
                session.getBasicRemote().sendText(message);
                Thread.sleep(2000);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}