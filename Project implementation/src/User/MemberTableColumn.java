package User;

import project.Member;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class MemberTableColumn extends Member {
    private String areaName;

    public MemberTableColumn (Member member, String areaName) {
        super(member.getAddress(), member.getCity(), member.getEducation(), member.getPhone(), member.getEmail(), member.getMID(), member.getDOB(), member.getName(), member.getAreaID(), member.getSex(), member.getOccupation(), member.getUID());
        
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
