package com.adventofcode.y2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PDay4 {
	public static void main(String[] args) {
		
		sumOfRealRoomSectorIds("aaaaa-bbb-z-y-x-123[abxyz]");
		sumOfRealRoomSectorIds("a-b-c-d-e-f-g-h-987[abcde]");
		sumOfRealRoomSectorIds("not-a-real-room-404[oarel]");
		sumOfRealRoomSectorIds("totally-real-room-200[decoy]");
		
		String inputString = "nzydfxpc-rclop-qwzhpc-qtylyntyr-769[oshgk]\r\n" + 
				"qzlozfhmf-bzmcx-bnzshmf-zbpthrhshnm-339[zmxdi]\r\n" + 
				"xtwtelcj-rclop-upwwjmply-zapcletzyd-743[itbds]\r\n" + 
				"mrxivrexmsrep-fewoix-ywiv-xiwxmrk-308[kzypw]\r\n" + 
				"ibghopzs-qobrm-difqvogwbu-142[lnrzo]\r\n" + 
				"irgyyolokj-xghhoz-lotgtiotm-228[vnmxd]\r\n" + 
				"foadouwbu-gqojsbusf-vibh-fsgsofqv-376[ymswi]\r\n" + 
				"jvuzbtly-nyhkl-wyvqljapsl-wshzapj-nyhzz-ylzlhyjo-903[jnyaz]\r\n" + 
				"amjmpdsj-cee-qcptgacq-236[caejm]\r\n" + 
				"nvrgfezqvu-avccpsvre-crsfirkfip-217[nrzcd]\r\n" + 
				"vdzonmhydc-bzmcx-bnzshmf-zbpthrhshnm-235[znyot]\r\n" + 
				"oxaflxzqfsb-mixpqfz-doxpp-abmxoqjbkq-393[xqbfo]\r\n" + 
				"drxevkzt-upv-crsfirkfip-893[rfikp]\r\n" + 
				"rkpqxyib-zelzlixqb-obzbfsfkd-627[wzymt]\r\n" + 
				"ajvyjprwp-kdwwh-bjunb-563[jwbpa]\r\n" + 
				"nzcczdtgp-eza-dpncpe-mldvpe-opalcexpye-171[wjzyc]\r\n" + 
				"jxdkbqfz-zixppfcfba-mixpqfz-doxpp-abmilvjbkq-809[nbaoc]\r\n" + 
				"tbxmlkfwba-zelzlixqb-xkxivpfp-315[yixla]\r\n" + 
				"gvcskirmg-gerhc-gsexmrk-hizipstqirx-620[zyosg]\r\n" + 
				"ygcrqpkbgf-ecpfa-eqcvkpi-uvqtcig-440[sbpfj]\r\n" + 
				"irdgrxzex-vxx-rthlzjzkzfe-425[zdqok]\r\n" + 
				"szfyrqriuflj-tfcfiwlc-wcfnvi-uvjzxe-425[lfipb]\r\n" + 
				"zgmfyxypbmsq-aylbw-bcqgel-912[dqtlr]\r\n" + 
				"ubhatstkwhnl-cxeeruxtg-wxitkmfxgm-475[ectpi]\r\n" + 
				"ejpanjwpekjwh-fahhuxawj-wymqeoepekj-316[utnvq]\r\n" + 
				"qlm-pbzobq-ciltbo-pqloxdb-601[lktqh]\r\n" + 
				"votubcmf-fhh-efwfmpqnfou-493[aiyzx]\r\n" + 
				"jqwpihizlwca-uqtqbizg-ozilm-kivlg-twoqabqka-382[frmkh]\r\n" + 
				"zovldbkfz-bdd-tlohpelm-497[dcfxw]\r\n" + 
				"atyzghrk-yigbktmkx-natz-jkyomt-748[ktyag]\r\n" + 
				"iuxxuyobk-hgyqkz-iayzuskx-ykxboik-566[yzsxi]\r\n" + 
				"jvsvymbs-zjhclunly-obua-klzpnu-903[ckmyr]\r\n" + 
				"sbnqbhjoh-ezf-tbmft-623[bfhte]\r\n" + 
				"forwcoqhwjs-rms-difqvogwbu-870[owfqr]\r\n" + 
				"yhtwhnpun-ibuuf-zopwwpun-721[tjlfz]\r\n" + 
				"guahyncw-wbiwifuny-omyl-nymncha-968[nywac]\r\n" + 
				"ykjoqian-cnwza-bhksan-zaoecj-576[btksq]\r\n" + 
				"ckgvutofkj-igtje-zxgototm-800[mlqgz]\r\n" + 
				"ipvohghykvbz-jvsvymbs-lnn-dvyrzovw-227[pysto]\r\n" + 
				"jqwpihizlwca-zilqwikbqdm-ntwemz-kwvbiqvumvb-382[antsy]\r\n" + 
				"njmjubsz-hsbef-cvooz-mbcpsbupsz-805[bferv]\r\n" + 
				"ojk-nzxmzo-xgvnndadzy-xcjxjgvoz-mzxzdqdib-785[vzpun]\r\n" + 
				"yhkpvhjapcl-ihzrla-svnpzapjz-747[pahzj]\r\n" + 
				"htqtwkzq-zsxyfgqj-kqtbjw-rfsfljrjsy-827[wzxif]\r\n" + 
				"fubrjhqlf-sodvwlf-judvv-ilqdqflqj-257[flqdj]\r\n" + 
				"forwcoqhwjs-qobrm-qcohwbu-rsgwub-116[gtsir]\r\n" + 
				"nzydfxpc-rclop-mfyyj-cpdplcns-483[gzysm]\r\n" + 
				"cjpibabsepvt-cbtlfu-nbobhfnfou-857[bfcno]\r\n" + 
				"oxmeeuruqp-ngzzk-geqd-fqefuzs-222[equzf]\r\n" + 
				"mvkccspson-lexxi-bomosfsxq-614[ybgsn]\r\n" + 
				"frqvxphu-judgh-fdqgb-frdwlqj-vhuylfhv-231[bojwc]\r\n" + 
				"sno-rdbqds-bgnbnkzsd-btrsnldq-rdquhbd-989[dbnsq]\r\n" + 
				"wrs-vhfuhw-fdqgb-frdwlqj-uhvhdufk-179[fhduw]\r\n" + 
				"ftzgxmbv-ynssr-vahvhetmx-mktbgbgz-397[truqi]\r\n" + 
				"xst-wigvix-tpewxmg-kveww-ywiv-xiwxmrk-984[nmrid]\r\n" + 
				"dkqjcbctfqwu-rncuvke-itcuu-ucngu-544[inaxl]\r\n" + 
				"hwdtljsnh-wfggny-fsfqdxnx-151[anbvm]\r\n" + 
				"aflwjfslagfsd-bwddqtwsf-vwhdgqewfl-970[sjqtc]\r\n" + 
				"hmsdqmzshnmzk-okzrshb-fqzrr-sqzhmhmf-885[qzbly]\r\n" + 
				"xcitgcpixdcpa-qphzti-gtrtxkxcv-141[ctxip]\r\n" + 
				"nbhofujd-tdbwfohfs-ivou-gjobodjoh-649[fnwgk]\r\n" + 
				"wfruflnsl-wfggny-xjwanhjx-905[lnztx]\r\n" + 
				"jrncbavmrq-rtt-fgbentr-975[rtbna]\r\n" + 
				"jqwpihizlwca-akidmvomz-pcvb-bziqvqvo-460[zakpd]\r\n" + 
				"oxmeeuruqp-nmewqf-eqdhuoqe-560[vtznk]\r\n" + 
				"plolwdub-judgh-udeelw-uhvhdufk-985[fnsty]\r\n" + 
				"kfg-jvtivk-treup-ivrthlzjzkzfe-503[ktvze]\r\n" + 
				"bqvvu-ywjzu-ykwpejc-naoawnyd-550[txaws]\r\n" + 
				"gsvvswmzi-wgezirkiv-lyrx-qerekiqirx-984[irevg]\r\n" + 
				"vcibutulxiom-yaa-uhufsmcm-552[gpimb]\r\n" + 
				"ugjjgkanw-usfvq-ugslafy-lwuzfgdgyq-918[gufaj]\r\n" + 
				"qfmcusbwq-foadouwbu-dzoghwq-ufogg-hsqvbczcum-506[uoqbc]\r\n" + 
				"qzchnzbshud-rbzudmfdq-gtms-zmzkxrhr-547[gxjyh]\r\n" + 
				"aflwjfslagfsd-usfvq-ugslafy-esjcwlafy-450[kjnil]\r\n" + 
				"nzwzcqfw-nsznzwlep-afcnsldtyr-951[hjrdi]\r\n" + 
				"aoubshwq-pogysh-kcfygvcd-740[pxyzt]\r\n" + 
				"zbytomdsvo-lkcuod-nocsqx-380[rqsuo]\r\n" + 
				"fmsledevhsyw-jpsaiv-wivzmgiw-542[pitok]\r\n" + 
				"qvbmzvibqwvit-ntwemz-abwziom-304[urjat]\r\n" + 
				"gvaaz-tdbwfohfs-ivou-eftjho-389[inlud]\r\n" + 
				"wlqqp-avccpsvre-ivjvrity-399[qcgto]\r\n" + 
				"shmml-pelbtravp-pubpbyngr-znantrzrag-897[prabn]\r\n" + 
				"iruzfrtkzmv-jtrmvexvi-ylek-jvimztvj-477[vijmr]\r\n" + 
				"hdgdovmt-bmvyz-xjgjmapg-xviyt-xjvodib-yzqzgjkhzio-499[tsira]\r\n" + 
				"willimcpy-yaa-omyl-nymncha-916[jtwau]\r\n" + 
				"dpssptjwf-gmpxfs-bobmztjt-389[kjlin]\r\n" + 
				"gpbepvxcv-snt-tcvxcttgxcv-245[etyfm]\r\n" + 
				"jxdkbqfz-ciltbo-cfkxkzfkd-367[xldij]\r\n" + 
				"udglrdfwlyh-sodvwlf-judvv-pdunhwlqj-231[rslnt]\r\n" + 
				"ygcrqpkbgf-ecpfa-eqcvkpi-gpikpggtkpi-440[pgkci]\r\n" + 
				"sno-rdbqds-eknvdq-otqbgzrhmf-391[yzexr]\r\n" + 
				"lzfmdshb-atmmx-bnmszhmldms-313[bacsl]\r\n" + 
				"qczcftiz-xszzmpsob-aofyshwbu-974[nxzyq]\r\n" + 
				"nwzekwypera-fahhuxawj-iwngapejc-420[yzguv]\r\n" + 
				"sbnqbhjoh-gmpxfs-efwfmpqnfou-389[sbwne]\r\n" + 
				"ugjjgkanw-xdgowj-ksdwk-554[sntqw]\r\n" + 
				"wdjcvuvmyjpn-kgvnodx-bmvnn-ncdkkdib-213[apifx]\r\n" + 
				"nvrgfezqvu-tyftfcrkv-uvgcfpdvek-269[tiuvc]\r\n" + 
				"uiovmbqk-jcvvg-abwziom-252[trvgn]\r\n" + 
				"fydelmwp-prr-ecltytyr-561[ryelp]\r\n" + 
				"ujoon-rpcsn-rdpixcv-jhtg-ithixcv-999[dcbon]\r\n" + 
				"ahngzyzqcntr-eknvdq-dmfhmddqhmf-131[dhmnq]\r\n" + 
				"iqmbazulqp-ngzzk-fqotzaxask-222[nmtgf]\r\n" + 
				"tfejldvi-xiruv-avccpsvre-nfibjyfg-113[vfice]\r\n" + 
				"wlsiayhcw-nij-mywlyn-xsy-nywbhifias-552[otlcf]\r\n" + 
				"muqfedyput-sqdto-seqjydw-skijecuh-iuhlysu-764[mqlfy]\r\n" + 
				"wbhsfbohwcboz-suu-hfowbwbu-324[bwhou]\r\n" + 
				"owshgfarwv-hdsklau-yjskk-suimakalagf-944[wtiza]\r\n" + 
				"ahngzyzqcntr-rbzudmfdq-gtms-bnmszhmldms-859[yvztm]\r\n" + 
				"qyujihctyx-vohhs-fiacmncwm-292[knzep]\r\n" + 
				"vetllbybxw-xzz-ybgtgvbgz-579[bgzlt]\r\n" + 
				"zekvierkzferc-tyftfcrkv-uvgrikdvek-477[pecqo]\r\n" + 
				"molgbzqfib-mixpqfz-doxpp-obzbfsfkd-367[ptnjg]\r\n" + 
				"oxmeeuruqp-otaoaxmfq-geqd-fqefuzs-924[puwxb]\r\n" + 
				"gpewwmjmih-nippcfier-gsrxemrqirx-646[tpsoa]\r\n" + 
				"xgvnndadzy-wvnfzo-gvwjmvojmt-603[nfstl]\r\n" + 
				"bjfutsneji-hfsid-htfynsl-htsyfnsrjsy-983[fdzej]\r\n" + 
				"pynffvsvrq-wryylorna-qrcnegzrag-351[dymsz]\r\n" + 
				"xjgjmapg-rzvkjiduzy-wvnfzo-kpmxcvndib-109[eyrcm]\r\n" + 
				"sebehvkb-rkddo-vydqdsydw-296[lgonm]\r\n" + 
				"hjgbwuladw-uzgugdslw-kwjnauwk-138[kgloe]\r\n" + 
				"ohmnuvfy-wuhxs-wiuncha-uwkocmcncih-890[tvylz]\r\n" + 
				"udpsdjlqj-iorzhu-wudlqlqj-491[rtwma]\r\n" + 
				"rdggdhxkt-ytaanqtpc-ejgrwphxcv-635[gtacd]\r\n" + 
				"eqttqukxg-ecpfa-yqtmujqr-596[hnvwy]\r\n" + 
				"laffe-lruckx-iutzgotsktz-852[nglsy]\r\n" + 
				"pkl-oaynap-xwogap-yqopkian-oanreya-394[ebzft]\r\n" + 
				"kyelcrga-afmamjyrc-bcnyprkclr-314[crayk]\r\n" + 
				"joufsobujpobm-dipdpmbuf-ufdiopmphz-571[ytgxs]\r\n" + 
				"ydjuhdqjyedqb-fbqijys-whqii-tufqhjcudj-894[ekswi]\r\n" + 
				"ajvyjprwp-kdwwh-mnenuxyvnwc-251[psaok]\r\n" + 
				"ibghopzs-suu-gsfjwqsg-220[qshwm]\r\n" + 
				"ugjjgkanw-hdsklau-yjskk-dstgjslgjq-502[lqxth]\r\n" + 
				"ugdgjxmd-hdsklau-yjskk-hmjuzskafy-788[vtyzi]\r\n" + 
				"lqwhuqdwlrqdo-mhoobehdq-oderudwrub-751[bzype]\r\n" + 
				"wdjcvuvmyjpn-kgvnodx-bmvnn-pnzm-oznodib-837[dcbaw]\r\n" + 
				"vcibutulxiom-qyujihctyx-wbiwifuny-fiacmncwm-994[tjxnm]\r\n" + 
				"vqr-ugetgv-dcumgv-tgegkxkpi-102[gvekt]\r\n" + 
				"encuukhkgf-lgnnadgcp-wugt-vguvkpi-752[vdmps]\r\n" + 
				"ktfitzbgz-wrx-vhgmtbgfxgm-267[twjsh]\r\n" + 
				"dzczkrip-xiruv-jtrmvexvi-ylek-kvtyefcfxp-243[vctis]\r\n" + 
				"pynffvsvrq-enzcntvat-qlr-qrcnegzrag-377[vdxzy]\r\n" + 
				"zixppfcfba-mixpqfz-doxpp-ixyloxqlov-679[pxfio]\r\n" + 
				"shoewudys-isqludwuh-xkdj-kiuh-juijydw-608[qedlg]\r\n" + 
				"qjopwxha-ywjzu-ykwpejc-nayaerejc-524[syznu]\r\n" + 
				"upq-tfdsfu-dboez-dpbujoh-nbobhfnfou-415[bfoud]\r\n" + 
				"fruurvlyh-udeelw-dqdobvlv-907[psznj]\r\n" + 
				"tcfkqcevkxg-dwppa-wugt-vguvkpi-336[klouj]\r\n" + 
				"plolwdub-judgh-gbh-uhdftxlvlwlrq-621[bnwav]\r\n" + 
				"chnylhuncihuf-wuhxs-wiuncha-xypyfijgyhn-110[hnuyc]\r\n" + 
				"froruixo-gbh-rshudwlrqv-153[amoni]\r\n" + 
				"clxalrtyr-nsznzwlep-zapcletzyd-327[guevs]\r\n" + 
				"xgsvgmotm-igtje-rghuxgzuxe-306[lcxzy]\r\n" + 
				"gpsxdprixkt-rpcsn-gtprfjxhxixdc-401[xprcd]\r\n" + 
				"lsyrkjkbnyec-nio-bokmaescsdsyx-874[nkgyo]\r\n" + 
				"buzahisl-ibuuf-zopwwpun-747[vwuxt]\r\n" + 
				"vqr-ugetgv-fag-yqtmujqr-882[gqrtu]\r\n" + 
				"bgmxkgtmbhgte-wrx-wxlbzg-137[zquts]\r\n" + 
				"ujqgywfau-ugdgjxmd-tskcwl-hmjuzskafy-112[yolzm]\r\n" + 
				"lqwhuqdwlrqdo-fkrfrodwh-frqwdlqphqw-985[qwdrf]\r\n" + 
				"surmhfwloh-fdqgb-uhvhdufk-621[dimhn]\r\n" + 
				"fhezusjybu-hqrryj-qdqboiyi-322[esjtk]\r\n" + 
				"gvaaz-tdbwfohfs-ivou-tijqqjoh-857[oafhi]\r\n" + 
				"xmtjbzidx-xviyt-mznzvmxc-759[xmzit]\r\n" + 
				"tfiifjzmv-gcrjkzt-xirjj-dribvkzex-399[ijrzf]\r\n" + 
				"zuv-ykixkz-kmm-uvkxgzouty-748[xvipz]\r\n" + 
				"gokzyxsjon-cmkfoxqob-rexd-domrxyvyqi-172[yfozw]\r\n" + 
				"plolwdub-judgh-frqvxphu-judgh-sodvwlf-judvv-frqwdlqphqw-959[duhlq]\r\n" + 
				"kfg-jvtivk-treup-tfekrzedvek-373[xyqzr]\r\n" + 
				"dmybmsuzs-oaddaeuhq-qss-pqeusz-586[mansh]\r\n" + 
				"ryexqpqhteki-rqiauj-iqbui-660[trqbl]\r\n" + 
				"ytu-xjhwjy-jll-wjhjnansl-125[zketn]\r\n" + 
				"fhezusjybu-muqfedyput-sqdto-udwyduuhydw-660[udyef]\r\n" + 
				"qspkfdujmf-dipdpmbuf-mphjtujdt-909[dwuov]\r\n" + 
				"cebwrpgvyr-enqvbnpgvir-enoovg-nanylfvf-533[akmyb]\r\n" + 
				"qfmcusbwq-pogysh-hfowbwbu-246[hdsbg]\r\n" + 
				"dmybmsuzs-bxmefuo-sdmee-abqdmfuaze-846[wsntq]\r\n" + 
				"sno-rdbqds-azrjds-nodqzshnmr-157[ogtbm]\r\n" + 
				"dpotvnfs-hsbef-cbtlfu-qvsdibtjoh-493[isjkl]\r\n" + 
				"nwilwcejc-lhwopey-cnwoo-odellejc-732[isofe]\r\n" + 
				"gokzyxsjon-mkxni-mykdsxq-bomosfsxq-822[nyudi]\r\n" + 
				"molgbzqfib-gbiivybxk-obxznrfpfqflk-679[wotra]\r\n" + 
				"cybyjqho-whqtu-rqiauj-jhqydydw-920[qyhjd]\r\n" + 
				"tinnm-pogysh-ghcfous-506[xtcso]\r\n" + 
				"myvybpev-cmkfoxqob-rexd-cdybkqo-146[boycd]\r\n" + 
				"pbeebfvir-shmml-enoovg-chepunfvat-949[nltsr]\r\n" + 
				"apuut-ezggtwzvi-yzqzgjkhzio-135[gdywb]\r\n" + 
				"xfbqpojafe-ezf-bobmztjt-441[qbwdc]\r\n" + 
				"ktfitzbgz-xzz-ehzblmbvl-943[zdigt]\r\n" + 
				"eqnqthwn-dcumgv-rwtejcukpi-232[umdca]\r\n" + 
				"xlrypetn-clmmte-opawzjxpye-379[bkvqj]\r\n" + 
				"fydelmwp-awldetn-rcldd-lylwjdtd-821[dlwet]\r\n" + 
				"owshgfarwv-esyfwlau-kusnwfywj-zmfl-ugflsafewfl-658[fwlsa]\r\n" + 
				"bnmrtldq-fqzcd-eknvdq-sqzhmhmf-807[snkmf]\r\n" + 
				"tyepcyletzylw-upwwjmply-cpnptgtyr-951[kyfol]\r\n" + 
				"ckgvutofkj-igtje-iugzotm-ynovvotm-462[otgvi]\r\n" + 
				"jshzzpmplk-ihzrla-klzpnu-981[yiaum]\r\n" + 
				"aoubshwq-qczcftiz-qvcqczohs-qighcasf-gsfjwqs-896[hyxzq]\r\n" + 
				"zilqwikbqdm-kpwkwtibm-ewzsapwx-668[zujgy]\r\n" + 
				"tpspahyf-nyhkl-jhukf-jvhapun-zopwwpun-669[slmnt]\r\n" + 
				"iuruxlar-lruckx-aykx-zkyzotm-852[kruxa]\r\n" + 
				"bdavqofuxq-bxmefuo-sdmee-dqeqmdot-144[gblym]\r\n" + 
				"eqnqthwn-ygcrqpkbgf-dcumgv-octmgvkpi-778[aznbf]\r\n" + 
				"amppmqgtc-kyelcrga-bwc-ylyjwqgq-522[aedsm]\r\n" + 
				"diozmivodjivg-xviyt-xjvodib-vxlpdndodji-109[dcnaq]\r\n" + 
				"wifilzof-wbiwifuny-uwkocmcncih-474[lcymu]\r\n" + 
				"dpmpsgvm-dboez-dpbujoh-efwfmpqnfou-779[ujlre]\r\n" + 
				"iwcjapey-fahhuxawj-nayaerejc-758[elvba]\r\n" + 
				"tcorcikpi-ejqeqncvg-vgejpqnqia-414[tywiv]\r\n" + 
				"excdklvo-mrymyvkdo-wkbuodsxq-120[ngxcw]\r\n" + 
				"nbhofujd-qmbtujd-hsbtt-bobmztjt-467[evdab]\r\n" + 
				"fubrjhqlf-gbh-pdqdjhphqw-959[nmklz]\r\n" + 
				"lxuxaodu-snuuhknjw-cnlqwxuxph-667[skyjn]\r\n" + 
				"ytu-xjhwjy-jll-zxjw-yjxynsl-931[tyzfu]\r\n" + 
				"cjpibabsepvt-sbccju-tbmft-519[ijnyz]\r\n" + 
				"bkwzkqsxq-lexxi-cobfsmoc-406[xbcko]\r\n" + 
				"yaxsnlcrun-dwbcjkun-kdwwh-orwjwlrwp-823[wnrcd]\r\n" + 
				"jchipqat-gpqqxi-ejgrwphxcv-739[pqcgh]\r\n" + 
				"etyyx-dff-cdudknoldms-937[dfyce]\r\n" + 
				"jsehsyafy-vqw-dgyaklauk-112[rhsgp]\r\n" + 
				"nzwzcqfw-awldetn-rcldd-opalcexpye-587[cdelw]\r\n" + 
				"nvrgfezqvu-wcfnvi-uvjzxe-139[vefnu]\r\n" + 
				"apuut-kgvnodx-bmvnn-ncdkkdib-915[stofz]\r\n" + 
				"hwdtljsnh-ojqqdgjfs-zxjw-yjxynsl-489[ftzsy]\r\n" + 
				"pualyuhapvuhs-jhukf-jvhapun-ayhpupun-877[oflqz]\r\n" + 
				"yaxsnlcrun-bljenwpna-qdwc-mnenuxyvnwc-407[ncwae]\r\n" + 
				"eqnqthwn-ejqeqncvg-nqikuvkeu-102[exsvc]\r\n" + 
				"ynssr-lvtoxgzxk-angm-tvjnblbmbhg-813[bgnlm]\r\n" + 
				"sehheiylu-zubboruqd-cqdqwucudj-400[ziuys]\r\n" + 
				"awzwhofm-ufors-qobrm-gozsg-246[zurge]\r\n" + 
				"ahngzyzqcntr-bzmcx-bnzshmf-lzmzfdldms-677[zmnbc]\r\n" + 
				"eza-dpncpe-awldetn-rcldd-wzrtdetnd-769[mtgef]\r\n" + 
				"htsxzrjw-lwfij-kqtbjw-wjxjfwhm-931[sjxwa]\r\n" + 
				"szfyrqriuflj-jtrmvexvi-ylek-nfibjyfg-373[alfvj]\r\n" + 
				"emixwvqhml-ntwemz-amzdqkma-876[lutzf]\r\n" + 
				"hwbba-fag-tgegkxkpi-726[zilbc]\r\n" + 
				"nwilwcejc-zua-zalhkuiajp-212[acijl]\r\n" + 
				"aflwjfslagfsd-esyfwlau-kusnwfywj-zmfl-mkwj-lwklafy-892[flwas]\r\n" + 
				"fmsledevhsyw-fewoix-xiglrspskc-256[sefil]\r\n" + 
				"zuv-ykixkz-lruckx-ykxboiky-306[odviu]\r\n" + 
				"ftzgxmbv-utldxm-ftgtzxfxgm-969[noxmk]\r\n" + 
				"ojk-nzxmzo-nxvqzibzm-cpio-mzvxlpdndodji-109[nfysr]\r\n" + 
				"molgbzqfib-mixpqfz-doxpp-abmilvjbkq-133[bimpq]\r\n" + 
				"zekvierkzferc-tyftfcrkv-jkfirxv-867[bjyft]\r\n" + 
				"gvaaz-ezf-bobmztjt-727[muyvq]\r\n" + 
				"mvhkvbdib-zbb-hvivbzhzio-551[yntvz]\r\n" + 
				"dwbcjkun-kdwwh-ujkxajcxah-641[jkwac]\r\n" + 
				"lhkhszqx-fqzcd-qzaahs-lzmzfdldms-209[tklbi]\r\n" + 
				"njmjubsz-hsbef-sbccju-qvsdibtjoh-571[tpswx]\r\n" + 
				"avw-zljyla-lnn-zopwwpun-149[lnwap]\r\n" + 
				"ckgvutofkj-hgyqkz-iayzuskx-ykxboik-358[mdnay]\r\n" + 
				"ytu-xjhwjy-hfsid-rfsfljrjsy-697[hmiag]\r\n" + 
				"houngfgxjuay-igtje-sgtgmksktz-384[monuj]\r\n" + 
				"qfkkj-ojp-ecltytyr-249[itsvz]\r\n" + 
				"udglrdfwlyh-udeelw-zrunvkrs-985[dlrue]\r\n" + 
				"gsvvswmzi-tpewxmg-kveww-viwievgl-178[vbmit]\r\n" + 
				"houngfgxjuay-yigbktmkx-natz-ykxboiky-930[bjyzu]\r\n" + 
				"eqttqukxg-uecxgpigt-jwpv-uvqtcig-102[gnzpx]\r\n" + 
				"amjmpdsj-bwc-pcqcypaf-288[gsywq]\r\n" + 
				"zntargvp-cynfgvp-tenff-npdhvfvgvba-793[vfngp]\r\n" + 
				"hdgdovmt-bmvyz-xcjxjgvoz-ozxcijgjbt-811[snjmz]\r\n" + 
				"etaqigpke-rncuvke-itcuu-ewuvqogt-ugtxkeg-154[eugtk]\r\n" + 
				"pbybeshy-sybjre-ybtvfgvpf-117[vszqj]\r\n" + 
				"vqr-ugetgv-tcddkv-uvqtcig-336[hzkdw]\r\n" + 
				"ykhknbqh-xwogap-pnwejejc-368[nqxzy]\r\n" + 
				"sehheiylu-rkddo-jusxdebewo-634[edhos]\r\n" + 
				"mvydjvxodqz-xcjxjgvoz-adivixdib-395[snpmt]\r\n" + 
				"ahngzyzqcntr-bzmcx-rsnqzfd-183[zfkpc]\r\n" + 
				"qxdwpopgsdjh-eaphixr-vgphh-detgpixdch-973[hpdgx]\r\n" + 
				"nij-mywlyn-jlidywncfy-jfumncw-alumm-zchuhwcha-682[nvybs]\r\n" + 
				"yhtwhnpun-jhukf-klzpnu-383[hnukp]\r\n" + 
				"yhtwhnpun-qlssfilhu-svnpzapjz-175[fopst]\r\n" + 
				"sgmtkzoi-jek-jkbkruvsktz-774[whzny]\r\n" + 
				"gifavtkzcv-wcfnvi-rercpjzj-711[cvfij]\r\n" + 
				"pkl-oaynap-acc-lqnydwoejc-940[aclno]\r\n" + 
				"vhkkhlbox-ktuubm-tvjnblbmbhg-475[gyhzn]\r\n" + 
				"guahyncw-wfummczcyx-wuhxs-guleyncha-422[iybfa]\r\n" + 
				"ydjuhdqjyedqb-hqrryj-sedjqydcudj-816[ftnej]\r\n" + 
				"rnqnyfwd-lwfij-gfxpjy-xytwflj-801[phsxc]\r\n" + 
				"vdzonmhydc-qzaahs-rdquhbdr-365[quvjr]\r\n" + 
				"ucynmlgxcb-zyqicr-rcaflmjmew-444[ncmzr]\r\n" + 
				"wfummczcyx-gcfcnuls-aluxy-luvvcn-jolwbumcha-864[culma]\r\n" + 
				"qzoggwtwsr-dfcxsqhwzs-suu-qighcasf-gsfjwqs-220[sgqwf]\r\n" + 
				"esyfwlau-mfklstdw-uzgugdslw-suimakalagf-918[igapw]\r\n" + 
				"zntargvp-wryylorna-genvavat-819[zmnji]\r\n" + 
				"ugfkmewj-yjsvw-uzgugdslw-umklgewj-kwjnauw-268[wugjk]\r\n" + 
				"xjinphzm-bmvyz-kgvnodx-bmvnn-pnzm-oznodib-109[rfzpw]\r\n" + 
				"mvydjvxodqz-mvwwdo-ozxcijgjbt-265[cxfdz]\r\n" + 
				"ujoon-rwdrdapit-bpcpvtbtci-375[ptbcd]\r\n" + 
				"aczupnetwp-dnlgpyrpc-sfye-afcnsldtyr-457[cydjq]\r\n" + 
				"uzfqdzmfuazmx-eomhqzsqd-tgzf-ymzmsqyqzf-898[zmqfd]\r\n" + 
				"lugjuacha-luvvcn-ijyluncihm-890[uclah]\r\n" + 
				"mtzslklcozfd-upwwjmply-lnbftdtetzy-379[yzwvu]\r\n" + 
				"myvybpev-oqq-bocokbmr-328[bomqv]\r\n" + 
				"tagzsrsjvgmk-xdgowj-ghwjslagfk-346[anbri]\r\n" + 
				"dpmpsgvm-ezf-mphjtujdt-493[dolas]\r\n" + 
				"votubcmf-sbccju-efqbsunfou-831[mnvky]\r\n" + 
				"zotts-xsy-nywbhifias-188[boqzr]\r\n" + 
				"gvcskirmg-glsgspexi-irkmriivmrk-646[igrkm]\r\n" + 
				"bnknqetk-cxd-cdozqsldms-625[dcknq]\r\n" + 
				"eqnqthwn-lgnnadgcp-cpcnauku-206[ytmnv]\r\n" + 
				"kmjezxodgz-wpiit-mznzvmxc-525[gtdob]\r\n" + 
				"dpotvnfs-hsbef-fhh-dvtupnfs-tfswjdf-519[fsdht]\r\n" + 
				"bwx-amkzmb-kpwkwtibm-lmdmtwxumvb-486[qmvwa]\r\n" + 
				"guahyncw-vohhs-lyuwkocmcncih-760[chnou]\r\n" + 
				"guahyncw-zfiqyl-nywbhifias-188[szhfp]\r\n" + 
				"ksodcbwnsr-foppwh-kcfygvcd-194[cdfko]\r\n" + 
				"gpewwmjmih-glsgspexi-jmrergmrk-542[bfqnt]\r\n" + 
				"vqr-ugetgv-fag-fgxgnqrogpv-440[gvfqr]\r\n" + 
				"encuukhkgf-etaqigpke-tcddkv-ceswkukvkqp-726[fijhw]\r\n" + 
				"yrwxefpi-fyrrc-hiwmkr-724[rfiwy]\r\n" + 
				"hwdtljsnh-bjfutsneji-hfsid-htfynsl-xfqjx-801[cdbsl]\r\n" + 
				"xjmmjndqz-xcjxjgvoz-jkzmvodjin-681[jmxzd]\r\n" + 
				"jqwpihizlwca-kivlg-tijwzibwzg-200[jpsbx]\r\n" + 
				"fodvvlilhg-froruixo-fkrfrodwh-wudlqlqj-621[yketz]\r\n" + 
				"wpuvcdng-fag-fgrctvogpv-518[klean]\r\n" + 
				"xgvnndadzy-xviyt-xjvodib-mzxzdqdib-421[oypak]\r\n" + 
				"kzeed-gzssd-qtlnxynhx-515[byszr]\r\n" + 
				"surmhfwloh-iorzhu-pdqdjhphqw-517[bhpqy]\r\n" + 
				"xcitgcpixdcpa-ytaanqtpc-rjhidbtg-htgkxrt-167[kjlxw]\r\n" + 
				"yuxufmdk-sdmpq-nmewqf-emxqe-248[cteon]\r\n" + 
				"iuxxuyobk-kmm-xkykgxin-306[hjxkm]\r\n" + 
				"joufsobujpobm-dboez-dpbujoh-mphjtujdt-675[fwybh]\r\n" + 
				"ajmrxjlcren-ouxfna-vjatncrwp-459[ajnrc]\r\n" + 
				"nwzekwypera-xwogap-paydjkhkcu-992[akpwe]\r\n" + 
				"aietsrmdih-gpewwmjmih-gerhc-stivexmsrw-282[eimhr]\r\n" + 
				"sxdobxkdsyxkv-nio-yzobkdsyxc-874[gpnhm]\r\n" + 
				"qfkkj-mldvpe-afcnsldtyr-639[dfkla]\r\n" + 
				"eqnqthwn-tcddkv-ucngu-674[lekca]\r\n" + 
				"lqxlxujcn-bcxajpn-667[aomrt]\r\n" + 
				"etaqigpke-dcumgv-wugt-vguvkpi-180[guvei]\r\n" + 
				"udglrdfwlyh-mhoobehdq-orjlvwlfv-413[mnizv]\r\n" + 
				"wyvqljapsl-jhukf-jvhapun-klzpnu-851[ixkjt]\r\n" + 
				"esyfwlau-jsttal-wfyafwwjafy-138[afwyj]\r\n" + 
				"bdavqofuxq-ymszqfuo-otaoaxmfq-fdmuzuzs-222[zbyrv]\r\n" + 
				"udskkaxawv-wyy-vwkayf-996[drsqf]\r\n" + 
				"qzoggwtwsr-qczcftiz-foppwh-gvwddwbu-246[btqac]\r\n" + 
				"yaxsnlcrun-yujbcrl-pajbb-nwprwnnarwp-745[cdwey]\r\n" + 
				"zhdsrqlchg-gbh-pdunhwlqj-439[hdglq]\r\n" + 
				"zekvierkzferc-nvrgfezqvu-treup-tfrkzex-ivjvrity-139[nthvs]\r\n" + 
				"vhkkhlbox-ktwbhtvmbox-vtgwr-vhtmbgz-ftgtzxfxgm-709[tbghv]\r\n" + 
				"kmjezxodgz-xmtjbzidx-agjrzm-rjmfncjk-863[hramk]\r\n" + 
				"qspkfdujmf-kfmmzcfbo-vtfs-uftujoh-129[nmtql]\r\n" + 
				"ipvohghykvbz-jhukf-jvhapun-jvuahputlua-591[cyqjf]\r\n" + 
				"lahxpnwrl-lqxlxujcn-vjwjpnvnwc-563[wcjme]\r\n" + 
				"sbejpbdujwf-qmbtujd-hsbtt-bdrvjtjujpo-493[jbtdu]\r\n" + 
				"ujoon-hrpktcvtg-wjci-stepgibtci-115[tdcgy]\r\n" + 
				"wlqqp-jtrmvexvi-ylek-rercpjzj-321[pyfoz]\r\n" + 
				"qyujihctyx-vohhs-yhachyylcha-604[xfbmz]\r\n" + 
				"eza-dpncpe-nlyoj-nzletyr-epnsyzwzrj-925[ytbnm]\r\n" + 
				"nzwzcqfw-awldetn-rcldd-lnbftdtetzy-743[tomzn]\r\n" + 
				"nwzekwypera-bhksan-yqopkian-oanreya-914[otvsm]\r\n" + 
				"avw-zljyla-wshzapj-nyhzz-klclsvwtlua-773[lazwh]\r\n" + 
				"plolwdub-judgh-iorzhu-vdohv-179[bmrjz]\r\n" + 
				"lnkfaypeha-zua-zarahkliajp-368[tzngm]\r\n" + 
				"slqryzjc-afmamjyrc-pcqcypaf-418[tjmsy]\r\n" + 
				"frqvxphu-judgh-vfdyhqjhu-kxqw-rshudwlrqv-387[dxhnm]\r\n" + 
				"uqtqbizg-ozilm-lgm-nqvivkqvo-928[rmnzf]\r\n" + 
				"lqwhuqdwlrqdo-edvnhw-ilqdqflqj-335[ctsda]\r\n" + 
				"zloolpfsb-mixpqfz-doxpp-obzbfsfkd-133[txiel]\r\n" + 
				"otzkxtgzoutgr-igtje-iugzotm-xkykgxin-592[zywxn]\r\n" + 
				"sbnqbhjoh-kfmmzcfbo-nbobhfnfou-701[fihgn]\r\n" + 
				"eqttqukxg-tcfkqcevkxg-rncuvke-itcuu-vtckpkpi-960[fobts]\r\n" + 
				"xgjougizobk-hatte-jkbkruvsktz-592[ktbgj]\r\n" + 
				"bqvvu-bhksan-pnwejejc-836[tcjgz]\r\n" + 
				"ikhcxvmbex-unggr-kxvxbobgz-787[opysz]\r\n" + 
				"jsehsyafy-usfvq-mkwj-lwklafy-320[msztr]\r\n" + 
				"ikhcxvmbex-ktuubm-ftgtzxfxgm-891[ojsny]\r\n" + 
				"ajvyjprwp-ajkkrc-mnenuxyvnwc-381[umkpn]\r\n" + 
				"pinovwgz-zbb-mznzvmxc-993[aumbt]\r\n" + 
				"ajyqqgdgcb-aylbw-rcaflmjmew-678[abcgj]\r\n" + 
				"houngfgxjuay-kmm-zxgototm-488[zudop]\r\n" + 
				"kmjezxodgz-ezggtwzvi-ozxcijgjbt-707[jyizu]\r\n" + 
				"eadalsjq-yjsvw-xdgowj-mkwj-lwklafy-762[jwald]\r\n" + 
				"aczupnetwp-ojp-dstaatyr-379[ftyeo]\r\n" + 
				"gvcskirmg-yrwxefpi-gerhc-gsexmrk-ywiv-xiwxmrk-958[rgixe]\r\n" + 
				"yuxufmdk-sdmpq-rxaiqd-pqbmdfyqzf-196[azivn]\r\n" + 
				"qyujihctyx-wuhxs-yhachyylcha-344[zdimn]\r\n" + 
				"rflsjynh-idj-yjhmstqtld-515[cvfph]\r\n" + 
				"lqwhuqdwlrqdo-edvnhw-rshudwlrqv-257[nlxst]\r\n" + 
				"odiih-kdwwh-mnbrpw-953[wdhib]\r\n" + 
				"ugdgjxmd-uzgugdslw-klgjsyw-814[cktda]\r\n" + 
				"mybbycsfo-pvygob-myxdksxwoxd-744[ifscp]\r\n" + 
				"bqvvu-ywjzu-odellejc-316[krcsj]\r\n" + 
				"nzcczdtgp-dnlgpyrpc-sfye-cplnbftdtetzy-743[kbdyu]\r\n" + 
				"pinovwgz-xcjxjgvoz-xjiovdihzio-525[mhjxn]\r\n" + 
				"ckgvutofkj-igtje-xkykgxin-878[vimez]\r\n" + 
				"rmn-qcapcr-zsllw-bcnjmwkclr-912[anzkg]\r\n" + 
				"ipvohghykvbz-yhiipa-zlycpjlz-227[oyzjt]\r\n" + 
				"nwilwcejc-nwxxep-wymqeoepekj-550[ztyes]\r\n" + 
				"uzfqdzmfuazmx-otaoaxmfq-pqhqxabyqzf-274[qafzm]\r\n" + 
				"hafgnoyr-qlr-chepunfvat-975[zauvm]\r\n" + 
				"irdgrxzex-treup-tfrkzex-ljvi-kvjkzex-269[lozqp]\r\n" + 
				"udskkaxawv-bwddqtwsf-klgjsyw-944[nmsxw]\r\n" + 
				"ujoon-rpcsn-gtprfjxhxixdc-921[xcjno]\r\n" + 
				"jrncbavmrq-enoovg-qrfvta-195[aqyxs]\r\n" + 
				"xgsvgmotm-yigbktmkx-natz-iutzgotsktz-462[smvtd]\r\n" + 
				"sxdobxkdsyxkv-mkxni-zebmrkcsxq-770[zkwax]\r\n" + 
				"zbytomdsvo-oqq-crszzsxq-614[iwqoc]\r\n" + 
				"wfruflnsl-kqtbjw-qfgtwfytwd-801[imsvp]\r\n" + 
				"nglmtuex-wrx-ybgtgvbgz-787[etuki]\r\n" + 
				"ixeumktoi-yigbktmkx-natz-uvkxgzouty-774[hylkz]\r\n" + 
				"cxy-bnlanc-ljwmh-cnlqwxuxph-719[unwgt]\r\n" + 
				"xcitgcpixdcpa-ytaanqtpc-hidgpvt-453[cptai]\r\n" + 
				"udglrdfwlyh-fkrfrodwh-fxvwrphu-vhuylfh-985[ntvum]\r\n" + 
				"dsxxw-glrcplyrgmlyj-afmamjyrc-yaosgqgrgml-912[hstuv]\r\n" + 
				"nglmtuex-xzz-wxiehrfxgm-267[wjyqr]\r\n" + 
				"ixccb-fdqgb-xvhu-whvwlqj-153[bchqv]\r\n" + 
				"vhehkyne-vtgwr-vhtmbgz-ehzblmbvl-449[mnuht]\r\n" + 
				"xgjougizobk-hgyqkz-jkyomt-774[sdeqt]\r\n" + 
				"ktiaaqnqml-zijjqb-abwziom-252[fgisn]\r\n" + 
				"glrcplyrgmlyj-cee-pcyaosgqgrgml-470[osmrp]\r\n" + 
				"qjopwxha-lhwopey-cnwoo-nawymqeoepekj-472[rfgnc]\r\n" + 
				"plolwdub-judgh-fdqgb-vklsslqj-959[ldbgj]\r\n" + 
				"yknnkoera-zua-wymqeoepekj-472[rsqmj]\r\n" + 
				"ujoon-ytaanqtpc-gtrtxkxcv-635[tacno]\r\n" + 
				"tcfkqcevkxg-fag-ujkrrkpi-856[njiek]\r\n" + 
				"uzfqdzmfuazmx-bdavqofuxq-qss-dqmocgueufuaz-170[wktxs]\r\n" + 
				"ltpedcxots-rpcsn-hwxeexcv-375[draoy]\r\n" + 
				"zntargvp-pnaql-nanylfvf-585[iejdf]\r\n" + 
				"lqwhuqdwlrqdo-vfdyhqjhu-kxqw-orjlvwlfv-101[szrtk]\r\n" + 
				"dyz-combod-oqq-cdybkqo-614[odqbc]\r\n" + 
				"jyddc-fyrrc-wepiw-802[chjtm]\r\n" + 
				"nglmtuex-yehpxk-phkdlahi-319[cjshn]\r\n" + 
				"surmhfwloh-fdqgb-xvhu-whvwlqj-205[vzite]\r\n" + 
				"wrs-vhfuhw-udeelw-dqdobvlv-179[znwyc]\r\n" + 
				"myxcewob-qbkno-lkcuod-cdybkqo-328[ysbjw]\r\n" + 
				"ixeumktoi-inuiurgzk-giwaoyozout-124[vnlcr]\r\n" + 
				"vhehkyne-utldxm-nlxk-mxlmbgz-839[cnryt]\r\n" + 
				"tagzsrsjvgmk-tskcwl-klgjsyw-216[sgkjl]\r\n" + 
				"bjfutsneji-idj-ijajqturjsy-203[gkoyb]\r\n" + 
				"plolwdub-judgh-gbh-wudlqlqj-335[snabj]\r\n" + 
				"ydjuhdqjyedqb-sqdto-seqjydw-tufbeocudj-504[cawtu]\r\n" + 
				"fkqbokxqflkxi-ciltbo-jxohbqfkd-913[mthlx]\r\n" + 
				"eadalsjq-yjsvw-tskcwl-sfsdqkak-840[sakdj]\r\n" + 
				"tipfxvezt-dzczkrip-xiruv-irsszk-ivtvzmzex-347[ewgst]\r\n" + 
				"plolwdub-judgh-fdqgb-pdqdjhphqw-309[slvtc]\r\n" + 
				"nwilwcejc-iehepwnu-cnwza-ywjzu-naoawnyd-914[wnace]\r\n" + 
				"lejkrscv-irsszk-fgvirkzfej-633[krsef]\r\n" + 
				"qzlozfhmf-bgnbnkzsd-qdrdzqbg-105[ltrxz]\r\n" + 
				"hmsdqmzshnmzk-bkzrrhehdc-idkkxadzm-sqzhmhmf-833[vsftk]\r\n" + 
				"mbggf-wyvqljapsl-ibuuf-ylhjxbpzpapvu-565[kxetg]\r\n" + 
				"vehmsegxmzi-tpewxmg-kveww-erepcwmw-360[ewmgp]\r\n" + 
				"mhi-lxvkxm-xzz-wxoxehifxgm-475[zvuxn]\r\n" + 
				"pejji-nio-gybucryz-848[scvwe]\r\n" + 
				"oqnidbshkd-rbzudmfdq-gtms-cdozqsldms-729[dsmqb]\r\n" + 
				"hmsdqmzshnmzk-lzfmdshb-idkkxadzm-btrsnldq-rdquhbd-937[yncvm]\r\n" + 
				"fmsledevhsyw-wgezirkiv-lyrx-jmrergmrk-932[bgytv]\r\n" + 
				"houngfgxjuay-lruckx-iayzuskx-ykxboik-462[vefmw]\r\n" + 
				"njmjubsz-hsbef-dboez-vtfs-uftujoh-337[bfjsu]\r\n" + 
				"lhkhszqx-fqzcd-azrjds-cdozqsldms-157[amnks]\r\n" + 
				"dpotvnfs-hsbef-dipdpmbuf-tbmft-103[zhrge]\r\n" + 
				"sebehvkb-rqiauj-jusxdebewo-166[jscdv]\r\n" + 
				"diozmivodjivg-pinovwgz-ezggtwzvi-mznzvmxc-811[ysntj]\r\n" + 
				"kwtwznct-kpwkwtibm-zmamizkp-902[kwmtz]\r\n" + 
				"jyddc-fyrrc-asvowlst-828[ybfgd]\r\n" + 
				"tagzsrsjvgmk-vqw-ugflsafewfl-580[xmqnr]\r\n" + 
				"mfklstdw-tmffq-kwjnauwk-502[fkwmt]\r\n" + 
				"xcitgcpixdcpa-rpcsn-rdpixcv-rdcipxcbtci-453[ynzqc]\r\n" + 
				"fmsledevhsyw-wgezirkiv-lyrx-hitevxqirx-542[eirvx]\r\n" + 
				"ojk-nzxmzo-zbb-ozxcijgjbt-213[zbjox]\r\n" + 
				"gpewwmjmih-hci-vigimzmrk-932[injxy]\r\n" + 
				"gpsxdprixkt-qjccn-hpath-349[pchtx]\r\n" + 
				"diozmivodjivg-nxvqzibzm-cpio-omvdidib-109[jivdx]\r\n" + 
				"dzczkrip-xiruv-srjbvk-crsfirkfip-269[mbnda]\r\n" + 
				"lgh-kwujwl-usfvq-ugslafy-vwhsjlewfl-580[ftwxr]\r\n" + 
				"ymszqfuo-rxaiqd-xmnadmfadk-456[smxyt]\r\n" + 
				"slqryzjc-njyqrga-epyqq-kypicrgle-158[ktcij]\r\n" + 
				"apwmeclga-hcjjwzcyl-bctcjmnkclr-496[cjlam]\r\n" + 
				"pejji-zvkcdsm-qbkcc-gybucryz-770[junto]\r\n" + 
				"kzeed-kqtbjw-xmnuunsl-931[eknub]\r\n" + 
				"fhezusjybu-sedikcuh-whqtu-hqrryj-cqhaujydw-322[kogjn]\r\n" + 
				"encuukhkgf-uecxgpigt-jwpv-fgrnqaogpv-648[gpuce]\r\n" + 
				"fnjyxwrinm-kjbtnc-bjunb-225[nbjcf]\r\n" + 
				"gifavtkzcv-sleep-kvtyefcfxp-737[cusry]\r\n" + 
				"nij-mywlyn-xsy-fiacmncwm-266[txfyk]\r\n" + 
				"pxtihgbsxw-cxeeruxtg-labiibgz-501[vfryk]\r\n" + 
				"oaxadrgx-vqxxknqmz-etubbuzs-612[gmzpy]\r\n" + 
				"oxaflxzqfsb-yxphbq-obzbfsfkd-497[gsjqc]\r\n" + 
				"lxaaxbren-ajmrxjlcren-kdwwh-uxprbcrlb-563[rxabl]\r\n" + 
				"drxevkzt-jtrmvexvi-ylek-ivrthlzjzkzfe-893[evzkr]\r\n" + 
				"xst-wigvix-veqtekmrk-hci-hizipstqirx-334[itxeh]\r\n" + 
				"hqcfqwydw-sxesebqju-bewyijysi-556[upyan]\r\n" + 
				"oxjmxdfkd-avb-abmxoqjbkq-809[cuyzr]\r\n" + 
				"vkppo-isqludwuh-xkdj-husuylydw-686[sfajr]\r\n" + 
				"nwilwcejc-ykjoqian-cnwza-ywjzu-ykjpwejiajp-576[jwaci]\r\n" + 
				"gpewwmjmih-hci-jmrergmrk-360[jftsi]\r\n" + 
				"ibghopzs-gqojsbusf-vibh-gvwddwbu-324[ratwb]\r\n" + 
				"mvhkvbdib-wvnfzo-gvwjmvojmt-785[zljyf]\r\n" + 
				"lahxpnwrl-mhn-bjunb-719[kexws]\r\n" + 
				"iuxxuyobk-inuiurgzk-vaxingyotm-722[snwtx]\r\n" + 
				"rnqnyfwd-lwfij-xhfajsljw-mzsy-wjhjnansl-671[nyphz]\r\n" + 
				"uwtojhynqj-wfggny-yjhmstqtld-229[qzmtg]\r\n" + 
				"dfcxsqhwzs-pibbm-qighcasf-gsfjwqs-220[iucxp]\r\n" + 
				"eqttqukxg-dwppa-uvqtcig-362[setiw]\r\n" + 
				"gcfcnuls-aluxy-vohhs-guleyncha-500[gchrt]\r\n" + 
				"ocipgvke-dwppa-gpikpggtkpi-518[tihzs]\r\n" + 
				"qfmcusbwq-dzoghwq-ufogg-cdsfohwcbg-454[ylkjh]\r\n" + 
				"yhtwhnpun-msvdly-zlycpjlz-123[qjnxy]\r\n" + 
				"lxuxaodu-ljwmh-lxjcrwp-anjlzdrbrcrxw-199[lnesc]\r\n" + 
				"qekrixmg-jpsaiv-tyvglewmrk-646[egikm]\r\n" + 
				"emixwvqhml-moo-wxmzibqwva-720[mwioq]\r\n" + 
				"kpvgtpcvkqpcn-dwppa-cpcnauku-934[bmprc]\r\n" + 
				"lugjuacha-vumeyn-mylpcwym-604[muyac]\r\n" + 
				"lzfmdshb-ahngzyzqcntr-dff-nodqzshnmr-937[pwdof]\r\n" + 
				"sbqiiyvyut-vkppo-zubboruqd-cqdqwucudj-348[osntj]\r\n" + 
				"ubhatstkwhnl-wrx-ftkdxmbgz-111[fojwk]\r\n" + 
				"mvhkvbdib-zbb-ncdkkdib-967[brnch]\r\n" + 
				"vetllbybxw-utldxm-mktbgbgz-579[gljhz]\r\n" + 
				"htsxzrjw-lwfij-gzssd-btwpxmtu-333[rhtqs]\r\n" + 
				"nzcczdtgp-nlyoj-nzletyr-xlcvpetyr-587[smnct]\r\n" + 
				"pybgmyargtc-zsllw-jyzmpyrmpw-366[zutsy]\r\n" + 
				"kfg-jvtivk-upv-jvimztvj-997[xicjt]\r\n" + 
				"kpvgtpcvkqpcn-hnqygt-ewuvqogt-ugtxkeg-388[gtkpq]\r\n" + 
				"ktiaaqnqml-kpwkwtibm-mvoqvmmzqvo-564[asert]\r\n" + 
				"mfklstdw-uzgugdslw-dgyaklauk-892[dgklu]\r\n" + 
				"gzefmnxq-pkq-xmnadmfadk-196[madfk]\r\n" + 
				"qcbgiasf-ufors-dzoghwq-ufogg-ghcfous-714[yiavh]\r\n" + 
				"veqtekmrk-nippcfier-asvowlst-958[thmsn]\r\n" + 
				"iehepwnu-cnwza-zua-skngodkl-134[naeku]\r\n" + 
				"xfbqpojafe-fhh-tfswjdft-571[fhjta]\r\n" + 
				"laffe-jek-ygrky-150[pjbaq]\r\n" + 
				"lxwbdvna-pajmn-kjbtnc-fxatbqxy-459[xbmlo]\r\n" + 
				"wkqxodsm-bkllsd-bomosfsxq-276[isaey]\r\n" + 
				"ovbunmneqbhf-fpniratre-uhag-qrirybczrag-741[rabne]\r\n" + 
				"xjmmjndqz-mvwwdo-kpmxcvndib-395[hyolt]\r\n" + 
				"zbytomdsvo-mkxni-mykdsxq-bomosfsxq-276[efcvd]\r\n" + 
				"jqwpihizlwca-bwx-amkzmb-jcvvg-ivitgaqa-252[dsmej]\r\n" + 
				"dszphfojd-sbccju-nbobhfnfou-805[bfocd]\r\n" + 
				"hwbba-lgnnadgcp-vgejpqnqia-830[ptkvu]\r\n" + 
				"wfintfhynaj-hmthtqfyj-fhvznxnynts-125[nfhty]\r\n" + 
				"wfummczcyx-wbiwifuny-mbcjjcha-864[cmwbf]\r\n" + 
				"tfcfiwlc-avccpsvre-uvjzxe-269[cvefa]\r\n" + 
				"dlhwvupglk-msvdly-dvyrzovw-331[nmeji]\r\n" + 
				"fnjyxwrinm-npp-orwjwlrwp-979[tqyvp]\r\n" + 
				"sgmtkzoi-hgyqkz-xkgiwaoyozout-904[ogkzi]\r\n" + 
				"qjopwxha-oywrajcan-dqjp-opknwca-680[qgsnh]\r\n" + 
				"oxjmxdfkd-zxkav-pxibp-185[mtfwl]\r\n" + 
				"mfklstdw-wyy-lwuzfgdgyq-814[iznma]\r\n" + 
				"zlilocri-bdd-pefmmfkd-341[intay]\r\n" + 
				"rwcnawjcrxwju-kdwwh-cajrwrwp-849[wrcja]\r\n" + 
				"xmrrq-uzgugdslw-jwuwanafy-372[uwagr]\r\n" + 
				"kzgwomvqk-zijjqb-ewzsapwx-278[wzjkq]\r\n" + 
				"lxuxaodu-ouxfna-ujkxajcxah-277[xaujo]\r\n" + 
				"nwzekwypera-iehepwnu-cnwza-fahhuxawj-zalhkuiajp-186[nbzay]\r\n" + 
				"vhkkhlbox-ktuubm-hixktmbhgl-943[byecg]\r\n" + 
				"qxdwpopgsdjh-uadltg-prfjxhxixdc-141[eqzvr]\r\n" + 
				"kyelcrga-zsllw-pcacgtgle-522[lcgae]\r\n" + 
				"qzoggwtwsr-ksodcbwnsr-dzoghwq-ufogg-zcuwghwqg-818[dzclv]\r\n" + 
				"xekdwvwnzkqo-lhwopey-cnwoo-bejwjyejc-238[ksrhc]\r\n" + 
				"npmhcargjc-cee-bctcjmnkclr-782[tgrxz]\r\n" + 
				"hwbba-ecpfa-eqcvkpi-ceswkukvkqp-336[kcepa]\r\n" + 
				"uwtojhynqj-hmthtqfyj-wjhjnansl-437[kylvd]\r\n" + 
				"sxdobxkdsyxkv-bknsykmdsfo-oqq-kmaescsdsyx-380[skdxo]\r\n" + 
				"rmn-qcapcr-afmamjyrc-dglylagle-158[aclmr]\r\n" + 
				"raphhxuxts-gpqqxi-advxhixrh-583[vuafx]\r\n" + 
				"nij-mywlyn-xsy-jolwbumcha-760[mkhgy]\r\n" + 
				"lnkfaypeha-xqjju-odellejc-680[ghsol]\r\n" + 
				"ytu-xjhwjy-wfggny-zxjw-yjxynsl-931[tynvp]\r\n" + 
				"myxcewob-qbkno-lkcuod-nofovyzwoxd-744[obcdk]\r\n" + 
				"diozmivodjivg-mvwwdo-gvwjmvojmt-161[vpsib]\r\n" + 
				"vhkkhlbox-cxeeruxtg-ehzblmbvl-787[behlx]\r\n" + 
				"iruzfrtkzmv-treup-tfrkzex-jvimztvj-841[xmwvi]\r\n" + 
				"kyelcrga-cee-pcacgtgle-730[yladm]\r\n" + 
				"iutyaskx-mxgjk-yigbktmkx-natz-jkyomt-436[tznsm]\r\n" + 
				"hvbizodx-agjrzm-ncdkkdib-421[iqnst]\r\n" + 
				"xzwrmkbqtm-kivlg-lmxtwgumvb-252[tkefm]\r\n" + 
				"udpsdjlqj-vfdyhqjhu-kxqw-pdqdjhphqw-439[dqhjp]\r\n" + 
				"mbggf-ibuuf-mpuhujpun-695[gnpdh]\r\n" + 
				"irdgrxzex-avccpsvre-ivtvzmzex-997[stcvr]\r\n" + 
				"sawlkjevaz-ywjzu-opknwca-602[awjkz]\r\n" + 
				"wlqqp-irsszk-tljkfdvi-jvimztv-217[mrqcl]\r\n" + 
				"sehheiylu-tou-sedjqydcudj-192[teamg]\r\n" + 
				"ajyqqgdgcb-pyzzgr-kylyeckclr-470[cjtul]\r\n" + 
				"ziuxioqvo-moo-bziqvqvo-278[ixnjm]\r\n" + 
				"vjpwncrl-kjbtnc-nwprwnnarwp-199[nwprc]\r\n" + 
				"wpuvcdng-gii-hkpcpekpi-986[picgk]\r\n" + 
				"dmybmsuzs-nmewqf-iadwetab-456[mabde]\r\n" + 
				"rtqlgevkng-tcddkv-fgukip-830[juyzr]\r\n" + 
				"votubcmf-dipdpmbuf-sfbdrvjtjujpo-727[rcslk]\r\n" + 
				"vhkkhlbox-wrx-ftgtzxfxgm-163[txmwq]\r\n" + 
				"zloolpfsb-mixpqfz-doxpp-qbzeklildv-289[lpozb]\r\n" + 
				"rkpqxyib-zxkav-zlxqfkd-xkxivpfp-393[bpquj]\r\n" + 
				"pbafhzre-tenqr-qlr-freivprf-455[byihv]\r\n" + 
				"kzeed-hfsid-htfynsl-jslnsjjwnsl-905[egluv]\r\n" + 
				"nlyoj-nzletyr-lylwjdtd-899[ymzvu]\r\n" + 
				"laffe-pkrrehkgt-sgxqkzotm-800[gsdnt]\r\n" + 
				"ynukcajey-xwogap-zaoecj-212[ewjah]\r\n" + 
				"rgndvtcxr-bxaxipgn-vgpst-hrpktcvtg-wjci-sthxvc-661[zwgis]\r\n" + 
				"ujqgywfau-vqw-vwnwdghewfl-580[istzh]\r\n" + 
				"jyddc-tvsnigxmpi-fewoix-hiwmkr-178[idmwx]\r\n" + 
				"fab-eqodqf-omzpk-etubbuzs-430[befoq]\r\n" + 
				"ibghopzs-suu-fsoqeiwgwhwcb-792[qzyrk]\r\n" + 
				"sedikcuh-whqtu-uww-vydqdsydw-166[dwuhq]\r\n" + 
				"cjpibabsepvt-qmbtujd-hsbtt-tupsbhf-467[wsrek]\r\n" + 
				"aietsrmdih-ikk-gsrxemrqirx-594[irekm]\r\n" + 
				"bwx-amkzmb-jcvvg-bziqvqvo-694[vbmqz]\r\n" + 
				"ixccb-exqqb-xvhu-whvwlqj-647[qxbch]\r\n" + 
				"nwlddtqtpo-nlyoj-dezclrp-639[dlnop]\r\n" + 
				"ahngzyzqcntr-azrjds-otqbgzrhmf-833[oquzx]\r\n" + 
				"xcitgcpixdcpa-gpqqxi-ejgrwphxcv-193[cpxgi]\r\n" + 
				"buzahisl-zjhclunly-obua-svnpzapjz-643[zalub]\r\n" + 
				"excdklvo-mkxni-mykdsxq-nozkbdwoxd-458[fxjwy]\r\n" + 
				"jvyyvzpcl-jyfvnlupj-msvdly-klclsvwtlua-253[injkl]\r\n" + 
				"emixwvqhml-akidmvomz-pcvb-zmkmqdqvo-434[mvqdi]\r\n" + 
				"dszphfojd-qmbtujd-hsbtt-sfbdrvjtjujpo-831[ykcho]\r\n" + 
				"kwzzwaqdm-zijjqb-camz-bmabqvo-902[zabmq]\r\n" + 
				"nvrgfezqvu-irsszk-jkfirxv-789[neysm]\r\n" + 
				"yflexwxoalrp-zelzlixqb-jxohbqfkd-679[lxbef]\r\n" + 
				"wfummczcyx-yaa-nluchcha-344[rmpgs]\r\n" + 
				"tcfkqcevkxg-gii-ocpcigogpv-674[stfma]\r\n" + 
				"nwzekwypera-ywjzu-ajcejaanejc-316[xoprq]\r\n" + 
				"qzlozfhmf-idkkxadzm-btrsnldq-rdquhbd-105[pawus]\r\n" + 
				"uqtqbizg-ozilm-kivlg-uizsmbqvo-356[xhvzm]\r\n" + 
				"apuut-kgvnodx-bmvnn-mzvxlpdndodji-473[dnvmo]\r\n" + 
				"wfummczcyx-dyffsvyuh-guhuaygyhn-500[yufhc]\r\n" + 
				"cybyjqho-whqtu-shoewudys-vbemuh-tuiywd-842[huywb]\r\n" + 
				"sedikcuh-whqtu-tou-jhqydydw-920[dhuqt]\r\n" + 
				"zekvierkzferc-wcfnvi-ljvi-kvjkzex-815[ibzsg]\r\n" + 
				"froruixo-udeelw-orjlvwlfv-777[zyusv]\r\n" + 
				"oxmeeuruqp-ngzzk-qzsuzqqduzs-222[mcqzj]\r\n" + 
				"gpewwmjmih-ikk-ywiv-xiwxmrk-568[uszki]\r\n" + 
				"aietsrmdih-jpsaiv-wepiw-334[iaeps]\r\n" + 
				"joufsobujpobm-cbtlfu-dvtupnfs-tfswjdf-441[fubjo]\r\n" + 
				"xst-wigvix-hci-viwievgl-256[jnlst]\r\n" + 
				"oknkvcta-itcfg-wpuvcdng-dwppa-qrgtcvkqpu-414[dcxst]\r\n" + 
				"rnqnyfwd-lwfij-gfxpjy-htsyfnsrjsy-957[whlxr]\r\n" + 
				"sbnqbhjoh-fhh-tbmft-181[jndic]\r\n" + 
				"slqryzjc-afmamjyrc-qcptgacq-236[soytq]\r\n" + 
				"rgllk-qss-ymdwqfuzs-768[ynsjx]\r\n" + 
				"nwilwcejc-ywjzu-ykwpejc-pnwejejc-966[fthzx]\r\n" + 
				"gokzyxsjon-lexxi-gybucryz-146[qomrj]\r\n" + 
				"cybyjqho-whqtu-zubboruqd-cqhaujydw-192[naxrp]\r\n" + 
				"esyfwlau-bwddqtwsf-vwkayf-294[acbmr]\r\n" + 
				"shmml-rtt-znantrzrag-455[vseqh]\r\n" + 
				"qlm-pbzobq-yrkkv-obpbxoze-601[lfewg]\r\n" + 
				"fbebmtkr-zktwx-utldxm-ybgtgvbgz-995[stygr]\r\n" + 
				"ikhcxvmbex-ietlmbv-zktll-vnlmhfxk-lxkobvx-943[lxkvb]\r\n" + 
				"rgndvtcxr-hrpktcvtg-wjci-prfjxhxixdc-193[crxtd]\r\n" + 
				"ucynmlgxcb-pyzzgr-kypicrgle-158[qtuyz]\r\n" + 
				"wpuvcdng-lgnnadgcp-vtckpkpi-466[sftpn]\r\n" + 
				"tfiifjzmv-treup-kirzezex-633[gjtxn]\r\n" + 
				"cvabijtm-jiasmb-lmxizbumvb-356[axbtn]\r\n" + 
				"xgvnndadzy-kgvnodx-bmvnn-yzkgjthzio-395[byaut]\r\n" + 
				"rdchjbtg-vgpst-tvv-pcpanhxh-765[hptvc]\r\n" + 
				"hqcfqwydw-isqludwuh-xkdj-cqhaujydw-322[mzgty]\r\n" + 
				"hvbizodx-wvnfzo-gjbdnodxn-577[kljip]\r\n" + 
				"udpsdjlqj-fruurvlyh-fdqgb-frdwlqj-vdohv-283[ktzrm]\r\n" + 
				"xjmmjndqz-zbb-jkzmvodjin-707[jmzbd]\r\n" + 
				"glrcplyrgmlyj-zsllw-nspafyqgle-184[ptidc]\r\n" + 
				"zvyvgnel-tenqr-cebwrpgvyr-fpniratre-uhag-hfre-grfgvat-377[zesyf]\r\n" + 
				"ubhatstkwhnl-vahvhetmx-wxitkmfxgm-605[qzvme]\r\n" + 
				"iqmbazulqp-dmnnuf-ruzmzouzs-898[shtag]\r\n" + 
				"surmhfwloh-gbh-ghsorbphqw-179[sickj]\r\n" + 
				"htqtwkzq-uqfxynh-lwfxx-xjwanhjx-593[rwtbd]\r\n" + 
				"kgjgrypw-epybc-njyqrga-epyqq-rpyglgle-600[jkcuz]\r\n" + 
				"ktiaaqnqml-zijjqb-zmikycqaqbqwv-642[qaibj]\r\n" + 
				"udglrdfwlyh-fdqgb-frdwlqj-sxufkdvlqj-803[cmkaq]\r\n" + 
				"oxmeeuruqp-pkq-pqbmdfyqzf-196[qpefm]\r\n" + 
				"dzczkrip-xiruv-sleep-ivjvrity-893[xjomn]\r\n" + 
				"dmpuamofuhq-ymszqfuo-otaoaxmfq-fdmuzuzs-482[mufoa]\r\n" + 
				"nbhofujd-ezf-tbmft-389[cjgtr]\r\n" + 
				"uzfqdzmfuazmx-otaoaxmfq-iadwetab-820[afmzd]\r\n" + 
				"froruixo-fdqgb-oderudwrub-205[ziyjo]\r\n" + 
				"ugjjgkanw-kusnwfywj-zmfl-dstgjslgjq-840[nhxgt]\r\n" + 
				"zhdsrqlchg-iorzhu-sxufkdvlqj-101[qtzca]\r\n" + 
				"dsxxw-aylbw-amyrgle-qcptgacq-912[qdwmn]\r\n" + 
				"veqtekmrk-hci-xiglrspskc-282[tfuln]\r\n" + 
				"qcffcgwjs-forwcoqhwjs-rms-hfowbwbu-480[hgnsl]\r\n" + 
				"jvsvymbs-jovjvshal-zhslz-539[ocmvj]\r\n" + 
				"enqvbnpgvir-rtt-fuvccvat-195[nmrlc]\r\n" + 
				"oxmeeuruqp-bxmefuo-sdmee-geqd-fqefuzs-170[uenfm]\r\n" + 
				"wlsiayhcw-wfummczcyx-xsy-xyjfisgyhn-214[zpqtr]\r\n" + 
				"jxdkbqfz-avb-obxznrfpfqflk-133[fbkqx]\r\n" + 
				"zvyvgnel-tenqr-pnaql-bcrengvbaf-195[eghnt]\r\n" + 
				"diozmivodjivg-ytz-vxlpdndodji-551[diovj]\r\n" + 
				"jyddc-jpsaiv-ywiv-xiwxmrk-308[idjvw]\r\n" + 
				"pbafhzre-tenqr-enoovg-hfre-grfgvat-403[erfga]\r\n" + 
				"pbeebfvir-enoovg-ernpdhvfvgvba-793[vebfg]\r\n" + 
				"wfummczcyx-zfiqyl-uhufsmcm-292[tvcdw]\r\n" + 
				"kwvacumz-ozilm-zijjqb-ivitgaqa-746[iazjm]\r\n" + 
				"udpsdjlqj-ixccb-sodvwlf-judvv-ghyhorsphqw-465[kgyhw]\r\n" + 
				"tcrjjzwzvu-wcfnvi-rthlzjzkzfe-451[zjcfr]\r\n" + 
				"qxdwpopgsdjh-rpcsn-htgkxrth-947[dkwlb]\r\n" + 
				"yaxsnlcrun-kdwwh-bnaerlnb-953[zyncx]\r\n" + 
				"zhdsrqlchg-vfdyhqjhu-kxqw-xvhu-whvwlqj-699[mriyj]\r\n" + 
				"bkzrrhehdc-bgnbnkzsd-lzqjdshmf-417[izpxt]\r\n" + 
				"nwzekwypera-fahhuxawj-wjwhuoeo-862[wsmnu]\r\n" + 
				"zgmfyxypbmsq-bwc-rcaflmjmew-964[nmpwb]\r\n" + 
				"guahyncw-wuhxs-wihnuchgyhn-188[vmayn]\r\n" + 
				"kwtwznct-jcvvg-uizsmbqvo-980[ryzva]\r\n" + 
				"udskkaxawv-lgh-kwujwl-uzgugdslw-vwhdgqewfl-138[trijm]\r\n" + 
				"shoewudys-rkddo-huiuqhsx-868[tozlb]\r\n" + 
				"bnknqetk-atmmx-rzkdr-183[zbyuw]\r\n" + 
				"hwdtljsnh-idj-xytwflj-983[sztqp]\r\n" + 
				"tipfxvezt-jtrmvexvi-ylek-cfxzjkztj-165[gwmzp]\r\n" + 
				"clotzlnetgp-nsznzwlep-opdtry-327[khryz]\r\n" + 
				"mhi-lxvkxm-bgmxkgtmbhgte-wrx-ltexl-449[cfrql]\r\n" + 
				"hqtyeqsjylu-sxesebqju-cqdqwucudj-686[ngaly]\r\n" + 
				"zlkprjbo-doxab-avb-ildfpqfzp-211[ponbm]\r\n" + 
				"bqvvu-zua-ykjpwejiajp-420[mdlgx]\r\n" + 
				"tfcfiwlc-treup-tfrkzex-drerxvdvek-841[fmlyq]\r\n" + 
				"rmn-qcapcr-qaytclecp-fslr-bctcjmnkclr-652[zksta]\r\n" + 
				"oazegyqd-sdmpq-nmewqf-xasuefuoe-248[qypjm]\r\n" + 
				"kwtwznct-lgm-tijwzibwzg-278[ytdmc]\r\n" + 
				"wlqqp-gcrjkzt-xirjj-rthlzjzkzfe-555[xzkhl]\r\n" + 
				"gpewwmjmih-gerhc-erepcwmw-646[stnzy]\r\n" + 
				"dmybmsuzs-qss-eqdhuoqe-144[sqdem]\r\n" + 
				"yflexwxoalrp-zelzlixqb-qoxfkfkd-705[gtnxw]\r\n" + 
				"votubcmf-cvooz-sftfbsdi-701[qhtkp]\r\n" + 
				"iuruxlar-xghhoz-gtgreyoy-306[fnctb]\r\n" + 
				"slqryzjc-bwc-qyjcq-574[pozts]\r\n" + 
				"wdjcvuvmyjpn-nxvqzibzm-cpio-gjbdnodxn-525[pcmhn]\r\n" + 
				"excdklvo-mkxni-mykdsxq-vklybkdybi-744[vmsba]\r\n" + 
				"pybgmyargtc-hcjjwzcyl-sqcp-rcqrgle-912[nhxvg]\r\n" + 
				"wifilzof-wuhxs-xypyfijgyhn-760[nuovc]\r\n" + 
				"ktiaaqnqml-jcvvg-lmaqov-512[nwxms]\r\n" + 
				"kfg-jvtivk-tyftfcrkv-crsfirkfip-945[fkirt]\r\n" + 
				"tfiifjzmv-avccpsvre-ivjvrity-581[fnemb]\r\n" + 
				"zotts-wuhxs-wiuncha-xyjfisgyhn-786[tzjse]\r\n" + 
				"ynssr-ktuubm-phkdlahi-579[bemfv]\r\n" + 
				"xlrypetn-mldvpe-dlwpd-145[rnfmz]\r\n" + 
				"mfklstdw-wyy-wfyafwwjafy-840[lksij]\r\n" + 
				"dsxxw-aylbw-amlryglkclr-938[larwx]\r\n" + 
				"wyvqljapsl-msvdly-mpuhujpun-435[gzlnx]\r\n" + 
				"bxaxipgn-vgpst-hrpktcvtg-wjci-steadnbtci-323[tcgip]\r\n" + 
				"oxjmxdfkd-mixpqfz-doxpp-abpfdk-471[dpxfk]\r\n" + 
				"tipfxvezt-szfyrqriuflj-avccpsvre-ivrthlzjzkzfe-321[zfrve]\r\n" + 
				"qyujihctyx-mwupyhayl-bohn-uwkocmcncih-708[chyui]\r\n" + 
				"zilqwikbqdm-kivlg-apqxxqvo-434[obtmp]\r\n" + 
				"willimcpy-luvvcn-qilembij-578[ilcmv]\r\n" + 
				"rflsjynh-kqtbjw-ijxnls-437[zskut]\r\n" + 
				"jsvagsulanw-hdsklau-yjskk-klgjsyw-814[uzmvg]\r\n" + 
				"oknkvcta-itcfg-tcddkv-yqtmujqr-908[zdync]\r\n" + 
				"zvyvgnel-tenqr-pnaql-pbngvat-qrcyblzrag-741[gvtck]\r\n" + 
				"xjgjmapg-zbb-adivixdib-395[ovzan]\r\n" + 
				"gvcskirmg-tpewxmg-kveww-wlmttmrk-464[szvty]\r\n" + 
				"gpewwmjmih-gerhc-gsexmrk-wlmttmrk-620[fqrba]\r\n" + 
				"jchipqat-gpqqxi-jhtg-ithixcv-661[ihqtc]\r\n" + 
				"bjfutsneji-ojqqdgjfs-ijufwyrjsy-619[jfsiq]\r\n" + 
				"gvcskirmg-fyrrc-hitpscqirx-308[kwgpv]\r\n" + 
				"mvhkvbdib-wpiit-rjmfncjk-525[stlem]\r\n" + 
				"bnqqnrhud-qzaahs-cdrhfm-339[pbsax]\r\n" + 
				"qfmcusbwq-qvcqczohs-rsgwub-116[qcsbu]\r\n" + 
				"qyujihctyx-yaa-guhuaygyhn-734[yahug]\r\n" + 
				"jqwpihizlwca-kivlg-kwibqvo-uizsmbqvo-616[qozkj]\r\n" + 
				"nglmtuex-vtgwr-ybgtgvbgz-865[gtbve]\r\n" + 
				"encuukhkgf-ecpfa-eqcvkpi-yqtmujqr-414[cekqu]\r\n" + 
				"jchipqat-ytaanqtpc-tcvxcttgxcv-375[jnfcy]\r\n" + 
				"mvydjvxodqz-xviyt-xjvodib-vxlpdndodji-915[spxnt]\r\n" + 
				"wfintfhynaj-hmthtqfyj-xmnuunsl-151[nfhtj]\r\n" + 
				"pynffvsvrq-sybjre-ratvarrevat-611[rvaef]\r\n" + 
				"hplazytkpo-dnlgpyrpc-sfye-nfdezxpc-dpcgtnp-327[uzifr]\r\n" + 
				"cybyjqho-whqtu-vbemuh-qdqboiyi-374[zlsdw]\r\n" + 
				"yhkpvhjapcl-wshzapj-nyhzz-svnpzapjz-825[bpcty]\r\n" + 
				"zhdsrqlchg-mhoobehdq-fxvwrphu-vhuylfh-179[hdflo]\r\n" + 
				"ynukcajey-ywjzu-ykwpejc-qoan-paopejc-238[bpemf]\r\n" + 
				"vehmsegxmzi-gerhc-gsexmrk-pefsvexsvc-256[umtvy]\r\n" + 
				"lugjuacha-jfumncw-alumm-uwkocmcncih-240[bzlaw]\r\n" + 
				"nvrgfezqvu-jtrmvexvi-ylek-jkfirxv-165[ywnzb]\r\n" + 
				"fhezusjybu-uww-fkhsxqiydw-920[hgusy]\r\n" + 
				"bgmxkgtmbhgte-vahvhetmx-hixktmbhgl-189[ebaun]\r\n" + 
				"apwmeclga-afmamjyrc-pcqcypaf-496[uyatz]\r\n" + 
				"pdjqhwlf-vfdyhqjhu-kxqw-whfkqrorjb-829[xogzy]\r\n" + 
				"crwwv-rkpqxyib-zxkav-rpbo-qbpqfkd-289[bkpqr]\r\n" + 
				"tfcfiwlc-irsszk-kvtyefcfxp-893[fciks]\r\n" + 
				"lejkrscv-wcfnvi-ivjvrity-191[uyalq]\r\n" + 
				"ktfitzbgz-unggr-inkvatlbgz-111[lmwni]\r\n" + 
				"fodvvlilhg-fdqgb-frdwlqj-frqwdlqphqw-205[kxstn]\r\n" + 
				"odkasqzuo-bxmefuo-sdmee-fqotzaxask-638[oaesd]\r\n" + 
				"pdjqhwlf-fdqgb-frdwlqj-rshudwlrqv-569[xcdnu]\r\n" + 
				"ckgvutofkj-vrgyzoi-mxgyy-jkvgxzsktz-592[murta]\r\n" + 
				"eza-dpncpe-mtzslklcozfd-clmmte-dezclrp-353[celzd]\r\n" + 
				"vehmsegxmzi-nippcfier-wxsveki-516[vqrpz]\r\n" + 
				"rflsjynh-jll-ijufwyrjsy-853[taqil]\r\n" + 
				"jvyyvzpcl-msvdly-hjxbpzpapvu-513[nyxtz]\r\n" + 
				"iehepwnu-cnwza-fahhuxawj-oanreyao-264[ulyvn]\r\n" + 
				"gcfcnuls-aluxy-wbiwifuny-omyl-nymncha-526[snoxf]\r\n" + 
				"oaxadrgx-dmpuamofuhq-omzpk-etubbuzs-638[uamob]\r\n" + 
				"oxmeeuruqp-nmewqf-dqeqmdot-352[kjtia]\r\n" + 
				"bqxnfdmhb-dff-btrsnldq-rdquhbd-521[iyjvl]\r\n" + 
				"joufsobujpobm-fhh-pqfsbujpot-701[obfjp]\r\n" + 
				"hafgnoyr-pnaql-pbngvat-fnyrf-845[vtsod]\r\n" + 
				"mhi-lxvkxm-wrx-kxvxbobgz-657[npmfu]\r\n" + 
				"jrncbavmrq-pnaql-chepunfvat-299[tnzyx]\r\n" + 
				"xgsvgmotm-lruckx-gtgreyoy-566[cuxte]\r\n" + 
				"vcibutulxiom-wbiwifuny-xyjfisgyhn-994[uayrz]\r\n" + 
				"wyvqljapsl-zjhclunly-obua-vwlyhapvuz-123[stmdx]\r\n" + 
				"tvsnigxmpi-jpsaiv-stivexmsrw-568[lhxnw]\r\n" + 
				"bnqqnrhud-azrjds-cdrhfm-703[pozyr]\r\n" + 
				"mfklstdw-tmffq-ugflsafewfl-164[flmst]\r\n" + 
				"tcorcikpi-hnqygt-fgukip-778[hzsum]\r\n" + 
				"amppmqgtc-hcjjwzcyl-qfgnngle-262[yfnvu]\r\n" + 
				"ynssr-vtgwr-ehzblmbvl-631[zxbiy]\r\n" + 
				"slqryzjc-aylbw-amyrgle-dglylagle-938[lyage]\r\n" + 
				"vrurcjah-pajmn-snuuhknjw-jwjuhbrb-745[dphsv]\r\n" + 
				"oaddaeuhq-eomhqzsqd-tgzf-etubbuzs-222[inrke]\r\n" + 
				"yrwxefpi-veffmx-qerekiqirx-542[efirx]\r\n" + 
				"nchhg-rmttgjmiv-bziqvqvo-304[vghim]\r\n" + 
				"vkppo-vbemuh-efuhqjyedi-244[fetmj]\r\n" + 
				"tyepcyletzylw-nlyoj-nzletyr-qtylyntyr-379[ngrvh]\r\n" + 
				"otzkxtgzoutgr-hatte-giwaoyozout-228[tjxcr]\r\n" + 
				"rgllk-eomhqzsqd-tgzf-pqbxakyqzf-534[lzpxc]\r\n" + 
				"zgmfyxypbmsq-zyqicr-jyzmpyrmpw-704[ewjdl]\r\n" + 
				"vehmsegxmzi-gerhc-gsexmrk-qevoixmrk-204[tyisn]\r\n" + 
				"lugjuacha-zfiqyl-xyjfisgyhn-890[fcsxk]\r\n" + 
				"qjopwxha-ywjzu-ykwpejc-zaoecj-810[rvmet]\r\n" + 
				"bnknqetk-sno-rdbqds-idkkxadzm-knfhrshbr-521[kdnbr]\r\n" + 
				"ksodcbwnsr-tzcksf-cdsfohwcbg-818[mnker]\r\n" + 
				"vdzonmhydc-rbzudmfdq-gtms-lzqjdshmf-183[abjvy]\r\n" + 
				"wfummczcyx-luvvcn-yhachyylcha-630[cyhal]\r\n" + 
				"zvyvgnel-tenqr-rtt-freivprf-351[zymsx]\r\n" + 
				"fhezusjybu-sqdto-jusxdebewo-972[amzjn]\r\n" + 
				"amjmpdsj-zyqicr-cleglccpgle-106[vdopa]\r\n" + 
				"hjgbwuladw-wyy-kwjnauwk-502[mrbin]\r\n" + 
				"willimcpy-vohhs-mbcjjcha-734[vsbfq]\r\n" + 
				"xjgjmapg-xcjxjgvoz-omvdidib-317[wynjr]\r\n" + 
				"htqtwkzq-idj-xytwflj-385[tjqwd]\r\n" + 
				"ynssr-xzz-xgzbgxxkbgz-579[nsivc]\r\n" + 
				"xgvnndadzy-agjrzm-rjmfncjk-473[toazb]\r\n" + 
				"pbeebfvir-sybjre-fuvccvat-533[stklm]\r\n" + 
				"jvuzbtly-nyhkl-ibuuf-aljouvsvnf-851[lmnuf]\r\n" + 
				"ziuxioqvo-ntwemz-uiviomumvb-902[arxeu]\r\n" + 
				"vrurcjah-pajmn-ajkkrc-mnbrpw-589[qmtsy]\r\n" + 
				"dwbcjkun-bljenwpna-qdwc-vjwjpnvnwc-537[nwjcb]\r\n" + 
				"oxjmxdfkd-mixpqfz-doxpp-jxkxdbjbkq-913[xdjkp]\r\n" + 
				"mvkccspson-mkxni-mykdsxq-vyqscdsmc-432[stfwy]\r\n" + 
				"rflsjynh-htwwtxnaj-jll-qtlnxynhx-879[jsdzt]\r\n" + 
				"pelbtravp-onfxrg-chepunfvat-663[hazbg]\r\n" + 
				"zbytomdsvo-zvkcdsm-qbkcc-vyqscdsmc-692[csdmv]\r\n" + 
				"qspkfdujmf-fhh-vtfs-uftujoh-415[nmzht]\r\n" + 
				"aczupnetwp-nlyoj-qtylyntyr-405[tjvzp]\r\n" + 
				"gsvvswmzi-jyddc-glsgspexi-wxsveki-646[puyzv]\r\n" + 
				"rgndvtcxr-eaphixr-vgphh-sthxvc-973[ijhlr]\r\n" + 
				"dyz-combod-mrymyvkdo-domrxyvyqi-250[pjlom]\r\n" + 
				"xst-wigvix-fewoix-jmrergmrk-646[irxeg]\r\n" + 
				"xgsvgmotm-kmm-iutzgotsktz-436[mtgko]\r\n" + 
				"nzwzcqfw-awldetn-rcldd-nzyeltyxpye-769[delnw]\r\n" + 
				"crwwv-oxyyfq-rpbo-qbpqfkd-393[qbfop]\r\n" + 
				"wlsiayhcw-jfumncw-alumm-lywycpcha-344[wfzqm]\r\n" + 
				"qfkkj-fydelmwp-nlyoj-nzletyr-cpnptgtyr-951[oxpuz]\r\n" + 
				"qcffcgwjs-qobrm-rsdofhasbh-376[zwyat]\r\n" + 
				"jshzzpmplk-pualyuhapvuhs-yhiipa-zopwwpun-669[simvn]\r\n" + 
				"nglmtuex-wrx-kxvxbobgz-735[phwgz]\r\n" + 
				"oaxadrgx-nmewqf-abqdmfuaze-404[tysvj]\r\n" + 
				"vkppo-zubboruqd-qdqboiyi-998[dhjui]\r\n" + 
				"ajvyjprwp-snuuhknjw-dbna-cnbcrwp-667[ziuhp]\r\n" + 
				"pybgmyargtc-zsllw-bcnjmwkclr-314[mnhck]\r\n" + 
				"pkl-oaynap-xwogap-opknwca-992[nhagy]\r\n" + 
				"hafgnoyr-onfxrg-znexrgvat-741[cywdg]\r\n" + 
				"vkppo-sqdto-ijehqwu-816[opqde]\r\n" + 
				"jvsvymbs-jhukf-zavyhnl-409[vhjsy]\r\n" + 
				"hqtyeqsjylu-cqwdujys-tou-husuylydw-686[kcdsj]\r\n" + 
				"awzwhofm-ufors-pibbm-rsdofhasbh-298[bfhos]\r\n" + 
				"xjinphzm-bmvyz-nxvqzibzm-cpio-mznzvmxc-161[oslup]\r\n" + 
				"tfejldvi-xiruv-wcfnvi-fgvirkzfej-529[sgtbw]\r\n" + 
				"qlm-pbzobq-ciltbo-pxibp-185[zjmpt]\r\n" + 
				"guahyncw-xsy-xymcah-630[fckyn]\r\n" + 
				"lahxpnwrl-ljwmh-jlzdrbrcrxw-407[lrwhj]\r\n" + 
				"dmybmsuzs-omzpk-ogefayqd-eqdhuoq-222[mctji]\r\n" + 
				"forwcoqhwjs-pibbm-twbobqwbu-480[bwoqc]\r\n" + 
				"mhi-lxvkxm-lvtoxgzxk-angm-xgzbgxxkbgz-839[lczyd]\r\n" + 
				"iqmbazulqp-rxaiqd-mocgueufuaz-378[ygdtb]\r\n" + 
				"plolwdub-judgh-udeelw-uhfhlylqj-309[ludhe]\r\n" + 
				"raphhxuxts-hrpktcvtg-wjci-htgkxrth-739[htrxc]\r\n" + 
				"pybgmyargtc-hcjjwzcyl-rcaflmjmew-548[ajlkr]\r\n" + 
				"lnkfaypeha-ywjzu-ykwpejc-ykjpwejiajp-368[jpyae]\r\n" + 
				"vehmsegxmzi-gerhc-gsexmrk-hizipstqirx-100[jzboa]\r\n" + 
				"pdjqhwlf-frqvxphu-judgh-iorzhu-frqwdlqphqw-725[yijon]\r\n" + 
				"kzgwomvqk-kivlg-kwibqvo-ivitgaqa-720[zjyxm]\r\n" + 
				"xqvwdeoh-surmhfwloh-fkrfrodwh-dqdobvlv-855[xwtjs]\r\n" + 
				"xgsvgmotm-igtje-iugzotm-sgxqkzotm-228[ygzda]\r\n" + 
				"lxwbdvna-pajmn-snuuhknjw-bcxajpn-953[yxark]\r\n" + 
				"oaddaeuhq-omzpk-oamfuzs-mocgueufuaz-326[odcqb]\r\n" + 
				"jyddc-ikk-hitevxqirx-750[btmqn]\r\n" + 
				"oaddaeuhq-rxaiqd-fqotzaxask-586[slgad]\r\n" + 
				"kwzzwaqdm-moo-nqvivkqvo-798[epnyr]\r\n" + 
				"fydelmwp-nsznzwlep-opalcexpye-847[ltbwy]\r\n" + 
				"dszphfojd-cbtlfu-tupsbhf-415[fbdhp]\r\n" + 
				"hqcfqwydw-rkddo-skijecuh-iuhlysu-114[ynqsd]\r\n" + 
				"ixeumktoi-inuiurgzk-uvkxgzouty-410[acqzt]\r\n" + 
				"wlqqp-avccpsvre-wzeretzex-347[bgzvw]\r\n" + 
				"vdzonmhydc-bzmcx-bnmszhmldms-157[rspcq]\r\n" + 
				"fodvvlilhg-mhoobehdq-whfkqrorjb-699[defpm]\r\n" + 
				"gntmfefwitzx-ojqqdgjfs-qfgtwfytwd-827[sypzf]\r\n" + 
				"nzydfxpc-rclop-mfyyj-wlmzclezcj-769[clyzf]\r\n" + 
				"zuv-ykixkz-pkrrehkgt-rumoyzoiy-852[yhkru]\r\n" + 
				"aietsrmdih-glsgspexi-vigimzmrk-802[sgnmt]\r\n" + 
				"rgndvtcxr-hrpktcvtg-wjci-igpxcxcv-245[xszoq]\r\n" + 
				"nwzekwypera-xqjju-skngodkl-758[kejnw]\r\n" + 
				"hcd-gsqfsh-rms-rsdzcmasbh-974[vtsqm]\r\n" + 
				"qspkfdujmf-dboez-mphjtujdt-935[diolt]\r\n" + 
				"aczupnetwp-nlyoj-afcnsldtyr-665[zemik]\r\n" + 
				"aoubshwq-qobrm-qcohwbu-rsdofhasbh-376[wyzxl]\r\n" + 
				"xtwtelcj-rclop-ncjzrpytn-ojp-qtylyntyr-353[lyris]\r\n" + 
				"zvyvgnel-tenqr-pelbtravp-rtt-fnyrf-819[fjysz]\r\n" + 
				"ejpanjwpekjwh-bhksan-paydjkhkcu-420[jkahp]\r\n" + 
				"ygcrqpkbgf-hnqygt-hkpcpekpi-882[pgkch]\r\n" + 
				"raphhxuxts-gpqqxi-pcpanhxh-817[qinta]\r\n" + 
				"gsvvswmzi-wgezirkiv-lyrx-stivexmsrw-646[isvrw]\r\n" + 
				"htqtwkzq-kqtbjw-fsfqdxnx-307[ytxis]\r\n" + 
				"oqnidbshkd-eknvdq-cdozqsldms-833[dqskn]\r\n" + 
				"qxdwpopgsdjh-hrpktcvtg-wjci-hidgpvt-219[tdlsw]\r\n" + 
				"fnjyxwrinm-snuuhknjw-jwjuhbrb-459[vjwxy]\r\n" + 
				"egdytrixat-eaphixr-vgphh-stepgibtci-609[vrzoq]\r\n" + 
				"veqtekmrk-fewoix-pskmwxmgw-906[ekmwx]\r\n" + 
				"xmrrq-eadalsjq-yjsvw-usfvq-vwnwdghewfl-502[wqsva]\r\n" + 
				"dpotvnfs-hsbef-gvaaz-sbccju-tfswjdft-649[lbipa]\r\n" + 
				"zvyvgnel-tenqr-enoovg-ybtvfgvpf-637[kchij]\r\n" + 
				"pynffvsvrq-cynfgvp-tenff-ybtvfgvpf-247[dcwfm]\r\n" + 
				"xjinphzm-bmvyz-xviyt-xjvodib-zibdizzmdib-187[gbnqs]\r\n" + 
				"ugfkmewj-yjsvw-hdsklau-yjskk-dgyaklauk-502[kajsu]\r\n" + 
				"iruzfrtkzmv-sleep-tljkfdvi-jvimztv-269[vitze]\r\n" + 
				"sawlkjevaz-oywrajcan-dqjp-hkceopeyo-550[gvitx]\r\n" + 
				"wfummczcyx-wifilzof-vumeyn-ijyluncihm-604[lnmdw]\r\n" + 
				"lahxpnwrl-kdwwh-xynajcrxwb-927[xykwv]\r\n" + 
				"xekdwvwnzkqo-fahhuxawj-oanreyao-836[xnzsy]\r\n" + 
				"mbiyqoxsm-bkllsd-bokmaescsdsyx-718[thcfp]\r\n" + 
				"uiovmbqk-zijjqb-zmamizkp-746[xpstr]\r\n" + 
				"nglmtuex-vkrhzxgbv-xzz-ehzblmbvl-293[zblvx]\r\n" + 
				"xgvnndadzy-kgvnodx-bmvnn-xpnojhzm-nzmqdxz-577[qgfhc]\r\n" + 
				"zntargvp-ohaal-jbexfubc-975[vflzg]\r\n" + 
				"vqr-ugetgv-tcddkv-gpikpggtkpi-830[zlyxv]\r\n" + 
				"qfkkj-nsznzwlep-nzyeltyxpye-847[satrm]\r\n" + 
				"dwbcjkun-yujbcrl-pajbb-fxatbqxy-225[glisn]\r\n" + 
				"tyftfcrkv-tljkfdvi-jvimztv-113[tvfij]\r\n" + 
				"hjgbwuladw-ugjjgkanw-tskcwl-suimakalagf-450[cneum]\r\n" + 
				"vkrhzxgbv-wrx-etuhktmhkr-397[fnspx]\r\n" + 
				"elrkdcdugrxv-zhdsrqlchg-edvnhw-vklsslqj-933[dlhrs]\r\n" + 
				"etaqigpke-lgnnadgcp-uvqtcig-752[ojdgw]\r\n" + 
				"nsyjwsfyntsfq-hmthtqfyj-ywfnsnsl-385[sfnyt]\r\n" + 
				"bnmrtldq-fqzcd-bgnbnkzsd-sqzhmhmf-833[jipnm]\r\n" + 
				"fkqbokxqflkxi-bdd-xkxivpfp-471[rjlxc]\r\n" + 
				"lnkfaypeha-bhksan-hwxknwpknu-316[nsoam]\r\n" + 
				"pelbtravp-ohaal-erprvivat-221[kdvcs]\r\n" + 
				"dfcxsqhwzs-qobrm-qcohwbu-ghcfous-350[choqs]\r\n" + 
				"ejpanjwpekjwh-xwogap-ajcejaanejc-706[dtcks]\r\n" + 
				"gzefmnxq-rxaiqd-pqhqxabyqzf-638[yntmj]\r\n" + 
				"awzwhofm-ufors-qobrm-qcohwbu-hsqvbczcum-454[tfiay]\r\n" + 
				"yknnkoera-yhwooebeaz-lhwopey-cnwoo-klanwpekjo-420[fqbwp]\r\n" + 
				"bkzrrhehdc-bzmcx-bnzshmf-cdoknxldms-183[bcdhm]\r\n" + 
				"htqtwkzq-jll-jslnsjjwnsl-905[oicay]\r\n" + 
				"npmhcargjc-bwc-sqcp-rcqrgle-834[thaxs]\r\n" + 
				"njmjubsz-hsbef-dboez-dvtupnfs-tfswjdf-909[qkeyv]\r\n" + 
				"qyujihctyx-wuhxs-wiuncha-nywbhifias-994[hiuwy]\r\n" + 
				"vetllbybxw-unggr-phkdlahi-475[rqpto]\r\n" + 
				"etyyx-dff-qdzbpthrhshnm-313[zpisy]\r\n" + 
				"ijmockjgz-jwezxo-nojmvbz-993[jozmb]\r\n" + 
				"xgvnndadzy-ytz-mznzvmxc-343[uhztm]\r\n" + 
				"pxtihgbsxw-yehpxk-wxitkmfxgm-189[clynd]\r\n" + 
				"tfiifjzmv-treup-tfekrzedvek-711[gptfw]\r\n" + 
				"sedikcuh-whqtu-rqiauj-iuhlysui-660[znymv]\r\n" + 
				"ktwbhtvmbox-ynssr-cxeeruxtg-tvjnblbmbhg-813[kdico]\r\n" + 
				"xst-wigvix-wgezirkiv-lyrx-tyvglewmrk-542[igrvw]\r\n" + 
				"gzefmnxq-fab-eqodqf-pkq-pqhqxabyqzf-222[examq]\r\n" + 
				"ncjzrpytn-nlyoj-nzletyr-ecltytyr-925[jybxu]\r\n" + 
				"mvkccspson-lexxi-crszzsxq-588[jirxq]\r\n" + 
				"zbytomdsvo-bkllsd-ecob-docdsxq-640[getaf]\r\n" + 
				"willimcpy-luvvcn-mbcjjcha-552[snrxz]\r\n" + 
				"htsxzrjw-lwfij-gntmfefwitzx-hfsid-htfynsl-xmnuunsl-307[fnsth]\r\n" + 
				"iuruxlar-jek-jkvruesktz-306[btnac]\r\n" + 
				"cqwdujys-rqiauj-efuhqjyedi-166[rgncm]\r\n" + 
				"dpssptjwf-dipdpmbuf-sfbdrvjtjujpo-623[yeftd]\r\n" + 
				"pbybeshy-onfxrg-qrfvta-195[wmjer]\r\n" + 
				"laffe-pkrrehkgt-uvkxgzouty-644[kefgr]\r\n" + 
				"rnqnyfwd-lwfij-jll-fhvznxnynts-723[qmybf]\r\n" + 
				"dyz-combod-lkcuod-wkbuodsxq-354[suqhl]\r\n" + 
				"gpewwmjmih-veffmx-ywiv-xiwxmrk-464[zyowm]\r\n" + 
				"xfbqpojafe-cvooz-bdrvjtjujpo-363[qgvxl]\r\n" + 
				"wyvqljapsl-kfl-huhsfzpz-435[yomjs]\r\n" + 
				"hqcfqwydw-rqiauj-huiuqhsx-478[kxtls]\r\n" + 
				"ajyqqgdgcb-zsllw-qrmpyec-392[nztsu]\r\n" + 
				"luxciuwncpy-zfiqyl-xypyfijgyhn-838[bzpxo]\r\n" + 
				"kdijqrbu-fbqijys-whqii-udwyduuhydw-556[ihdkv]\r\n" + 
				"mfklstdw-bwddqtwsf-ghwjslagfk-450[esbmd]\r\n" + 
				"lugjuacha-dyffsvyuh-nywbhifias-578[snqwt]\r\n" + 
				"ibghopzs-qobrm-qcohwbu-fsoqeiwgwhwcb-298[ndtlm]\r\n" + 
				"nwilwcejc-oywrajcan-dqjp-hkceopeyo-394[cejow]\r\n" + 
				"vqr-ugetgv-tcddkv-ucngu-258[xetvd]\r\n" + 
				"rtt-genvavat-975[taveg]\r\n" + 
				"willimcpy-dyffsvyuh-xyjfisgyhn-656[mrjtz]\r\n" + 
				"dmbttjgjfe-njmjubsz-hsbef-gmpxfs-dpoubjonfou-779[yakzv]\r\n" + 
				"muqfedyput-rqiauj-kiuh-juijydw-660[rkonp]\r\n" + 
				"pkl-oaynap-fahhuxawj-odellejc-342[xmeyn]\r\n" + 
				"qlm-pbzobq-yrkkv-pbosfzbp-315[bpkoq]\r\n" + 
				"wihmogyl-aluxy-vumeyn-ijyluncihm-292[yilmu]\r\n" + 
				"mvydjvxodqz-wvnfzo-nvgzn-291[vnzdo]\r\n" + 
				"ikhcxvmbex-ktuubm-hixktmbhgl-215[bhkmx]\r\n" + 
				"willimcpy-vohhs-xypyfijgyhn-136[pmnwz]\r\n" + 
				"ynukcajey-xwogap-skngodkl-394[enjif]\r\n" + 
				"ynukcajey-xqjju-zalwnpiajp-394[kzjlp]\r\n" + 
				"yhtwhnpun-jovjvshal-hjxbpzpapvu-539[ycldk]\r\n" + 
				"nglmtuex-ktuubm-ybgtgvbgz-397[qvtsp]\r\n" + 
				"cvabijtm-rmttgjmiv-lmxtwgumvb-174[zpytf]\r\n" + 
				"fnjyxwrinm-ajkkrc-mnyuxhvnwc-459[molxs]\r\n" + 
				"mybbycsfo-mkxni-yzobkdsyxc-614[ybckm]\r\n" + 
				"ugdgjxmd-kusnwfywj-zmfl-ghwjslagfk-840[gfjwd]\r\n" + 
				"wbhsfbohwcboz-dzoghwq-ufogg-cdsfohwcbg-766[obghw]\r\n" + 
				"qekrixmg-ikk-qerekiqirx-334[aeldt]\r\n" + 
				"ktwbhtvmbox-mhi-lxvkxm-utldxm-lmhktzx-657[yqjuz]\r\n" + 
				"ugdgjxmd-wyy-klgjsyw-216[gydjw]\r\n" + 
				"ucynmlgxcb-cee-pcacgtgle-704[tonxb]\r\n" + 
				"nsyjwsfyntsfq-hmthtqfyj-ijxnls-931[rdmog]\r\n" + 
				"enzcntvat-ohaal-ybtvfgvpf-455[cvmts]\r\n" + 
				"aczupnetwp-nsznzwlep-dlwpd-483[ticoy]\r\n" + 
				"wbhsfbohwcboz-pibbm-cdsfohwcbg-350[oebpc]\r\n" + 
				"shmml-cynfgvp-tenff-znexrgvat-715[fyuze]\r\n" + 
				"sedikcuh-whqtu-uww-huiuqhsx-582[ytsoz]\r\n" + 
				"ynukcajey-pkl-oaynap-xwogap-nayaerejc-550[mnfkp]\r\n" + 
				"ipvohghykvbz-zjhclunly-obua-huhsfzpz-851[mecug]\r\n" + 
				"tbxmlkfwba-oxyyfq-ixyloxqlov-783[woqrj]\r\n" + 
				"zilqwikbqdm-kpwkwtibm-abwziom-954[yzmul]\r\n" + 
				"kwvacumz-ozilm-zijjqb-apqxxqvo-590[dojfm]\r\n" + 
				"bqxnfdmhb-bgnbnkzsd-sdbgmnknfx-547[ajynr]\r\n" + 
				"sbnqbhjoh-dmbttjgjfe-dipdpmbuf-gjobodjoh-103[bjdoh]\r\n" + 
				"jsvagsulanw-usfvq-vwhsjlewfl-268[kiwfy]\r\n" + 
				"mbggf-buzahisl-lnn-wbyjohzpun-539[bnghl]\r\n" + 
				"htwwtxnaj-jll-ijajqturjsy-411[zhgpj]\r\n" + 
				"amppmqgtc-aylbw-amyrgle-pcacgtgle-496[agclm]\r\n" + 
				"jchipqat-uadltg-detgpixdch-895[wogif]\r\n" + 
				"ktfitzbgz-unggr-tgterlbl-605[wjmxs]\r\n" + 
				"yhwooebeaz-ywjzu-ykwpejc-bejwjyejc-498[sgtmz]\r\n" + 
				"muqfedyput-fbqijys-whqii-cqhaujydw-634[pcekt]\r\n" + 
				"udskkaxawv-mfklstdw-hdsklau-yjskk-dstgjslgjq-840[xeguw]\r\n" + 
				"hqfxxnknji-kqtbjw-qfgtwfytwd-983[fqtwj]\r\n" + 
				"veqtekmrk-fyrrc-eguymwmxmsr-490[stfrm]\r\n" + 
				"awzwhofm-ufors-ksodcbwnsr-tzcksf-gozsg-298[sofwz]\r\n" + 
				"tinnm-gqojsbusf-vibh-gsfjwqsg-714[dczyw]\r\n" + 
				"nuatmlmdpage-ngzzk-pqbxakyqzf-456[azgkm]\r\n" + 
				"htsxzrjw-lwfij-kqtbjw-jslnsjjwnsl-255[ldqwi]\r\n" + 
				"zotts-zfiqyl-lywycpcha-136[fwujm]\r\n" + 
				"odiih-kdwwh-ldbcxvna-bnaerln-927[dnabh]\r\n" + 
				"nuatmlmdpage-dmnnuf-xasuefuoe-586[atenm]\r\n" + 
				"qxdwpopgsdjh-rpcsn-rdpixcv-htgkxrth-739[pkxqs]\r\n" + 
				"iruzfrtkzmv-sleep-rthlzjzkzfe-633[ykopj]\r\n" + 
				"ejpanjwpekjwh-nwxxep-zaoecj-550[ejpwa]\r\n" + 
				"rwcnawjcrxwju-kdwwh-cnlqwxuxph-979[genou]\r\n" + 
				"rwcnawjcrxwju-lqxlxujcn-mnyuxhvnwc-719[wxnmk]\r\n" + 
				"qlm-pbzobq-avb-jxohbqfkd-601[mzylk]\r\n" + 
				"lqwhuqdwlrqdo-vfdyhqjhu-kxqw-frqwdlqphqw-881[qwdhl]\r\n" + 
				"udglrdfwlyh-gbh-ilqdqflqj-439[otyms]\r\n" + 
				"hvbizodx-ezggtwzvi-nojmvbz-473[isoun]\r\n" + 
				"dzczkrip-xiruv-vxx-ivtvzmzex-763[yblku]\r\n" + 
				"oaxadrgx-bxmefuo-sdmee-xasuefuoe-222[exaou]\r\n" + 
				"bnmrtldq-fqzcd-bzmcx-vnqjrgno-287[odhcx]\r\n" + 
				"wifilzof-wbiwifuny-lyuwkocmcncih-864[iwcfl]\r\n" + 
				"ynukcajey-ydkykhwpa-yqopkian-oanreya-654[cghze]\r\n" + 
				"egdytrixat-qjccn-bpgztixcv-349[ctgix]\r\n" + 
				"slqryzjc-cee-kypicrgle-210[gqknl]\r\n" + 
				"jef-iushuj-rqiauj-iqbui-296[mzxhd]\r\n" + 
				"qcffcgwjs-gqojsbusf-vibh-gozsg-220[gsfbc]\r\n" + 
				"eadalsjq-yjsvw-usfvq-ugslafy-vwnwdghewfl-606[kyzev]\r\n" + 
				"willimcpy-jfumncw-alumm-xymcah-318[mclai]\r\n" + 
				"excdklvo-bkllsd-vklybkdybi-432[hrznt]\r\n" + 
				"gntmfefwitzx-gzssd-xjwanhjx-801[xfgjn]\r\n" + 
				"qzoggwtwsr-xszzmpsob-fsgsofqv-636[cthmf]\r\n" + 
				"houngfgxjuay-hgyqkz-xkykgxin-332[spxuj]\r\n" + 
				"oaxadrgx-eomhqzsqd-tgzf-qzsuzqqduzs-638[meluy]\r\n" + 
				"qzoggwtwsr-qobrm-rsdzcmasbh-740[fwsan]\r\n" + 
				"bkzrrhehdc-sno-rdbqds-qzaahs-vnqjrgno-339[rdhnq]\r\n" + 
				"excdklvo-cmkfoxqob-rexd-zebmrkcsxq-458[xaqgb]\r\n" + 
				"oknkvcta-itcfg-uecxgpigt-jwpv-fgukip-856[gcikp]\r\n" + 
				"shoewudys-rkddo-qdqboiyi-530[doiqs]\r\n" + 
				"mrxivrexmsrep-gerhc-pefsvexsvc-828[ubzia]\r\n" + 
				"fydelmwp-mfyyj-hzcvdsza-769[anbml]\r\n" + 
				"rwcnawjcrxwju-ljwmh-bqryyrwp-277[nxatm]";
		
		sumOfRealRoomSectorIds(inputString);
		
		findRoom(inputString, "northpole object storage");
	}
	
	static void sumOfRealRoomSectorIds(String inputString) {
		List<String> kioskRooms = Arrays.asList(inputString.split("\\s*\\r\\n\\s*"));
		int sectorIdTotal = 0;
		boolean foundAValidRoom = false;
		for (String room : kioskRooms) {
			@SuppressWarnings("rawtypes")
			List response = roomStatusAndSectorId(room);
			if((boolean) response.get(0)) {
				sectorIdTotal += (Integer) response.get(1);
				foundAValidRoom = true;
			}
		}
		String theKioskStr = (kioskRooms.size() == 1) ? inputString : "For the given input";
		if(foundAValidRoom) {
			System.out.println(theKioskStr + " --> sum of the sector IDs of the real rooms --> " + sectorIdTotal);
		} else {
			System.out.println(theKioskStr + " --> No valid room found..!!");
		}
	}
	
	static void findRoom(String inputString, String decryptedRoomName) {
		List<String> kioskRooms = Arrays.asList(inputString.split("\\s*\\r\\n\\s*"));
		boolean foundRoom = false;
		int roomSectorId = 0;
		for (String room : kioskRooms) {
			@SuppressWarnings("rawtypes")
			List response = roomStatusAndSectorId(room);
			if((boolean) response.get(0)) {
				if(cip((String) response.get(2), (int) response.get(1)).equals(decryptedRoomName)) {
					foundRoom = true;
					roomSectorId = (Integer) response.get(1);
					break;
				}
			}
		}
		if(foundRoom) {
			System.out.println("found the room --> " + decryptedRoomName + ", with sector ID --> " + roomSectorId);
		} else {
			System.out.println("could not find the room .!!");
		}
	}
	
	static String cip(String message, int offset) {
		StringBuilder result = new StringBuilder();
		for (char character : message.toCharArray()) {
		    if (character != '-') {
		        int originalAlphabetPosition = character - 'a';
		        int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
		        char newCharacter = (char) ('a' + newAlphabetPosition);
		        result.append(newCharacter);
		    } else {
		        result.append(' ');
		    }
		}
		return result.toString();
	}

	@SuppressWarnings("rawtypes")
	static List roomStatusAndSectorId(String roomString) {
		int idx1 = roomString.lastIndexOf('-');
		String encryptStr = roomString.substring(0, idx1);
		String sectorStr = roomString.substring(idx1 + 1, idx1 + 4);
		String checkSumStr = roomString.substring(roomString.indexOf("[") + 1, roomString.indexOf("]"));
		return Arrays.asList(isAValidRoom(encryptStr, checkSumStr), Integer.parseInt(sectorStr), encryptStr);
	}
	
	static boolean isAValidRoom(String encryptStr, String checkSumStr) {
		Map<Long, List<Character>> enryptStrChars = charsByWeight(charsByCount(encryptStr));
		// verify if the check-sum string fitting the pattern based on the encrypt string chars weight.
		for(Character c : checkSumStr.toCharArray()) {
			TreeMap<Long, List<Character>> tempEnryptStrChars = new TreeMap<>(Collections.reverseOrder());
			// verify each char is fitting the criteria.
			Character[] rmChars = new Character[1];
			for(Entry<Long, List<Character>> entry : enryptStrChars.entrySet()) {
				if(entry.getValue().size() == 1) {
					if(c == entry.getValue().get(0)) {
						rmChars[0] = c;
						break;
					}
				} else {
					List<Character> enList = entry.getValue();
					Collections.sort(enList);
					if(enList.get(0) == c) {
						rmChars[0] = c;
						break;
					} else {
						return false;
					}
				}
			}
			// remove the chars from the weighted map that are already fitting the pattern for the next char iteration. 
			boolean done = false;
			for(Entry<Long, List<Character>> entry : enryptStrChars.entrySet()) {
				if(entry.getValue().size() == 1 && !done) {
					done = true;
					continue;
				} else {
					if(!done) {
						tempEnryptStrChars.put(entry.getKey(), entry.getValue().stream().filter(x -> (x != rmChars[0])).collect(Collectors.toList()));
						done = true;
					} else {
						tempEnryptStrChars.put(entry.getKey(), entry.getValue());
					}
				}
			}
			enryptStrChars = tempEnryptStrChars;
		}
		return true;
	}

	static Character[] removeElements(Character[] input, Character deleteMe) {
		Character[] newSet = new Character[input.length - 1];
		int countIdx = 0;
	    for(Character item : input) {
	    	if(deleteMe != item) {
	        	newSet[countIdx] = item;
	        	countIdx++;
	        }
	    }
	    return newSet;
	}
	
	static Map<Character, Long> charsByCount(String encryptStr) {
		List<Character> encryptList = new ArrayList<Character>();
		for (char ch : encryptStr.toCharArray()) {
			if ('-' == ch) {
				continue;
			}
			encryptList.add(ch);
		}
		return encryptList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	static <K, V> TreeMap<V, List<K>> charsByWeight(Map<K, V> normalMap) {
		TreeMap<V, List<K>> byChrsWeightMap = new TreeMap<>(Collections.reverseOrder());
		for (Entry<K, V> entry : normalMap.entrySet()) {
			byChrsWeightMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
		}
		return byChrsWeightMap;
	}
}
