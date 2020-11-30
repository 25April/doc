# 一、Http请求

#  HTTP请求的完全过程

### 1.1 浏览器根据域名解析IP地址

​    浏览器根据访问的域名找到其IP地址。DNS查找过程如下：

1. 浏览器缓存：首先搜索浏览器自身的DNS缓存（缓存的时间比较短，大概只有1分钟，且只能容纳1000条缓存），看自身的缓存中是否是有域名对应的条目，而且没有过期，如果有且没有过期则解析到此结束。
2. 系统缓存：如果浏览器自身的缓存里面没有找到对应的条目，那么浏览器会搜索操作系统自身的DNS缓存，如果找到且没有过期则停止搜索解析到此结束。
3. 路由器缓存：如果系统缓存也没有找到，则会向路由器发送查询请求。
4. ISP（互联网服务提供商） DNS缓存：如果在路由缓存也没找到，最后要查的就是ISP缓存DNS的服务器。

### 1.2 浏览器与WEB服务器建立一个TCP连接

​    TCP的3次握手。

### 1.3 浏览器给WEB服务器发送一个HTTP请求

​    一个HTTP请求报文由请求行（request line）、请求头部（headers）、空行（blank line）和请求数据（request body）4个部分组成。

![img](https://img-blog.csdnimg.cn/20190527111928530.png)



**1.3.1 请求行**

​    请求行分为三个部分：请求方法、请求地址URL和HTTP协议版本，它们之间用空格分割。例如，GET /index.html HTTP/1.1。

**1.请求方法**

​    HTTP/1.1 定义的请求方法有8种：GET（完整请求一个资源）、POST（提交表单）、PUT（上传文件）、DELETE（删除）、PATCH、HEAD（仅请求响应首部）、OPTIONS（返回请求的资源所支持的方法）、TRACE（追求一个资源请求中间所经过的代理）。最常的两种GET和POST，如果是RESTful接口的话一般会用到GET、POST、DELETE、PUT。

**（1）GET**

​    当客户端要从服务器中读取文档时，当点击网页上的链接或者通过在浏览器的地址栏输入网址来浏览网页的，使用的都是GET方式。GET方法要求服务器将URL定位的资源放在响应报文的数据部分，会送给客户端。使用GET方法时，请求参数和对应的值附加在URL后面，利用一个问号‘？’代表URL的结尾与请求参数的开始，传递参数长度受限制。例如，/index.jsp?id=100&op=bind。通过GET方式传递的数据直接放在地址中，所以GET方式的请求一般不包含“请求内容”部分，请求数据以地址的形式表现在请求行。地址中‘？’之后的部分就是通过GET发送的请求数据，各个数据之间用‘&’符号隔开。显然这种方式不适合传送私密数据。另外，由于不同的浏览器对地址的字符限制也有所不同，一半最多只能识别1024个字符，所以如果需要传送大量数据的时候，也不适合使用GET方式。如果数据是英文字母/数字，原样发送；如果是空格，转换为+；如果是中文/其他字符，则直接把字符串用BASE64加密，得出：%E4%BD%A0%E5%A5%BD，其中%XX中的XX为该符号以16进制表示的ASCII。

**（2）POST**

​    允许客户端给服务器提供信息较多。POST方法将请求参数封装在HTTP请求数据中，以名称/值的形式出现，可以传输大量数据，这样POST方式对传送的数据大小没有限制，而且也不会显示在URL中。POST方式请求行中不包含数据字符串，这些数据保存在“请求内容”部分，各数据之间也是使用‘&’符号隔开。POST方式大多用于页面的表单中。因为POST也能完成GET的功能，因此多数人在设计表单的时候一律都使用POST方式，其实这是一个误区。GET方式也有自己的特点和优势，我们应该根据不同的情况来选择是使用GET还是使用POST。

![img](https://img-blog.csdnimg.cn/20190527112007870.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2FpbHVubGVl,size_16,color_FFFFFF,t_70)



**2.URL**

​    URL：统一资源定位符，是一种资源位置的抽象唯一识别方法。

​    组成：<协议>://<主机>:<端口>/<路径>

​    端口和路径有事可以省略（HTTP默认端口号是80）

![img](https://img-blog.csdnimg.cn/20190527112032864.png)



**3.协议版本**

​    协议版本的格式为：HTTP/主版本号.次版本号，常用的有HTTP/1.0和HTTP/1.1

**1.3.2 请求头部**

​    请求头部为请求报文添加了一些附加信息，由“名/值”对组成，每行一对，名和值之间使用冒号分隔。

​    请求头部的最后会有一个空行，表示请求头部结束，接下来为请求数据。

![img](https://img-blog.csdnimg.cn/2019052711205938.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2FpbHVubGVl,size_16,color_FFFFFF,t_70)



**1.3.3 请求数据**

​    请求数据不在GET方法中使用，而在POST方法中使用。POST方法适用于需要客户填写表单的场合。与请求数据相关的最长使用的请求头部是Cntent-Type和Content-Length。下面是一个POST方法的请求报文：

POST 　/index.php　HTTP/1.1 　　 请求行

Host: localhost

User-Agent: Mozilla/5.0 (Windows NT 5.1; rv:10.0.2) Gecko/20100101 Firefox/10.0.2　　请求头

Accept: text/html,application/xhtml+xml,application/xml;q=0.9,/;q=0.8

Accept-Language: zh-cn,zh;q=0.5

Accept-Encoding: gzip, deflate

Connection: keep-alive

Referer: http://localhost/

Content-Length：25

Content-Type：application/x-www-form-urlencoded

　　空行

username=aa&password=1234　　请求数据

### 1.4 服务器端响应HTTP请求，浏览器得到HTML代码

​    HTTP响应报文由状态行（status line）、相应头部（headers）、空行（blank line）和响应数据（response body）4个部分组成。

![img](https://img-blog.csdnimg.cn/2019052711212421.png)



**1.4.1 状态行**

​    状态行由3部分组成，分别为：协议版本、状态码、状态码扫描。其中协议版本与请求报文一致，状态码描述是对状态码的简单描述。

![img](https://img-blog.csdnimg.cn/20190527112145931.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2FpbHVubGVl,size_16,color_FFFFFF,t_70)



**1.4.2 响应头部**

![img](https://img-blog.csdnimg.cn/20190527112207584.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2FpbHVubGVl,size_16,color_FFFFFF,t_70)



**1.4.3 响应数据**

​    用于存放需要返回给客户端的数据信息。

HTTP/1.1 200 OK　　状态行

Date: Sun, 17 Mar 2013 08:12:54 GMT　　响应头部

Server: Apache/2.2.8 (Win32) PHP/5.2.5

X-Powered-By: PHP/5.2.5

Set-Cookie: PHPSESSID=c0huq7pdkmm5gg6osoe3mgjmm3; path=/

Expires: Thu, 19 Nov 1981 08:52:00 GMT

Cache-Control: no-store, no-cache, must-revalidate, post-check=0, pre-check=0

Pragma: no-cache

Content-Length: 4393

Keep-Alive: timeout=5, max=100

Connection: Keep-Alive

Content-Type: text/html; charset=utf-8

　　空行

 

><html>　　响应数据
>
><head>
>
></head>
>
><body>
>
>Hello HTTP!
>
></body>
>
></html>

### 1.5 浏览器解析HTML代码，并请求HTML代码中的资源

​    浏览器拿到HTML文件后，开始解析HTML代码，遇到静态资源时，就向服务器端去请求下载。

### 1.6 关闭TCP连接，浏览器对页面进行渲染呈现给用户

​    浏览器利用自己内部的工作机制，把请求到的静态资源和HTML代码进行渲染，呈现给用户。

## 二、Spring 基于http协议的注解

## **1.@RequestBody不能使用多次(且不能接受表单数据)**

> 原因很简单:
>
> 一个request 中只有一个请求体
>
> @RequestBody 从请求体中拿数据  只能接受 contentType为 application/json;...
>
> 用String接受的是json字符串  Object,Map接受得是一个LinkedHashMap
>
> **(且不能接受表单数据)**
>
> @RequestBody不支持该媒体类型    无法将（name1=value1&name2=value2…）转换为对象 
>
> ```java
> 2020-09-27 15:19:05.874  WARN 26344 --- [nio-8080-exec-2] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported]
> ```
>
>  
>
> **@RequestBody 用String 倒是可以接收www-form-urlencoded**
>
> *@RequestBody*
>
> 1、该注解常用来处理Content-Type:不是`application/x-www-form-urlencoded`编码的内容，例如application/json, application/xml等
>
> 2、它是通过使用HandlerAdapter 配置的`HttpMessageConverters`来解析post data body，然后绑定到相应的bean上的。
>
> 3、因为配置有FormHttpMessageConverter，所以也可以用来处理 `application/x-www-form-urlencoded`的内容，处理完的结果放在一个MultiValueMap<String, String>里，这种情况在某些特殊需求下使用，详情查看FormHttpMessageConverter api;、

## **2.@RequestParam 不能注解复杂类型参数**

>**@RequestParam 处理得是请求参数中的简单类型或者是   Map**
>
>控制台打印
>
>2020-09-28 14:57:49.966  INFO 21444 --- [5)-192.168.56.1] com.alibaba.druid.pool.DruidDataSource   : {dataSource-1} inited
>java.util.LinkedHashMap
>{map=1, a=2}-----
>java.util.LinkedHashMap
>{}-----
>
>1、常用来处理简单类型的绑定，通过Request.getParameter()获取的String可以直接转换为简单类型的情况（String--> 简单类型的转换操作由ConversionService配置的转换器来完成）；因为使用request.getParameter()方式获取参数，所以可以处理get 方式中queryString的值，也可以处理post方式中 body data的值；
>
>2、用来处理Content-Type: 为 `application/x-www-form-urlencoded`编码的内容，提交方式GET、POST；
>
>3、该注解有两个属性： value、required； value用来指定要传入值的id名称，required用来指示参数是否必须绑定



### 参考

**在使用springmvc的时候，后台@RequestBody接受的是一个json格式的字符串，一定是一个字符串。** 
我们可以通过@RequestBody Map

```java
    @RequestMapping(value="/queryAccountList.do",produces="application/json;charset=UTF-8")
    @ResponseBody
    public HashMap<String, Object> queryAccountList(@RequestBody Map<String, Object> paramsMap){
        System.out.println("paramsMap="+paramsMap);
        String  channel= (String) paramsMap.get("channel");
        String function_code=(String) paramsMap.get("function_code");
        Map<String, Object> reqParam=(Map<String, Object>)paramsMap.get("data");1234567
```

当前端调用我们的接口时，传入json字符串，就转为了map对象。这里主要是@RequestBody的底层实现，我们不讨论。

**json对象和json字符串的区别：** 
var person={“name”:”zhangsan”,”sex”:”男”,”age”:”24”}//json对象 
var person=’{“name”:”zhangsan”,”sex”:”男”,”age”:”24”}’;//json字符串 
json对象转为json字符串，调用stringify方法：

```java
var person={"name":"zhangsan","sex":"男","age":"24"};//json对象
var personString = JSON.stringify(person);
alert(personString);123
```

**SpringMVC接受json字符串类型。** 
在SpringMVC中基于REST开发时，前端传入后台的应该是一个json格式的字符串，而不是一个json对象 
GET、POST方式提时， 根据request header Content-Type的值来判断: 
**application/x-www-form-urlencoded， 可选（即非必须，因为这种情况的数据@RequestParam, @ModelAttribute也可以处理，当然@RequestBody也能处理**）； 
multipart/form-data, 不能处理（即使用@RequestBody不能处理这种格式的数据）； 
其他格式， 必须（其他格式包括**application/json, application/xml等。这些格式的数据，必须使用@RequestBody来处理**）。

# HTTP中application/x-www-form-urlencode是什么？

```js
1.在学习ajax时，若用post请求，需要设置如下代码。
    ajax.setRequireHeader("content-type","application/x-www-form-urlencoded")
12
```

2.form的enctype属性为编码方式，常用有两种：application/x-www-form-urlencoded和multipart/form- data，默认为application/x-www-form-urlencoded。
在这里主要说一下默认：application/x-www-form-urlencode是是一种表单提交方式，该方式是采用urlencode的，也就是说，提交的数据都是经过加密的，服务端需要decode才能正确获得数据。
当action为get时候，浏览器用x-www-form-urlencoded的编码方式把form数据转换成一个字串（name1=value1&name2=value2…），然后把这个字串append到url后面，用?分割，加载这个新的url。

### 在普通类上定义`@PatnVariable`注解时value值可以不用声明，直接写值就好，但是在`Feign`接口下使用该注解，则需要声明value：

```java
@FeignClient(name = "TUZI")



public interface TuziClientService{



    @GetMapping("/demo/get/{id}")



    Tuzi get(@PathVariable(value="id") int id);//value需要显式声明，否则报错



}
```

 