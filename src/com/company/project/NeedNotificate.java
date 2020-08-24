package com.company.project;

public interface NeedNotificate {
    //Проверка необходимости оповещения по индикаторам,
    // например срок влкада заканчивается менее, чем через месяц
    boolean isNeedToNotificate();
    //День для оповещения, например, конец месяца - для регулярного информирования, еженедельно - предупреждающее
    boolean isDateToNotificate();
}
