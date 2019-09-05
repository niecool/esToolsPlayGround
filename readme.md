1.guice
    
    关键原理：只使用Java泛型和注解（当然spring也支持注解），轻量级的依赖注入框架。对于很多中间件对性能是由很高要求的，所以使用spring全家桶是不合适的。
    官方文档网址：https://github.com/google/guice/wiki/Motivation

2.jersey和spring mvc对比：

    Jersey 是一个Java规范（JAX-RS）下的基于Rest风格(轻量级RESTful风格)的Web Service开发框架。
    1. jersey同样提供DI，是由glassfish hk2实现，也就是说，如果想单独使用jersey一套，需要另外学习Bean容器；
    2. MVC出发点即是WEB，但jersey出发点确实RESTFull，体现点在与接口的设计方面，如MVC返回复杂结构需要使用ModelAndView,而jersey仅仅需要返回一个流或者文件句柄；
    3. jersey提供一种子资源的概念，这也是RESTFull中提倡所有url都是资源；
    4. jersey直接提供application.wadl资源url说明；
    5. MVC提供Session等状态管理，jersey没有，这个源自RESTFull设计无状态化；
    6. Response方法支持更好返回结果，方便的返回Status，包括200，303，401，403；
    7. 提供超级特别方便的方式访问RESTFull;
    
3.rest概念：

    1、什么是REST？
    REST不是"rest"这个单词
    
    Representational State Transfer 直接翻译：表现层状态转移，
    
    找到的一种最好理解的说法是:URL定位资源，用HTTP动词GET,POST,DELETE,DETC）描述操作。
    
    Resource：资源，即数据。
    Representational：某种表现形式，比如用JSON，XML，JPEG等；
    State Transfer：状态变化。通过HTTP动词实现。
    
    1，资源：资源就是网络上的一个实体，一段文本，一张图片等。资源总是要通过一种载体来反应它的内容。文本可以用TXT，也可以用HTML或者XML、图片可以用JPG格式或者PNG格式，JSON是现在最常用的资源表现形式。
    
    2，统一接口。RESTful风格的数据元操作CRUD（create,delete,update,read）分别对应HTTP方法：GET用来获取资源，DELETE用来删除资源，这样就统一了数据操作的接口，PUT用来更新资源，POST用来新建资源（也可以用于更新资源）。
    
    3，URI。可以用一个URI（统一资源定位符）指向资源，即每个URI都对应一个特定的资源。要获取这个资源访问它的URI就可以，因此URI就成了每一个资源的地址或识别符。一般的，每个资源至少有一个URI与之对应，最典型的URI就是URL。
    
    4，无状态。所谓无状态即所有的资源都可以URI定位，而且这个定位与其他资源无关，也不会因为其他资源的变化而变化。如果输入一个URL就可以得到指定员工的工资，则这种情况就是无状态的，由一个URL与之对应可以通过HTTP动词方法得到资源，这就是典型的RESTful风格。
    
    REST原则：
    
       <1>网络上的所有事物都被抽象为资源
    
       <2> 每个资源都有一个唯一的资源标识符
    
       <3> 同一个资源具有多种表现形式(xml,json等)
    
       <4>  对资源的各种操作不会改变资源标识符
    
       <5> 所有的操作都是无状态的
    
4.什么是Restful?
    restful: 遵守了rest原则的web服务
    
    理解：rest与restful相比，多了一个ful,就英语层面来说是一个形容词，restful翻译为中文为： “rest式的”
    
    是rest式的什么呢？答案是:rest式的应用，rest风格的web服务也是rest式的应用，rest式的web服务是一种ROA(TheResource-Oriented Architecture)(面向资源的架构)，ROA听起来很高大上有没有。。
    
    两者的联系与区别
    restful是由rest派生出来的。
    
    restful用法：
    在Restful之前的操作：
    http://127.0.0.1/user/query/1 GET  根据用户id查询用户数据
    http://127.0.0.1/user/save POST 新增用户
    http://127.0.0.1/user/update POST 修改用户信息
    http://127.0.0.1/user/delete GET/POST 删除用户信息
    
    RESTful用法：
    http://127.0.0.1/user/1 GET  根据用户id查询用户数据
    http://127.0.0.1/user  POST 新增用户
    http://127.0.0.1/user  PUT 修改用户信息
    http://127.0.0.1/user  DELETE 删除用户信息
    
    之前的操作是没有问题的,大神认为是有问题的,有什么问题呢?你每次请求的接口或者地址,都在做描述,例如查询的时候用了query,新增的时候用了save,其实完全没有这个必要,我使用了get请求,就是查询.使用post请求,就是新增的请求,我的意图很明显,完全没有必要做描述,这就是为什么有了restful.   
    
    符合REST架构设计的API是RESTful API.
    
    资源类上的常用注解有：
    @Path，标注资源类或者方法的相对路径
    @GET，@PUT，@POST，@DELETE，标注方法是HTTP请求的类型。
    @Produces，标注返回的MIME媒体类型
    @Consumes，标注可接受请求的MIME媒体类型
    @PathParam，@QueryParam，@HeaderParam，@CookieParam，@MatrixParam，@FormParam
    
    分别标注方法的参数来自于HTTP请求的不同位置，例如
    @PathParam来自于URL的路径，
    @QueryParam来自于URL的查询参数，
    @HeaderParam来自于HTTP请求的头信息，
    @CookieParam来自于HTTP请求的Cookie。
    
    
5.HPPC:高性能集合工具包(High Performance Primitive Collections for Java)

    关键原理是：存储基本类型而不将它们作为对象装箱。这样可以提高内存利用率并提高性能。
    官方文档网址：https://github.com/carrotsearch/hppc/wiki
