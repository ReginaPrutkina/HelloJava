package com.company.project;

import java.time.LocalDate;

public class NotificationService implements NeedNotificate{
    private String notificationText;
    private boolean notifyFlag;
    NotificationService(){
        if (isDateToNotificate())
        {
            notificationText = "текущее состояние вкладов";
            notifyFlag = true;
        }
        if (isNeedToNotificate())
        {
            notificationText += "Истеакет срок вклада";
            notifyFlag = true;
        }

    }
    public String getNotificationText(){
        return notificationText;
    }
    public boolean getNotifyFlag(){
        return notifyFlag;
    }
    @Override
    public boolean isNeedToNotificate() {
        //Посылаем оповещение
        return false;
    }

    @Override
    public boolean isDateToNotificate() {
        return false;
    }
}
