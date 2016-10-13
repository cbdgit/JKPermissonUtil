package com.example.jinkai.jkpermissonutil;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private Button btnPreSingle, btnPreMulti;

    public MainActivityFragment() {
    }

    View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main, container, false);
        btnPreSingle = (Button) mRootView.findViewById(R.id.btn_per_single);
        btnPreMulti = (Button) mRootView.findViewById(R.id.btn_pre_multi);
        btnPreSingle.setOnClickListener(this);
        btnPreMulti.setOnClickListener(this);
        return mRootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_per_single:
                ((PermissionActivity) getActivity()).checkPermission(new PermissionActivity.CheckPermListener() {
                    @Override
                    public void Granted() {
                        Toast.makeText(getContext(), "通过", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void Denied() {
                        Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
                        //检查是否选择了不再提醒
                    }
                }, "请求获取照相机权限", Manifest.permission.CAMERA);
                break;
            case R.id.btn_pre_multi:
                ((PermissionActivity) getActivity()).checkPermission(new PermissionActivity.CheckPermListener() {
                    @Override
                    public void Granted() {
                        Toast.makeText(getContext(), "通过", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void Denied() {
                        Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
                        //如果选择不在提示
                    }
                }, "请求获取照相机和读取文件权限", Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                break;
        }
    }
}
