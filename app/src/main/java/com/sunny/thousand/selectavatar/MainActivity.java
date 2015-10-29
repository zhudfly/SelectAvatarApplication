package com.sunny.thousand.selectavatar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    private AvatarImageView avatarImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        avatarImageView = (AvatarImageView) findViewById(R.id.avatarIv);
//        avatarImageView.setDialogBackgroundColor("#00AAAA"); //设置对话框的背景色
//        avatarImageView.setBtnClickedColor("#00AAAA"); //设置按钮点击后的颜色

//        avatarImageView.setAnimResId(R.style.avatar_dialog_animation); //设置dialog显示的动画
//        avatarImageView.setTitleColor("#FFEEAA");  //设置标题的颜色
//        avatarImageView.setBtnBackgroundColor("#FFEEAA"); //设置按钮的背景色
//        avatarImageView.setTitleLineColor("#FFEEAA"); //设置标题下的分割线的颜色
//        avatarImageView.setLineColor("#FFEEAA"); //设置按钮之间的分割线的颜色
//        avatarImageView.setTitlePaddingTopBottom(30); //设置标题的padding
//        avatarImageView.setBtnPaddingTopBottom(30); //设置按钮的padding
//        avatarImageView.setTitleText("testTitle"); //设置标题的文字
//        avatarImageView.setPhotoButtonText("testPhotoText"); //设置拍照按钮的文字
//        avatarImageView.setChoosePicButtonText("testChooseText"); //设置选择照片的文字
//        avatarImageView.setDialogCorner(20); //设置dialog的角度
//        avatarImageView.setBtnTextColor("#FFEEAA"); //设置按钮文本的颜色
//        avatarImageView.setTitleTextSize(30); //设置标题的文字大小
//        avatarImageView.setBtnTextSize(30); //设置按钮的文字大小

        avatarImageView.setAfterCropListener(new AvatarImageView.AfterCropListener() {
            @Override
            public void afterCrop(Bitmap photo) {
                Toast.makeText(MainActivity.this,"设置新的头像成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //在拍照、选取照片、裁剪Activity结束后，调用的方法
        if(avatarImageView != null){
            avatarImageView.onActivityResult(requestCode,resultCode,data);
        }
    }
}
