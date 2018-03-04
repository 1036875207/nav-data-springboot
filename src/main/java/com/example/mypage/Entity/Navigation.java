package com.example.mypage.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Navigation {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String en_name;
    private Integer wight;
    @OneToMany
    private List<Navigation> childlist;
    private Integer childnum;
    private Integer ischild; //此属性用来判断是否是最大分类  1 是
    private String template;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<Navigation> getChildlist() {
        return childlist;
    }

    public void setChildlist(List<Navigation> childlist) {
        this.childlist = childlist;
    }

    public Integer getChildnum() {
        return childnum;
    }

    public void setChildnum(Integer childnum) {
        this.childnum = childnum;
    }

    public Integer getIschild() {
        return ischild;
    }

    public void setIschild(Integer ischild) {
        this.ischild = ischild;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public Integer getWight() {
        return wight;
    }

    public void setWight(Integer wight) {
        this.wight = wight;
    }
}
