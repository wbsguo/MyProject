package com.example.myproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.myproject.utils.ActivitysUtils;

public class BaseOnBackActivity extends BaseActivity{
	@Override
	public void onBackPressed() {
		exitdialog();
    }
	public void exitdialog(){
		twoBtnDialognotitle(this,
				getResources().getString(R.string.cancel),
				getResources().getString(R.string.confrim),
				getResources().getString(R.string.exitmessage),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog,
										int which) {
						dialog.dismiss();
					}
				}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog,
										int which) {
						dialog.dismiss();
						ActivitysUtils.getInstance().destory();
					}
				}).show();
	}
	public Dialog twoBtnDialognotitle(Context context, String btnText01, String btnText02,
									  String message, DialogInterface.OnClickListener listener01, DialogInterface.OnClickListener listener02) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(message);
		builder.setPositiveButton(btnText01, listener01);
		builder.setNeutralButton(btnText02, listener02);
		AlertDialog nInfoDlg = builder.create();
		nInfoDlg.setCanceledOnTouchOutside(false);
		return nInfoDlg;
	}
}
