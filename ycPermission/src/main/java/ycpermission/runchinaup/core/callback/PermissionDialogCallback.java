package ycpermission.runchinaup.core.callback;

public abstract class PermissionDialogCallback {

    /**
     * 关闭回调
     *
     * @param isAgainAsk 是否是第二次询问
     */
    public abstract void onCancel(boolean isAgainAsk);

    /**
     * 确认回调
     *
     * @param isAgainAsk 是否是第二次询问
     */
    public void onSure(boolean isAgainAsk) {
    }


}
