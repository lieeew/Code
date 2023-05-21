package com.hspedu.Spring.bean;

import com.hspedu.Spring.bean.Monster;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class SpELBean {

    private String name;
    private Monster monster;
    private String monsterName;
    private String crySound; //叫声
    private String bookName;
    private Double result;

    public SpELBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getCrySound() {
        return crySound;
    }

    public void setCrySound(String crySound) {
        this.crySound = crySound;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    //cry 方法会返回字符串
    public String cry(String sound) {
        return "发出 " + sound + "叫声...";
    }

    //read 返回字符串
    public static String read(String bookName) {
        return "正在看 " + bookName;
    }

    public void crySound() {
        // empty method
    }

    @Override
    public String toString() {
        return "SpELBean{" +
                "name='" + name + '\'' +
                ", monster=" + monster +
                ", monsterName='" + monsterName + '\'' +
                ", crySound='" + crySound + '\'' +
                ", bookName='" + bookName + '\'' +
                ", result=" + result +
                '}';
    }
}
