# JKPermissonUtil

① 继承PermissionActivity
   </br>或者添加PermissionActivity中权限部分代码到自己的activity父类中。
</br>② 添加所需权限到manifest
</br>③ 在需要判断权限的地方调用checkPermission

<code>
 checkPermission(new CheckPermListener() {
                    @Override
                    public void Granted() {
                    
                        Toast.makeText(MainActivity.this, "通过", Toast.LENGTH_SHORT).show();
                        
                    }
                    @Override
                    public void Denied() {
                    
                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                        
                        
                    }
                }, "请求获取照相机权限", Manifest.permission.CAMERA);
</code>
