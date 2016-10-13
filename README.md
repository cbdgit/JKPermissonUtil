# JKPermissonUtil

① 继承PermissionActivity
   或者添加PermissionActivity中权限部分代码到自己的activity父类中。
② 添加所需权限到manifest
③ 在需要判断权限的地方调用checkPermission

<code>
 checkPermission(new CheckPermListener() {<br>
                    @Override<br>
                    public void Granted() {<br>
                        Toast.makeText(MainActivity.this, "通过", Toast.LENGTH_SHORT).show();<br>
                    }<br>
                    @Override<br>
                    public void Denied() {<br>
                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();<br>
                    }<br>
                }, "请求获取照相机权限", Manifest.permission.CAMERA);
</code>
