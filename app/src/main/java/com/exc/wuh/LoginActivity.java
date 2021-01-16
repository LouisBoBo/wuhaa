package com.exc.wuh;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import com.badoo.mobile.util.WeakHandler;
import com.exc.api.CommonMessage;
import com.exc.api.bizimpl.WHImpl;
import com.exc.api.vo.BaseVo;
import com.exc.api.vo.PartitionQueryVo;
import com.exc.api.vo.UserLoginVo;
import com.exc.utils.CommonParameter;
import com.exc.utils.MD5Util;
import com.exc.utils.ToastUtils;
import com.exc.utils.UserInfoUtil;
import com.exc.wuh.view.CustomDialog;
import com.exc.wuh.view.VerifyCode;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private WHImpl whBiz;
    private BaseVo<UserLoginVo> mUserVo;
    private View loginbutton;
    private EditText usernameEdit;
    private EditText passwordEdit;
    private EditText codeEdit;
    private ImageView scanImage;
    private ImageView smallimge;
    private VerifyCode codeimage;
    private boolean bukejian;
    private CustomDialog customDialog;

    private WeakHandler mHandler = new WeakHandler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            customDialog.dismiss();
            switch (msg.what) {
                case CommonMessage.MSG_REQUEST_SUCCESS_2:
                    try {
                        mUserVo = (BaseVo<UserLoginVo>) msg.obj;

                        if (mUserVo!=null && mUserVo.getData()!=null){
                            UserInfoUtil.saveUserInfo(LoginActivity.this,mUserVo.getData().getToken());
                        }

                        loginSuccess();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_FAILURE_2:

                    ToastUtils.showToast(LoginActivity.this, R.string.common_web_response_failed, false);
                    break;
                default:
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        whBiz = WHImpl.getInstance();
        bukejian = true;

        initLoginView();
    }

    public void initLoginView(){

        usernameEdit = findViewById(R.id.usernameEdit);
        passwordEdit = findViewById(R.id.passwrordEdit);
        codeEdit = findViewById(R.id.codeEdit);
        loginbutton = findViewById(R.id.loginbutton);
        scanImage = findViewById(R.id.scanImageview);
        smallimge = findViewById(R.id.smallimg);
        codeimage = findViewById(R.id.codeimage);
        scanImage.setImageResource(R.mipmap.unscan);
        smallimge.setImageResource(R.mipmap.group3);

        customDialog= new CustomDialog(this);

        setEditTextHintWithSize(usernameEdit,"请输入账号",16);
        setEditTextHintWithSize(passwordEdit,"请输入密码",16);
        setEditTextHintWithSize(codeEdit,"请输入验证码",16);

        codeimage.getBackground();
        passwordEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());

        //登录按钮点击事件
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usernameEdit.getText().toString().length() == 0)
                {
                    ToastUtils.showToast(LoginActivity.this,"请输入账号",false);
                    return;
                }
                if(passwordEdit.getText().toString().length() == 0){
                    ToastUtils.showToast(LoginActivity.this,"请输入密码",false);
                    return;
                }
                if(codeEdit.getText().toString().length() == 0){
                    ToastUtils.showToast(LoginActivity.this,"请输入验证码",false);
                    return;
                }


                if(!codeimage.isEqualsIgnoreCase(codeEdit.getText().toString())){
                    ToastUtils.showToast(LoginActivity.this,"请输入正确的验证码",false);
                    return;
                }
                userloginHttp(usernameEdit.getText().toString(),passwordEdit.getText().toString(),codeEdit.getText().toString());
            }
        });
        //密码可见不可见
        scanImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukejian = !bukejian;
                scanImage.setImageResource(bukejian?R.mipmap.unscan:R.mipmap.scan);
                passwordEdit.setTransformationMethod(bukejian?PasswordTransformationMethod.getInstance():HideReturnsTransformationMethod.getInstance());
            }
        });

        //测试用
//        Intent intent = new Intent(LoginActivity.this,MapTypeDemo.class);
//        startActivity(intent);
//        finish();
    }
    //登录请求
    private void userloginHttp(String username,String password,String code){
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("username",username);
//        hashMap.put("code",code);
        hashMap.put("password", MD5Util.computeMD5(password));
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<UserLoginVo>>() {}.getType();
        if(null != customDialog){
            customDialog.dismiss();
            customDialog= new CustomDialog(LoginActivity.this);
            customDialog.show();
        }
        whBiz.userlogin(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_2, CommonMessage.MSG_REQUEST_FAILURE_2, type);
    }

    //登录成功跳转
    public void loginSuccess(){
        Intent intent = new Intent(LoginActivity.this,MapTypeDemo.class);
        startActivity(intent);
        finish();
    }

    public static void setEditTextHintWithSize(EditText editText, String hintText, @Dimension int size) {
        if (!TextUtils.isEmpty(hintText)) {
            SpannableString ss = new SpannableString(hintText);
            //设置字体大小 true表示单位是sp
            AbsoluteSizeSpan ass = new AbsoluteSizeSpan(size, true);
            ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            editText.setHint(new SpannedString(ss));
        }
    }
    }
