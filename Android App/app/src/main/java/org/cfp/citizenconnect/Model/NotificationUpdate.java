package org.cfp.citizenconnect.Model;

import io.realm.Realm;
import io.realm.RealmObject;

import static org.cfp.citizenconnect.CitizenConnectApplication.realm;


/**
 * Created by shahzaibshahid on 03/01/2018.
 */

public class NotificationUpdate extends RealmObject {
    int newNotification;

    public int getLastState() {
        return lastState;
    }

    public void setLastState(int lastState) {
        this.lastState = lastState;
    }

    int lastState;

    public int getNewNotification() {

        return newNotification;
    }

    public void setNewNotification(int _newNotification) {
        realm.executeTransaction(realm -> newNotification = _newNotification);
    }

    public static NotificationUpdate getInstance(Realm realm) {
        final NotificationUpdate[] notificationUpdate = {realm.where(NotificationUpdate.class).findFirst()};
        if (notificationUpdate[0] == null) {
            realm.executeTransaction(realm1 -> notificationUpdate[0] = realm1.createObject(NotificationUpdate.class));
        }
        return notificationUpdate[0];
    }
    public static  boolean clearNotification(){
        NotificationUpdate notificationStatus  = getInstance(realm);
        if(notificationStatus.getNewNotification()==0){
            return true;
        }
        else {
            return  false;
        }
    }
}
