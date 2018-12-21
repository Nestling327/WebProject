package Vo;

import java.util.List;

public class Commend {
    private String info;
    private int id;
    private int pid;
    private String username;
    List<Commend> childcom;
    public Commend(String username,String info,int pid){
        this.username = username;
        this.info = info;
        this.pid = pid;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public int getPid() {
        return pid;
    }

    public List<Commend> getChildcom() {
        return childcom;
    }

    public String getInfo() {
        return info;
    }

    public void setChildcom(List<Commend> childcom) {
        this.childcom = childcom;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
