package org.akshanshgusain.sessionmanagement;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class AlertDialogManager {

    public void showAlertDialog(Context mContext,String title,String message, Boolean status)
    {
        final AlertDialog mAlertDialog=new AlertDialog.Builder(mContext).create();
        //Title
        mAlertDialog.setTitle(title);
        //Message
        mAlertDialog.setMessage(message);

        if(status != null)
            // Setting alert dialog icon
            mAlertDialog.setIcon((status) ? R.drawable.ic_launcher_foreground : R.drawable.ic_launcher_background);

        // Setting OK Button
        mAlertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                         mAlertDialog.dismiss();
            }
        });
        mAlertDialog.show();

    }
}
