package ycpermission.runchinaup.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;

import java.util.Arrays;
import java.util.List;

import ycpermission.runchinaup.core.callback.PermissionCallback;

/**
 * Created by nopointer on 2018/8/20.
 * 原驰网络权限的请求
 */

public class YCPermissionRequester extends AbsPermsRequester {

    public YCPermissionRequester(RequestPermissionInfo permissionInfo) {
        super(permissionInfo);
    }

    AlertDialog firstDialog = null;
    AlertDialog aginDialog = null;

    @Override
    protected void cfgPermissionInfoDialog(final Activity activity, final RequestPermissionInfo permissionInfo) {
        if (firstDialog == null) {
            firstDialog = new AlertDialog.Builder(activity)
                    .setPositiveButton(permissionInfo.getPermissionSureText(), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            executePermissionsRequest(activity, permissionInfo.getPermissionArr(), permissionInfo.getRequestCode());
                        }
                    })
                    .setNegativeButton(permissionInfo.getPermissionCancelText(), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            // act as if the permissions were denied
                            if (activity instanceof PermissionCallback) {
                                ((PermissionCallback) activity).onPermissionsDenied(permissionInfo.getRequestCode(), Arrays.asList(permissionInfo.getPermissionArr()));
                            }
                        }
                    }).create();
        }
        if (!TextUtils.isEmpty(permissionInfo.getPermissionTitle())) {
            firstDialog.setTitle(permissionInfo.getPermissionTitle());
        }
        if (!TextUtils.isEmpty(permissionInfo.getPermissionMessage())) {
            firstDialog.setMessage(permissionInfo.getPermissionMessage());
        }
        firstDialog.setCancelable(false);
        firstDialog.setCanceledOnTouchOutside(false);
        firstDialog.show();
    }

    @Override
    protected void cfgPermissionInfoDialogForNeverAsk(final Activity activity, final RequestPermissionInfo permissionInfo, List<String> permissionArr) {
        if (aginDialog == null) {
            aginDialog = new AlertDialog.Builder(activity)
                    .setPositiveButton(permissionInfo.getAginPermissionSureText(), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                            intent.setData(uri);
                            startAppSettingsScreen(activity, intent, permissionInfo.getRequestCode());
                        }
                    }).setNegativeButton(permissionInfo.getAgainPermissionCancelText(), null).create();
        }
        if (!TextUtils.isEmpty(permissionInfo.getAgainPermissionTitle())) {
            aginDialog.setTitle(permissionInfo.getAgainPermissionTitle());
        }
        if (!TextUtils.isEmpty(permissionInfo.getAginPermissionMessage())) {
            aginDialog.setMessage(permissionInfo.getAginPermissionMessage());
        }
        aginDialog.setCancelable(false);
        aginDialog.setCanceledOnTouchOutside(false);
        aginDialog.show();
    }

}