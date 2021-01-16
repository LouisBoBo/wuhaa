package com.exc.api.vo;

import java.util.List;

public class UserLoginVo {


    /**
     * site : 1277
     * roleGrade : 1
     * partitionId : 1
     * roleId : 1
     * permissions : [{"code":"light:module","name":"智慧灯光模块","id":1,"sort":1,"parentId":0},{"code":"electricity:module","name":"强电模块","id":2,"sort":1,"parentId":0},{"code":"map:module","name":"地图工况模块","id":3,"sort":1,"parentId":0},{"code":"supervision:module","name":"智慧监控模块","id":4,"sort":1,"parentId":0},{"code":"laser:module","name":"激光表演模块","id":5,"sort":1,"parentId":0},{"code":"stage:module","name":"舞美灯光模块","id":6,"sort":1,"parentId":0},{"code":"interaction:module","name":"互动中心模块","id":7,"sort":1,"parentId":0},{"code":"geyser:module","name":"喷泉景观模块","id":8,"sort":1,"parentId":0},{"code":"network:module","name":"网络安全模块","id":9,"sort":1,"parentId":0},{"code":"permission:module","name":"权限模块","id":10,"sort":1,"parentId":0},{"code":"audio:module","name":"智能音响模块","id":11,"sort":1,"parentId":0},{"code":"report:module","name":"报表统计模块","id":12,"sort":1,"parentId":0},{"code":"color:module","name":"颜色管理模块","id":13,"sort":1,"parentId":0},{"code":"light:common","name":"灯光常用功能","id":14,"sort":2,"parentId":1},{"code":"light:common:home","name":"快捷首页","id":15,"sort":3,"parentId":14},{"code":"light:common:map","name":"控制单元地图","id":16,"sort":3,"parentId":14},{"code":"light:common:switch:partition","name":"分区节目切换","id":17,"sort":3,"parentId":14},{"code":"light:common:switch:fast","name":"快速节目切换","id":18,"sort":3,"parentId":14},{"code":"light:common:script","name":"快速策略生成","id":19,"sort":3,"parentId":14},{"code":"light:common:time","name":"快速时间设置","id":20,"sort":3,"parentId":14},{"code":"light:common:video","name":"快速媒体处理","id":21,"sort":3,"parentId":14},{"code":"light:common:timer","name":"定时开关机","id":22,"sort":3,"parentId":14},{"code":"light:control","name":"控制单元管理","id":23,"sort":2,"parentId":1},{"code":"light:control:node","name":"控制单元节点列表","id":24,"sort":3,"parentId":23},{"code":"light:control:group","name":"控制单元分组列表","id":25,"sort":3,"parentId":23},{"code":"light:control:partition","name":"控制单元分区列表","id":26,"sort":3,"parentId":23},{"code":"light:control:execute","name":"控制单元控制","id":27,"sort":3,"parentId":23},{"code":"light:control:node:add","name":"新增控制单元","id":28,"sort":4,"parentId":24},{"code":"light:control:node:delete","name":"删除控制单元","id":29,"sort":4,"parentId":24},{"code":"light:control:node:update","name":"修改控制单元","id":30,"sort":4,"parentId":24},{"code":"light:control:node:get","name":"查看控制单元","id":31,"sort":4,"parentId":24},{"code":"light:control:group:add","name":"新增控制单元分组","id":32,"sort":4,"parentId":25},{"code":"light:control:group:delete","name":"删除控制单元分组","id":33,"sort":4,"parentId":25},{"code":"light:control:group:update","name":"修改控制单元分组","id":34,"sort":4,"parentId":25},{"code":"light:control:group:get","name":"查看控制单元分组","id":35,"sort":4,"parentId":25},{"code":"light:control:partition:add","name":"新增控制单元分区","id":36,"sort":4,"parentId":26},{"code":"light:control:partition:delete","name":"删除控制单元分区","id":37,"sort":4,"parentId":26},{"code":"light:control:partition:update","name":"修改控制单元分区","id":38,"sort":4,"parentId":26},{"code":"light:program","name":"灯光节目管理","id":39,"sort":2,"parentId":1},{"code":"light:program:source","name":"节目源文件","id":40,"sort":3,"parentId":39},{"code":"light:program:handle","name":"视频处理","id":41,"sort":3,"parentId":39},{"code":"light:program:progress","name":"任务进度","id":42,"sort":3,"parentId":39},{"code":"light:program","name":"节目列表","id":43,"sort":3,"parentId":39},{"code":"light:program:script","name":"播放策略","id":44,"sort":3,"parentId":39},{"code":"light:program:review","name":"节目预览","id":45,"sort":3,"parentId":39},{"code":"light:program:source:upload","name":"上传源视频","id":46,"sort":4,"parentId":40},{"code":"light:program:source:delete","name":"删除源视频","id":47,"sort":4,"parentId":40},{"code":"light:program:video:delete","name":"删除节目","id":48,"sort":4,"parentId":43},{"code":"light:state","name":"系统状态管理","id":49,"sort":2,"parentId":1},{"code":"light:state:fault","name":"故障列表","id":50,"sort":3,"parentId":49},{"code":"light:state:statistics","name":"统计与呈现","id":51,"sort":3,"parentId":49},{"code":"light:state:fault:find","name":"故障发现","id":52,"sort":3,"parentId":49},{"code":"light:state:trend","name":"趋势与预测","id":53,"sort":3,"parentId":49},{"code":"light:intelligent","name":"智能主控","id":54,"sort":2,"parentId":1},{"code":"light:intelligent:node","name":"智能节点列表","id":55,"sort":3,"parentId":54},{"code":"light:intelligent:control","name":"智能节点控制","id":56,"sort":3,"parentId":54},{"code":"light:intelligent:script","name":"智能播放策略","id":57,"sort":3,"parentId":54},{"code":"light:intelligent:node:add","name":"新增智能节点","id":58,"sort":4,"parentId":55},{"code":"light:intelligent:node:delete","name":"删除智能节点","id":59,"sort":4,"parentId":55},{"code":"light:intelligent:node:update","name":"修改智能节点","id":60,"sort":4,"parentId":55},{"code":"light:intelligent:node:get","name":"智能节点详情","id":61,"sort":4,"parentId":55},{"code":"light:intelligent:group:add","name":"新增智能节点组","id":62,"sort":4,"parentId":55},{"code":"light:intelligent:group:delete","name":"删除智能节点组","id":63,"sort":4,"parentId":55},{"code":"light:intelligent:group:update","name":"修改智能节点组","id":64,"sort":4,"parentId":55},{"code":"light:intelligent:group:get","name":"智能节点组详情","id":65,"sort":4,"parentId":55},{"code":"light:intelligent:program:add","name":"新增智能节点节目","id":66,"sort":4,"parentId":55},{"code":"light:intelligent:program:delete","name":"删除智能节点节目","id":67,"sort":4,"parentId":55},{"code":"light:intelligent:script:add","name":"新增智能播放策略","id":68,"sort":4,"parentId":57},{"code":"light:intelligent:script:delete","name":"删除智能播放策略","id":69,"sort":4,"parentId":57},{"code":"light:intelligent:script:get","name":"智能播放策略详情","id":70,"sort":4,"parentId":57},{"code":"electricity:common","name":"强电常用功能","id":71,"sort":2,"parentId":2},{"code":"electricity:common:home","name":"强电快捷首页","id":72,"sort":3,"parentId":71},{"code":"electricity:manage","name":"强电管理","id":73,"sort":2,"parentId":2},{"code":"electricity:manage:node","name":"强电节点管理","id":74,"sort":3,"parentId":73},{"code":"electricity:manage:group","name":"强电节点分组","id":75,"sort":3,"parentId":73},{"code":"electricity:manage:partition","name":"强电节点分区","id":76,"sort":3,"parentId":73},{"code":"electricity:manage:scene","name":"强电场景编辑","id":77,"sort":3,"parentId":73},{"code":"electricity:manage:control","name":"回路控制","id":78,"sort":3,"parentId":73},{"code":"electricity:manage:timer","name":"场景执行","id":79,"sort":3,"parentId":73},{"code":"electricity:manage:scene:current","name":"当前执行场景","id":80,"sort":3,"parentId":73},{"code":"electricity:manage:energy:statistics","name":"能耗统计","id":81,"sort":3,"parentId":73},{"code":"electricity:manage:analysis","name":"能耗分析","id":82,"sort":3,"parentId":73},{"code":"electricity:manage:report","name":"能耗报表","id":83,"sort":3,"parentId":73},{"code":"electricity:manage:node:add","name":"新增强电节点","id":84,"sort":4,"parentId":74},{"code":"electricity:manage:node:delete","name":"删除强电节点","id":85,"sort":4,"parentId":74},{"code":"electricity:manage:node:update","name":"修改强电节点","id":86,"sort":4,"parentId":74},{"code":"electricity:manage:node:get","name":"强电节点详情","id":87,"sort":4,"parentId":74},{"code":"electricity:manage:device:add","name":"新增强电设备","id":88,"sort":4,"parentId":74},{"code":"electricity:manage:device:delete","name":"删除强电设备","id":89,"sort":4,"parentId":74},{"code":"electricity:manage:device:update","name":"修改强电设备","id":90,"sort":4,"parentId":74},{"code":"electricity:manage:channel:update","name":"修改强电回路","id":91,"sort":4,"parentId":74},{"code":"electricity:manage:group:add","name":"新增强电分组","id":92,"sort":4,"parentId":75},{"code":"electricity:manage:group:delete","name":"删除强电分组","id":93,"sort":4,"parentId":75},{"code":"electricity:manage:group:update","name":"修改强电分组","id":94,"sort":4,"parentId":75},{"code":"electricity:manage:group:get","name":"强电分组详情","id":95,"sort":4,"parentId":75},{"code":"electricity:manage:partition:add","name":"新增强电分区","id":96,"sort":4,"parentId":76},{"code":"electricity:manage:partition:delete","name":"删除强电分区","id":97,"sort":4,"parentId":76},{"code":"electricity:manage:partition:update","name":"修改强电分组","id":98,"sort":4,"parentId":76},{"code":"electricity:manage:partition:get","name":"强电分区详情","id":99,"sort":4,"parentId":76},{"code":"electricity:manage:scene:add","name":"新增强电场景","id":100,"sort":4,"parentId":77},{"code":"electricity:manage:timer:add","name":"新增定时","id":101,"sort":4,"parentId":79},{"code":"electricity:manage:timer:excute","name":"立即执行场景","id":102,"sort":4,"parentId":79},{"code":"electricity:manage:timer:delete","name":"删除定时","id":103,"sort":4,"parentId":80},{"code":"laser:control:manage","name":"激光控制单元管理","id":104,"sort":2,"parentId":5},{"code":"laser:node","name":"激光节点列表","id":105,"sort":3,"parentId":104},{"code":"laser:node:control","name":"激光节点控制","id":106,"sort":3,"parentId":104},{"code":"laser:script","name":"激光节点策略","id":107,"sort":3,"parentId":104},{"code":"laser:node:add","name":"新增激光节点","id":108,"sort":4,"parentId":105},{"code":"laser:node:delete","name":"删除激光节点","id":109,"sort":4,"parentId":105},{"code":"laser:node:update","name":"修改激光节点","id":110,"sort":4,"parentId":105},{"code":"laser:node:get","name":"激光节点详情","id":111,"sort":4,"parentId":105},{"code":"laser:group:add","name":"新增激光节点组","id":112,"sort":4,"parentId":105},{"code":"laser:group:delete","name":"删除激光节点组","id":113,"sort":4,"parentId":105},{"code":"laser:group:update","name":"修改激光节点组","id":114,"sort":4,"parentId":105},{"code":"laser:group:get","name":"激光节点组详情","id":115,"sort":4,"parentId":105},{"code":"laser:program:add","name":"新增激光节目","id":116,"sort":4,"parentId":105},{"code":"laser:program:delete","name":"删除激光节目","id":117,"sort":4,"parentId":105},{"code":"laser:script:add","name":"新增激光策略","id":118,"sort":4,"parentId":107},{"code":"laser:script:delete","name":"删除激光策略","id":119,"sort":4,"parentId":107},{"code":"laser:script:get","name":"激光策略详情","id":120,"sort":4,"parentId":107},{"code":"laser:script:pause","name":"暂停激光策略","id":121,"sort":4,"parentId":107},{"code":"laser:script:resume","name":"恢复激光策略","id":122,"sort":4,"parentId":107},{"code":"light:program:source:audit","name":"视频审核","id":123,"sort":4,"parentId":40},{"code":"light:program:script:add","name":"新增灯光策略","id":124,"sort":4,"parentId":44},{"code":"light:program:script:delete","name":"删除灯光策略","id":125,"sort":4,"parentId":44},{"code":"light:program:script:update","name":"修改灯光策略","id":126,"sort":4,"parentId":44},{"code":"light:program:script:get","name":"灯光策略详情","id":127,"sort":4,"parentId":44},{"code":"light:program:script:issue","name":"下发灯光策略","id":128,"sort":4,"parentId":44},{"code":"light:common:home:emergency:release","name":"紧急发布","id":129,"sort":4,"parentId":15},{"code":"light:program:source:skip","name":"跳过视频审核","id":130,"sort":4,"parentId":40},{"code":"light:common:home:emergency:skip","name":"跳过紧急发布","id":131,"sort":4,"parentId":15},{"code":"permission:it:manage","name":"IT管理","id":132,"sort":2,"parentId":10},{"code":"permission:it:log","name":"运行日志","id":133,"sort":3,"parentId":132},{"code":"permission:it:report","name":"报表统计","id":134,"sort":3,"parentId":132},{"code":"permission:it:system:parameter","name":"系统参数","id":135,"sort":3,"parentId":132},{"code":"permission:it:process","name":"进程管理","id":136,"sort":3,"parentId":132},{"code":"permission:account:manage","name":"账号管理","id":137,"sort":2,"parentId":10},{"code":"permission:account:user","name":"用户管理","id":138,"sort":3,"parentId":137},{"code":"permission:account:role","name":"角色管理","id":139,"sort":3,"parentId":137},{"code":"permission:account:user:add","name":"新增用户","id":140,"sort":4,"parentId":138},{"code":"permission:account:user:delete","name":"删除用户","id":141,"sort":4,"parentId":138},{"code":"permission:account:user:update","name":"修改用户","id":142,"sort":4,"parentId":138},{"code":"permission:account:role:add","name":"新增角色","id":143,"sort":4,"parentId":139},{"code":"permission:account:role:delete","name":"删除角色","id":144,"sort":4,"parentId":139},{"code":"permission:account:role:update","name":"修改角色","id":145,"sort":4,"parentId":139},{"code":"permission:asset","name":"资产管理","id":146,"sort":2,"parentId":10},{"code":"permission:asset:add","name":"新增资产","id":147,"sort":4,"parentId":146},{"code":"permission:asset:delete","name":"删除资产","id":148,"sort":4,"parentId":146},{"code":"permission:asset:update","name":"修改资产","id":149,"sort":4,"parentId":146},{"code":"permission:order","name":"工单管理","id":150,"sort":2,"parentId":10},{"code":"permission:order:add","name":"新增工单","id":151,"sort":4,"parentId":150},{"code":"permission:order:delete","name":"删除工单","id":152,"sort":4,"parentId":150},{"code":"permission:order:update","name":"修改工单","id":153,"sort":4,"parentId":150},{"code":"permission:fault","name":"故障列表","id":155,"sort":2,"parentId":10},{"code":"permission:message:push","name":"消息推送","id":156,"sort":2,"parentId":10},{"code":"permission:notice:publish","name":"消息列表","id":157,"sort":3,"parentId":156},{"code":"permission:information","name":"资讯列表","id":158,"sort":3,"parentId":156},{"code":"permission:notice:publish:add","name":"新增消息","id":159,"sort":4,"parentId":157},{"code":"permission:notice:publish:delete","name":"删除消息","id":160,"sort":4,"parentId":157},{"code":"permission:information:add ","name":"新增资讯","id":161,"sort":4,"parentId":158},{"code":"permission:information:delete","name":"删除资讯","id":162,"sort":4,"parentId":158},{"code":"permission:system:manage","name":"系统管理","id":163,"sort":2,"parentId":10},{"code":"permission:system:state","name":"系统状态","id":164,"sort":3,"parentId":163},{"code":"permission:player:state","name":"播放器状态","id":165,"sort":3,"parentId":163},{"code":"permission:software:update","name":"节点软件更新","id":166,"sort":3,"parentId":163},{"code":"light:control:node:change","name":"改变节点分区","id":167,"sort":4,"parentId":26},{"code":"light:control:partition:get","name":"分区详情","id":168,"sort":4,"parentId":26},{"code":"light:program:video:update","name":"更改节目状态","id":169,"sort":4,"parentId":43},{"code":"personal:center:module","name":"个人中心","id":170,"sort":1,"parentId":0},{"code":"electricity:manage:node:change","name":"改变节点分区","id":171,"sort":4,"parentId":76},{"code":"electricity:manage:scene:fast","name":"场景快速执行","id":172,"sort":4,"parentId":72},{"code":"light:program:video:send","name":"视频下发","id":173,"sort":4,"parentId":43},{"code":"light:common:home:emergency:stop","name":"紧急消息停止","id":174,"sort":4,"parentId":15},{"code":"light:program:video:stop","name":"停止播放","id":175,"sort":4,"parentId":43},{"code":"light:control:node:list","name":"控制单元列表","id":176,"sort":4,"parentId":24},{"code":"light:control:group:list","name":"控制单元组列表","id":177,"sort":4,"parentId":25},{"code":"light:control:partition:list","name":"控制单元分区列表","id":178,"sort":4,"parentId":26},{"code":"light:program:source:list","name":"源文件列表","id":179,"sort":4,"parentId":40},{"code":"light:program:list","name":"节目列表","id":180,"sort":4,"parentId":43},{"code":"light:program:script:list","name":"播放策略列表","id":181,"sort":4,"parentId":44},{"code":"light:state:fault:list","name":"故障列表","id":182,"sort":4,"parentId":50},{"code":"light:intelligent:node:list","name":"智能节点列表","id":183,"sort":4,"parentId":55},{"code":"light:intelligent:script:list","name":"智能播放策略列表","id":184,"sort":4,"parentId":57},{"code":"electricity:manage:node:list","name":"强电节点列表","id":185,"sort":4,"parentId":74},{"code":"electricity:manage:group:list","name":"强电分组列表","id":186,"sort":4,"parentId":75},{"code":"electricity:manage:partition:list","name":"强电分区列表","id":187,"sort":4,"parentId":76},{"code":"electricity:manage:scene:list","name":"强电场景列表","id":188,"sort":4,"parentId":77},{"code":"laser:node:list","name":"激光节点列表","id":189,"sort":4,"parentId":105},{"code":"laser:script:list","name":"激光策略列表","id":190,"sort":4,"parentId":107},{"code":"laser:group:list","name":"激光分组列表","id":191,"sort":4,"parentId":105},{"code":"light:intelligent:group:list","name":"智能节点组列表","id":192,"sort":4,"parentId":55},{"code":"permission:account:user:list","name":"用户列表","id":193,"sort":4,"parentId":138},{"code":"permission:account:role:list","name":"角色列表","id":194,"sort":4,"parentId":139},{"code":"permission:order:list","name":"工单列表","id":195,"sort":4,"parentId":150},{"code":"permission:fault:list","name":"故障列表","id":196,"sort":4,"parentId":155},{"code":"permission:notice:publish:list","name":"消息列表","id":197,"sort":4,"parentId":157},{"code":"permission:information:list","name":"资讯列表","id":198,"sort":4,"parentId":158},{"code":"permission:asset:list","name":"资产列表","id":199,"sort":4,"parentId":146},{"code":"light:program:handle:fast","name":"视频快速处理","id":200,"sort":4,"parentId":41},{"code":"light:program:handle:stop","name":"停止处理","id":201,"sort":4,"parentId":41},{"code":"light:program:handle:video","name":"视频处理","id":202,"sort":4,"parentId":41},{"code":"map:home","name":"首页","id":203,"sort":2,"parentId":3},{"code":"map:home:region:start","name":"点击启动","id":204,"sort":4,"parentId":203},{"code":"map:home:region:stop","name":"点击停止","id":205,"sort":4,"parentId":203},{"code":"map:home:control","name":"策略控制权限","id":206,"sort":4,"parentId":203},{"code":"map:home:emergency:control","name":"紧急控制权限","id":207,"sort":4,"parentId":203},{"code":"map:site","name":"站点管理","id":208,"sort":2,"parentId":3},{"code":"map:site:site:add","name":"添加站点","id":209,"sort":4,"parentId":208},{"code":"map:site:building:add","name":"添加建筑","id":210,"sort":4,"parentId":208},{"code":"map:site:site","name":"站点","id":211,"sort":3,"parentId":208},{"code":"map:site:site:list","name":"站点集合","id":212,"sort":4,"parentId":211},{"code":"map:site:site:update","name":"修改站点","id":213,"sort":4,"parentId":211},{"code":"map:site:site:get","name":"站点详情","id":214,"sort":4,"parentId":211},{"code":"map:site:site:delete","name":"删除站点","id":215,"sort":4,"parentId":211},{"code":"map:site:building","name":"建筑物","id":216,"sort":3,"parentId":208},{"code":"map:site:building:list","name":"建筑物集合","id":217,"sort":4,"parentId":216},{"code":"map:site:building:update","name":"修改建筑物","id":218,"sort":4,"parentId":216},{"code":"map:site:building:get","name":"建筑物详情","id":219,"sort":4,"parentId":216},{"code":"map:site:building:delete","name":"删除建筑物","id":220,"sort":4,"parentId":216},{"code":"map:schedule","name":"日程管理","id":221,"sort":2,"parentId":3},{"code":"map:schedule:add","name":"新增日程","id":222,"sort":4,"parentId":221},{"code":"map:schedule:delete","name":"删除日程","id":223,"sort":4,"parentId":221},{"code":"map:line","name":"路线管理","id":224,"sort":2,"parentId":3},{"code":"map:line:add","name":"路线新增","id":225,"sort":4,"parentId":224},{"code":"map:line:delete","name":"路线删除","id":226,"sort":4,"parentId":224},{"code":"map:line:update","name":"路线编辑","id":227,"sort":4,"parentId":224},{"code":"map:line:strategy:add","name":"路线策略新增","id":228,"sort":4,"parentId":224},{"code":"map:line:strategy:delete","name":"路线策略删除","id":229,"sort":4,"parentId":224},{"code":"map:line:strategy:detail","name":"路线策略编辑","id":230,"sort":4,"parentId":224},{"code":"map:fault","name":"故障检测","id":231,"sort":2,"parentId":3},{"code":"map:fault:notifi:settings","name":"故障通知设置","id":232,"sort":4,"parentId":231},{"code":"map:fault:state","name":"故障状态按钮","id":233,"sort":4,"parentId":231},{"code":"map:fault:set","name":"故障设置","id":234,"sort":4,"parentId":231},{"code":"map:data","name":"数据中心","id":235,"sort":2,"parentId":3},{"code":"map:operation","name":"操作日志","id":236,"sort":2,"parentId":3},{"code":"map:device","name":"设备管理","id":237,"sort":2,"parentId":3},{"code":"map:device:daily","name":"日常维护","id":238,"sort":4,"parentId":237},{"code":"map:device:replace","name":"更替维护","id":239,"sort":4,"parentId":237},{"code":"map:asset","name":"资产管理","id":240,"sort":2,"parentId":3},{"code":"light:common:situation","name":"全局策略","id":241,"sort":3,"parentId":14},{"code":"light:common:situation:list","name":"全局策略列表","id":242,"sort":4,"parentId":241},{"code":"light:common:situation:get","name":"查看全局策略","id":243,"sort":4,"parentId":241},{"code":"light:common:situation:add","name":"新增全局策略","id":244,"sort":4,"parentId":241},{"code":"light:common:situation:delete","name":"删除全局策略","id":245,"sort":4,"parentId":241},{"code":"light:common:situation:update","name":"修改全局策略","id":246,"sort":4,"parentId":241},{"code":"electricity:manage:scene:update","name":"修改强电场景","id":247,"sort":4,"parentId":77},{"code":"electricity:manage:scene:delete","name":"删除强电场景","id":248,"sort":4,"parentId":77},{"code":"map:line:list","name":"路线列表","id":249,"sort":4,"parentId":224},{"code":"map:home:start:ceremony","name":"启动仪式","id":250,"sort":4,"parentId":203},{"code":"map:home:region:urgen","name":"紧急关闭\t","id":251,"sort":4,"parentId":203},{"code":"map:home:region:send","name":"一键下发","id":252,"sort":4,"parentId":203},{"code":"map:home:schedule:send","name":"日程下发","id":253,"sort":4,"parentId":203},{"code":"permission:order:generate","name":"生成工单设置","id":254,"sort":4,"parentId":150},{"code":"permission:order:first:trial","name":"工单初审(区级)","id":255,"sort":4,"parentId":150},{"code":"permission:order:handle","name":"工单处理中","id":256,"sort":4,"parentId":150},{"code":"permission:order:complete","name":"工单处理完成","id":257,"sort":4,"parentId":150},{"code":"permission:order:second:trial","name":"工单审核(区级)","id":258,"sort":4,"parentId":150},{"code":"permission:order:get","name":"工单详情","id":259,"sort":4,"parentId":150},{"code":"permission:order:first:trial:city","name":"工单初审(市级)","id":260,"sort":4,"parentId":150},{"code":"permission:order:second:trial:city","name":"工单审核(市级)","id":261,"sort":4,"parentId":150},{"code":"permission:notice:publish:update","name":"编辑消息","id":262,"sort":4,"parentId":157},{"code":"permission:order:declare:add","name":"工单问题申报","id":263,"sort":4,"parentId":150},{"code":"permission:order:declare:update","name":"工单问题审核","id":264,"sort":4,"parentId":150},{"code":"permission:notice:publish:update","name":"编辑消息","id":265,"sort":4,"parentId":157},{"code":"permission:order:declare:add","name":"工单问题申报","id":266,"sort":4,"parentId":150},{"code":"permission:order:declare:update","name":"工单问题审核","id":267,"sort":4,"parentId":150}]
     * roleName : 超级管理员
     * userName : 超级管理员
     * userId : 1
     * token : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwicGhvbmUiOiIxNTk4ODg4ODg4OCIsImlhdCI6MTYwNTY5Mzg4NywiZXhwIjo0ODE3MzQwODYzNn0.o3kph4kRw3AITkKUYUckhexn1vkYaQ0D9r3bndQQiok
     */

    private int site;
    private int roleGrade;
    private int partitionId;
    private int roleId;
    private String roleName;
    private String userName;
    private int userId;
    private String token;
    /**
     * code : light:module
     * name : 智慧灯光模块
     * id : 1
     * sort : 1
     * parentId : 0
     */

    private List<PermissionsBean> permissions;

    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }

    public int getRoleGrade() {
        return roleGrade;
    }

    public void setRoleGrade(int roleGrade) {
        this.roleGrade = roleGrade;
    }

    public int getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(int partitionId) {
        this.partitionId = partitionId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<PermissionsBean> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionsBean> permissions) {
        this.permissions = permissions;
    }

    public static class PermissionsBean {
        private String code;
        private String name;
        private int id;
        private int sort;
        private int parentId;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }
    }
}
