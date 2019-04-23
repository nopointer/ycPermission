package lib.ycPermission;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.google.gson.Gson;

import java.util.List;

import lib.ycPermission.base.BasePermissionCheckActivity;
import simaple.ycPermission.R;
import ycpermission.runchinaup.core.RequestPermissionInfo;
import ycpermission.runchinaup.log.ycPerLog;


public class MainActivity extends BasePermissionCheckActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int loadLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initView() {
        super.initView();
    }

    @Override
    protected RequestPermissionInfo loadPermissionsConfig() {
        RequestPermissionInfo requestPermissionInfo = new RequestPermissionInfo();
        requestPermissionInfo.setPermissionMessage("请授权这些权限");
        requestPermissionInfo.setPermissionCancelText("取消");
        requestPermissionInfo.setPermissionSureText("确定");
        requestPermissionInfo.setAginPermissionMessage("需要授权啊");
        requestPermissionInfo.setAginPermissionTitle("11");
        requestPermissionInfo.setAginPermissionCancelText("取消");
        requestPermissionInfo.setAginPermissionSureText("确定");

        requestPermissionInfo.setPermissionArr(new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.READ_SMS,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE});
        return requestPermissionInfo;
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        super.onPermissionsGranted(requestCode, perms);
        ycPerLog.e("获取到了部分的权限" + new Gson().toJson(perms));
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        super.onPermissionsDenied(requestCode, perms);
        ycPerLog.e("拒绝了部分的权限" + new Gson().toJson(perms));
    }

    @Override
    public void onGetAllPermission() {
        super.onGetAllPermission();
        ycPerLog.e("获取到了所有的权限");
    }
}
