### Android Studio Project Template

构建新的 Android Studio 工程，快速开始你的新 App 开发

#### 集成的模块和功能库

- [x] 一键修改包名及包路径结构
- [x] 自动签名
- [x] 版本号自动修改 (根据 git tag 及 tag 计数修改)
- [x] 模块化
- [x] 数据库ORM
- [x] 优先单实例
- [x] MVP
- [x] Dagger2
- [x] OkHttp3
- [x] retrofit2
- [x] Rxjava
- [x] requerydb
- [x] gson
- [x] glide
- [x] stetho (debug only)
- [x] jni
- [x] .gitignore
- [x] test 依赖

#### 使用
1\. 下载模板源码

```shell
git clone https://github.com/xdtianyu/template
```

2\. 更改包名

将应用包名更改为 `com.example.myapp`

```shell
./template.sh com.example.myapp
```

3\. 使用 Android Studio 打开工程，`Build->Make Project` 会提示找不到 `release.jks`

4\. 拷贝或新建 `release.jks` 文件，放置在工程根目录。按照 `signing.properties.example`  文件新建 `signing.properties` 文件并修改签名密码和别名。

5\. 再次编译及安装应用

#### 其他

1\.  `manifest.properties` 可以用来替换 `manifest` 中的 `meta-data` 数据。和 `signing.properties` 相同，在 CI 编译服务器中不存在这些属性时，`gradle` 会读取系统环境变量替换这些信息。
