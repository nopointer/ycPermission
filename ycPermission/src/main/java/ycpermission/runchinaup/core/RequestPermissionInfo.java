package ycpermission.runchinaup.core;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by nopointer on 2018/8/21.
 * 权限的信息
 */

public class RequestPermissionInfo implements Serializable {

    //申请权限的标题
    private String permissionTitle = "";
    //申请权限的文字说明
    private String permissionMessage = "";
    //要申请的权限
    private String[] permissionArr = null;

    //取消按钮的文字
    private String permissionCancelText = "";
    //确定按钮的文字
    private String permissionSureText = "";

    private int requestCode = 666;

    //再次请求权限的标题
    private String againPermissionTitle = "";
    //再次请求权限的文字说明
    private String againPermissionMessage = "";
    //取消按钮的文字
    private String againPermissionCancelText = "";
    //确定按钮的文字
    private String againPermissionSureText = "";


    public String getPermissionTitle() {
        return permissionTitle;
    }

    public void setPermissionTitle(String permissionTitle) {
        this.permissionTitle = permissionTitle;
    }



    public String[] getPermissionArr() {
        return permissionArr;
    }

    public void setPermissionArr(String[] permissionArr) {
        this.permissionArr = permissionArr;
    }

    public String getPermissionCancelText() {
        return permissionCancelText;
    }

    public void setPermissionCancelText(String permissionCancelText) {
        this.permissionCancelText = permissionCancelText;
    }

    public String getPermissionSureText() {
        return permissionSureText;
    }

    public void setPermissionSureText(String permissionSureText) {
        this.permissionSureText = permissionSureText;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public String getAgainPermissionTitle() {
        return againPermissionTitle;
    }

    public void setAginPermissionTitle(String aginPermissionTitle) {
        this.againPermissionTitle = aginPermissionTitle;
    }



    public String getAgainPermissionCancelText() {
        return againPermissionCancelText;
    }

    public void setAginPermissionCancelText(String aginPermissionCancelText) {
        this.againPermissionCancelText = aginPermissionCancelText;
    }

    public String getAginPermissionSureText() {
        return againPermissionSureText;
    }

    public void setAginPermissionSureText(String aginPermissionSureText) {
        this.againPermissionSureText = aginPermissionSureText;
    }

    public String getPermissionMessage() {
        return permissionMessage;
    }

    public void setPermissionMessage(String permissionMessage) {
        this.permissionMessage = permissionMessage;
    }

    public String getAginPermissionMessage() {
        return againPermissionMessage;
    }

    public void setAginPermissionMessage(String aginPermissionMessage) {
        this.againPermissionMessage = aginPermissionMessage;
    }

    @Override
    public String toString() {
        return "RequestPermissionInfo{" +
                "permissionTitle='" + permissionTitle + '\'' +
                ", permissionMessage='" + permissionMessage + '\'' +
                ", permissionArr=" + Arrays.toString(permissionArr) +
                ", permissionCancelText='" + permissionCancelText + '\'' +
                ", permissionSureText='" + permissionSureText + '\'' +
                ", requestCode=" + requestCode +
                ", againPermissionTitle='" + againPermissionTitle + '\'' +
                ", againPermissionMessage='" + againPermissionMessage + '\'' +
                ", againPermissionCancelText='" + againPermissionCancelText + '\'' +
                ", againPermissionSureText='" + againPermissionSureText + '\'' +
                '}';
    }
}
