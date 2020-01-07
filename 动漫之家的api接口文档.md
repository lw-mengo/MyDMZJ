[TOC]

# 动漫之家的api接口文档

**注意：对方服务器开启了图片防盗链，因此图片的url都需要加header的Referer属性**

~~Referer:'http://images.dmzj.com/'~~

`Referer:http:v3api.dmzj.com/`

### 文章推荐列表--用于banner

##### api地址

`http://v3api.dmzj.com/v3/article/recommend/header.json?timestamp=1576929059&channel=Android&_debug=0&version=2.7.023`

##### 返回数据类型：

data里是个数组，太多了所以显示部分
```json
{
  "code": 0,
  "msg": "成功",
  "data": [
    {
      "id": 2891,
      "title": "[视频]沙雕女神与慎重勇者的千层套路",
      "pic_url": "https://images.dmzj.com/news/recommend/15766630851309.jpg",
      "object_id": 65918,
      "object_url": "https://v2api.dmzj.com/article/show/v2/65918.html"
    }
  ]
}
```
### 推荐新闻接口



##### api地址
`http://v3api.dmzj.com/v3/article/list/0/2/0.json?timestamp=1576929059&channel=Android&_debug=0&version=2.7.023`
*链接的V2后面的参数依次是:
0->推荐新闻，1->动画情报,2->漫画情报，3->轻小说情报……
中间的是一个排序的参数，从1-3，默认用2就好
最后一个是page，表示页数，从0开始
*

##### 返回数据：
返回的是一个数组
```json
[
  {
    "title": "冷冷的狗粮胡乱的往脸上拍，这该死的甜美",
    "from_name": "",
    "from_url": "",
    "create_time": 1576893599,
    "is_foreign": 0,
    "foreign_url": "",
    "intro": "冬天的氛围太适合凑在暖气旁，开着暖宝捂手，披着暖融融的摊子，桌面上铺满各式各样的零食，窝在沙发上刷热剧，日剧总是带着温暖，就像是冬天里的一把火，温暖着人心，治愈着心情。",
    "author_id": 104325434,
    "status": 1,
    "row_pic_url": "https://images.dmzj.com/news/article/65954/row_5dfd795e9f998.jpg",
    "col_pic_url": "https://images.dmzj.com/news/article/65954/col_5dfd79681d3e0.jpg",
    "qchat_show": 0,
    "article_id": 65954,
    "page_url": "https://v2api.dmzj.com/article/show/v2/65954.html",
    "comment_amount": "7",
    "author_uid": 104325434,
    "cover": "https://avatar.dmzj.com/68/65/686574e990bc9c22ab4d503c5a6c7191.png",
    "nickname": "花卷儿葛格",
    "mood_amount": 6
  },
  {
    "title": "动漫之家论坛开放！完成新手报道领取网盘福利！",
    "from_name": "",
    "from_url": "",
    "create_time": 1576838346,
    "is_foreign": 0,
    "foreign_url": "",
    "intro": "随着动漫之家土豆田的反复耕耘（x）我们的应用版本也在不断更新。\r\n现在一个大家久违的功能终于恢复了，那就是动漫之家论坛！",
    "author_id": 100022613,
    "status": 1,
    "row_pic_url": "https://images.dmzj.com/news/article/65953/row_5dfca368dadde.jpg",
    "col_pic_url": "https://images.dmzj.com/news/article/65953/col_5dfca38c50efd.jpg",
    "qchat_show": 1,
    "article_id": 65953,
    "page_url": "https://v2api.dmzj.com/article/show/v2/65953.html",
    "comment_amount": "156",
    "author_uid": 100022613,
    "cover": "https://avatar.dmzj.com/76/84/7684ac528369ded76a0b993913e78486.png",
    "nickname": "苍月十羽",
    "mood_amount": 297
  }
]
```
**上面json中page_url就是对应文章的详情页**

### 手机首页的推荐

##### api链接

`http://v3api.dmzj.com/recommend_new_game.json`

**后面可以加？timestamp=1576928394&category_id=50&channel=Android&_debug=0&version=2.7.023**

*返回的json*

```json
[
  {
    "category_id": 46,
    "title": "大图推荐",
    "sort": 1,
    "data": [
      {
        "cover": "https://images.dmzj.com/tuijian/750_480/200102yinxiangyan04.jpg",
        "title": "《映像研》动画化来袭！提前看漫画预热吧",
        "sub_title": "《映像研》动画化来袭！提前看漫画预热吧",
        "type": 1,
        "url": "",
        "obj_id": 48406,
        "status": "连载中",
        "is_dot": "0"
      }
    ]
  },
  {
    "category_id": 47,
    "title": "近期必看",
    "sort": 3,
    "data": [
      {
        "cover": "https://images.dmzj.com/webpic/9/190826yydzz.jpg",
        "title": "夜樱",
        "sub_title": "作者：权平ひつじ",
        "type": 1,
        "url": "",
        "obj_id": 49840,
        "status": "连载中"
      }
    ]
  },
  {
    "category_id": 93,
    "title": "游戏专区",
    "sort": 4,
    "data": [
      {
        "cover": "https://images.dmzj.com/tuijian/320_170/s200102syjtjs03.jpg",
        "title": "家庭教师正版手游",
        "sub_title": "家庭教师正版手游",
        "type": 10,
        "url": "",
        "obj_id": 110,
        "status": ""
      }
    ]
  },
  {
    "category_id": 48,
    "title": "火热专题",
    "sort": 5,
    "data": [
      {
        "cover": "https://images.dmzj.com/tuijian/320_170/191122xinman78.jpg",
        "title": "新漫周刊第78期",
        "sub_title": "新漫周刊第78期",
        "type": 5,
        "url": "",
        "obj_id": 390,
        "status": "",
        "is_dot": "0"
      }
    ]
  },
  {
    "category_id": 51,
    "title": "大师级作者怎能不看",
    "sort": 7,
    "data": [
      {
        "cover": "https://images.dmzj.com/tuijian/150_200/171211yajianxiuzao.jpg",
        "title": "押见修造",
        "sub_title": "",
        "type": 8,
        "url": "",
        "obj_id": 3734,
        "status": ""
      }
    ]
  },
  {
    "category_id": 52,
    "title": "国漫也精彩",
    "sort": 8,
    "data": [
      {
        "cover": "https://images.dmzj.com/img/webpic/16/1017039361514025908.jpg",
        "title": "崩坏3rd",
        "sub_title": "作者：上海米哈游",
        "type": 1,
        "url": "",
        "obj_id": 27708,
        "status": "连载中"
      }
    ]
  },
  {
    "category_id": 53,
    "title": "美漫大事件",
    "sort": 9,
    "data": [
      {
        "cover": "https://images.dmzj.com/tuijian/320_170/0829mimidiguo.jpg",
        "title": "秘密帝国",
        "sub_title": "",
        "type": 1,
        "url": "",
        "obj_id": 40252,
        "status": "连载中"
      }
    ]
  },
  {
    "category_id": 54,
    "title": "热门连载",
    "sort": 10,
    "data": [
      {
        "cover": "https://images.dmzj.com/webpic/16/9999.jpg",
        "title": "明明是以剑士为目标入学的 魔法适性却有9999！？",
        "sub_title": "作者：惟丞/iimAn/年中麦茶太郎",
        "type": 1,
        "url": "",
        "obj_id": 44288,
        "status": "连载中"
      }
    ]
  },
  {
    "category_id": 55,
    "title": "条漫专区",
    "sort": 11,
    "data": [
      {
        "cover": "https://images.dmzj.com/tuijian/320_170/160802qingmeizhuma.jpg",
        "title": "完全没有恋爱感情的青梅竹马",
        "sub_title": "",
        "type": 1,
        "url": "",
        "obj_id": 33322,
        "status": "连载中"
      }
    ]
  },
  {
    "category_id": 92,
    "title": "动画专区",
    "sort": 12,
    "data": [
      {
        "cover": "https://images.dmzj.com/webpic/16/703xqiangdazhanzheng.jpg",
        "title": "猜谜王",
        "sub_title": "作者：杉基イクラ",
        "type": 1,
        "url": "",
        "obj_id": 7643,
        "status": "连载中"
      }
    ]
  },
  {
    "category_id": 56,
    "title": "最新上架",
    "sort": 13,
    "data": [
      {
        "id": 51713,
        "title": "盛夏的JK休憩",
        "authors": "福本真久",
        "status": "已完结",
        "cover": "https://images.dmzj.com/webpic/11/200103sxdjkxq.jpg"
      }
    ]
  }
]
```



| 字段        | 含义             |
| ----------- | ---------------- |
| category_id | 分类id           |
| title       | 栏目标题         |
| sort        | 栏目分类标志     |
| data        | 数据区，是个数组 |

##### 猜你喜欢 api

`http://v3api.dmzj.com/recommend/batchUpdate?timestamp=1576928394&category_id=50&channel=Android&_debug=0&version=2.7.023`

##### 大师级作者推荐

```html
http://v3api.dmzj.com/UCenter/author/3734.json?timestamp=1578109469&channel=Android&_debug=0&version=2.7.023
```

| 字段 | 含义                |
| ---- | ------------------- |
| 3734 | 上一层api中的obj_id |

*返回的数据*

##### 更新页面

`http://v3api.dmzj.com/latest/100/0.json?timestamp=1577337349&channel=Android&_debug=0&version=2.7.023`

##### 分类页面

`http://v3api.dmzj.com/0/category.json?timestamp=1577337597&channel=Android&_debug=0&version=2.7.023`

##### 专题页面

`http://v3api.dmzj.com/subject/0/0.json?timestamp=1577337789&channel=Android&_debug=0&version=2.7.023`

##### 点击轮播图片进入的链接

`http://v3api.dmzj.com/subject/399.json?timestamp=1577849629&channel=Android&_debug=0&version=2.7.023`

| 字段    | 含义                |
| ------- | ------------------- |
| subject | 详情页              |
| 399     | 上一级api给的obj_id |

**banner中的广告 api中返回的是一个H5页面链接！**

##### 点击游戏进入的

`http://v3api.dmzj.com/game_c/game/detail/113.json?timestamp=1577857313&uid=&channel=Android&_debug=0&version=2.7.023`

| 字段 | 含义                            |
| ---- | ------------------------------- |
| 113  | 上一级api返回json中的obj_id字段 |

##### 点击漫画进入的

*评论json*  

`http://v3comment.dmzj.com/v1/4/latest/51438?page_index=1&limit=10&timestamp=1577857740&channel=Android&_debug=0&version=2.7.023`

*置顶评论*

`http://v3api.dmzj.com/comment2/getTopComment/4/4/51438.json?timestamp=1577857740&channel=Android&_debug=0&version=2.7.023`

*漫画信息*

```html
http://v3api.dmzj.com/comic/comic_{obj_id}.json?timestamp=1577857740&channel=Android&_debug=0&version=2.7.023
```

​	**参数obj_id是漫画的id**

```json
{
  "id": 49013,
  "islong": 1,
  "direction": 1,
  "title": "生肖·十二魂",
  "is_dmzj": 0,
  "cover": "https://images.dmzj.com/img/webpic/11/1077076911561950385.jpg",
  "description": "在这个弱肉强食的世界，与世隔绝的日月岛上强大的兽族单方面狩猎着畜族，而坚强团结的畜族为了生存不停地抗争着，这场战争持续了整整百余年，各族民不聊生。为了打破这一不平等的格局，一些经历过磨难的英雄豪杰正在集结，一支名为“生肖”的组织悄然崛起……",
  "last_updatetime": 1577754160,
  "last_update_chapter_name": "21 入局",
  "copyright": 1,
  "first_letter": "s",
  "comic_py": "shengxiaoshierhun",
  "hidden": 0,
  "hot_num": 4227246,
  "hit_num": 160298704,
  "uid": 107707691,
  "is_lock": 0,
  "last_update_chapter_id": 91708,
  "types": [
    {
      "tag_id": 6,
      "tag_name": "格斗"
    },
    {
      "tag_id": 3248,
      "tag_name": "热血"
    },
    {
      "tag_id": 5848,
      "tag_name": "奇幻"
    }
  ],
  "status": [
    {
      "tag_id": 2309,
      "tag_name": "连载中"
    }
  ],
  "authors": [
    {
      "tag_id": 15463,
      "tag_name": "TAPIR梦貘映画"
    }
  ],
  "subscribe_num": 19161,
  "chapters": [
    {
      "title": "连载",
      "data": [
       
        {
          "chapter_id": 85580,
          "chapter_title": "1话",
          "updatetime": 1561966435,
          "filesize": 3085921,
          "chapter_order": 1
        }
      ]
    }
  ],
  "author_notice": "微信公众号：TAPIR梦貘映画\n新浪微博：绘梦者阿尼威",
  "comic_notice": "QQ讨论群：86202241新浪微博：生肖·十二魂 微信公众号：TAPIR梦貘映画",
  "comment": {
    "comment_count": 1203,
    "latest_comment": [
      {
        "comment_id": 23033634,
        "uid": 108138071,
        "content": "棒",
        "createtime": 1578016493,
        "nickname": "鬼刀开",
        "avatar": "https://avatar.dmzj.com/42/0e/420e7dfc26f60c9814668523af205929.png"
      },
      {
        "comment_id": 23033257,
        "uid": 108161116,
        "content": "牛族的判逃应该是当初的畜王与兽王之间的交易，兽族可以杀牛解决温饱，畜族的生存压力会小很多，但只要牛族一日是畜族的一份子，这个交易就永远不会实现，所以只能找个借口炒了牛的尤鱼，毕竟不可能会有畜族的人同意这个交易。牛族这是被当成商品了啊。。。",
        "createtime": 1578014149,
        "nickname": "dmzj_108161116",
        "avatar": "https://avatar.dmzj.com/5c/be/5cbe8200a28de6bea3b004038d34c723.png"
      }
    ]
  },
  "url_links": [],
  "isHideChapter": "0",
  "dh_url_links": [
    {
      "title": "网页端",
      "list": []
    },
    {
      "title": "APP端",
      "list": []
    }
  ],
  "is_dot": "0"
}
```

*部分参数解析*

| 参数                     | 含义                                              |
| ------------------------ | :------------------------------------------------ |
| id                       | 漫画的id                                          |
| islong                   | ~~目测用来控制标签切换页的1是显示，2是隐藏~~ 未知 |
| direction                | ~~用来控制标签切换，1是日漫，2是国漫~~ 未知       |
| title                    | 漫画标题                                          |
| is_dmzj                  | 未知标签                                          |
| cover                    | 封面图片链接                                      |
| description              | 漫画简介                                          |
| last_updatetime          | 最后更新的时间戳                                  |
| last_update_chapter_name | 最新的章节标题                                    |
| copyright                | 著作权标志                                        |
| first_letter             | 漫画标题的首字母                                  |
| comic_py                 | 漫画标题的拼音                                    |
| hidden                   | 未知                                              |
| hot_num                  | 人气 日漫专用标签                                 |
| hit_num                  | 点击 国漫专用标签                                 |
| is_lock                  | 锁定标志，估计是一些被禁止的                      |
| last_update_chapter_id   | 最新章节的id                                      |
| types                    | 漫画类型                                          |
| authors                  | 漫画作者                                          |
| subscr——num              | 订阅                                              |
| status                   | 完结还是连载状态                                  |
| chapters                 | 漫画章节列表                                      |
| author——notice           | 作者公告                                          |
| comic_notice             | 漫画公告                                          |
| comment                  | 评论列表                                          |





### 小说获取

###### 推荐列表

`http://v3api.dmzj.com/novel/recommend.json?timestamp=1576929340&channel=Android&_debug=0&version=2.7.023`

###### 进入具体的小说

`http://v3api.dmzj.com/novel/2769.json?timestamp=1576929602&channel=Android&_debug=0&version=2.7.023`

###### 该小说的评论

`http://v3comment.dmzj.com/v1/1/latest/2769?page_index=1&limit=10&timestamp=1576929602&channel=Android&_debug=0&version=2.7.023`

##### 进入第一卷后的api

`http://v3api.dmzj.com/novel/chapter/2769.json?timestamp=1576929770&channel=Android&_debug=0&version=2.7.023`

##### 进入具体章节的api 返回的时txt文件，里面有HTML格式

`http://v3api.dmzj.com/novel/download/2769_10507_101813.txt`



### 开发过程中的记录

###### gradle加载慢的话，可以使用阿里云镜像仓库。

