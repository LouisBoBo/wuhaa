package com.exc.api.vo;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

/*
* 平板地图--勾选复选框查询站点建筑物
* */
public class PartitionFindlistVo {


    /**
     * list : [{"name":"大区站点","id":312},{"name":"测试区","id":313},{"name":"沌口区","id":315},{"name":"洪山区","id":317},{"name":"机场集团","id":318},{"name":"沌口万科翡翠玖玺站点","id":338},{"name":"沌口嘎呐印象站点","id":339},{"name":"东西湖区","id":387},{"name":"武昌区","id":389},{"name":"东湖风景区","id":390},{"name":"沌口宁康园站点","id":416},{"name":"青山区","id":418},{"name":"黄陂区","id":421},{"name":"湖北机场集团","id":484},{"name":"湖北机场集团","id":485},{"name":"天河机场开关站点","id":487},{"name":"航发集团动态站点","id":498},{"name":"东西湖愿景城北侧在线","id":499},{"name":"沌口金桥太子湖1号站点","id":505},{"name":"沌口碧桂园泰富城站点","id":510},{"name":"桥梁处","id":511},{"name":"江夏区","id":512},{"name":"新洲区","id":513},{"name":"汉阳区","id":514},{"name":"硚口区","id":515},{"name":"江汉区","id":516},{"name":"沌口激光的测试","id":518},{"name":"沌口湘隆时代大公馆站点","id":526},{"name":"沌口观澜御苑站点","id":527},{"name":"沌口经开万达","id":531},{"name":"沌口财富广场站点","id":532},{"name":"沌口东风公司展厅站点","id":538},{"name":"沌口神龙青年公寓站点","id":540},{"name":"沌口神龙汽车站点","id":541},{"name":"沌口区城市便捷酒店站点","id":542},{"name":"沌口金色港湾四期站点","id":543},{"name":"沌口新港地产站点","id":544},{"name":"沌口经开未来城站点","id":545},{"name":"沌口青澳都市尚巢站点","id":546},{"name":"沌口联投湖北路桥站点","id":547},{"name":"沌口万科金域蓝湾站点","id":548},{"name":"沌口观澜太子湖联动站点","id":549},{"name":"沌口观澜外校城站点","id":551},{"name":"沌口人信太子湾站点","id":552},{"name":"沌口鹏程金湖公寓开关","id":554},{"name":"沌口金凯酒店站点","id":555},{"name":"沌口中百仓储站点","id":556},{"name":"沌口喜瑞得酒店开关","id":557},{"name":"沌口区第一初级中学站点","id":558},{"name":"沌口通达伟业大厦站点","id":559},{"name":"沌口华润新龙医药站点","id":560},{"name":"沌口开发区法院站点","id":561},{"name":"沌口金泰商务酒店站点","id":562},{"name":"沌口开发区管委会","id":563},{"name":"沌口天鹅湖山庄站点","id":564},{"name":"沌口人信奥林苑站点","id":565},{"name":"沌口双湖泊岸站点","id":566},{"name":"沌口圣龙国际广场站点","id":568},{"name":"沌口金利屋大厦站点","id":571},{"name":"沌口金色港湾一期站点","id":572},{"name":"沌口协和医院站点","id":573},{"name":"沌口东合中心站点","id":574},{"name":"沌口南太子湖岸线站点","id":575},{"name":"沌口金色港湾五期站点","id":576},{"name":"沌口绿岛大厦站点","id":577},{"name":"沌口全季酒店站点","id":578},{"name":"沌口吉祥国际站点","id":579},{"name":"沌口供电公司站点","id":580},{"name":"沌口交通大队站点","id":581},{"name":"沌口中国工商银行站点","id":582},{"name":"沌口中国农业银行站点","id":583},{"name":"沌口新都国际嘉园站点","id":584},{"name":"沌口健龙果岭公元站点","id":585},{"name":"沌口中国民生银行站点","id":586},{"name":"沌口汉阳客运站站点","id":587},{"name":"沌口龙阳建材家具城站点","id":588},{"name":"沌口中环湖畔站点","id":589},{"name":"沌口升官渡小区站点","id":590},{"name":"沌口武汉设计广场站点","id":591},{"name":"沌口东风汽车站点","id":592},{"name":"沌口湖北水总站点","id":593},{"name":"沌口三角湖新民校区站点","id":594},{"name":"洪山珞南一标","id":607},{"name":"洪山区329控制站点","id":608},{"name":"白马","id":613},{"name":"青山铂金瑞府","id":614},{"name":"青山怡江苑测试0330","id":615},{"name":"青山奥山世纪广场","id":616},{"name":"青山青扬六和站点","id":617},{"name":"青山怡江苑0401","id":618},{"name":"青山奥山世纪城V公馆","id":619},{"name":"青山奥山世纪广场401","id":620},{"name":"青山武汉江山二期401","id":621},{"name":"青山铂金瑞府开关","id":622},{"name":"青山武汉江山一期401","id":623},{"name":"青山铂金瑞府(动态)","id":624},{"name":"波光霞影","id":625},{"name":"汉阳邓甲新城A区","id":626},{"name":"名流公馆","id":627},{"name":"军运村","id":628},{"name":"汉阳欧亚达国际广场","id":630},{"name":"汉阳欣隆一号公馆","id":631},{"name":"汉阳星光国际二期","id":632},{"name":"汉阳武汉市中医医院","id":633},{"name":"汉阳武汉市汉阳医院","id":634},{"name":"汉阳绿地中央广场商业楼","id":635},{"name":"汉阳绿地中央广场二期","id":636},{"name":"汉阳和昌都会华府","id":637},{"name":"汉阳华发未来荟","id":638},{"name":"汉阳红光景观苑","id":639},{"name":"汉阳雅丽花园","id":640},{"name":"汉阳墨水湖大桥","id":641},{"name":"汉阳招商公园","id":642},{"name":"汉阳红光怡馨苑","id":643},{"name":"汉阳五里墩高压局宿舍","id":644},{"name":"汉阳红光翠景苑","id":645},{"name":"汉阳汉阳铁路和谐家园","id":646},{"name":"汉阳世茂外滩","id":647},{"name":"汉阳世茂锦绣长江4期","id":648},{"name":"汉阳知音学府","id":649},{"name":"汉阳华丽苑小区","id":650},{"name":"汉阳翠微福苑","id":651},{"name":"汉阳枫华锦都","id":652},{"name":"汉阳江腾国际广场","id":654},{"name":"汉阳区人民法院","id":655},{"name":"汉阳广电兰亭熙园","id":656},{"name":"汉阳希岸亲雅酒店","id":657},{"name":"汉阳开来东方华庭","id":658},{"name":"汉阳维也纳酒店","id":659},{"name":"汉阳垦鑫花园","id":660},{"name":"汉阳十里和府","id":661},{"name":"汉阳钰龙湾汇园","id":662},{"name":"汉阳汉桥金福世家","id":663},{"name":"汉阳十里锦绣二期","id":664},{"name":"汉阳阳光十里新城","id":665},{"name":"汉阳顶琇广场","id":666},{"name":"汉阳龙阳凯悦大厦","id":667},{"name":"汉阳人信汇时代中心","id":668},{"name":"汉阳都会中心繁华里","id":669},{"name":"汉阳武汉卷烟厂","id":670},{"name":"汉阳人信汇商业","id":671},{"name":"汉阳1+1空间","id":672},{"name":"汉阳龙阳御园","id":673},{"name":"汉阳太康城","id":674},{"name":"汉阳诗朗绿色街区","id":675},{"name":"汉阳锦绣锦豪视觉酒店","id":676},{"name":"汉阳武汉海宁皮革城","id":677},{"name":"汉阳龙阳大道人行天桥","id":678},{"name":"汉阳鲤跃龙门站点","id":679},{"name":"汉阳御水华城","id":680},{"name":"汉阳鲤鱼洲家园","id":681},{"name":"汉阳武汉恒大御景湾","id":682},{"name":"汉阳恒大御景湾2期","id":683},{"name":"汉阳新城璟悦城","id":684},{"name":"汉阳和昌中心","id":685},{"name":"龙阳建材家居城","id":686},{"name":"汉阳美好广场","id":687},{"name":"汉阳钰龙湾景园","id":688},{"name":"汉阳鹏程苑","id":689},{"name":"汉阳江腾苑A区","id":690},{"name":"汉阳邓甲新城","id":691},{"name":"汉阳燕归园","id":692},{"name":"汉阳广电兰亭都荟","id":693},{"name":"汉阳汉阳区政府","id":694},{"name":"汉阳武汉摩尔城","id":695},{"name":"汉阳人信汇四期-天誉","id":696},{"name":"汉阳九州通大厦","id":697},{"name":"汉阳龙阳时代","id":698},{"name":"汉阳卧龙墨水湖湖边","id":699},{"name":"汉阳麦普利斯广场","id":700},{"name":"汉阳观澜国际","id":701},{"name":"汉阳武汉国际博览中心","id":702},{"name":"汉阳广电兰亭时代二期","id":703},{"name":"汉阳广电兰亭时代","id":704},{"name":"汉阳金地澜菲溪岸西区","id":705},{"name":"汉阳欧亚达国际广场裙楼","id":706},{"name":"汉阳中青假日酒店","id":707},{"name":"汉阳武汉市文化局","id":708},{"name":"汉阳垂直社交圈","id":709},{"name":"汉阳新龙尚座","id":710},{"name":"汉阳龙阳熙悦","id":711},{"name":"汉阳21世纪购物中心","id":712},{"name":"汉阳万科汉阳国际","id":713},{"name":"汉阳5点5医药产业大厦","id":714},{"name":"汉阳升官渡经贸大厦","id":715},{"name":"汉阳新城阳光国际广场","id":716},{"name":"汉阳汉阳社会福利院","id":717},{"name":"汉阳绿地国博财富中心","id":718},{"name":"汉阳红叶酒店","id":719},{"name":"汉阳居然之家（汉阳）","id":720},{"name":"名流公馆","id":721},{"name":"洪山澳新专修学院","id":723},{"name":"湖北澳新教育专修学院","id":724},{"name":"洪山东湖尚郡站点","id":725},{"name":"洪山东亭新嘉源站点","id":726},{"name":"洪山中建福地星城站点","id":727},{"name":"东湖风景东湖天下站点","id":733},{"name":"东湖风景东湖名邸","id":734},{"name":"东湖雅斯特酒店","id":735},{"name":"东湖国家电力监管委员会","id":736},{"name":"湖北美术馆","id":737},{"name":"东湖秀水公寓","id":738},{"name":"红光","id":739},{"name":"武昌东湖春树里小区","id":742},{"name":"武昌东湖丽景酒店","id":743},{"name":"武昌东湖中学教师宿舍","id":744},{"name":"1武昌欧亚达建材家居","id":745},{"name":"武昌中力名居站点","id":746},{"name":"武昌东湖路开关站点","id":748},{"name":"武昌武汉岳家嘴","id":749},{"name":"机场路(道理、绿化带)","id":750},{"name":"两江四岸","id":751},{"name":"硚口区所有开关节点","id":756},{"name":"硚口天安医院动态站点","id":757},{"name":"硚口云都大酒店","id":758},{"name":"硚口亚洲大酒店","id":759},{"name":"硚口金叶大厦","id":760},{"name":"硚口丽景苑","id":761},{"name":"硚口葛洲坝城市花园","id":763},{"name":"硚口城市广场家庭公寓","id":764},{"name":"硚口中御公馆","id":766},{"name":"硚口东辉花园","id":767},{"name":"硚口葛洲坝大厦","id":768},{"name":"硚口航天星苑","id":769},{"name":"硚口天骄国际","id":770},{"name":"硚口兴隆大厦","id":771},{"name":"硚口中环新天地","id":772},{"name":"硚口越秀联机站点","id":773},{"name":"硚口长江大酒店","id":774},{"name":"硚口富商大厦","id":775},{"name":"硚口新世界酒店","id":776},{"name":"硚口7天连锁酒店","id":777},{"name":"硚口武汉地铁办公楼","id":778},{"name":"硚口汉水熙园","id":779},{"name":"沌口汉口银行站点","id":783},{"name":"洪山东湖国贸中心站点","id":784},{"name":"洪山中科开物站点","id":785},{"name":"洪山中铁科技大厦站点","id":786},{"name":"洪山广泽大厦站点","id":787},{"name":"洪山能源大厦站点","id":788},{"name":"洪山湖北省电力大厦站点","id":789},{"name":"洪山宏源电力中心站点","id":790},{"name":"洪山华中电网调度大厦","id":791},{"name":"洪山电力研究院站点","id":792},{"name":"洪山国家电网电力站点","id":793},{"name":"绿景苑港东名居一期","id":794},{"name":"青山区江南新天地联机","id":795},{"name":"青山虹琦花园站点","id":796},{"name":"洪山诺展星座站点","id":797},{"name":"洪山铁机盛世家园站点","id":798},{"name":"洪山武汉公寓站点","id":799},{"name":"洪山汉庭酒店站点","id":800},{"name":"洪山白马馨居东区站点","id":801},{"name":"洪山白马鑫居西区站点","id":802},{"name":"洪山欢乐星城站点","id":803},{"name":"洪山中国工商银行站点","id":805},{"name":"洪山学府鑫苑站点","id":806},{"name":"洪山果然时尚酒店站点","id":807},{"name":"洪山鹏程国际站点","id":808},{"name":"洪山妇幼保健院站点","id":809},{"name":"洪山凯旋门广场住宅站点","id":810},{"name":"洪山法老王国际会所站点","id":811},{"name":"洪山城市快捷酒店站点","id":812},{"name":"洪山龙潭SOMO站点","id":813},{"name":"洪山徐东嘉园站点","id":814},{"name":"洪山国电大厦站点","id":815},{"name":"洪山华中电力金融大厦站点","id":816},{"name":"洪山鸿源国际公馆站点","id":817},{"name":"洪山华腾园站点","id":818},{"name":"洪山中冶南方大厦站点","id":819},{"name":"洪山V7星公馆站点","id":820},{"name":"洪山金和中心站点","id":821},{"name":"洪山东湖睿园站点","id":822},{"name":"洪山省电社区站点","id":823},{"name":"洪山大城小院站点","id":824},{"name":"洪山铁机村还建楼站点","id":825},{"name":"洪山铁机湾385号楼","id":826},{"name":"洪山柴林尚城站点","id":827},{"name":"洪山融侨悦府站点","id":828},{"name":"洪山武汉站站点","id":829},{"name":"洪山东湖庭园站点","id":830},{"name":"洪山万豪圣会站点","id":831},{"name":"洪山珞珈山剧院站点","id":832},{"name":"洪山樱花大厦站点","id":833},{"name":"洪山马房山逸夫楼站点","id":834},{"name":"洪山狮城公寓站点","id":835},{"name":"洪山湖北警备司令部站点","id":836},{"name":"洪山湖北省总队宿舍站点","id":837},{"name":"洪山湖北省水利研究院","id":838},{"name":"洪山区行政服务中心站点","id":839},{"name":"洪山丽岛紫园联机站点","id":840},{"name":"洪山丽岛紫园动态站点","id":841},{"name":"洪山丽湖花园站点","id":843},{"name":"洪山阜华大厦站点","id":844},{"name":"洪山未来城站点","id":845},{"name":"洪山武汉理工大学创业园","id":846},{"name":"洪山理工大孵化楼站点","id":847},{"name":"洪山武汉理工设计研究院","id":848},{"name":"洪山月星家居站点","id":849},{"name":"洪山珞桂路99号站点","id":850},{"name":"洪山万象生活广场站点","id":851},{"name":"洪山湖北国际旅行卫生","id":852},{"name":"洪山狮城小镇温馨公寓","id":853},{"name":"洪山星光时代站点","id":854},{"name":"洪山丽岛花园动态站点","id":855},{"name":"洪山明泽大厦站点","id":856},{"name":"洪山明泽丽湾站点","id":857},{"name":"洪山高农大厦站点","id":858},{"name":"洪山格林泰花园酒店站点","id":859},{"name":"洪山瑞湖天地站点","id":860},{"name":"洪山澜花语岸站点","id":861},{"name":"洪山珞南雅居站点","id":862},{"name":"洪山湖北水利技术学院","id":863},{"name":"洪山华大家园联机站点","id":864},{"name":"洪山复地悦城站点","id":865},{"name":"洪山马应龙药业园区站点","id":866},{"name":"洪山武汉南大门综合医院","id":867},{"name":"洪山金地西岸故事站点","id":868},{"name":"洪山农业科技楼站点","id":869},{"name":"洪山南湖城市大厦站点","id":870},{"name":"洪山湖北生物科技北区","id":871},{"name":"洪山南湖狮山美庐站点","id":872},{"name":"洪山三鸿领域站点","id":873},{"name":"洪山御景名门站点","id":874},{"name":"洪山武汉理工大学站点","id":875},{"name":"洪山春林庭苑站点","id":876},{"name":"洪山劳动局宿舍站点","id":877},{"name":"洪山湖北长江出版集团","id":878},{"name":"洪山中建三局小区站点","id":879},{"name":"洪山丽岛2046#站点","id":880},{"name":"洪山瑞安之星站点","id":881},{"name":"洪山清江锦城西区站点","id":882},{"name":"洪山毛坦港湾站点","id":883},{"name":"洪山彩虹郡站点","id":884},{"name":"洪山楚天都市沁园站点","id":885},{"name":"洪山东原湖光里站点","id":886},{"name":"洪山波光霞影站点","id":887},{"name":"洪山金地圣爱米伦站点","id":888},{"name":"洪山星维酒店站点","id":889},{"name":"洪山鸿城家园站点","id":890},{"name":"洪山珞珈雅苑站点","id":891},{"name":"洪山南湖新城家园站点","id":892},{"name":"洪山明泽丰华苑站点","id":894},{"name":"洪山万科金色城市站点","id":895},{"name":"洪山观庭金色世家站点","id":896},{"name":"洪山湘龙鑫城站点","id":897},{"name":"洪山长江鑫都站点","id":898},{"name":"洪山青菱城市花园站点","id":899},{"name":"华润紫云府二期站点","id":900},{"name":"武昌中小企业服务平台","id":901},{"name":"武昌居然之家站点","id":902},{"name":"武昌光明万丽酒店站点","id":903},{"name":"硚口武汉首佳耳鼻喉医院","id":907},{"name":"东湖风景东湖小学站点","id":908},{"name":"硚口艳阳天旺角","id":909},{"name":"东风大道绿化带","id":911},{"name":"武昌福星惠誉国际城1期","id":912},{"name":"洪山青江苑站点","id":914},{"name":"洪山南湖雅园站点","id":915},{"name":"洪山武汉市工商局站点","id":916},{"name":"东西湖愿景城站点","id":917},{"name":"东西湖凯旋名居站点","id":918},{"name":"东西湖愿景时代站点","id":919},{"name":"东西湖华新融城站点","id":920},{"name":"武昌武汉大学本科生院楼","id":921},{"name":"武昌茶港新村东院站点","id":922},{"name":"武昌瑞安城市酒店站点","id":923},{"name":"武昌湖北省科技创业大厦","id":924},{"name":"武昌湖北省地震监测中心","id":925},{"name":"武昌红星大院站点","id":926},{"name":"武昌地铁K7站点","id":927},{"name":"武昌沃尔玛购物中心站点","id":928},{"name":"武昌中力企业大厦站点","id":930},{"name":"武昌联发国际大厦站点","id":931},{"name":"武昌都市经典站点","id":932},{"name":"武昌湖北能源站点","id":933},{"name":"武昌英特小区站点","id":934},{"name":"武昌山河企业大厦站点","id":935},{"name":"武昌菩提金商务中心站点","id":936},{"name":"武昌新金龙酒店站点","id":937},{"name":"武昌东海湾站点","id":938},{"name":"武昌世纪名苑B区站点","id":939},{"name":"武昌027社区站点","id":940},{"name":"武昌华亚新领地站点","id":941},{"name":"武昌雄楚春天站点","id":942},{"name":"武昌百瑞景一期站点","id":943},{"name":"武昌凯旋名邸站点","id":944},{"name":"武昌楚天传媒大厦站点","id":945},{"name":"东湖国创楚源东湖酒店","id":946},{"name":"东湖宾馆宿舍站点","id":947},{"name":"东湖武汉弘毅大酒店站点","id":948},{"name":"青山怡江苑站点","id":949},{"name":"桥梁处十升立交桥站点","id":950},{"name":"龙阳大道立交桥站点","id":951},{"name":"升官渡立交桥站点","id":952},{"name":"杨泗港江城大道处立交桥","id":953},{"name":"墨水湖立交桥站点","id":954},{"name":"梅子山通道站点","id":955},{"name":"常青立交桥站点","id":956},{"name":"江夏何家湖村二期站点","id":957},{"name":"江夏黄家湖党员服务中心","id":958},{"name":"江夏邢远长小区站点","id":959},{"name":"江夏豹山小区站点","id":960},{"name":"华中师大武汉传媒学院","id":961},{"name":"江夏百度百捷站点","id":962},{"name":"江夏光谷SOHO站点","id":963},{"name":"江夏光谷大道CBC站点","id":964},{"name":"江夏三和光谷道站点","id":965},{"name":"江夏中冶创业苑站点","id":966},{"name":"江夏保利清能西海岸站点","id":967},{"name":"江夏阳光时尚商业街站点","id":968},{"name":"江夏阳光大湖第站点","id":969},{"name":"江夏百步亭江南郡站点","id":970},{"name":"江夏花山郡站点","id":971},{"name":"江汉欧亚达国际广场站点","id":972},{"name":"江汉东方建国大酒店站点","id":973},{"name":"武汉市经委会及爱尔眼科","id":974},{"name":"江汉葛洲坝广场站点","id":975},{"name":"江汉万景国际动态站点","id":976},{"name":"江汉万景国际联动站点","id":977},{"name":"江汉国家税务局站点","id":978},{"name":"江汉顶琇西北湖站点","id":979},{"name":"江汉军区干休所站点","id":980},{"name":"江汉湖北教育出版社站点","id":981},{"name":"江汉元辰国际站点","id":982},{"name":"江汉花园道站点","id":983},{"name":"江汉地铁科普馆站点","id":984},{"name":"路线站点-1号保障路线","id":985},{"name":"路线站点-2号保障线路","id":986},{"name":"路线站点-3号保障线路","id":987},{"name":"路线站点-4号保障线路","id":988},{"name":"路线站点-5号保障线路","id":989},{"name":"路线站点-6号保障线路","id":990},{"name":"路线站点-7号保障线路","id":991},{"name":"路线站点-8号保障线路","id":992},{"name":"路线站点-9号保障线路","id":993},{"name":"路线站点-10号保障线路","id":994},{"name":"东西湖常青一中站点","id":995},{"name":"东西湖常青花园6小区","id":996},{"name":"东西湖常青花园恒大御景","id":997},{"name":"愿景城北侧小区开关站点","id":998},{"name":"东西湖凯旋名居开关站点","id":999},{"name":"东西湖伊甸园荣昌花园","id":1000},{"name":"东西湖新城俊园站点","id":1001},{"name":"东西湖区华新融城开关","id":1002},{"name":"东西湖愿景城C区动态","id":1003},{"name":"洪山珞珈山路19小区","id":1004},{"name":"珞南街四眼井社区","id":1005},{"name":"洪山华城大厦","id":1006},{"name":"洪山瑞景华庭","id":1007},{"name":"洪山荣泰小区","id":1008},{"name":"洪山劝业场社区","id":1009},{"name":"洪山马房山校区教工楼","id":1010},{"name":"洪山马房山校区逸夫楼","id":1011},{"name":"传感技术国家工程实验室","id":1012},{"name":"洪山黎明苑教师小区","id":1013},{"name":"洪山洪发大厦","id":1014},{"name":"洪山中国银行(洪山)","id":1015},{"name":"洪山区人力资源服务中心","id":1016},{"name":"洪山南远大楼","id":1017},{"name":"洪山明雅苑小区","id":1018},{"name":"洪山尤李村电信宿舍","id":1019},{"name":"洪山珞南电信小区","id":1020},{"name":"中建三局武汉中心医院","id":1021},{"name":"水利水电科学研究院","id":1022},{"name":"洪山郧阳大厦","id":1023},{"name":"洪山狮龙花苑","id":1024},{"name":"丽岛紫园（商业裙楼）","id":1025},{"name":"洪山区政府","id":1026},{"name":"马房山校区宿舍楼","id":1028},{"name":"洪山达达酒店","id":1029},{"name":"洪山理工大学产业楼","id":1030},{"name":"洪山马房山中学","id":1031},{"name":"洪山教委科技大楼","id":1032},{"name":"洪山鸿桂苑北区","id":1033},{"name":"洪山凯旋门广场站点","id":1034},{"name":"洪山圆梦美丽家园","id":1035},{"name":"洪山狮城名居","id":1036},{"name":"洪山南湖鱼场小区","id":1037},{"name":"洪山锦江之星开关站点","id":1038},{"name":"国际旅行卫生保健中心","id":1039},{"name":"旅行卫生保健中心南侧","id":1040},{"name":"洪山口腔健康检查中心","id":1041},{"name":"洪山区珞狮路小学","id":1042},{"name":"校园艺术大赛组委会","id":1043},{"name":"洪山一元堂中医门诊部","id":1045},{"name":"狮城风华新都","id":1047},{"name":"洪山区国有资产经营公司","id":1049},{"name":"洪山丽岛花园开关站点","id":1058},{"name":"洪山明泽半岛尊邸","id":1061},{"name":"武汉市武昌医院南湖院区","id":1066},{"name":"洪山南湖渔场小区","id":1079},{"name":"洪山郑氏推拿","id":1081},{"name":"洪山恒信汽车城","id":1083},{"name":"大华南湖公园世家一期","id":1085},{"name":"洪山江汉饭店","id":1086},{"name":"水利水电技术学院开关","id":1090},{"name":"水利水电技术学院联动","id":1091},{"name":"国土资源规划局洪山分局","id":1099},{"name":"洪山华大家园开关站点","id":1102},{"name":"洪山紫菘珞狮花园","id":1136},{"name":"中财金融培训中心","id":1138},{"name":"洪山华农教职工宿舍","id":1139},{"name":"武昌武汉大学开关站点","id":1140},{"name":"狮城立交桥（武昌）","id":1141},{"name":"武昌武汉大学茶港区开关","id":1142},{"name":"武昌湖北省审计厅开关","id":1143},{"name":"江夏武汉学院大学城","id":1144},{"name":"武昌茶港新村东院开关","id":1145},{"name":"武昌茶港军转小区开关","id":1146},{"name":"狮城立交桥北段","id":1147},{"name":"武昌阳光大厦动态站点","id":1148},{"name":"武昌亚太医疗美容开关","id":1149},{"name":"武昌中科院测量开关站点","id":1150},{"name":"武昌湖北工商局开关站点","id":1151},{"name":"武昌中国农业银行开关","id":1152},{"name":"武昌长城资产管理公司","id":1153},{"name":"武昌滨湖大厦开关站点","id":1154},{"name":"武昌湖北社科院开关站点","id":1155},{"name":"武昌体育馆开关站点","id":1156},{"name":"武昌粤海酒店开关站点","id":1157},{"name":"武昌亢龙太子酒轩开关","id":1158},{"name":"楚天181创意产业园","id":1159},{"name":"武昌文学艺术联合会开关","id":1160},{"name":"武昌东湖公安局宿舍开关","id":1161},{"name":"武昌新华网开关站点","id":1162},{"name":"黄浦路立交桥开关站点","id":1163},{"name":"竹叶山立交桥开关站点","id":1164},{"name":"姑嫂树立交桥开关站点","id":1165},{"name":"青山奥山世纪广场开关","id":1166},{"name":"武昌奥山世纪城澜橼道","id":1207},{"name":"武昌欧景苑动态站点","id":1208},{"name":"武昌和平立交桥开关站点","id":1209},{"name":"东西湖联通佳苑联机站点","id":1210},{"name":"东西湖新城璟汇联机站点","id":1212},{"name":"硚口城市便捷酒店开关","id":1213},{"name":"硚口葛洲坝写字楼开关","id":1214},{"name":"硚口公路局科研大楼开关","id":1215},{"name":"硚口南大天地开关站点","id":1216},{"name":"硚口天和宾馆开关站点","id":1217},{"name":"硚口同济宝丰小区开关","id":1218},{"name":"硚口同馨花园开关站点","id":1219},{"name":"硚口武汉地铁开关站点","id":1220},{"name":"硚口武汉市肺科医院开关","id":1221},{"name":"硚口香溢大酒店开关站点","id":1222},{"name":"硚口血液中心开关站点","id":1223},{"name":"硚口振升商住楼开关站点","id":1224},{"name":"硚口中御广场开关站点","id":1225},{"name":"硚口宝丰房产开关站点","id":1226},{"name":"路线站点-第二条展示线路","id":1227},{"name":"沌口佳阳曼邦精品酒店","id":1228},{"name":"沌口P+R停车场","id":1230},{"name":"硚口葛洲坝酒店开关站点","id":1231},{"name":"硚口湖北商务大楼开关","id":1232},{"name":"硚口湖北商业广场开关","id":1233},{"name":"硚口时代天骄开关站点","id":1234},{"name":"沌口宁康壹品苑","id":1235},{"name":"烟草集团卷烟销售公司","id":1236},{"name":"硚口武汉一轻科研大厦","id":1237},{"name":"硚口星7宾馆开关站点","id":1238},{"name":"硚口中国工商银行开关","id":1239},{"name":"武昌野芷湖立交桥开关","id":1240},{"name":"沌口观澜太子湖开关站点","id":1241},{"name":"洪山红十字会","id":1242},{"name":"洪山九龙国际大酒店","id":1243},{"name":"路线站点-第三条展示线路","id":1246},{"name":"路线站点-第四条展示线路","id":1247},{"name":"路线站点-第五条展示线路","id":1248},{"name":"路线站点-第六条展示线路","id":1249},{"name":"洪山湖北省公安厅","id":1250},{"name":"洪山阳光128酒店","id":1251},{"name":"洪山迪雅花园","id":1252},{"name":"洪山如家商旅酒店","id":1253},{"name":"武昌起义门","id":1254},{"name":"武昌楚望台","id":1255},{"name":"武昌汇文新都D区","id":1256},{"name":"武昌白鳍豚大厦","id":1257},{"name":"汉阳梅子立交桥站点","id":1259},{"name":"武昌安格酒店","id":1260},{"name":"东风大道立交桥站点","id":1261},{"name":"武昌武昌站","id":1262},{"name":"沌口太子湖畔星苑","id":1263},{"name":"沌口武汉盛世锦江大酒店","id":1265},{"name":"沌口三角湖岸线","id":1266},{"name":"鹦鹉洲大桥西侧","id":1267},{"name":"过街天桥","id":1268},{"name":"青菱立交桥（武昌）","id":1269},{"name":"洪山华中师大附小","id":1270},{"name":"洪山南湖瑶苑","id":1271},{"name":"武昌武汉大学医学部6号","id":1272},{"name":"洪山武商量贩","id":1273},{"name":"洪山中国石化管道","id":1274},{"name":"洪山江南脑科医院","id":1275},{"name":"洪山茶宴酒店","id":1276},{"name":"二号路线","id":1277},{"name":"杨春湖立交桥（武昌）","id":1278},{"name":"二号联机","id":1279},{"name":"三号开关","id":1280},{"name":"复地15栋测试","id":1281},{"name":"东湖风景博物馆","id":1282},{"name":"洪山中商徐东平价广场","id":1283},{"name":"东湖梨园医院联机站点","id":1287},{"name":"东湖梨园小区联机站点","id":1288},{"name":"东湖武汉纺织大学公寓楼","id":1289},{"name":"东湖景园A区动态站点","id":1290},{"name":"东湖康斐斯健身联机站点","id":1292},{"name":"东湖华侨城双子座","id":1293},{"name":"东湖纯水岸一期联机站点","id":1294},{"name":"东湖武汉华侨城三期","id":1295},{"name":"武汉华侨城实业发展中心","id":1296},{"name":"东湖欢乐谷联机站点","id":1297},{"name":"东湖玛雅海滩酒店联机","id":1298},{"name":"东湖东湖景园C区动态","id":1299},{"name":"东湖东湖景园B区动态","id":1300},{"name":"武昌区红庙立交桥开关","id":1301},{"name":"东西湖长源假日港湾","id":1302},{"name":"东湖风景区东湖天下动态","id":1303},{"name":"汉阳区太子尚品","id":1304},{"name":"武昌创意产业园","id":1305},{"name":"武昌鑫宝来大酒店","id":1306},{"name":"东西湖熙龙湾","id":1307},{"name":"汉阳龙阳熙悦动态站点","id":1308},{"name":"江夏何家湖小区","id":1309},{"name":"中国海关中国检疫检验","id":1311},{"name":"黄陂中国东方航空开关","id":1312},{"name":"黄陂民航湖北空管分局","id":1313},{"name":"马家湖大桥动态站点","id":1314},{"name":"江夏豹山村还建小区","id":1315},{"name":"江夏龚家铺村","id":1316},{"name":"收费站开关站点","id":1317},{"name":"丰荷山互通动态站点","id":1318},{"name":"路线站点-两江四岸","id":1319},{"name":"路线站点-东湖绿心","id":1320},{"name":"路线站点-武汉体育馆","id":1321},{"name":"路线站点-军运村","id":1322},{"name":"路线站点-天河机场","id":1323},{"name":"路线站点-武汉火车站","id":1324},{"name":"路线站点-汉口火车站","id":1325},{"name":"路线站点-武昌火车站","id":1326},{"name":"东湖春树里小区(测试)","id":1327},{"name":"武昌719研究所","id":1328},{"name":"硚口联动6栋楼","id":1330},{"name":"硚口联动5栋楼","id":1331},{"name":"东西湖区（测试）","id":1333},{"name":"武昌文学艺术联合会","id":1335},{"name":"华侨城生态住宅二期","id":1339},{"name":"沌口湘隆时代广场联机","id":1341},{"name":"福星联发","id":1342},{"name":"1号保障线路","id":1343},{"name":"东西湖EPC","id":1344},{"name":"5号保障线路","id":1345},{"name":"东西湖EPC站点","id":1347},{"name":"2号保障线路","id":1349},{"name":"4号保障线路","id":1350},{"name":"徐东大街至东湖宾馆楼宇","id":1351},{"name":"6号保障线路","id":1353},{"name":"徐东大街武昌区","id":1354},{"name":"东湖风景区联机0513","id":1355},{"name":"东西湖联机站点","id":1356},{"name":"汉阳联机站点","id":1357},{"name":"洪山联机站点","id":1358},{"name":"江夏联机站点","id":1359},{"name":"硚口联机站点","id":1360},{"name":"武昌联机站点","id":1361},{"name":"3号保障线路","id":1362},{"name":"江北快速路开关站点","id":1364},{"name":"东西湖工薪小区动态站点","id":1365},{"name":"东西湖工薪小区开关站点","id":1366},{"name":"沌口区重点保障线路站点","id":1367},{"name":"青山区重点保障线路站点","id":1368},{"name":"东西湖区重点保障线路站点","id":1369},{"name":"路线站点-重点保障建筑","id":1370},{"name":"桥梁处重点保障建筑","id":1371},{"name":"武昌区重点保障建筑","id":1372},{"name":"汉阳区重点保障线路站点","id":1373},{"name":"机场重点保障线路站点","id":1374},{"name":"东湖风景区重点保障站点","id":1375},{"name":"洪山区重点保障线路站点","id":1376},{"name":"东湖高新区","id":1377},{"name":"黄陂区重点保障线路站点","id":1378},{"name":"硚口区重点保障建筑","id":1380},{"name":"江夏区重点保障建筑","id":1382},{"name":"湖北机场集团重点保障建筑","id":1384},{"name":"航发集团重点保障建筑","id":1385},{"name":"新洲区重点保障建筑","id":1386},{"name":"东湖高新区重点保障建筑","id":1387},{"name":"7号保障线路","id":1388},{"name":"8号保障线路","id":1389},{"name":"9号保障线路","id":1390},{"name":"10号保障线路","id":1391},{"name":"12号保障线路","id":1393},{"name":"17号保障线路","id":1394},{"name":"20号保障线路","id":1395},{"name":"22号保障线路","id":1396},{"name":"23号保障线路","id":1397},{"name":"16号保障线路","id":1398},{"name":"A区块站点","id":1399},{"name":"B区块站点","id":1400},{"name":"C区块站点","id":1401},{"name":"E区块站点","id":1402},{"name":"F区块站点","id":1403},{"name":"G区块站点","id":1404},{"name":"江夏科创广场联机站点","id":1405},{"name":"沌口金利屋联动","id":1408},{"name":"硚口融侨锦城","id":1409},{"name":"测试站点","id":1413},{"name":"路线站点-11号保障路线","id":1416},{"name":"路线站点-12号保障路线","id":1417},{"name":"路线站点-13号保障路线","id":1418},{"name":"路线站点-14号保障路线","id":1419},{"name":"路线站点-15号保障路线","id":1420},{"name":"路线站点-16号保障路线","id":1421},{"name":"路线站点-17号保障路线","id":1422},{"name":"路线站点-18号保障路线","id":1423},{"name":"路线站点-19号保障路线","id":1424},{"name":"路线站点-20号保障路线","id":1425},{"name":"路线站点-21号保障路线","id":1426},{"name":"路线站点-22号保障路线","id":1427},{"name":"路线站点-23号保障路线","id":1428},{"name":"路线站点-24号保障路线","id":1429},{"name":"路线站点-25号保障路线","id":1430},{"name":"硚口区EPC站点","id":1431},{"name":"硚口区硚房站点","id":1432},{"name":"洪山区江南新天地B区联机","id":1433},{"name":"洪山区江南新天地C区联机","id":1434},{"name":"机场高速路测试","id":1448},{"name":"汉阳体育中心高架照明立交桥","id":1449},{"name":"新洲区领港城","id":1450},{"name":"新洲区财富广场","id":1451},{"name":"新洲区阳逻欣隆国际","id":1452},{"name":"新洲区保利圆梦城三期","id":1453},{"name":"新洲区保利圆梦城二期","id":1455},{"name":"新洲区江汉路与圆梦南路交汇处","id":1457},{"name":"新洲区阳逻欣隆湖滨半岛二期","id":1458},{"name":"新洲区保利圆梦城九期","id":1459},{"name":"新洲区保利圆梦城六期","id":1460},{"name":"新洲区长江御龙新城","id":1461},{"name":"新洲区阳逻中央花园城","id":1462},{"name":"新洲区阳逻城市印象","id":1463},{"name":"新洲区阳逻山庄","id":1464},{"name":"新洲区阳逻新洲一中","id":1465},{"name":"新洲区阳逻枫桦雅苑","id":1466},{"name":"新洲区阳逻开发区人民检察院检察室","id":1467},{"name":"新洲区阳逻泊湖天下二期","id":1468},{"name":"新洲区阳逻红岭小区","id":1469},{"name":"新洲区阳逻香榭花都","id":1470},{"name":"新洲区阳逻开发区柴泊湖大道桥绕城高速","id":1471},{"name":"新洲区保利圆梦城一期","id":1472},{"name":"新洲区保利圆梦城二期","id":1473},{"name":"新洲区西班牙美食乐购街","id":1474},{"name":"硚口越秀写字楼","id":1478},{"name":"硚口越秀公寓","id":1479},{"name":"机场A区","id":1482},{"name":"天河机场道桥景观带电箱","id":1484},{"name":"东西湖城郊检察院","id":1485},{"name":"硚口区宝丰时代","id":1486},{"name":"天河机场西庭院","id":1487},{"name":"洪山珞南二标未来城酒店","id":1488},{"name":"洪山融侨悦府一期","id":1489},{"name":"洪山融侨悦府二期","id":1490},{"name":"东湖高新epc","id":1491},{"name":"观澜高尔夫公馆","id":1492},{"name":"山河企业大厦","id":1493},{"name":"dddd","id":1495},{"name":"沌口五标东合中心","id":1496},{"name":"东西湖愿景城北侧新建小区5号楼","id":1497},{"name":"武昌联发九都国际","id":1498},{"name":"东西湖愿景城站点1","id":1499},{"name":"东湖高新当代中心","id":1500},{"name":"湖北省美术馆","id":1501},{"name":"汉阳都市兰亭5栋楼","id":1502},{"name":"沌口新新人家","id":1503},{"name":"青山区奥山澜橼","id":1504},{"name":"天河机场东庭院","id":1505},{"name":"硚口越秀写字楼裙楼联机站点","id":1507},{"name":"汉阳复地海上海","id":1509},{"name":"东合中心三期路灯","id":1510},{"name":"东湖高新区生物技术交易市场","id":1512},{"name":"硚口区泰合广场","id":1513},{"name":"洪山银泰创意城","id":1514},{"name":"东西湖欧亚酒店及写字楼","id":1515},{"name":"汉阳汉商大厦写字楼","id":1516},{"name":"东湖风景区东湖景园A区16","id":1517},{"name":"鹏程国际B栋-新世界百货","id":1518},{"name":"测试建筑物（联机）","id":1519},{"name":"汉阳区世茂锦绣长江3期","id":1520},{"name":"汉阳区世茂锦绣长江6期","id":1521},{"name":"东湖风景区东湖景园B区26","id":1522},{"name":"汉阳悦江名邸","id":1523},{"name":"东湖景园C区31号楼","id":1524},{"name":"东西湖美联奥林匹克花园","id":1526},{"name":"东西湖联通佳苑","id":1527},{"name":"汉阳区龙阳时代3栋楼","id":1528},{"name":"体育中心周边灯光控制楼宇","id":1529},{"name":"路线站点-10.19","id":1530},{"name":"巡线20191019","id":1531},{"name":"洪山狮子山二标南湖狮山美庐","id":1532},{"name":"五零所平台","id":1534},{"name":"机场高速交投集团绿化带","id":1535},{"name":"沌口六标人信太子湾14号楼","id":1538},{"name":"洪山区EPC","id":1539},{"name":"市级接待线路","id":1540},{"name":"路线站点-市级接待线路","id":1541},{"name":"50所黄陂区","id":1542},{"name":"50所洪山区","id":1543},{"name":"50所江岸区","id":1544},{"name":"50所桥梁处","id":1545},{"name":"50所武汉站","id":1546},{"name":"50所硚口区","id":1547},{"name":"江夏区文化大道楼宇清单","id":1548},{"name":"何家湖二期1号楼","id":1549},{"name":"何家湖二期21号楼","id":1550},{"name":"青山航拍20200119","id":1552},{"name":"汉阳欧亚达国际广场2栋楼","id":1553},{"name":"武汉市动态楼宇","id":1554},{"name":"武汉市联机建筑","id":1555},{"name":"沌口二标东合中心C","id":1557},{"name":"Z1天河机场\u2014长江二桥\u2014东湖徐东大街","id":1560},{"name":"洪山区晨旭楼宇","id":1561},{"name":"Z2天河机场经二七长江大桥至东湖宾馆","id":1563},{"name":"Z4火车站区域、欢乐大道","id":1564},{"name":"Z5 武汉站\u2014东湖宾馆\u2014江夏区运动员村","id":1565},{"name":"Z6 杨春湖路","id":1566},{"name":"星测试站点","id":1572},{"name":"12222233132","id":1573},{"name":"测试","id":1576},{"name":"测试站点111","id":1577},{"name":"1111","id":1578},{"name":"213213","id":1580}]
     * type : 2
     */

    private int type;
    /**
     * name : 大区站点
     * id : 312
     */

    private List<ListBean> list;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    @Entity(tableName = "building")
    public static class ListBean {
        private String name;
        @PrimaryKey
        private int id;
        private int partitionId;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        @Ignore
        private boolean isSelect;

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

        public int getPartitionId() {
            return partitionId;
        }

        public void setPartitionId(int partitionId) {
            this.partitionId = partitionId;
        }
    }
}
