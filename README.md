JDK 版本：
==============
Sun JDK1.7

JUnit版本：
==============
junit-4.10.jar

解题思路（IMPORTANT！！）
==============
因为参加过TW的两三次Openday，所以对相应的业务场景比较熟悉，选择了这道题。刚读懂题时，对里面的逻辑实体除了Talk，Session，Conference一眼能看出来之外，其他的业务的思路还是比较混乱的，尤其是对每个Session的时间处理上，相减，比较，循环找出能放进session的talk等等，看似很小的一个app其实对细节的要求很高，一旦在初期设计上不注意字段的类型的选用，因为一个细节推倒重来的可能型很大。

这道题的关键是对lunch和networking这两个特殊业务的处理，在最开始的设计中，只有简单的morningSession和afternoonSession，在后面的输出中，发现lunch和networking无法作为一个特殊的talk（最开始的设想是把他俩当成特殊的talk最后放进去）放在session中，但是偶然发现这两个特殊的业务其实可以作为两个特殊的session存在，也就是一个track有四个session，只不过这两个特殊的session没有talklist，在toString时需要作特殊处理（但是这个特殊处理比当做talk做处理要简单的多）。但是这样的设计也有缺陷，就是在题中的需求说，networking的开始不早于16点，不晚于17点，而当做session处理的话，需要对session的开始时间卡死，不够灵活。

另外一点就是，在schedule时要注意，最好将所有的talk按照持续时间，从大到小排序，这样schedule出来的时间表更加合理一些。（当然不排除有更好的算法，时间紧迫，暂且先满足基本需求）

代码结构介绍
==============
src/com/tony/app/ConferenceCreation.java:整个应用的入口类，入口main方法

src/com/tony/biz/ 业务处理包

    TrackBizService.java:Track实体的业务操作类，用于传入talk的list集合，来组装track
    
    TalkBizService.java :Talk的业务操作类，用于从配置文件组装talk，返回Talk的List以及impl包下的两个实现类

src/com/tony/config:用于存放原始的talk配置文件

src/com/tony/entity:实体包

    Conference.java：活动类（这个app中业务实体中逻辑最高层）

    Track.java:介于Conference和Session之间的业务实体，(可以近似理解为一个Track就是一天的内容)

    Session.java: 整个app中第二小的逻辑实体，一个session包含一组talk(最小的逻辑实体,One-To-Many)

    SessionType.java:被包含在session中，两者是One-To-One的对应关系

    Talk.java : app中最小的逻辑实体，被包含在session中，一个session包含一组talk

src/com/tony/util:通用包
    
    Tool.java:工具类。
        包含字符串转换Talk实体的方法，整个app实现schedule的核心方法和给每一个新的Track实体准备所包含的sessionList的方法

src/test/com/tony/biz:源码中biz包下的方法的测试。

src/test/com/tony/util:源码中Tool.java的方法测试



RUN THIS APP（这里只介绍大体过程）
=====================
新建项目---------将src文件夹粘贴到项目目录下---------进入IDE，在src/com/tony/app/ConferenceCreation.java文件中，右键,点击“Run ConferenceCreation's main()”----------之后查看控制台的输出。
（如果需要测试src/test下的包下的测试类，请自行将Junit-4.10.jar添加到项目的引用中，然后在每个测试类里，右键，点击“Run xxx's xxxx”）

