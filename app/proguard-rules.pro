# 方法名等混淆指定配置
-obfuscationdictionary ../proguard-dict1.txt
# 类名混淆指定配置
-classobfuscationdictionary ../proguard-dict1.txt
# 包名混淆指定配置
-packageobfuscationdictionary ../proguard-dict1.txt

# 强制混淆 MainActivity 类
-keep, allowobfuscation class com.example.testproject.MainActivity

