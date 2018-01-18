package org.cfp.citizenconnect.Model;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import static org.cfp.citizenconnect.CitizenConnectApplciation.realm;

/**
 * Created by shahzaibshahid on 13/12/2017.
 */

public class Notifications extends RealmObject {

    @PrimaryKey
    String id;
    String filePath;
    String date;
    String description;
    String tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public  static void setNotifications(Notifications notificationsObj,Realm mRealm){
        mRealm.executeTransaction(realm -> {
            Notifications notifications = realm.createObject(Notifications.class, UUID.randomUUID().toString());
            notifications.setDate(notificationsObj.getDate());
            notifications.setDescription(notificationsObj.getDescription());
            notifications.setFilePath(notificationsObj.getFilePath());
            notifications.setTag(notificationsObj.getTag());
        });
    }

}