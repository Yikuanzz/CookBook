appId:1689655

appKey:a378db02CD0146229F24680C3f4a0ef6



菜谱 App 设计与实现

ViewPager 控件制作菜谱 App 引导界面

OkHttp GSON 解析 API

RecycleView 控件将菜谱分类和菜谱列表展现

SQLite 数据库进行菜谱数据的收藏



## 1.引导界面设置

创建 Android 工程 Cookbook

res 目录下创建 layout 并新建 activity_main.xml 文件，代码如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">
</LinearLayout>
```



然后再添加：

* ViewPage 控件设置权重为 1
* View 控件用来分隔空白
* 横向排列的线性布局，放置底部导航栏 RadioGroup 和 RadioButton



图标放在 drawable 下，新建 a.xml b.xml c.xml

按钮设计通过 android:state_checked 选择器指定按下的图标和没按下的图标状态：

* home
* collection
* personalcenter



```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/homepage" android:state_checked="false"/>
    <item android:drawable="@drawable/homepage2" android:state_checked="true"/>
</selector>
```



```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/collection" android:state_checked="false"/>
    <item android:drawable="@drawable/collection2" android:state_checked="true"/>
</selector>
```



```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/personalcenter" android:state_checked="false"/>
    <item android:drawable="@drawable/personalcenter2" android:state_checked="true"/>
</selector>
```



接下来实现逻辑代码，在 MainActivity 中创建对应的控件



```java
public class MyFragmentAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragmentList2;
    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList2){
        super(fm);
        this.fagmentList2 = fagmentList2;
    }
    
    public Fragment getItem(int i){
        return fragmentList2.get(i);
    }
    
    public int getCount(){
        return fragmentList2.size();
    }
}
```









