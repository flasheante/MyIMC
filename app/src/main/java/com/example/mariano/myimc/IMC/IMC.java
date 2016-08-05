package com.example.mariano.myimc.IMC;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;


/**
 * Created by Mariano on 3/8/16.
 */
@DatabaseTable(tableName ="IMCs")
public class IMC implements Serializable{
    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true)
    private int myId;

    @DatabaseField
    private String userName;

    @DatabaseField
    private String userHeight;

    @DatabaseField
    private String userWeight;

    @DatabaseField
    private String userIMC;

    @DatabaseField
    private String userMessage;

    public IMC() {}

    public IMC(String userName, String userHeight, String userWeight, String userIMC, String userMessage) {
        myId = 0;
        this.userName = userName;
        this.userHeight = userHeight;
        this.userWeight = userWeight;
        this.userIMC = userIMC;
        this.userMessage = userMessage;
    }
    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeight(){ return userHeight; }

    public void setUserHeight(String userHeight){ this.userHeight = userHeight;}

    public String getUserWeight(){ return userWeight; }

    public void setUserWeight(String userWeight){ this.userWeight = userWeight;}

    public String getUserIMC(){ return userIMC; }

    public void setUserIMC(String userHeight){ this.userIMC = userIMC;}

    public String getUserMessage(){ return userMessage; }

    public void setUserMessage(String userHeight){ this.userMessage = userMessage;}

}
