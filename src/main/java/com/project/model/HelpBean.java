package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "helptable")
public class HelpBean {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="helpid")
private int hid;

@Column(name = "userid")
private String uid;

private String issue;

private String name;

private String description;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}



public int getHid() {
return hid;
}

public void setHid(int hid) {
this.hid = hid;
}

public String getUid() {
return uid;
}

public void setUid(String uid) {
this.uid = uid;
}

public String getIssue() {
return issue;
}

public void setIssue(String issue) {
this.issue = issue;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

}