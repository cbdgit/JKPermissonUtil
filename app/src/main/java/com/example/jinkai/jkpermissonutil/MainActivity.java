package com.example.jinkai.jkpermissonutil;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends PermissionActivity implements View.OnClickListener {
    private Button btnPreSingle, btnPreMulti, btnFrag;
    private FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPreSingle = (Button) findViewById(R.id.btn_per_single);
        btnPreMulti = (Button) findViewById(R.id.btn_pre_multi);
        btnFrag = (Button) findViewById(R.id.btn_fragment);
        fl = (FrameLayout) findViewById(R.id.fragment);

        btnPreSingle.setOnClickListener(this);
        btnPreMulti.setOnClickListener(this);
        btnFrag.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_per_single:
                checkPermission(new CheckPermListener() {
                    @Override
                    public void Granted() {
                        Toast.makeText(MainActivity.this, "通过", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void Denied() {
                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                        //检查是否选择了不再提醒
                    }
                }, "请求获取照相机权限", Manifest.permission.CAMERA);
                break;
            case R.id.btn_pre_multi:
                checkPermission(new CheckPermListener() {
                    @Override
                    public void Granted() {
                        Toast.makeText(MainActivity.this, "通过", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void Denied() {
                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                        //如果选择不在提示
                    }
                }, "请求获取照相机和读取文件权限", Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                break;
            case R.id.btn_fragment:
                fl.removeAllViews();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new MainActivityFragment()).commit();
                break;
        }
    }
}
