package lib.ycPermission.base;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.List;

import ycpermission.runchinaup.core.RequestPermissionInfo;
import ycpermission.runchinaup.core.YCPermissionRequester;
import ycpermission.runchinaup.core.callback.PermissionCallback;
import ycpermission.runchinaup.log.ycPerLog;


/**
 * Created by nopointer on 2018/9/1.
 * 权限检测器
 */

public abstract class BasePermissionCheckFragment extends BaseFragment implements PermissionCallback {

    private YCPermissionRequester ycPermissionRequester = null;

    public void requestPermission(RequestPermissionInfo requestPermissionInfo) {

        if (requestPermissionInfo == null) {
            ycPerLog.e("权限列表为空，不请求");
            return;
        }
        if (ycPermissionRequester == null) {
            ycPermissionRequester = new YCPermissionRequester(requestPermissionInfo);
        }
        ycPermissionRequester.requestPermission(this, this);
    }


    @Override
    protected void initView() {
        requestPermission(loadPermissionsConfig());
    }


    protected RequestPermissionInfo loadPermissionsConfig() {
        return null;
    }

    /**
     * 用户权限处理,
     * 如果全部获取, 则直接过.
     * 如果权限缺失, 则提示Dialog.
     *
     * @param requestCode  请求码
     * @param permissions  权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        ycPermissionRequester.onRequestPermissionsResult(this, requestCode, permissions, grantResults, this);
    }


    @Override
    public void onGetAllPermission() {
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        RequestPermissionInfo requestPermissionInfo = ycPermissionRequester.getPermissionInfo();
        if (requestPermissionInfo != null && !TextUtils.isEmpty(requestPermissionInfo.getAginPermissionMessage())) {
            ycPermissionRequester.checkDeniedPermissionsNeverAskAgain(this, perms);
        }
    }
}
