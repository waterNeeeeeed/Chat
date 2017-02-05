package runfeng.chat.model.msg;

/**
 * Created by 帝 on 2017/2/4.
 */
public class Msg {
    private int id;
    private String username;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
