//引入mock模块
import Mock from 'mockjs';

Mock.mock(RegExp('/auth/oauth/token' + ".*"), 'post',{ //输出数据
  'access_token': 'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJoYW5rbyIsInNjb3BlIjpbInNlcnZlciJdLCJvcmdhbml6YXRpb25faWQiOjAsImV4cCI6MTYxNDk1OTg3MywiYXV0aG9yaXRpZXMiOlsiNiIsIjciXSwianRpIjoiYzU5MDQ1ZWItZDc2NS00ZWZhLWJkZTMtMzY0ZTVhMDM5YmNmIiwiY2xpZW50X2lkIjoiYXBwIn0.W-ny3ie21kP1qNVBnbyDHnw69MidRKYfkSQQoia-Hlm5aSFuKoIqedYPY4PNxd5wNlC-TZDtUa6P3We2ZwltRen3IUJlxlYxJaBg1uKGY_ZNdet8T11lB2T8Nu5s_sQr5FSqUIEdGlK9CC8DsgL9wlpPzDeUwMcab4WqVkXR_hxrLX_lnrm8Ybblcj7ZqzeyYli0-HnXIEMddA0svxHPw93XnIiIuUk5C6ft2nToCGK60uwPGhWfRE3v2BagfUdmfWAHtXIq1Mh0cBVlYz5mRXNfRin5LLUh3Kn2AUcaE7IEeOhb1um6UNABIDS2vde4Onznk5Xgh6IAgiCabSZQXQ',
  'token_type':'bearer'
});

Mock.mock(RegExp('/admin/menu/list' + ".*"), 'get',[
  {
    "icon": "admin",
    "updateTime": 1614333314000,
    "sort": 1,
    "uri": "",
    "parentId": -1,
    "createTime": 1614066837000,
    "name": "后台管理",
    "id": 1000,
    "status": 1,
    "children": [
      {
        "icon": "user",
        "updateTime": 1614333305000,
        "sort": 2,
        "uri": "/admin/user",
        "parentId": 1000,
        "children": [],
        "createTime": 1614066837000,
        "name": "用户管理",
        "id": 1100,
        "status": 1
      },
      {
        "icon": "user",
        "updateTime": 1614333317000,
        "sort": 3,
        "uri": "/admin/role",
        "parentId": 1000,
        "children": [],
        "createTime": 1614066837000,
        "name": "角色管理",
        "id": 1200,
        "status": 1
      }
    ]
  }
]);

Mock.mock(RegExp('/admin/user/info' + ".*"), 'get',{
  "code": 200,
  "message": "操作成功",
  "data": {
    "username": "hanko",
    "password": "$2a$10$WGPEQHsr76LMODVpVyzKweBg6N3H/DBo5u230mZhjo3A4x0kygNVS",
    "icon": null,
    "status": 1,
    "permissions": [
      "/admin/user/add",
      "/admin/user/update",
      "/admin/user/delete",
      "/admin/user/info",
      "/admin/user/list"
    ],
    "roles": [
      "6",
      "7"
    ],
    "organizationId": 0
  }
});

Mock.mock(RegExp('/admin/user/list' + ".*"), 'get',{
  "data": [
    {
      "id":"1",
      "username": "hanko",
      "nickName": "汉克"
    },{
      "id":"2",
      "username": "zhangsan",
      "nickName": "张三"
    }
  ]
});

Mock.mock(RegExp('/admin/role/list' + ".*"), 'get',{
  "data": [
    {
      "id":"1",
      "name": "admin",
      "description": "管理员",
      "adminCount": 10
    },{
      "id":"2",
      "name": "user",
      "description": "普通用户",
      "adminCount": 2
    }
  ]
});

