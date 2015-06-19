package org.sfbtmc.activity;

import java.io.File;

import org.apache.http.Header;
import org.sfbtmc.R;
import org.sfbtmc.util.TmcLogUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

public class NewVerDownloadActivity extends Activity implements OnClickListener {
	public static final String KEY_DOWN_URL = "downloadUrl";
	private ProgressBar downProgressBar;
	String downUrl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_new_ver_donwlaod);

		downProgressBar = (ProgressBar) findViewById(R.id.activity_new_ver_down_progressbar);

		downUrl = getIntent().getStringExtra(KEY_DOWN_URL);
		
		if(TextUtils.isEmpty(downUrl)){
			toLoginActivity();
		}
		startDownlaod(downUrl);
	}

	public static final void startDownload(Context ctx, String downloadUrl) {
		Intent in = new Intent(ctx, NewVerDownloadActivity.class);
		in.putExtra(KEY_DOWN_URL, downloadUrl);
		ctx.startActivity(in);
	}

	private void openFile(File file) {
		TmcLogUtils.e("OpenFile", file.getName());
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(android.content.Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file),
				"application/vnd.android.package-archive");
		startActivity(intent);
		
		this.finish();
	}
	
	private void updateProgressBar(long bytesWritten, long totalSize){
		downProgressBar.setProgress((int) (bytesWritten *100 / totalSize));
	}

	private void startDownlaod(String url) {
		String fileName = url.substring(url.lastIndexOf("/") + 1);

		AsyncHttpClient client = new AsyncHttpClient();
		File downloadDir = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		File apkFile = new File(downloadDir.getAbsolutePath(), fileName);

		client.post(url, new FileAsyncHttpResponseHandler(apkFile, false) {
			
			@Override
			public void onProgress(long bytesWritten, long totalSize) {
				super.onProgress(bytesWritten, totalSize);
				updateProgressBar(bytesWritten, totalSize);
			}

			@Override
			public void onFailure(int arg0, Header[] arg1, Throwable arg2,
					File arg3) {
				showDownFailDialog();
			}

			@Override
			public void onSuccess(int arg0, Header[] arg1, File arg2) {
				openFile(arg2);
			}

		});

	}
	
	private void toLoginActivity() {
		 Intent in = new Intent(this, LoginActivity.class);
		 startActivity(in);
		 this.finish();
	}

	private void retryDownload(){
		downProgressBar.setProgress(0);
		startDownlaod(downUrl);
	}
	
	private void showDownFailDialog(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Sorry")
		.setMessage("Download Failed, check your network and try again.")
		.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				toLoginActivity();
			}
		})
		.setPositiveButton("Retry", new  DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				retryDownload();
			}
		});
		builder.create().show();
		
		
		
	}

	@Override
	public void onBackPressed() {
		// super.onBackPressed();

	}

	@Override
	public void onClick(View arg0) {
		int i = arg0.getId();
	}
}
