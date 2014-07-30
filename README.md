#Selenium使用selenium-spoon-plugin样例工程#
=====================

使用方式：  
在你的selenium项目的pom中添加下面的依赖：   

		<dependency>
        	<groupId>com.yeetrack.selenium</groupId>
        	<artifactId>spoon</artifactId>
        	<version>1.0</version>
    	</dependency>

添加plugin：  

		<plugin>
            <groupId>com.yeetrack.selenium</groupId>
            <artifactId>spoon</artifactId>
            <version>1.0</version>
            <executions>
                <execution>
                    <id>spoon report</id>
                    <phase>post-integration-test</phase>
                    <goals>
                        <goal>spoon</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>

注意：如果在maven repo仓库中找不到selenium-spoon的包，可以将selenium-spoon的包安装到本地maven仓库里，方法是：  

+ 下载插件源码，github地址： [https://github.com/yeetrack/selenium-spoon-plugin](https://github.com/yeetrack/selenium-spoon-plugin)
+ 在插件项目跟路径执行 `mvn clean install`

在截图时，不要再使用selenium提供的方法，要使用插件提供的方法：   

	DriverCapture.snapShot("这里输入图片描述", driver);

插件使用log4j日志框架，已经添加了log4j的包，这里直接使用即可。  

	Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	logger.info("info");
	logger.debug("debug");
	logger.error("error");

执行：

	mvn clean install

截图存放路径：**target/screenshots**  
html报告路径： **target/screenshotResult/report**

