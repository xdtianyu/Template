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
- [x] gitlab ci

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

2\. github ci 需要配置 `Secret variables`

| 环境变量              | 说明                        |
| ----------------- | ------------------------- |
| ALIAS             | release.jks 别名            |
| ALIAS_PASSWORD    | release.jks 别名密码          |
| API_KEY           | 可选，注册在 Manifest 的 APK_KEY |
| KEYSTORE_PASSWORD | release.jks 密码            |
| encrypted_iv      | release.jks.enc 解密 iv     |
| encrypted_key     | release.jks.enc 解密 key    |

要配置 gitlab 自动编译签名支持，需要将 `release.jks` 文件加密为 `release.jks.enc`

**通过一个密文生成 iv 和 key**

替换 `I_AM_PUBLIC_AND_NOT_USED_FOR_RELEASE` 为任意字符串，建议30位以上随机字符串

```shell
openssl enc -nosalt -aes-256-cbc -pass pass:I_AM_PUBLIC_AND_NOT_USED_FOR_RELEASE -P
```

```shell
key=12CF1B5E0D192628AA922230549EEDFD889E6CF7463933C6DABD9A1300FCA23D
iv =66813CF28D04CD129D57436B78DECBA4
```

**使用生成的 key 和 iv 加密 release.jks 文件**

注意替换其中的 key 和 iv 值 

```
openssl aes-256-cbc -K 12CF1B5E0D192628AA922230549EEDFD889E6CF7463933C6DABD9A1300FCA23D -iv 66813CF28D04CD129D57436B78DECBA4 -in release.jks -out release.jks.enc -e
```

将 `release.jks.enc` 文件提交到代码仓库，同时配置 gitlab `Secret variables`  中的环境变量。