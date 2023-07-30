package sakura.bw.addon.usages;

public class WarningMessages {
    private String message = "";

    //==******************==
    //这里是所有的警告消息
    //==******************==

    public String Mysql_NotConnected(){
        message = "You haven't connected to the server\nPlease use the usage 'search' or retry";
        return message;
    }

    public String SetPlayermaps_NotConfirm(){
        message = "This method is very dangerous\nSo Please use method 'confirm_remove' for twice\nThen you can successfully execute this method";
        return message;
    }

    public String SetPlayermaps_NotConfirm_1l(){
        message = "Please confirm for twice,there is one time left";
        return message;
    }

    public String SetPlayermaps_ConfirmSuccessully(){
        message = "Confirm successfully you can remove for now";
        return message;
    }

    public String SetPlayermaps_alreadychanged(){
        message = "The mode has already changed,But it doesn't matter";
        return message;
    }

    public String SetPlayermaps_nomoremode(){
        message = "There is no more mode to confirm";
        return message;
    }
}
